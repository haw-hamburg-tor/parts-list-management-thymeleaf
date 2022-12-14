FROM amazoncorretto:17

RUN mkdir /deployment

COPY build/libs/parts-list-management-thymeleaf-1.0.0.jar /deployment/parts-list-management-thymeleaf-1.0.0.jar

ENTRYPOINT ["java", "-jar", "/deployment/parts-list-management-thymeleaf-1.0.0.jar"]
