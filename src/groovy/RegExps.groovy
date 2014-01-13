// slashy regex with old style comments

/*
    The input string to parse is from the output of the 'df -k' command.
    Example input:
  
        Filesystem           1K-blocks      Used Available Use% Mounted on
        /dev/sda1              4185956   1206996   2762888  31% /
        /dev/sda11            30679784  28324040    772140  98% /extra
        <..lines omitted..>
        fas3050c-1-2.b:/vol/canis
                              10485760   6599936   3885824  63% /nfs/data_d2/dog_data
        fas6070-1-1.b:/vol/felis
                             314572800  54889600 259683200  18% /nfs/DATA-1/cat_data
   
    We want the available disk space in KB, for /nfs/data remote
    disk partitions, which is "3885824" and "259683200" in the sample
    above. Note that partitions that start out with "/nfs/data" may be
    either upper or lower case. (#2:) Capture the partition name for debugging.
   
    (#1:) Capture the space available in KB as the number before the
    percentage number (digits followed by '%'). The pattern match
    is relying on there being just one instance of a numeric
    percentage (\d+%) occuring in the each usable output line.
 
    The header line contains a "%", but the characters preceding it
    are non-numeric, "Use%", so it is ignored. Also, many of the lines
    we want are split across two lines, but it is only the second line
    that contains the information we want.
 
    The "(?i)" match flag indicates the pattern is case insensitive.

    The extended mode (?x) allows whitespace and comments starting with "#"
    to be embedded in the regular expression.
*/
pattern = ~/(?i)(\d+)\s+\d+%\s+(\/nfs\/data.*)/

// string converted to a regex

regex = "(?i)(\\d+)\\s+\\d+%\\s+(/nfs/data.*)"
pattern = ~regex
// here document string converted to a regex

regex = '''(?ix)(\\d+)\\s+\\d+%\\s+(/nfs/data.*)'''
pattern = ~regex
Essentially, when converting a slashy regex to a string based pattern:
Forward slashes don't need to be escaped by back slashes so "\/" becomes "/"
Double the remaining back slashes. Back slashes need to be escaped by back slashes when quoting strings (either normal or here documents)
If you want to match whitespace, then you must use "\\s"
You can match "#" with "\\#" so that it's not interpreted as the beginning of a comment
What does the third example buy you? Now newlines and comments can be included. The third example (here document) above can also be written:
// here document string converted to a regex
// a.k.a. extended match mode 
regex =  '''(?ix)        # case insensitive, extended format
            (\\d+)       # 1: The disk space we want
            \\s+         # some whitespace
            \\d+%        # a number followed by %
            \\s+         # some more whitespace
            (/nfs/data.*)    # 2: partition name'''
pattern = ~regex

/*
    The input string to parse is from...
    <...the rest of the header comment from above...>
    With 'debugging = true', this prints some information to show 
    the regular expression is working on the test data:
*/
boolean debugging = true

if (debugging) {
    // Test data
    dfkOutput = '''
Filesystem           1K-blocks      Used Available Use% Mounted on
/dev/sda1              4185956   1206996   2762888  31% /
/dev/sda11            30679784  28324040    772140  98% /extra
fas3050c-1-2.b:/vol/canis
                      10485760   6599936   3885824  63% /nfs/data_d2/dog_data
fas6070-1-1.b:/vol/felis
                     314572800  54889600 259683200  18% /nfs/DATA-1/cat_data
'''
} else {
    // Real data
    dfkOutput = 'df -k'.execute().text
}

long kbAvail = 0

regex =  '''(?ix)      # enable case-insensitive matches, extended patterns
            (\\d+)     # 1: The disk space we want
            \\s+       # some whitespace
            \\d+%      # a number followed by %
            \\s+       # some more whitespace
            (/nfs/data.*)  # 2: partition name'''

pattern = ~regex
matcher = pattern.matcher(dfkOutput)

if (debugging) {
    println """matcher pattern: 
/---------------------------------\\
${matcher.pattern()}
\\---------------------------------/"""

    println "match count=${matcher.getCount()}"
}

for (i=0; i < matcher.getCount(); i++) {
    if (debugging) {
        println "    text matched in matcher[${i}]: '" + matcher[i][0] + "'"
        println "        free space in  (group 1): '" + matcher[i][1] + "'"
        println "        partition name (group 2): '" + matcher[i][2] + "'"
    }
    kbAvail += matcher[i][1].toLong()
}

println "KB available=${kbAvail}"