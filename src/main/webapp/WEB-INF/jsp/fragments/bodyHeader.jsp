<%--
  Created by IntelliJ IDEA.
  User: b.istomin
  Date: 09.02.2016
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">

        <a href="meal">
            <div class="navbar-header navbar-brand"><fmt:message key="app.title"/></div>
        </a>

        <div class="collapse navbar-collapse">
            <form class="navbar-form navbar-right">
                <%--<a class="btn btn-info" role="button" href="users"><fmt:message key="users.title"/></a>--%>
                <a class="btn btn-info" role="button" href="profile">${project.getName()} profile</a>
            </form>
        </div>
    </div>
</div>