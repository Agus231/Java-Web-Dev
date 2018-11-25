<%--@elvariable id="list" type="java.util.List"--%>

<%--
  Created by IntelliJ IDEA.
  User: verdas
  Date: 19.11.18
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Parsing results</title>
</head>
<body>
<table border="1" width="100%" cellpadding="5">
    <caption>Parsed xml document.</caption>
    <tr>
        <th rowspan="2">Name</th>
        <th rowspan="2">Id</th>
        <th rowspan="2">Type</th>
        <th rowspan="2">Energy, ккал</th>
        <th rowspan="2">Production</th>
        <th rowspan="2">Produced date</th>
        <th colspan="3">Values</th>
        <th colspan="4">Ingredients</th>
        <th rowspan="2">Chocolate type</th>
    </tr>
    <tr>
        <th>Proteins, гр.</th>
        <th>Starches, гр.</th>
        <th>Fats, гр.</th>
        <th>Water</th>
        <th>Sugar, мг.</th>
        <th>Fructose, мг.</th>
        <th>Vanilla, мг.</th>
    </tr>
    <c:forEach var="elem" items="${ list }" varStatus="status">
    <tr>
        <td><c:out value="${ elem.name }"/> </td>
        <td><c:out value="${ elem.candyId }"/> </td>
        <td><c:out value="${ elem.type }"/> </td>
        <td><c:out value="${ elem.energy }"/> </td>
        <td><c:out value="${ elem.production }"/> </td>
        <td>
            <fmt:setLocale value="en-EN"/>
            <fmt:formatDate value="${ elem.producedDate }"/>
        </td>
        <td><c:out value="${ elem.values.proteins }"/> </td>
        <td><c:out value="${ elem.values.starches }"/> </td>
        <td><c:out value="${ elem.values.fats }"/> </td>
        <td><c:out value="${ elem.ingredients.water }"/> </td>
        <td><c:out value="${ elem.ingredients.sugar }"/> </td>
        <td><c:out value="${ elem.ingredients.fructose }"/> </td>
        <td><c:out value="${ elem.ingredients.vanilla }"/> </td>
        <td>
            <c:catch var="exception" >
                <c:out value="${ elem.chocolateType }"/>
            </c:catch>
            <c:if test="${ not empty exception }">
                <c:out value="null"/>
            </c:if>
        </td>
    </tr>
    </c:forEach>
</table>
<button type="button" name="back" onclick="history.back()">back</button>
</body>
</html>
