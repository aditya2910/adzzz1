webmvc3 - is a standalone REST service in Spring and not using spring-boot.

To run this app:
 1. start zipkin server
 2. do mvn clean install here
 3. mvn jetty:start
 4. endpoint - http://localhost:8080/


here is spring application is being traced using zipkin