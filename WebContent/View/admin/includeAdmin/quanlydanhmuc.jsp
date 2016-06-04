
<%@page import="models.DanhMuc"%>
<%@page import="java.util.Vector"%>
<%@ page pageEncoding="utf-8" %>
<% Vector<DanhMuc> vtdanhmuc=(Vector<DanhMuc>) request.getAttribute("danhmuc"); %>
<% DanhMuc dam = (DanhMuc) request.getAttribute("dam"); %>
<% boolean canAddDM = (boolean) request.getAttribute("canAddDM"); %>
<div class="center-right-title">Quản lý Danh Mục<%=(dam!=null)? " - "+ dam.getTitle(): "" %></div>

	<div class="col-sm-12 col-xs-12 center-right-main-admin">
	<div class="center-right-main-admin-child"> 				
	<%@include file="/View/flash.jsp" %>
	<div class="table-responsive" style="padding-left:10px;padding-right:10px;">
        <table class="table table-bordered table-condensed table-qlslider">
            <tr class="title-table" style="color:#00ff21;height:45px;background-color:#808080">       
                <th>STT</th>
                <th>Tiêu đề</th>                                           
                <th style="color:red;" colspan=2>Chức năng</th>
            </tr>
       		<% if(vtdanhmuc.size()>0) {
       		int i=1;
       		for(DanhMuc item:vtdanhmuc){
       		%>
                <tr class="title-noidung">
                    <td>
                      <%= i %>
                    </td>
                    <td>
                     <a href="${ pageContext.request.contextPath}/admin/danhmuc/<%= item.getId()%>"><%=item.getTitle() %></a>
                    </td>
                    <td> 
                     <form role="form" method="post" 
                     action="${ pageContext.request.contextPath}/admin/danhmuc/<%= item.getId()%>/update">
                     	<div class="col-sm-10"><input class="form-control" type="text" name="title" placeholder="Tiêu đề mới"/></div>
                        <div class="col-sm-2"><button type="submit" class="btn btn-info">Sửa</button></div>
                     </form>
                    </td>  
                    <td> 
                     <form role="form" method="post" 
                     action="${ pageContext.request.contextPath}/admin/danhmuc/<%= item.getId()%>/delete">
                       <button type="submit" class="btn btn-danger" onclick="return window.confirm('Xoá?');">Xoá</button>
                     </form>
                    </td>                                          
                </tr>                            
			<%i++;
			}
       		}%>
      	</table>
   	</div> 	
   	<% if(canAddDM) {%>		
	<form class="form-horizontal" role="form" action="${ pageContext.request.contextPath}/admin/danhmuc/<%=dam!=null?dam.getId():""%>" method="post" >
	 	<div class="form-group"> 	
	    	<div class="col-sm-8"><input class="form-control" type="text" name="title" placeholder="Danh mục mới"/></div>
	    	<div class="col-sm-4"><input class="btn btn-primary" type="submit" value="Thêm Danh Mục" /></div>       
	    </div>		 				 				 			
	</form>
	<% } %>
	</div>	
</div>
	 			