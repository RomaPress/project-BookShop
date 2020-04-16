<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%--    <script src="../js/lib/jquery-1.11.1.js"></script>--%>
    <%--    <script src="../js/get.js"></script>--%>
    <script src="https://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script>function getTwoValues() {
        var val1 = document.getElementById("first_line");
        var val2 = document.getElementById("second_line");
        var line1 = val1.options[val1.selectedIndex].text;
        var line2 = val2.options[val2.selectedIndex].text;
        $.ajax({
            type: "GET",
            url: "/BookShop_war/answer",
            dataType: "json",
            data: {line1: line1, line2: line2},
            success: function (data) {
                document.getElementById("result").innerText = data.result;
            }
        });
    }</script>


</head>
<body>
















<form method="post" action="<c:url value='/select_table'/>">

    <c:forEach var="i" items="${firstList}">

        <input type="radio" name="first_line" value="<c:out value="${i}"/>"><c:out value="${i}"/>
        <br/>
    </c:forEach>


    <br/>
    <input type="submit" value="Select" name="Select1"/>
</form>

<%----------------------------------------------------------------------------------------%>


<%--<%--%>
<%--    String sCommand = request.getParameter("first_line");--%>
<%--    out.println(sCommand);--%>
<%--%>--%>


<%----------------------------------------------------------------------------------------%>
<%--<form method="post" action="<c:url value='/select_table'/>">--%>

<%--    <label>--%>
<%--        <select name="first_line" id="first_line">--%>
<%--            <c:forEach var="i" items="${firstList}">--%>
<%--                <option>--%>
<%--                    <c:out value="${i}"/>--%>
<%--                </option>--%>
<%--            </c:forEach>--%>

<%--        </select>--%>
<%--    </label>--%>
<%--    <br/>--%>
<%--    <input type="submit" value="Select" name="Select1"><br>--%>
<%--</form>--%>


<label>
    <select name="second_line" id="second_line" selected="selected">

        <c:forEach var="i" items="${secondList}">
            <option>
                <c:out value="${i}"/>
            </option>
        </c:forEach>
    </select>
</label>
<br/>
<input type="button" value="Select" name="Select2" onclick="getTwoValues()">
<br/>


<form method="get" action="<c:url value='/answer'/>">
    <label>
        <ul>


            <c:out value="${result1}"/>
            <c:out value="${result2}"/>


            <c:forEach var="i" items="${answerList}">

                <li> Answer: <c:out value="${i}"/></li>
                <hr/>
            </c:forEach>

        </ul>
    </label>
</form>


</body>
</html>
