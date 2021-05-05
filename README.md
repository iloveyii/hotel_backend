JAVA Spring boot
================
Spring boot based web application

## Installations
- Install plugin in Settings > Plugins and search Spring Assistant
- Create spring based app in IJ and add dependencies, web, devtools, actuator
- Create Controller at src main java with annotations like Controller, GetMapping etc
- Open src main java @SpringBootApplication, at the right of class click the green Run button ( CTRL + SHIFT + F10) 


## Configuration
- The `view` paths in templates/application.properties
```java
spring.mvc.view.prefix: /WEB-INF/
spring.mvc.view.suffix: .html
```

## Testing
- Click inside controller method and click generate from menu or alt+insert
- Add a test : 
    - Arrange: create controller object
    - Act : Run the test
    - Assert: Compare results


## Deploy
- Build jar `mvn clean install`
- Find jar file in target dir and run `java -jar file.jar`
- Run with pm2 `pm2 start 'java -jar file.jar' --name java-tomcat`

### Shortcuts IntelliJ
- Insert dependency -> open pom file -> ALT + Insert
