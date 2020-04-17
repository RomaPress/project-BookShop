<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>

    <script src="https://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>

    <script>
        function getFirstLine() {
            var val1 = document.getElementById("first_line");
            var line1 = val1.options[val1.selectedIndex].text;
            $.ajax({
                type: "GET",
                url: "/BookShop_war/select_table",
                dataType: "json",
                data: {line1: line1},
                success: function (data) {
                    var html;
                    var $select = $('#second_line');
                    $.each(data.result, function (i, obj) {
                        html += '<option value="' + obj.name + '">' + obj.name + '</option>';
                    });
                    $select.html(html)
                }
            });
        }
    </script>

    <script>function getTwoValues() {
        var val1 = document.getElementById("first_line");
        var line1 = val1.options[val1.selectedIndex].text;
        var val2 = document.getElementById("second_line");
        var line2 = val2.options[val2.selectedIndex].text;
        $.ajax({
            type: "GET",
            url: "/BookShop_war/answer",
            dataType: "json",
            data: {line1: line1, line2: line2},
            success: function (data) {
                var html = "";
                var select = $('#answer');
                $.each(data.result, function (i, obj) {
                    html += '<li>' + obj.name + '</li>';
                });
                select.html(html)
            }
        });
    }</script>

</head>

<body>
<label>
    <select name="first_line" id="first_line">
        <c:forEach var="i" items="${firstList}">
            <option>
                <c:out value="${i}"/>
            </option>
        </c:forEach>

    </select>
</label>

<input type="button" value="Select" name="Select1" onclick="getFirstLine()"> <br>

<label>
    <select name="second_line" id="second_line"> </select>
</label>

<input type="button" value="Select" name="Select2" onclick=" getTwoValues()">
<br/>

<label id="answer"></label>

</body>
</html>
