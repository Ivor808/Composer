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


<table border="1">
    <tr>
        <th>SongListID</th>
        <th>UserID</th>
    </tr>
    <c:forEach items="${allLikedSongPlaylists}" var="allLikedSongPlaylists" >
        <tr>
            <td><c:out value="${allLikedSongPlaylists.getSongListId()}" /></td>
            <td><c:out value="${allLikedSongPlaylists.getUserId()}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
