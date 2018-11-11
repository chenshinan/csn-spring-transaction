#!/bin/sh

java -Dspring.datasource.url="jdbc:mysql://localhost:3306/csn-spring-transcation?useUnicode=true&characterEncoding=utf-8&useSSL=false" \
 -Dspring.datasource.username=root \
 -Dspring.datasource.password=root \
 -Dliquibase.drop=true \
 -Dliquibase.dir=src/main/resources/liquibase \
 -jar liquibase/csn-liquibase-tool.jar