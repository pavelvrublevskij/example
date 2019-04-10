The Data Operations with rollback possibility
============================
Read carefully all links before start to analyze or coding. Project is fully documented.

REQUIREMENTS
---------------------------
Project need all this stuff. Find, download, configure for your OS:
* [Gradle](https://gradle.org/)->[Documentation](https://docs.gradle.org/current/userguide/userguide.html)
* [Liquibase](https://www.liquibase.org/)->[How used in project](db/README.md)
* [JAVA SE (JDK and JRE) from oracle](https://www.oracle.com)

Environment variables
---------------------------
For running Gradle, firstly add the environment variable GRADLE_HOME. This should point to the unpacked files 
from the Gradle website. Next add GRADLE_HOME/bin to your PATH environment variable. 
Usually, this is sufficient to run Gradle.
Same thing for running Java with environment variable JAVA_HOME.

Running and testing your installation
---------------------------
* To test java run - java -v
* To test gradle run - gradle -v
* To test liquibase run - liquibase --version

Gradle plugin searcher
---------------------------
* https://plugins.gradle.org/

Project Directory Structure
---------------------------
I recommend to use IntelliJ IDEA 2016.3.X or above for work with gradle project 
library, or choose for self another tool.

Main project consist one [db](/db/) child project module, but you can have more for your scope

Project structure
---------------------------
Project consist two main directories:

    - database-operations (gradle parent project)
        - db (gradle child project)
    
To see if gradle working properly (you have to install first), open console and write command:
    
    gradlew projects
    
Important
---------------------------
Change value on <your_database> to your existing database name in file db\src\main\resources\changelog\v0.0\dcl\schema.sql

You can call __.\run.sh__ to execute changelogs.