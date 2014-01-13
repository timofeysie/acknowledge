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
    either upper or lower case. Capture the partition name for debugging.
  
    Capture the space available in KB as the number before the
    percentage number (digits followed by '%'). The pattern match
    is relying on there being just one instance of a numeric
    percentage (\d+%) occurring in the each usable output line.

    The header line contains a "%", but the characters preceding it
    are non-numeric, "Use%", so it is ignored. Also, many of the lines
    we want are split across two lines, but it is only the second line
    that contains the information we want.

    The "(?i)" match flag indicates the pattern is case insensitive.
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
regex =  '''(?ix)    # comments are now allowed!
            (\\d+)   # disk space
            \\s+
            \\d+%    # one or more numbers followed by "%"
            \\s+
            (/nfs/data.*)  # partition name'''
pattern = ~regex

