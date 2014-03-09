

#IIRC#
###the Null Object design pattern###

The initial question read was how to avoid doing this constantly:
```
if (someobject != null) {
    someobject.doCalc();
}
```
Here is an answer to that:

Avoid using nulls as a response. With methods that return collections, it's easy: return empty collections (or arrays) instead of nulls pretty much all the time.

With non-collections it might be harder. Consider this as an example: if you have these interfaces:
```
public interface Action {
  void doSomething();
}

public interface Parser {
  Action findAction(String userInput);
}
```
where Parser takes raw user input and finds something to do, perhaps if you're implementing a command line interface for something. Now you might make the contract that it returns null if there's no appropriate action. That leads the null checking you're talking about.

An alternative solution is to never return null and instead do something like this:
```
public class MyParser implements Parser {
  private static Action DO_NOTHING = new Action() {
    public void doSomething() { /* do nothing */ }
  };

  public Action findAction(String userInput) {
    // ...
    if ( /* we can't find any actions */ ) {
      return DO_NOTHING;
    }
  }
}
```
Compare:
```
Parser parser = ParserFactory.getParser();
if (parser == null) {
  // now what?
  // this would be an example of where null isn't (or shouldn't be) a valid response
}
Action action = parser.findAction(someInput);
if (action == null) {
  // do nothing
} else {
  action.doSomething();
}
```
to
```
ParserFactory.getParser().findAction(someInput).doSomething();
```

Now for the Null Object Patter:

Description: Instead of using a null reference to convey absence of an object (for instance, a non-existent customer), one uses an object which implements the expected interface, but whose method body is empty. 

Agile

When we started our drive to become a professional Java developer and not just a solo 'hobbiest' user, we looked into best practices for working developers, and started using Git(Hub) and all it's related tools to manage our projects.  There were still a few things we learned about but didn;t get into, such as continuous integration.  Anyhow, there seems to be a standard list things to fill in with the tools you use.  Here is the list:

testing
mocking
code coverage
static analysis
Continuous Integration
QA dashboard
documentation and Knowledge Management
Code Review

Here is a sample from StackOverflow:

xUnit tools family for testing
EasyMock + PowerMock (alternatives: Mockito, JMock) for mocking
Cobertura (alternatives: EMMA, Clover) for code coverage
Checkstyle, FindBugs, PMD for static analysis
Hudson (alternatives: TeamCity, Bamboo) for Continuous Integration
Sonar as QA dashboard
XWiki (alternative: Trac, Confluence) for documentation and Knowledge Management
Review Board (alternatives: Crucible, SmartBear) for Code Review

Here would be our response:

testing: JUnit
mocking: A custom mock object made by us.
code coverage:  Sorry, what?
static analysis: ditto
Continuous Integration: Running Ant often?
QA dashboard: GitHub?
documentation and Knowledge Management: JavaDocs
Code Review: the note files.

Obviosuly these wont be impressive answers during an interview, so we should probably get ready and fill in the list with a simple standard answer.  OpenShit may supply more answers here, such as CI.  Here is another list:

Building:
Code repo:
CI: 
Testing:
Reporting: 
Project management: 
Documentation: 

And another answer:

Building: Ant, maven, ...
Code repo: SVN, CVS, Git, ....
CI: Hudson, Cruise Control, Luntbuild, Bamboo, ...
Testing: Junit, easymock, mockito, XmlUnit, HtmlUnit, ...
Reporting: Cobertura, Emma, FindBugs, JavaDoc, ...
Project management: XPlanner, GreenHopper, JIRA, ....
Documentation: Confluence, XWiki, ....

Lets combine the lists and get a consesus on the blanks we have:

Building:
Code repo:
Testing:
Reporting: 
Project management: 
Documentation: 
mocking
code coverage
static analysis
Continuous Integration
QA dashboard
Code Review

There may be a few redunancies there, but lets start filling in the list with all the answers, then we can choose the easiest and standard reponses to start learning about and using>

Building: Ant, Maven (Check)
Code repo: GitHub (Check)
Testing: JUnit (Check)

Code Coverage/Reporting: Coberturax2, Emmax2, FindBugs, JavaDoc, Clover

Project management: XPlanner, GreenHopper, JIRA, or Greenhopper (Jira plugin)

Documentation: Confluencex2, XWikix2, Trac

Mocking: EasyMockx2 + PowerMock, Mockito, JMock, mockito, XmlUnit, HtmlUnit

Static Analysis: Checkstyle, FindBugs, PMD 

Continuous Integration: Hudsonx2, Cruise Control, Luntbuild, Bamboox2, TeamCity

QA dashboard: Sonar 

Code Review: Review Board, Crucible, SmartBear 

- Notes
Bugzilla and JIRA pretty much the same?
We are using Bugzilla in Test Cycle. We put all test cases there

What the hell is static analysis and do we need it?  FindBugs sounds like a nice idea...

Next, lets look at the ones that have a x2 which means they were mentioned by at least two posters:

Cobertura
free Java tool that calculates the percentage of code accessed by tests. It can be used to identify which parts of your Java program are lacking test coverage. It is based on jcoverage.
use Cobertura to see how good your
regressions test are. 
What's a regressions test?
failureProperty="test.failed" doesnt work in the ant script.
<sysproperty key="net.sourceforge.cobertura.datafile" file="${basedir}/cobertura.ser" />
Also doesnt work.
cobertura-instrument task not found.
"You need to use classpathref - not classpath: "
<taskdef classpathref="cobertura.classpath" ... 
But we already use that.  And this is becomming a huge tanjent into Ant.  The instrumrnt task seems to be the problem now:
<target name="instrument" depends="compile"> 
<cobertura-instrument todir="${instrumented.dir}">
    <includeclasses regex=".*" />
    <excludeclasses regex=".*\.Test.*" />

    <instrumentationClasspath>
        <path refid="test.classpath" />
        <pathelement location="${test.build}" />
    </instrumentationClasspath>
</cobertura-instrument>
</target> 

So, we replaced it with the instrument call from the sample project in the cobertura folder:

<target name="instrument" depends="init,compile">
		<!--
			Remove the coverage data file and any old instrumentation.
		-->
		<delete file="cobertura.ser"/>
		<delete dir="${instrumented.dir}" />

		<!--
			Instrument the application classes, writing the
			instrumented classes into ${build.instrumented.dir}.
		-->
		<cobertura-instrument todir="${instrumented.dir}">
			<!--
				The following line causes instrument to ignore any
				source line containing a reference to log4j, for the
				purposes of coverage reporting.
			-->
			<ignore regex="org.apache.log4j.*" />

			<fileset dir="${classes.dir}">
				<!--
					Instrument all the application classes, but
					don't instrument the test classes.
				-->
				<include name="**/*.class" />
				<exclude name="**/*Test.class" />
			</fileset>
		</cobertura-instrument>
	</target>
Still same failure.  So we put the jars from cobertura in the domartin lib to make sure ant was finding them, but still, same failure.  And we have wasted half a day for coverage.  Maybe we should give Emma a try.


EMMA is an open-source toolkit for measuring and reporting Java code coverage.

JIRA Agile unlocks the power of Agile, whether you're a seasoned agile expert, or just getting started.  Creating and estimating stories, building a sprint backlog, identifying team commitment and velocity, visualizing team activity, reporting on team progress
GreenHopper is now called JIRA Agile.


Actions.  We could start by using Cobertura with Domartin to make sure tests test the all the code.  We can add it to the ant build script.  In fact we may be able to run Findbugs, Pmd, Checkstyle, JUnit and Cobertrua with Ant.

