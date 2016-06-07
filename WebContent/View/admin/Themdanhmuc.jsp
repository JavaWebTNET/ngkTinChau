<%@ page pageEncoding="utf-8" %>
<%@page import="models.DanhMuc"%>

<% DanhMuc dam = (DanhMuc) request.getAttribute("dam"); %>
<div class="center-right-title">Thêm Danh Mục</div>
<%@ include file="/View/flash.jsp" %>	
<div class="col-sm-12 col-xs-12 center-right-main-admin">
  <div class="center-right-main-admin-child"> 	
   
		  <form class="form-horizontal" role="form" enctype="multipart/form-data" 
		  action="${ pageContext.request.contextPath}/admin/danhmuc/<%=dam!=null?dam.getId():"" %>" method="post" >
		  <div class="form-group">	  
		    <label class="control-label td-title col-sm-2" >Tiêu đề (*)</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="title" name="title"  placeholder="Tiêu đề">
		    </div>
		  </div>	  
		  <div class="form-group">	  
		    <label class="control-label td-title col-sm-2" >Nội dung</label>
		    <div class="col-sm-10">
		      <textarea class="form-control" id="detail" name="detail"></textarea>
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
