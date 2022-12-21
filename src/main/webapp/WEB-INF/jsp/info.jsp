<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><c:out value="${msg}"/></title>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${message_number == 0}">
            <div>
                <p class="mb-0"><c:out value="${msg}"/></p>
                <c:if test="${link == '/login'}">
                    <a href="/login" type="button"><strong><c:out value="${text}"/></strong></a>
                </c:if>
                <c:if test="${link == '/registration'}">
                    <a href="/registration" type="button"><strong><c:out value="${text}"/></strong></a>
                </c:if>
            </div>
        </c:when>
        <c:when test="${message_number == 1}">
            <div>
                <p><c:out value="${msg}"/></p>
                <c:if test="${link == '/login'}">
                    <a href="/login" type="button"><strong><c:out value="${text}"/></strong></a>
                </c:if>
                <c:if test="${link == '/registration'}">
                    <a href="/registration" type="button"><strong><c:out value="${text}"/></strong></a>
                </c:if>
            </div>
        </c:when>
        <c:when test="${message_number == null}">
            <h4><c:out value="${msg}"/>
                <c:if test="${link == '/login'}">
                    <a href="/login"><c:out value="${text}"/></a>
                </c:if>
                <c:if test="${link == '/registration'}">
                    <a href="/registration"><c:out value="${text}"/></a>
                </c:if>
            </h4>
        </c:when>
        <c:otherwise>
            <h6>Unexpected error</h6>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>