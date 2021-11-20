<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AllLikedSongPlaylists</title>
</head>
<body>
	<h1>Enter UserId</h1>
	<form action="readuseralllikedsongplaylist" method="post">
		<p>
			<label for="userId">UserId</label>
			<input id="userId" name="userId" value="${fn:escapeXml(param.userId)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
		</p>
	</form>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
	<table border="1">
	        <tr>
	        <th>SongID</th>
	        <th>SongTitle</th>
	        <th>ReleaseYear</th>
	    </tr>
	    <c:forEach items="${songs}" var="songs" >
	        <tr>
	        	<td><c:out value="${songs.getSongId()}" /></td>
	            <td><c:out value="${songs.getSongTitle()}" /></td>
	            <td><c:out value="${songs.getReleaseYear()}" /></td>
	        </tr>
	    </c:forEach>
</table>
</body>
</html>
