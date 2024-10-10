import java.util.regex.Matcher
import java.util.regex.Pattern

println "32. Regular expressions"
println "the ~\"pattern\" expression "
println "creates a compiled Java Pattern object from the given pattern "
println "string."
println "the =~ (create Matcher) "
println "and ==~ (returns boolean, whether String matches the pattern) "
println "operators."
import java.util.regex.Matcher
import java.util.regex.Pattern
println " ~ creates a Pattern from String"
def pattern = ~/foo/
assert pattern instanceof Pattern
assert pattern.matcher("foo").matches()    // returns TRUE
assert ! pattern.matcher("foobar").matches() // returns FALSE, because matches() must match whole String
println " =~ creates a Matcher, and in a boolean context, it's \"true\" if it has at least one match, \"false\" otherwise."
assert "cheesecheese" =~ "cheese"
assert "cheesecheese" =~ /cheese/
assert "cheese" == /cheese/   /*they are both string syntaxes*/
assert ! ("cheese" =~ /ham/)
println " ==~ tests, if String matches the pattern"
assert "2009" ==~ /\d+/  // returns TRUE
println "How to assert a false? "+ ("holla" ==~ /\d+/ )// returns FALSE
// lets create a Matcher
def matcher = "cheesecheese" =~ /cheese/
assert matcher instanceof Matcher
// lets do some replacement
def cheese = ("cheesecheese" =~ /cheese/).replaceFirst("nice")
assert cheese == "nicecheese"
assert "color" == "colour".replaceFirst(/ou/, "o")
cheese = ("cheesecheese" =~ /cheese/).replaceAll("nice")
assert cheese == "nicenice"
// simple group demo
// You can also match a pattern that includes groups.  First create a matcher object,
// either using the Java API, or more simply with the =~ operator.  Then, you can index
// the matcher object to find the matches.  matcher[0] returns a List representing the
// first match of the regular expression in the string.  The first element is the string
// that matches the entire regular expression, and the remaining elements are the strings
// that match each group.
// Here's how it works:
def m = "foobarfoo" =~ /o(b.*r)f/
assert m[0] == ["obarf", "bar"]
assert m[0][1] == "bar"
// Although a Matcher isn't a list, it can be indexed like a list.  In Groovy 1.6
// this includes using a collection as an index:
matcher = "eat green cheese" =~ "e+"
assert "ee" == matcher[2]
assert ["ee", "e"] == matcher[2..3]
assert ["e", "ee"] == matcher[0, 2]
assert ["e", "ee", "ee"] == matcher[0, 1..2]
matcher = "cheese please" =~ /([^e]+)e+/
assert ["se", "s"] == matcher[1]
assert [["se", "s"], [" ple", " pl"]] == matcher[1, 2]
assert [["se", "s"], [" ple", " pl"]] == matcher[1 .. 2]
assert [["chee", "ch"], [" ple", " pl"], ["ase", "as"]] == matcher[0, 2..3]
// Matcher defines an iterator() method, so it can be used, for example,
// with collect() and each():
matcher = "cheese please" =~ /([^e]+)e+/
matcher.each { println it }
matcher.reset()
assert matcher.collect { it } == [["chee", "ch"], ["se", "s"], [" ple", " pl"], ["ase", "as"]]
// The semantics of the iterator were changed by Groovy 1.6.
// In 1.5, each iteration would always return a string of the entire match, ignoring groups.
// In 1.6, if the regex has any groups, it returns a list of Strings as shown above.
//
// there is also regular expression aware iterator grep()
assert ["foo", "moo"] == ["foo", "bar", "moo"].grep(~/.*oo$/)
// which can be written also with findAll() method
assert ["foo", "moo"] == ["foo", "bar", "moo"].findAll { it ==~ /.*oo/ }
println ""
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

println "Essentially, when converting a slashy regex to "
println "a string based pattern:"
println "Forward slashes don't need to be escaped by back slashes "
println "so \"\\/\" becomes \"/\""
println "Double the remaining back slashes. "
println "Back slashes need to be escaped by back slashes "
println "when quoting strings (either normal or here documents)"
println "If you want to match whitespace, then you must use \"\\s\""
println "You can match \"#\" with \"\\#\" so that it's not interpreted "
println "as the beginning of a comment"
println "What does the third example buy you? Now newlines and comments "
println "can be included. The third example (here document) above can "
println "also be written:"

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

