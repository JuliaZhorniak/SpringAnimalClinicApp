<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib.jsp" %>

<ul>
<c:forEach items="${ users }" var="user">
	<li>${ user.id } | ${ user.login} | 
		<a href="/user/profile/${ user.id }">Profile</a>
	</li>
</c:forEach>
</ul>