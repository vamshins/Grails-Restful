<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.7/angular.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.7/angular-resource.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.7/angular-route.js"></script>	
<script type="text/javascript" src="resources/js/app.js"></script>
<script type="text/javascript" src="resources/js/ui-bootstrap.js"></script>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="resources/css/home.css">
<link rel="stylesheet" type="text/css" href="resources/css/signin.css">
</head>
<body ng-app="app">
	
	<div ng-controller="AppCtrl">
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" ng-click="home()" href="">Home</a>
				<ul class="nav">
		            <li><a href="#/list">Current Users</a></li>
		            <li><a href="#/new">New User</a></li>
		        </ul>
			</div>
		</div>
			
		<div ng-view></div>	
	</div>
</body>
</html>
