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
				<p><a class="btn btn-warning" href="#">example</a></p>
				<p><a class="btn btn-info" href="#">example</a></p>
				<p><a class="btn btn-danger" href="#">example</a></p>
			</div>
			<div class="col-sm-8 text-left"> 
				<h1>Hello World ?</h1>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
				<hr>
				<h3>Test</h3>
				<p>Lorem ipsum...</p>
			</div>
			<div class="col-sm-2 sidenav"></div>
		</div>
	</div>
<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
</body>
<c:import url="/WEB-INF/views/include/bottom.jsp"></c:import>
</html>