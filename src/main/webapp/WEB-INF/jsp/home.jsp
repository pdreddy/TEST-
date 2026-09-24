<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${appName}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<main class="card">
    <span class="badge">JSP is running</span>
    <h1>${appName}</h1>
    <p class="lead">This page is rendered on your local server with Spring MVC and JSP.</p>

    <div class="info">
        <span>Server time</span>
        <strong>${serverTime}</strong>
    </div>

    <form action="${pageContext.request.contextPath}/greet" method="post">
        <label for="name">What is your name?</label>
        <div class="form-row">
            <input id="name" name="name" type="text" maxlength="60"
                   placeholder="Enter your name" autocomplete="name">
            <button type="submit">Say hello</button>
        </div>
    </form>

    <%-- JSP expression language displays the controller-provided name after submit. --%>
    <p class="greeting" ${empty name ? 'hidden' : ''}>Hello, <strong>${name}</strong>!</p>

    <p class="hint">Edit <code>src/main/webapp/WEB-INF/jsp/home.jsp</code> to try your own JSP code.</p>
    <p class="hint"><a href="${pageContext.request.contextPath}/struts/hello.action">Open the Struts 2 example</a></p>
</main>
</body>
</html>
