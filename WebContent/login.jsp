<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LogIn Account</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
	rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
		<div class="regbox box">
			
			<h1>LogIN Account</h1>
			<form action="Loginserve" method="post">
				<p>Username</p>
				<input type="text" placeholder="Username" name="uname" required>
				<p>Password</p>
				<input type="password" placeholder="Password" name="pass" required>
				<p>
				 <input type="submit" value="LogIn">
				 <span style="color:red;">${error}</span>
			</form>
		</div>
	</div>
</body>
</html>