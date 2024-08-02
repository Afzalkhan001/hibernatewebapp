<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

/* General styles */
/* General styles */
body {
    font-family: Arial, sans-serif;
    background-color: black;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center; /* Centers the form horizontally */
    align-items: center; /* Centers the form vertically */
    height: 100vh; /* Ensures the body takes up the full height of the viewport */
    background-image: url('https://tse2.mm.bing.net/th?id=OIP.sz6BiLWJIgD-U71dRGkt4QHaEK&pid=Api&P=0&h=180');
    background-size: cover; /* Ensures the background image covers the entire viewport */
    background-position: center; /* Centers the background image */
}

form {
    background-color: rgba(255, 255, 255, 0.8); /* Makes the form background slightly transparent */
    padding: 20px;
    border-radius: 8px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 300px;
}

input.form-control {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    font-size: 14px;
}

input.form-control:focus {
    border-color: #007bff;
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
    outline: none;
}

button.btn-primary {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 4px;
    background-color: #007bff;
    color: white;
    font-size: 16px;
    cursor: pointer;
}

button.btn-primary:hover {
    background-color: #0056b3;
}


</style>
<%@include file="bootstrap.jsp"%>
</head>
<body>
<form action="toconnect" method="post">
  <input type="text" placeholder="enter name" class="form-control" name="name">
  <input type="email" placeholder="enter email" class="form-control" name="email">
  <input type="password" placeholder="password" class="form-control" name="password">
  <button class="btn btn-primary">Register</button>
</form>
</body>
</html>