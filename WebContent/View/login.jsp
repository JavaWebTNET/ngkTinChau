<%@page pageEncoding="UTF-8"%>

<div class="col-sm-12 col-xs-12 center-right-one">
	<div class="center-right-title">Đăng Nhập</div>
	<%@ include file="/View/flash.jsp" %>	
	<div class="col-sm-12 col-xs-12 center-right-main">
	 <form class="form-horizontal" method="post" role="form">
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="user">Tên Đăng Nhập:</label>
	    <div class="col-sm-10">
	      <input type="text" name="user" class="form-control" id="user" placeholder="Tên Đăng Nhập">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="pass">Mật Khẩu:</label>
	    <div class="col-sm-10">
	      <input type="password" name="pass" class="form-control" id="pass" placeholder="Mật Khẩu">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">Đăng Nhập</button>
	    </div>
	  </div>
	</form>
	</div>
</div>
