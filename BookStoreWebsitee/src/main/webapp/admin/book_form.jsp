<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="cacheControl.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new Book</title>
<link rel="stylesheet" href="../css/style.css" >
<script type="text/javascript" src="../js/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">

  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
 


</head>
<body>
<jsp:directive.include file="header.jsp" />
<div align="center">
  <h1 class="pageheading">Users Management</h1>
  <c:if test="${book != null}">
    Edit Book
  </c:if>
  <c:if test="${book == null}">
    Create New Book
  </c:if>
</div>

<div align="center">
  <c:if test="${book != null}">
    <form action="update_book" method="post" id="bookForm" enctype="multipart/form-data">
      <input type="hidden" name="bookId" value="${book.bookId}">
  </c:if>
  <c:if test="${book == null}">
    <form action="create_book" method="post" id="bookForm" enctype="multipart/form-data">
  </c:if>
  <table class="form">
  
  <tr>
  <td> Category </td>
  <td>
  <select name="category" id="category">
  
  <c:forEach items="${listCategory}" var="category">
  <option value="${category.categoryId}">
  ${category.name} 
  </option>
  </c:forEach>
  </select>
  </td>
  </tr>
    <tr>
      <td align="right">Title:</td>
      <td align="left"><input type="text" id="title" name="title"  size="20" value="${book.title}" /></td>
    </tr>
    <tr>
      <td align="right">Author:</td>
      <td align="left"><input type="text" id="author" name="author" size="20" value="${book.author}" /></td>
    </tr>
 <tr>
      <td align="right">ISBN:</td>
      <td align="left"><input type="text" id="isbn" name="isbn" size="20" value="${book.isbn}" /></td>
    </tr>
     <tr>
      <td align="right">Publish Date:</td>
      <td align="left"><input type="text" id="publishDate" name="publishDate" size="20" value="${book.publishDate}" /></td>
    </tr>
     <tr>
      <td align="right">Book Image:</td>
      <td align="left"><input type="file" id="bookImage" name="bookImage" size="20" /></br>
<img id="thumbnail" alt="Image Preview" style="width:20%; margin-top: 10px">

      
      </td>
    </tr>
     <tr>
      <td align="right">Price:</td>
      <td align="left"><input type="text" id="price" name="price" size="20" value="${book.price}" /></td>
    </tr>
     <tr>
      <td align="right">Description:</td>
      <td align="left">
     <textarea rows="5" cols="50" name="description" id="description"></textarea>
    
      </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <button type="submit"> Save </button>&nbsp;&nbsp;&nbsp;
        <button id="buttonCancel">Cancel</button>
      </td>
    </tr>
  </table>
  </form>
</div>

<jsp:directive.include file="footer.jsp" />


<script type="text/javascript">
$("#publishDate").datepicker();
$('#bookImage').change(function() {
    showImageThumbnail(this);
});




$(document).ready(function() {
	  $("#bookForm").validate({
	    rules: {
	    	category:"required" ,
	    	title:"required" ,
	    	author: "required",
	    	isbn: "required",
	    	publishDate:"required",
	    	price:"required",
	    	description:"required"
	    },
	    messages: {
	    	category:"Please enter category" ,
	    	title:"Please enter title" ,
	    	author: "Please enter author",
	    	isbn: "Please enter isbn",
	    	publishDate:"Please enter publishDate",
	    	price:"Please enter price",
	    	description:"Please enter Description"
	    }
	  });
  
  $("#buttonCancel").click(function(){
	 history.go(-1); 
  });
});

function showImageThumbnail(fileInput)
{
	
	var file = fileInput.files[0];
	
	var reader =  new FileReader();
	
	reader.onload  = function (e) {
		
		$('#thumbnail').attr('src',e.target.result);
		
		
	};
	
	reader.readAsDataURL(file);
	
	
	
}


</script>

</body>
</html>
