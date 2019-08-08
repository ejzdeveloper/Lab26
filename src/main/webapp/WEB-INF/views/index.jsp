<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie data</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sandstone/bootstrap.min.css" rel="stylesheet" integrity="sha384-G3Fme2BM4boCE9tHx9zHvcxaQoAkksPQa/8oyn1Dzqv7gdcXChereUsXGx6LtbqA" crossorigin="anonymous">
</head>
<body class="simplex">
	<div class="container">
    	<h1>Movies</h1>
    	
    	<div class="form-inline form-group mb-2">
			<label for="search-input" class="sr-only">Filter</label>
    		<input type="text" class="form-control" id="search-input" placeholder="Filter">
    	</div>
    	
    	<table class="table">
    		<thead>
    			<tr>
	    			<th>Title</th>
	    			<th>Category</th>
    			</tr>
   			</thead>
    	
	</div>
</body>
</html>