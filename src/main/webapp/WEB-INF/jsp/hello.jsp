<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hello JSP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<main class="card">
    <span class="badge">Direct JSP route</span>
    <h1>Hello from hello.jsp</h1>
    <p class="lead">
        This file is stored safely below <code>WEB-INF/jsp</code> and is rendered at
        <code>/hello.jsp</code> through Spring MVC.
    </p>
    <p class="hint"><a href="${pageContext.request.contextPath}/">Back to the Spring MVC example</a></p>
</main>
</body>
</html>
