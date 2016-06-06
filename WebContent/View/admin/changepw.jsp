<%@page pageEncoding="UTF-8"%>

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
