<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an AllLikedSongsPlayList</title>
	<!-- mobile responsive meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- ** Plugins Needed for the Project ** -->
	<!-- Bootstrap -->
	<link rel="stylesheet" href="plugins/bootstrap/bootstrap.min.css">
	<!-- themefy-icon -->
	<link rel="stylesheet" href="plugins/themify-icons/themify-icons.css">
	<!-- slick slider -->
	<link rel="stylesheet" href="plugins/slick/slick.css">
	<!-- venobox popup -->
	<link rel="stylesheet" href="plugins/Venobox/venobox.css">
	<!-- aos -->
	<link rel="stylesheet" href="plugins/aos/aos.css">

	<!-- Main Stylesheet -->
	<link href="css/style.css" rel="stylesheet">

	<!--Favicon-->
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
</head>
<!-- navigation -->
<section class="fixed-top navigation">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar"
					aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- navbar -->
			<div class="collapse navbar-collapse text-center" id="navbar">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<a class="nav-link" href="/Composer/">Home</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="updateuser">Update User</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="createallsongsplaylist">Create All Liked Songs Playlist</a>
					</li>
					<li class="nav-item">
						<a class="nav-link page-scroll" href="readuseralllikedsongplaylist">Liked Songs</a>
					</li>
					<li class="nav-item">
						<a class="nav-link page-scroll" href="deletesong">Edit Playlist</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="CreateUserFavorites">Create User Favorite Playlist</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="DeleteUserFavorites">Delete User Favorites</a>
					</li>
				</ul>
			</div>
		</nav>
	</div>
</section>
<section class="hero-section hero" data-background="" style="background-image: url(images/hero-area/banner-bg.png);">
	<div class = "container" style="width:500px; margin:0 auto;">
		<body>
			<h1>Enter UserId</h1>
			<h1>${messages.title}</h1>
			<form action="createallsongsplaylist" method="post">
				<p>
					<label for="userId">UserID</label>
					<input id="userId" name="userId" value="${fn:escapeXml(param.userId)}">
				</p>
				<p>
					<input type="submit">
				</p>
			</form>
			<br/><br/>
			<p>
				<span id="successMessage"><b>${messages.success}</b></span>
			</p>
		</body>
	</div>
</section>
</html>