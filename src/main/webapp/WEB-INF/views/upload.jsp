<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="/user/image/upload" method="post" enctype="multipart/form-data">
	<input type="hidden" value="${ userId }" name="user_id">
	
	<input type="file" name="profileImage"> <br>
	<button type="submit">Upload</button>
</form>