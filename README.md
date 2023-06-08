# Parts List Management with Thymeleaf
This repository contains a web application to manage components.
It may be used
* to show an overview of all components.
* create new Components (Products or Materials).
* list all Materials of a given Product.

Its entrypoint is [PartsListApplication.java](src/main/java/org/hawhamburg/partslist/PartsListApplication.java).

---

The web application was built with [Thymeleaf](https://www.thymeleaf.org/) as the front-end templating engine
and [Spring Boot](https://spring.io/projects/spring-boot) for everything else.

This repository contains end-to-end tests, that were written using [Selenium](https://www.selenium.dev/documentation/),
a framework for browser automation.
The selenium tests may be found in the [endtoend test package](src/test/java/org/hawhamburg/partslist/endtoend).

A Dockerfile for the application can be found in [Dockerfile](Dockerfile).  To build and run it, use:  
`./gralew run build`  
`docker build -t benthor318/parts-list-management:0.0.1`  
`docker run -p 8080:8080 benthor318/parts-list-management:0.0.1`

---

## Tasks
- [x] Create a Dockerfile to run the application anywhere.
