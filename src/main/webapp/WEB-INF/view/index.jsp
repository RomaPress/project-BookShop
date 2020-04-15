<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src="js/lib/jquery-1.11.1.js"></script>
    <script src="js/get.js"></script>
</head>
<body>

select request

<form method="post" action="<c:url value='/select_table'/>" >

    <label>
        <select name="first_line" id="first_line">
            <label id="result"></label>
            <c:forEach var="i" items="${firstList}">
                <option>
                    <c:out value="${i}"/>
                </option>
            </c:forEach>

        </select>
    </label>
    <br/>
    <input type="submit" value="Select" name="Select1" ><br>
</form>





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
    <input type="button" value="Select" name="Select2" onclick="getTwoValues()" >
    <br/>










<form method="get" action="<c:url value='/answer'/>">
    <label>
        <select name="answer_line" id="answer_line" selected="selected">

            <c:forEach var="i" items="${answerList}">
                <option>
                    <c:out value="${i}"/>
                </option>
            </c:forEach>
        </select>
    </label>

</form>







<%--<form  method="post" action="<c:url value='/answer'/>">--%>
<%--    <label>--%>
<%--        <ul>--%>


<%--            <c:out value="${result1}"/>--%>
<%--            <c:out value="${result2}"/>--%>



<%--            <c:forEach var="i" items="${answerList}">--%>

<%--                <li> Answer: <c:out value="${i}"/></li>--%>
<%--                <hr/>--%>
<%--            </c:forEach>--%>

<%--        </ul>--%>
<%--    </label>--%>
<%--</form>--%>


</body>
</html>