def dfkOutput = null // output of the 'df -k' command
boolean debugging = true

if (debugging) 
{
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
    
} else 
{
    // Real data
    dfkOutput = 'df -k'.execute().text
}

long kbAvail = 0

regex =  '''(?ix)                 # enable case-insensitive matches, extended patterns
            (\\d+)         # 1: The disk space we want
            \\s+           # some whitespace
            \\d+%          # a number followed by %
            \\s+           # some more whitespace
            (/nfs/data.*) # 2: partition name'''

pattern = ~regex
matcher = pattern.matcher(dfkOutput)

if (debugging) 
{
    println """matcher pattern: 
    /---------------------------------\\
    ${matcher.pattern()}
    \\---------------------------------/"""
    println "match count=${matcher.getCount()}"
}

for (i=0; i < matcher.getCount(); i++) 
{
    if (debugging) 
    {
        println "    text matched in matcher[${i}]: '" + matcher[i][0] + "'"
        println "        free space in  (group 1): '" + matcher[i][1] + "'"
        println "        partition name (group 2): '" + matcher[i][2] + "'"
    }
    kbAvail += matcher[i][1].toLong()
}

println "KB available=${kbAvail}"

println ""
println "i CASE_INSENSITIVE ignore case Do case insensitive pattern matching"
println "d UNIX_LINES       only new lines for ., ^ and \$"
println "m MULTILINE        multiline"
println "s DOTALL           Single-line mode"
println "u UNICODE_CASE     Enables Unicode-aware case folding."
println "x COMMENTS         Extended mode for space, newlines, comments"
println "g global           Global-keeps track of a current position"
println ""
println "You could write in Java"
// Java regex with extended format
println ""
println "String patternStr = "   
println "      \"(?ix)         # case insensitive, extended format\\n\" +"
println "      \"(\\d+)        # 1: The disk space we want\\n\" +"
println "      \"\\s+          # some whitespace\\n\" +"
println "      \"\\d+%         # a number followed by %\\n\" +"
println "      \"\\s+          # some more whitespace\\n\" +"
println "      \"(/nfs/data.*) # 2: partition name\\\";"
println "Pattern pattern = Pattern.compile(patternStr);"
println "Matcher m = pattern.matcher(dfkOutput);"
println ""
println "But it would be a little less typing with ordinary comments:"
// Java regex with comments simulating extended format
println "String patternStr ="
println "     \"(?i)\" +         // case insensitive"
println "     \"(\\d+)\" +       // 1: The disk space we want"
println "     \"\\s+\" +         // some whitespace"
println "     \"\\d+%\" +        // a number followed by %"
println "     \"\\s+\" +         // some more whitespace"
println "     \"(/nfs/data.*)\"; // 2: partition name"
println "Pattern pattern = Pattern.compile(patternStr);"
println "Matcher m = pattern.matcher(dfOutput);" 
println ""
println "For comparison, here's the Perl equivalent:"
println "# Perl regex"
println "\$dfOutput =~ "
println "    m!                    # begin match"
println "        (\\d+)             # 1: Disk space we're after"
println "        \\s+               # one+ whitespace characters"
println "        \\d+%              # digits followed by '%'"
println "        \\s+               # one+ whitespace characters"
println "        (/nfs/data.*)     # 2: partition name"
println "    !ix;                  # end match with case-(i)nsensitive"
println "                          # and e(x)tended format options\""
println ""
println "A Groovy regex combined with a here document, this becomes much cleaner (and more Perl-like):"
println "regex =  '''(?ix)         # enable case-insensitive matches, extended patterns"
println "            (\\d+)         # 1: The disk space we want"
println "            \\s+           # some whitespace"
println "            \\d+%          # a number followed by %"
println "            \\s+           # some more whitespace"
println "            (/nfs/data.*) # 2: partition name'''"
println "pattern = ~regex"
println "matcher = pattern.matcher(dfOutput)"