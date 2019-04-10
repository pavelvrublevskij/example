#!/bin/sh
cd `dirname $0`

## Rollback ALL changes (uncomment this if you want to rollback all your changes by your choosen changelog file)
##./gradlew -PliquibaseCommandValue=9999 -PfileName=changelog-example.xml rollbackCount


## Rollback to some tag updated changes (uncomment this if you want to rollback your changes by your choosen changelog file)
##./gradlew -PliquibaseCommandValue=v1.0 -PfileName=changelog-example.xml rollback

## Make changes
./gradlew -PfileName=changelog-example.xml update