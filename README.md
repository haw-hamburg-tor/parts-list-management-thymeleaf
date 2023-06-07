# Parts List Management with Thymeleaf
![Build](https://github.com/haw-hamburg-tor/parts-list-management-thymeleaf/actions/workflows/ci.yml/badge.svg)

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

---

## Task
- [x] Create a pipeline to automatically build the project and execute all tests.
- [x] Add computation of test coverage with JaCoCo.
- [ ] Perform static code analysis with sonarqube.
