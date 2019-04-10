Liquibase
---------------------------
Project structure is familar to maven structure. 
Started from "db" directory.
* Directory init_scripts has required files to create from scratch database. Use that if database doesn't exist
* Main directory for changes -> src/main/resources/changelog/
* Main file has name changelog-master.xml (all opretion srart from here). You also start from here to analyze how 
  it works

Liquibase
============================
Good materials to understand how to work with liquibase:
* http://www.liquibase.org/documentation (Main documentation (use for changelogs or see examples)

Other materials with examples:
* http://shengwangi.blogspot.lt/2016/04/liquibase-helloworld-example.html
* https://www.mssqltips.com/sqlservertip/4340/sql-server-database-change-management-with-liquibase
* http://dba-presents.com/index.php/liquibase/27-database-versioning-part-2-liquibase-how-to-use-video

Liquibase data types:
* http://stackoverflow.com/questions/16890723/list-all-liquibase-sql-types

Liquibase articles:
* http://dba-presents.com/index.php/liquibase

Liquibase Gradle plugin documentation:
* https://github.com/liquibase/liquibase-gradle-plugin

Liquibase gradle
--
* For update on development environment, you'd run:

        >gradlew update -PfileName=changelog-example.xml
        
* For rollback by count on development environment, you'd run:
        
        >gradlew rollbackCount -PfileName=changelog-example.xml -PliquibaseCommandValue=<count value>
        