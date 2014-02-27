Java Seven

- Initializer blocks get called everytime the class is constructed. The static block only gets called once, no matter how many objects of that type you create.

Shadowing
public class ShadowTest 
{
    public int x = 0;  
    class FirstLevel 
    {
        public int x = 1;  // member variable of the inner class
        void methodInFirstLevel(int x) 
        {
            System.out.println("parameter   x "+x      +" shadows all other xs");
            System.out.println("inner class x "+this.x+" shadows outer class x"); 
            System.out.println("Outer class x "+ShadowTest.this.x              );
        }

* overriding.interface)methods contians code that needs Java 8.


Special non-capturing contructs like (?<=X) mean X, via zero-width positive lookbehind.

TOC
The StringBuilder Class
The Character Class
he String Class

#The StringBuilder Class#
-  exactly the same as StringBuffer whos methods are synchronized thus thread-safe.
- StringBuilder methods:
- append(boolean b) or (char c, char[] str, char[] str, int offset, int len, double, float, int , long,  obj, String).
- delete(int start, int end)
- deleteCharAt(int index)
- insert(int offset, (boolean, char, float, int, long, Object, String, double))
- insert(int offset, char[] str)
- insert(int index, char[] str, int offset, int len)
- replace(int start, int end, String s)
- setCharAt(int index, char c)
- reverse()

#The Character Class#
- Character ch = new Character('a');
- boolean isLetter(char ch), isDigit, isWhitespace, isUpper/LowerCase, toUpper/LowerCase
- escape sequence is a character starting with a \ (backslash)
\t  tab
\b  backspace
\n  newline
\r  carriage return
\f  formfeed
\'  single quote character
\"  double quote character

#The String Class#
- boolean ends/startsWith(String su/prefix)
- boolean startsWith(String prefix, int offset) 
- int compareTo/IgnoreCase(String anotherString) Compares two strings lexicographically. Returns an integer indicating whether this string is greater than (result is > 0), equal to (result is = 0), or less than (result is < 0) the argument.
- boolean equals/IgnoreCase(String anotherString)  
- boolean regionMatches(int toffset, String other, int ooffset, int len)  Tests whether the specified region of this string matches the specified region of the String argument.
Region is of length len and begins at the index toffset for this string and ooffset for the other string.
- boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) if true, case is ignored when comparing characters.
- boolean matches(String regex) Tests whether this string matches the specified regular expression.