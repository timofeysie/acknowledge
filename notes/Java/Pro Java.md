Oracle Professional Programmer Level II Exam notes.

Regualar Expressions  
JDBC  

IO and Concurrency?  Platfrom Environment

###Regular Expressionses###
Instances of the Pattern class are immutable and are safe for use by multiple concurrent threads. Instances of the Matcher class are not safe for such use.

###JDBC###
The JDBC API - provides programmatic access to relational data to execute SQL statements, retrieve results, and propagate changes back to an underlying data source. can also interact with multiple data sources in a distributed, heterogeneous environment.
- included in both SE and EE. 
- JDBC 4.0 API is divided into two packages: java.sql and javax.sql.

JDBC Driver Manager - The JDBC DriverManager class defines objects which can connect Java applications to a JDBC driver. DriverManager has traditionally been the backbone of the JDBC architecture. It is quite small and simple.
- The Standard Extension packages javax.naming and javax.sql let you use a DataSource object registered with a Java Naming and Directory Interface (JNDI) naming service to establish a connection with a data source. 
You can use either connecting mechanism, but using a DataSource object is recommended whenever possible.

JDBC Test Suite - The JDBC driver test suite helps you to determine that JDBC drivers will run your program. These tests are not comprehensive or exhaustive, but they do exercise many of the important features in the JDBC API.

JDBC-ODBC Bridge - provides JDBC access via ODBC drivers. Note that you need to load ODBC binary code onto each client machine that uses this driver. As a result, the ODBC driver is most appropriate on a corporate network where client installations are not a major problem, or for application server code written in Java in a three-tier architecture.

This Trail uses the first two of these these four JDBC components to connect to a database and then build a java program that uses SQL commands to communicate with a test Relational Database. The last two components are used in specialized environments to test web applications, or to communicate with ODBC-aware DBMSs.
