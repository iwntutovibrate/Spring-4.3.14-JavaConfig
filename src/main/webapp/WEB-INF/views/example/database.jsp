<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/commonTags.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<c:import url="/WEB-INF/views/include/head.jsp" />
<body>
	<div class="container-fluid text-center wrap">    
		<div class="row content container">
			<div class="col-sm-2 sidenav">
				<p><a class="btn btn-success" href="${_url}/">&nbsp;&nbsp;&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;&nbsp;</a></p>
				<p><a class="btn btn-primary" href="${_url}/example/database">DATABASE</a></p>
				<p><a class="btn btn-warning" href="${_url}/example/security/index">SECURITY</a></p>
				<p><a class="btn btn-info" href="#">example</a></p>
				<p><a class="btn btn-danger" href="#">example</a></p>
			</div>
			<div class="col-sm-8 text-left"> 
				<h1>Database Example. </h1>
				<br />
				<p>- Insert, Select, Update, Delete</p>
				<hr>
				<h3>1. Select </h3>
				<p>- User list</p>
				<br />
				<c:forEach items="${exampleList}" var="list">
					<p>IDX : ${list.idx}</p>
					<p>NAME : ${list.name}</p>
					<p>AGE : ${list.age}</p>
					<p>COUNTRY : ${list.country}</p>
					<br />
				</c:forEach>
				<hr>
				<form id="frmInsert" action="${_url}/example/database/insert" method="post">
					<h3>2. Insert </h3>
					<br />
					<input class="inputBox" type="text" id="Iidx" name="idx" placeholder="[PK-INDEX] 1 to 999..">
					<input class="inputBox" type="text" id="Iname" name="name" placeholder="Name..">
					<input class="inputBox" type="text" id="Iage" name="age" placeholder="Age..">
					<input class="inputBox" type="text" id="Icountry" name="country" placeholder="Country..">
					<a id="btnInsert" class="btn">Submit</a>
				</form>
				<hr>
				<form id="frmUpdate" action="${_url}/example/database/update" method="post">
					<h3>3. Update </h3>
					<br />
					<input class="inputBox" type="text" id="Uidx" name="idx" placeholder="[PK-INDEX] 1 to 999..">
					<input class="inputBox" type="text" id="Uname" name="name" placeholder="Name..">
					<a id="btnUpdate" class="btn">Submit</a>
				</form>
				<hr>
				<form id="frmDelete" action="${_url}/example/database/delete" method="post">
					<h3>4. Delete </h3>
					<br />
					<input class="inputBox" type="text" id="Didx" name="idx" placeholder="[PK-INDEX] 1 to 999..">
					<a id="btnDelete" class="btn">Submit</a>
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
	
	$('#btnInsert').click(function(){
		
		var idx = $('#Iidx');
		var name = $('#Iname');
		var age = $('#Iage');
		var country = $('#Icountry');
		
		if(idx.val() == null || idx.val() == "" || name.val() == null || name.val() == "" ||
				age.val() == null || age.val() == "" || country.val() == null || country.val() == "") {
			alert('빈 칸을 모두 입력해주세요. ');
			return false;
		} else {
			$('#frmInsert').submit();
		}
	});
	
	$('#btnUpdate').click(function(){
	
		var idx = $('#Uidx');
		var name = $('#Uname');
		
		if(idx.val() == null || idx.val() == "" || name.val() == null || name.val() == "") {
			alert('빈 칸을 모두 입력해주세요. ');
			return false;
		} else {
			$('#frmUpdate').submit();
		}
	});
	
	$('#btnDelete').click(function(){
		
		var idx = $('#Didx');
		
		if(idx.val() == null || idx.val() == "") {
			alert('빈 칸을 모두 입력해주세요. ');
			return false;
		} else {
			$('#frmDelete').submit();
		}
	});
	
});
</script>
</html>