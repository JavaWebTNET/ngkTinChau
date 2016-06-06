<%@ page pageEncoding="utf-8" %>
<%@ page import="lang.Lang" %>
<% Lang lang = new Lang(); %>
<% String keytt = (String)request.getAttribute("keytt"); %>
<% String valuett = (String)request.getAttribute("valuett"); %>
<div class="center-right-title">Cập nhật Trang <%=lang.getMessage(keytt) %></div>
<%@ include file="/View/flash.jsp" %>	
<div class="col-sm-12 col-xs-12 center-right-main-admin">
  <div class="center-right-main-admin-child"> 	
		  <form class="form-horizontal" role="form" enctype="multipart/form-data" 
		  action="${ pageContext.request.contextPath}/admin/thongtin/<%=keytt %>" method="post" >
		   
		  <div class="form-group">	  
		    <label class="control-label td-title col-sm-2" >Nội dung</label>
		    <div class="col-sm-10">
		      <textarea class="form-control" id="detail" name="detail">
		      	<%=valuett %>
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
