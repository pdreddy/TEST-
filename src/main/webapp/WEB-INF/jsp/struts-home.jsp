<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Struts JSP Demo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<main class="card">
    <span class="badge">Struts is running</span>
    <h1>Struts 2 JSP Demo</h1>
    <p class="lead">This JSP is rendered by a Struts action inside the same Spring Boot application.</p>

    <div class="info">
        <span>Server time</span>
        <strong><s:property value="serverTime"/></strong>
    </div>

    <s:form action="hello" namespace="/struts" method="post" theme="simple">
        <label for="struts-name">What is your name?</label>
        <div class="form-row">
            <s:textfield id="struts-name" name="name" maxlength="60"
                         placeholder="Enter your name"/>
            <button type="submit">Say hello</button>
        </div>
    </s:form>

    <s:if test="name != null && !name.isEmpty()">
        <p class="greeting">Hello, <strong><s:property value="name"/></strong>!</p>
    </s:if>

    <p class="hint"><a href="${pageContext.request.contextPath}/">Open the Spring MVC example</a></p>
</main>
</body>
</html>
