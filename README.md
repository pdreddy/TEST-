# Spring Boot JSP demo

A minimal application that serves JSP pages locally through both Spring MVC and Apache Struts 2. Each example includes a small form so you can see the framework pass data to a JSP view.

## Prerequisites

- Java 17 or newer
- Maven 3.8 or newer

## Run locally

From the project directory, run:

```bash
mvn spring-boot:run
```

Open one of the examples in your browser:

- Spring MVC: <http://localhost:8080/>
- Struts 2: <http://localhost:8080/struts/hello.action>

Stop the server with `Ctrl+C`.

You can also create and run the executable WAR:

```bash
mvn clean package
java -jar target/jsp-demo.war
```

## Where to make changes

- `HomeController.java` handles the `/` and `/greet` routes.
- `src/main/webapp/WEB-INF/jsp/home.jsp` is the JSP view.
- `StrutsHelloAction.java` handles the Struts `/struts/hello.action` route.
- `src/main/resources/struts.xml` maps the Struts action to `struts-home.jsp`.
- `StrutsConfiguration.java` registers the Struts filter only for `/struts/*`.
- `src/main/resources/static/css/style.css` styles the page.
- `application.properties` configures the JSP view folder and server port.

JSP files are deliberately stored under `WEB-INF`, so visitors cannot bypass the controller and request a view directly. Add another controller method and JSP file to create more pages.

The two frameworks run side by side. Spring MVC owns the root routes, while the Struts filter is deliberately limited to `/struts/*` so it does not intercept them. Struts actions are created as prototype-scoped Spring beans, allowing normal Spring dependency injection without sharing request-specific action state.
