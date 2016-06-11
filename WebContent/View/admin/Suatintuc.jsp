<%@ page pageEncoding="utf-8" %>

<%@ page import="models.TinTuc" %>
<% TinTuc tintuc = (TinTuc)request.getAttribute("tintuc"); %>
<div class="center-right-title">Cập nhật tin tức</div>
<%@ include file="/View/flash.jsp" %>	
<div class="col-sm-12 col-xs-12 center-right-main-admin">
  <div class="center-right-main-admin-child"> 	
		  <form class="form-horizontal" role="form" 
		  action="${ pageContext.request.contextPath}/admin/tintuc/<%=tintuc.getId() %>/update" method="post" >
		  <div class="form-group">	  
		    <label class="control-label td-title col-sm-2" >Tiêu đề (*)</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" value="<%=tintuc.getTitle() %>"
		      id="title" name="title"  placeholder="Tiêu đề">
		    </div>
		  </div>	  
		  <div class="form-group">	  
		    <label class="control-label td-title col-sm-2" >Nội dung</label>
		    <div class="col-sm-10">
		      <textarea class="form-control" id="detail" name="detail">
		      	<%=tintuc.getDetail() %>
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
