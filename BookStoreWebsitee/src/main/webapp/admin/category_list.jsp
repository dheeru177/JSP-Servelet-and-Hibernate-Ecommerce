<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:include page="cacheControl.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Categories - Evergreen Bookstore Administration</title>
<link rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
<jsp:directive.include file="header.jsp" />
<div align="center">
    <h2 class="pageheading">Category Management</h2>
    <h3><a href="category_form.jsp">Create New Category</a></h3>
</div>

<c:if test="${message != null}">
    <div align="center">
        <h4 class="message">${message}</h4>
    </div>
</c:if>

<div align="center" cellpadding="5">
    <table border="1">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="cat" items="${listCategory}" varStatus="status">
            <tr>
                <td>${status.index}</td>
                <td>${cat.categoryId}</td>
                <td>${cat.name}</td>
                <td>
                    <a href="edit_category?id=${cat.categoryId}">Edit</a>
                    <a href="javascript:void(0);" class="deletelink" id="${cat.categoryId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<script>
$(document).ready(function(){
    $(".deletelink").each(function(){
        $(this).on("click", function(){
            categoryId = $(this).attr("id");
            if(confirm('Are you sure you want to delete the category with ID ' + categoryId + '?')){
                window.location = 'delete_category?id=' + categoryId;
            }
        });
    });
});
</script>

<jsp:directive.include file="footer.jsp" />

</body>
</html>
