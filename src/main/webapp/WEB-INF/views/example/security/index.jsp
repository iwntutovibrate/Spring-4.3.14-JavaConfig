<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/commonTags.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<c:import url="/WEB-INF/views/include/head.jsp" />
<body>
	<div class="container-fluid text-center">    
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<p><a class="btn btn-success" href="${_url}/">&nbsp;&nbsp;&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;&nbsp;</a></p>
				<p><a class="btn btn-primary" href="${_url}/example/database">DATABASE</a></p>
				<p><a class="btn btn-warning" href="${_url}/example/security/index">SECURITY</a></p>
				<p><a class="btn btn-info" href="#">example</a></p>
				<p><a class="btn btn-danger" href="#">example</a></p>
			</div>
			<div class="col-sm-8 text-left"> 
				<h1>Spring Security.</h1>
				<br />
				<p>Register, Login, Logout</p>
				<p>- Exmaple Database Name : USER </p>
				<p>- SQL File Directory : /src/main/resources/user.sql </p>
				<hr>
				<h3>1. Register </h3>
				<p><a href="${_url}/example/security/register">Go Register</a></p>
				<hr>
				<h3>2. Login </h3>
				<p><a href="${_url}/example/security/login">Go Login</a></p>
				<hr>
				<h3>3. Logout </h3>
				<p>Your name is : ${_user.name}</p>
				<p><a href="${_url}/example/security/success">Only authorized 'user' can come in here.</a></p>
				<p><a href="${_url}/security/logout">Go Logout</a></p>
				<hr>
			</div>
			<div class="col-sm-2 sidenav"></div>
		</div>
	</div>
<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
</body>
<c:import url="/WEB-INF/views/include/bottom.jsp"></c:import>
</html>