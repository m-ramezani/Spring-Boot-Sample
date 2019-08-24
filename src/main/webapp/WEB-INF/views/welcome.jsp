<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Demo project
    </title>
</head>
<body>
<div class="container">
Welcome ${name}!! <a href="/todo-list"> click here</a> to manage your todo's
</div>
<security:authorize access="hasRole('ADMIN')">
    Hello ADMIN
</security:authorize>
<security:csrfInput/>
</body>
</html>
<%@ include file="common/footer.jspf" %>
