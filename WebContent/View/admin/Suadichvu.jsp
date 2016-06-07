<%@ page pageEncoding="utf-8" %>

<%@ page import="models.DichVu" %>
<% DichVu dichvu = (DichVu)request.getAttribute("dichvu"); %>
<div class="center-right-title">Cập nhật dịch vụ</div>
<%@ include file="/View/flash.jsp" %>	
<div class="col-sm-12 col-xs-12 center-right-main-admin">
  <div class="center-right-main-admin-child"> 	
		  <form class="form-horizontal" role="form" enctype="multipart/form-data" 
		  action="${ pageContext.request.contextPath}/admin/dichvu/<%=dichvu.getId_dv() %>/update" method="post" >
		  <div class="form-group">	  
		    <label class="control-label td-title col-sm-2" >Tiêu đề (*)</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" value="<%=dichvu.getName_dv() %>"
		      id="name_dv" name="name_dv"  placeholder="Tiêu đề">
		    </div>
		  </div>	  
		   <div class="form-group">
		    <label class="control-label td-title col-sm-2" >Hình ảnh</label>
		    <div class="col-sm-10"> 
		    	<div class="div-stt-imglogo">
		    	<img src="<%=dichvu.imageLink(request) %>" >
		    	</div>
		    	<input class="form-control" type="file" name="file-image"  />	       
		    </div>
		  </div>
		  <div class="form-group">	  
		    <label class="control-label td-title col-sm-2" >Nội dung</label>
		    <div class="col-sm-10">
		      <textarea class="form-control" id="detail" name="detail">
		      	<%=dichvu.getDetail() %>
		      </textarea>
		    </div>
		  </div>	
		  <div class="form-group"> 
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-success" id="btn-themdichvu">Submit</button>
		    </div>
		  </div>
		</form>
  </div>
</div>
<script src="<%=request.getContextPath()%>/View/ckeditor/ckeditor.js"></script>
<SCRIPT> 
	CKEDITOR.replace( 'detail' );
</script>
