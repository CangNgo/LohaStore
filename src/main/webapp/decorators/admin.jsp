<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><dec:title default="Trang chủ" /></title>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href="<c:url value ='/template/admin/assets/css/bootstrap.min.css'/>" rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="<c:url value ='/template/admin/assets/css/animate.min.css' />" rel="stylesheet" />

<!--  Light Bootstrap Table core CSS    -->
<link href="<c:url value ='/template/admin/assets/css/light-bootstrap-dashboard.css?v=1.4.0' />"
	rel="stylesheet" />


<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="<c:url value ='/template/admin/assets/css/demo.css' />" rel="stylesheet" />


<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href="<c:url value ='/template/admin/assets/css/pe-icon-7-stroke.css' />" rel="stylesheet" />

</head>
<body >

	<div class="wrapper">

		<!-- header -->
		<%@ include file="/common/admin/sidebar.jsp"%>
		<!-- header -->

		<div class="main-panel">
			<%@ include file="/common/admin/header.jsp"%>
			<div class="content">
				<dec:body />
			</div>
			<%@ include file="/common/admin/footer.jsp"%>
		</div>
	</div>
	<!--   Core JS Files   -->
	<script src="<c:url value ='/template/admin/assets/js/jquery.3.2.1.min.js' /> " type="text/javascript"></script>
	<script src="<c:url value = '/template/admin/assets/js/bootstrap.min.js'/>" type="text/javascript"></script>

	<!--  Charts Plugin -->
	<script src="<c:url value ='/template/admin/assets/js/chartist.min.js'/>"></script>

	<!--  Notifications Plugin    -->
	<script src="<c:url value ='/template/admin/assets/js/bootstrap-notify.js' />"></script>

	<!--  Google Maps Plugin    -->
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

	<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="<c:url value ='/template/admin/assets/js/light-bootstrap-dashboard.js?v=1.4.0' />"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="<c:url value ='/template/admin/assets/js/demo.js' /> "></script>
</body>
</html>