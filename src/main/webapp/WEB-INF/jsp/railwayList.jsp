<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>


<section>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Short name</th>
            <th>Stations</th>
        </tr>
        </thead>
        <c:forEach items="${railwayList}" var="railway">
            <jsp:useBean id="railway" scope="page" type="ru.intellex.model.Railway"/>

            <tr>
                <td class="id"><c:out value="${railway.rwId}"/></td>
                <td class="name"><c:out value="${railway.rwName}"/></td>
                <td class="shortname"><c:out value="${railway.rwShortname}"/></td>
                <td class="shortname"><c:out value="${railway.stations}"/></td>
            </tr>
        </c:forEach>
    </table>
</section>

<hr>

</body>
</html>
