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

## Run and test in IntelliJ IDEA

1. Install a JDK 17 (or newer) and IntelliJ IDEA. The Community edition is enough
   because Spring support from IntelliJ is not required to run this Maven project.
2. In IntelliJ, choose **File → Open**, select this project's `pom.xml`, and choose
   **Open as Project**. If prompted, select **Trust Project**.
3. Open **File → Project Structure → Project** and set **Project SDK** to JDK 17 or
   newer. Keep the language level set to **SDK default**.
4. Open the **Maven** tool window and click **Reload All Maven Projects**. Wait until
   dependency indexing finishes.
5. In the Maven tool window, expand **jsp-demo → Plugins → spring-boot** and run
   **spring-boot:run**. Alternatively, open `JspDemoApplication.java` and click the
   green Run button next to `main`.
6. Wait for `Started JspDemoApplication` in the Run window, and then visit:
   - Spring MVC/JSP: <http://localhost:8080/>
   - Struts 2/JSP: <http://localhost:8080/struts/hello.action>
7. Enter a name and submit the form on each page. A greeting confirms that the
   request reached the controller/action and returned the JSP view.

To run the automated tests, right-click `src/test/java` and choose **Run 'All Tests'**,
or run the `test` goal from **Maven → jsp-demo → Lifecycle → test**. The same check is
available in IntelliJ's terminal:

```bash
mvn test
```

For debugging, place a breakpoint in `HomeController.greet` or
`StrutsHelloAction.execute`, start the app with **Debug** instead of **Run**, and submit
the matching browser form.

### IntelliJ troubleshooting

- If imports stay red, confirm that Maven is not in offline mode and reload the Maven
  project so it can download dependencies from Maven Central.
- If port 8080 is already used, change `server.port` in
  `src/main/resources/application.properties`, restart the app, and use that port in
  the URLs above.
- If a JSP change is not visible, stop and restart the application. JSP recompilation
  behavior can differ between IntelliJ editions and run configurations.
- Run only one application configuration at a time. A second instance cannot bind to
  the same port.

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
