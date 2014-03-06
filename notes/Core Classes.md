 TOC

Shadowing  
The StringBuilder Class  
The Character Class  
The String Class  

#Shadowing#
```
public class ShadowTest {
    public int x = 0;  
    class FirstLevel {
        public int x = 1;  // member variable of the inner class
        void methodInFirstLevel(int x) {
            ("parameter   x "+x      +" shadows all other xs");
            ("inner class x "+this.x+" shadows outer class x"); 
            ("Outer class x "+ShadowTest.this.x              );
        }
```
#The StringBuilder Class#
- like String objects but can be modified(append(),insert())
- same as StringBuffer whos methods are synchronized thus thread-safe.
- StringBuilder methods:
- StringBuilder() Creates an empty string builder with capacity of 16 
- void ensureCapacity(int minCapacity) Ensures that the capacity is at least equal to the specified minimum.
- void setLength(int newLength) turcates or adds null chars.
- append(), insert(), setLength() greater than the current capacity(), the capacity is automatically increased.
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
- boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) if true, case is ignored when comparing characters
- boolean matches(String regex) Tests whether this string matches the specified regular expression.
- string literal: a series of characters enclosed in double quotes.
- accessor methods: used to obtain information about an object (str.length();)
- string1.concat(string2); returns string1 with string2 added to it.  can be used w a string literal "str1 ".concat("str2");
- String substring(int beginIndex): like the one with two args,	Returns from the index of the first character to the end of the string.
- String[] split(String regex) Searches for a match as specified by the string argument (which contains a regular expression) and splits this string into an array of strings accordingly.
- String[] split(String regex, int limit) The optional integer argument specifies the maximum size of the returned array. 
- CharSequence subSequence(int beginIndex, int endIndex)	Returns a new character sequence constructed from beginIndex index up until endIndex - 1.
- String replace(char oldChar, char newChar)
- String replace(CharSequence target, CharSequence replacement)	
- String replaceAll(String regex, String replacement)
- String replaceFirst(String regex, String replacement)	Replaces the first substring of this string that matches the given regular expression with the given replacement.
- boolean ends/startsWith(String suf/prefix)
- boolean startsWith(String prefix, int offset)
- int compareTo(String anotherString) lexicographically compare. Returns an integer indicating whether this string is greater than (result is > 0), equal to (result is = 0), or less than (result is < 0) the argument.
- "Abcde".compareTo("Abcdefg") = -2 but
- "Abcde".compareTo("ABCDEFG") = 32 (or ABcde)
- "Abcde".compareTo("Aacde") = 1
- Apple vs Banana = -1 & Banana vs Apple = 1
- Apple vs Able = 14
int compareToIgnoreCase(String str)	Compares two strings lexicographically, ignoring differences in case. Returns an integer indicating whether this string is greater than (result is > 0), equal to (result is = 0), or less than (result is < 0) the argument.
boolean equals(Object anObject)	Returns true if and only if the argument is a String object that represents the same sequence of characters as this object.
boolean equalsIgnoreCase(String anotherString)	Returns true if and only if the argument is a String object that represents the same sequence of characters as this object, ignoring differences in case.
boolean regionMatches(int toffset, String other, int ooffset, int len)	Tests whether the specified region of this string matches the specified region of the String argument.
Region is of length len and begins at the index toffset for this string and ooffset for the other string.

boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)	Tests whether the specified region of this string matches the specified region of the String argument.
Region is of length len and begins at the index toffset for this string and ooffset for the other string.

The boolean argument indicates whether case should be ignored; if true, case is ignored when comparing characters.

boolean matches(String regex)	Tests whether this string matches the specified regular expression. Regular expressions are discussed in the lesson titled "Regular Expressions."