<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Account</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
	rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="regbox box">
			
			<h1>Register Account</h1>
			<form action="Registerserve" method="post">
				<p>Username</p>
				<input type="text" placeholder="Username" name="uname" required>
				<p>Password</p>
				<input type="password" placeholder="Password" name="pass" required>
				<p>Name</p>
				<input type="text" placeholder="Name" name="nm" required>
				<p>Phone no.</p>
				<input type="text" placeholder="Phone no." name="phno" required>
				<p>Email</p>
				<input type="text" placeholder="Useremail" name="email" required>
				<p>
				 <input type="submit" value="Register">
			</form>
		</div>
	</div>
</body>
</html>
