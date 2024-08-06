<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	data-integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	data-crossorigin="anonymous">

<link href="<c:url value='/template/web/css/style.css'/>"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value = '/template/web/css/hoalen.css'/>">
<link rel="stylesheet"
	href="<c:url value = '/template/web/css/chitietsanpham.css'/> ">
<link rel="stylesheet"
	href="<c:url value ='/template/web/css/giohang.css' />">
<link rel="stylesheet"
	href="<c:url value= '/template/web/css/dangnhap.css'/>">
</head>
<body data-ng-app="myapp" data-ng-controller="myCtrl">
	<!-- header -->
	<%@include file="/common/web/header.jsp"%>
	<div id="maincontent"></div>
	
	<!-- content -->
	<div class="container">
		<dec:body />
	</div>
 	<!-- end content -->
 	
 	<!-- footer -->
	<%@include file="/common/web/footer.jsp"%>
	<!-- end footer -->
	<!-- script file -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		data-integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		data-crossorigin="anonymous"></script>


	<script src="https://kit.fontawesome.com/8e2265a6ab.js"
		data-crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="<c:url value='/template/web/js/angular.min.js'/>"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="<c:url value= '/template/web/js/angular-route.min.js' />"></script>
	<script src="<c:url value= '/template/web/js/app.js'/>"></script>
	<script src="<c:url value= '/template/web/js/sanpham.json'/>"></script>
	<script src="<c:url value= '/template/web/js/checkBooostrap.js' />"></script>
</body>
</html>