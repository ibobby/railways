<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  User: bobby
  Date: 04.05.2015
  Time: 0:07
--%>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<%--<jsp:include page="fragments/bodyHeader.jsp"/>--%>

<section>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th></th>
            <th>id</th>
            <th>Name</th>
            <th>Detail</th>
            <th>Modify date</th>
            <th>Manager</th>
        </tr>
        </thead>
        <c:forEach items="${projectList}" var="project">
            <jsp:useBean id="railway" scope="page" type="ru.intellex.model.Railway"/>

            <tr>
                <td align="center">
                    <input type="checkbox" name="selectedItems"
                           value="${railway.rwId}"/>
                </td>
                <%--<td class="id"><c:out value="${project.id}"/></td>--%>
                <td class="name"><c:out value="${railway.rwName}"/></td>
                <%--<td class="description"><c:out value="${project.description}"/></td>
                <td><fmt:formatDate value="${project.modified}" pattern="dd-MMMM-yyyy"/></td>
                <td><c:out value="${project.manager}"/></td>--%>
            </tr>
        </c:forEach>
    </table>
</section>
<%--<div id="editFormDiv" style="visibility: hidden">
    <form id="editForm">
        id: <input type="text" name="id" /><br />
        Name: <input type="text" name="name" /><br />
        Detail: <input type="text" name="description"  /><br />
        <div>
            <p><input type="button" id="save" value="save"/>
            <input type="button" id="close" value="close"/></p>
        </div>
    </form>
</div>--%>
<div>
    <a class="btn btn-xs btn-primary" id="edit">Edit</a>
    <a class="btn btn-xs btn-danger" id="delete">Delete</a>
</div>
<hr>
<%--<jsp:include page="fragments/footer.jsp"/>--%>
</body>
<script type="text/javascript">
    $(function () {
        $('input[type="checkbox"]').on('change', function () {

                    // uncheck checkboxes in the same column
                    $('td').find('input[type="checkbox"]:eq(' + $(this).index() + ')').not(this).prop('checked', false);

                }
        );

        $("#edit").click(function () {
            $(':checkbox').each(function () {
                if ($(this).is(":checked")) {
                    //alert($(this).closest("tr").find(".id").text());
                    /*$('#editFormDiv').css('visibility', 'visible');*/
                }
            });
        });

        $("#delete").click(function () {
            $(':checkbox').each(function () {
                if ($(this).is(":checked")) {
                    var curId = $(this).closest("tr").find(".id").text();
                    alert(curId);
                    $.ajax({
                        url: "http://localhost:8080/projects/rest/admin/projects/" + curId,
                        type: "DELETE",
                        success: function(response) {

                        }
                    });
                }
            });
        });


        $("#save").click(function () {
            var formjson = $('#editForm').serializeArray();
            var formxml = json2xml(formjson);
            $.post("http://localhost:8080/projects/rest/admin/projects/", { 'data': formxml }, function(data){
                // callback logic
            });
            return false;
        });

    })

    function json2xml(o, tab) {
        var xml=[], addChild = function(name, v, ind) {
            var childs;
            if (v instanceof Array) {
                for (var i=0, n=v.length; i<n; i++)
                    addChild(name, v[i], ind);
            } else if (typeof(v) == "object") {
                xml.push(ind, "<", name);
                childs = [];
                for (var p in v) {
                    if (!v.hasOwnProperty(p))
                        continue;
                    if (p.charAt(0) == "@")
                        xml.push(" ", p.substr(1), '="', v[p].toString().replace('&', '&amp;').replace('"', '&quot;'), '"');
                    else
                        childs.push(p);
                }
                xml.push( childs.length ? ">" : "/>" );
                if (childs.length) {
                    for (var i=0, n=childs.length, p; i<n; i++) {
                        p = childs[i];
                        if (p == "#text")
                            xml.push(v[p].toString().replace('&', '&amp;').replace('<', '&lt;'));
                        else if (p == "#cdata")
                            xml.push('<![CDATA[', v[p].toString().replace(']]'+'>', ']]]]'+'><![CDATA[>'), ']]'+'>');
                        else
                            addChild(p, v[p], ind+tab);
                    }
                    if (/[>\n]$/.test(xml[xml.length-1]))
                        xml.push(ind);
                    xml.push('</', name, '>');
                }
            } else {
                xml.push(ind, "<", name, ">", v.toString().replace('&', '&amp;').replace('<', '&lt;'), "</", name, ">");
            }
        };
        for (var m in o)
            addChild(m, o[m], "\n");
        xml.shift(); // Remove the first indent
        return xml.join('');
    }

</script>
</html>
