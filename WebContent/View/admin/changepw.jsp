<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="w@idth=device-width, initial-scale=1.0">
        <title>Bootstrap 3 Tabs</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
       	<link rel="stylesheet" href="<%=request.getContextPath()%>/View/CSS/CssTc.css">
       	<script src="<%=request.getContextPath()%>/View/JS/myjs.js"></script>
</head>
<body>



<div class="container contai-main">


<%@ include file="/View/include/header.jsp" %>


<!-- -----main center----- -->
<div class="row">
<div class="col-sm-12 dol-xs-12 contai-main-center">
<div class="col-sm-3 col-xs-12 main-center-left">
<!-- ---- -->
<div class="col-sm-12 col-xs-12 center-left-one">

<%@ include file="/View/admin/includeAdmin/left-header.jsp" %>					


 </div>
</div> <!-- kết thúc  main-center-left được khai báo trong left-header -->
<div class="col-sm-9 col-xs-12 main-center-right"> <!-- bắt đầu phần center -->

<div class="col-sm-12 col-xs-12 center-right-one">
	<div class="center-right-title">Thay Đổi Mật Khẩu</div>
	<%@ include file="/View/flash.jsp" %>	
	<div class="col-sm-12 col-xs-12 center-right-main">
	 <form class="form-horizontal" method="post" role="form">
	  <div class="form-group">
	    <label class="control-label col-sm-3" for="pass">Mật Khẩu:</label>
	    <div class="col-sm-9">
	      <input type="password" name="pass" class="form-control" id="pass" placeholder="Mật Khẩu">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-3" for="new_pass">Mật Khẩu Mới:</label>
	    <div class="col-sm-9">
	      <input type="password" name="new_pass" class="form-control" id="new_pass" placeholder="Mật Khẩu Mới">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-3" for="cf_pass">Nhập Lại Mật Khẩu:</label>
	    <div class="col-sm-9">
	      <input type="password" name="cf_pass" class="form-control" id="cf_pass" placeholder="Nhập Lại Mật Khẩu">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-3 col-sm-9">
	      <button type="submit" class="btn btn-default">Lưu</button>
	    </div>
	  </div>
	</form>
	</div>
</div>

</div> <!-- đóng phần main-center-right -->
</div> <!-- đóng phần contai-main-center --> 
</div> <!-- đóng phân row center -->
 <!-- -----end maincenter----- -->
 

<%@ include file="/View/admin/includeAdmin/footer.jsp" %>


</div>

</body>
</html>