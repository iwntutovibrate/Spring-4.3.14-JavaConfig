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
				<hr>
				<h3>1. Register </h3>
				<br />
				<form id="frmRegister">
					<input class="inputBox" type="text" id="loginId" name="loginId" placeholder="아이디">
					<input class="inputBox" type="password" id="loginPw" name="loginPw" placeholder="비밀번호">
					<input class="inputBox" type="text" id="name" name="name" placeholder="이름">
					<a id="btnRegister" class="btn">Submit</a><br />
				</form>
				<hr>
			</div>
			<div class="col-sm-2 sidenav"></div>
		</div>
	</div>
<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
</body>
<c:import url="/WEB-INF/views/include/bottom.jsp"></c:import>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#btnRegister').click(function(){
		
		var loginId = $('#loginId');
		var loginPw = $('#loginPw');
		var name = $('#name');
		
		if(loginId.val() == null || loginId.val() == "" || loginPw.val() == null || loginPw.val() == "" ||
				name.val() == null || name.val() == "" ) {
			alert('빈 칸을 모두 입력해주세요.')
			return false;
		} else {
			
			var url = '${_url}/example/security/register';
			$.post(url, $('#frmRegister').serialize(), function(data){
				alert(data);
				location.href = '${_url}/example/security/index';
			});
		}
	});
});
</script>
</html>