![alt tag](https://api.travis-ci.org/heidiks/spring-boot-forecast-seed.svg?branch=master)
[![codecov](https://codecov.io/gh/heidiks/spring-boot-forecast-seed/branch/master/graph/badge.svg)](https://codecov.io/gh/heidiks/spring-boot-forecast-seed)

# spring-boot-forecast-seed
A starter project integration with http://openweathermap.org/api.
Based on a RESTful architecture

### Stack:
- Spring Boot
- AngularJS
- Bootstrap
- H2 Database
- Lombok

### Require
- JDK 8
- Bower
- Maven

### Run
```sh
$ bower install
$
$ mvn clean install
$ mvn spring-boot:run
```

### Configuration (Optional)
For configure appid from openweather, edit *openweather.api.key* on **application.properties**.

### Integration
- [Travis CI](https://travis-ci.org/heidiks/spring-boot-forecast-seed)
- [Codecov](https://codecov.io/gh/heidiks/spring-boot-forecast-seed)

### TODO
- Rest Assured
- Replace alert's to toaster
- Create handler's for exceptions throws
