<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="cacheControl.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Books - Evergreen Bookstore Administration</title>
<link rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h1 class="pageheading">Books Management</h1>
		<h3>
			<a href="new_book">Create New Book</a>
		</h3>
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
				<th>Image</th>
				<th>Title</th>
				<th>Author</th>
				<th>Category</th>
				<th>Price</th>
				<th>Last Updated</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="book" items="${listBooks}" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${book.bookId}</td>
					<td><img src="data:image/jpg;base64 ,${book.base64Image}"
						width="84" height="110" /></td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.category.name}</td>
					<td>${book.price}</td>
					<td>${book.lastUpdateTime}</td>
					<td><a href="edit_book?id=${book.bookId}">Edit</a> <a
						href="javascript:void(0)" class="deletelink" id="${book.bookId}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<script>
$(document).ready(function(){
    $(".deletelink").each(function(){
        $(this).on("click", function(){
            userId = $(this).attr("id");
            if(confirm('Are you sure you want to delete the user with ID ' + userId + '?')){
                window.location = 'delete_user?id=' + userId;
            }
        });
    });
});
</script>

	<jsp:directive.include file="footer.jsp" />

</body>
</html>
