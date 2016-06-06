<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="/View/include/headtag.jsp" %>	
</head>
<body>

<div class="container contai-main">

<%@ include file="/View/include/header.jsp" %>
<%@ include file="/View/include/slider.jsp" %>

<!-- -----main center----- -->
<div class="row">
<div class="col-sm-12 dol-xs-12 contai-main-center">
<div class="col-sm-3 col-xs-12 main-center-left">
<!-- ---- -->
<div class="col-sm-12 col-xs-12 center-left-one">

<%@ include file="/View/include/left-header.jsp" %>					
<%@ include file="/View/include/left-footer.jsp" %>	

</div>
</div> <!-- kết thúc  main-center-left được khai báo trong left-header -->
<div class="col-sm-9 col-xs-12 main-center-right"> <!-- bắt đầu phần center -->

<%@ include file="include/center.jsp" %>

</div> <!-- đóng phần main-center-right -->
</div> <!-- đóng phần contai-main-center --> 
</div> <!-- đóng phân row center -->
 <!-- -----end maincenter----- -->
 
<%@ include file="include/slider-footer.jsp" %>
<%@ include file="include/footer.jsp" %>

</div>

</body>
</html>