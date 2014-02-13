Groovy

Grape (The Groovy Adaptable Packaging Engine or Groovy Advanced Packaging Engine) is the infrastructure enabling the grab() calls in Groovy, a set of classes leveraging Ivy to allow for a repository driven module system for Groovy. This allows a developer to write a script with an essentially arbitrary library requirement, and ship just the script. Grape will, at runtime, download as needed and link the named libraries and all dependencies forming a transitive closure when the script is run from existing repositories such as Ibiblio, Codehaus, and java.net.


Testing
often Ant / Maven look for *.java files to find unit tests with pattern matching, rather than *.class files.

There's an option in Maven to ensure you search for classes (and so find any Groovy unit test cases) via this property

maven.test.search.classdir = true
Once you've got this enabled you can use Maven goals to run individual test cases like this

maven test:single -Dtestcase=foo.MyGroovyTest
