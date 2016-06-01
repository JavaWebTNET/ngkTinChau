
<%@page import="models.DichVu"%>
<%@page import="java.util.Vector"%>
<%@ page pageEncoding="utf-8" %>
<% Vector<DichVu> vtDV=(Vector<DichVu>) request.getAttribute("dichvu"); %>
<div class="center-right-title">Quản lý Dịch Vụ</div>

	<div class="col-sm-12 col-xs-12 center-right-main-admin">
	<div class="center-right-main-admin-child"> 				
	<%@include file="/View/flash.jsp" %>
	<form role="form" action="${ pageContext.request.contextPath}/admin/dichvu/create" method="get" >
	 	<div class="form-group"> 	
	    	<div class="col-sm-4"><input class="btn btn-primary" type="submit" value="Thêm dịch vụ" /></div>       
	    </div>		 				 				 			
	</form>
	<div class="table-responsive" style="padding-left:10px;padding-right:10px;">
        <table class="table table-bordered table-condensed table-qlslider">
            <tr class="title-table" style="color:#00ff21;height:45px;background-color:#808080">       
                <th>STT</th>
                <th>Hình ảnh</th> 
                <th>Tiêu đề</th>                                           
                <th style="color:red;" colspan=2>Chức năng</th>
            </tr>
       		<% if(vtDV.size()>0) {
       		int i=1;
       		for(DichVu item:vtDV){
       		%>
                <tr class="title-noidung">
                    <td>
                      <%= i %>
                    </td>
                    <td class="slider-td-img">
                     <img src="<%=item.imageLink(request) %>">
                    </td>
                    <td>
                    	<%=item.getName_dv() %>
                    </td>
                    <td> 
                     <form role="form" method="get" 
                     action="${ pageContext.request.contextPath}/admin/dichvu/<%= item.getId_dv()%>/edit">
                        <button type="submit" class="btn btn-info">Sửa</button>
                     </form>
                    </td>  
                    <td> 
                     <form role="form" method="post" 
                     action="${ pageContext.request.contextPath}/admin/dichvu/<%= item.getId_dv()%>/delete">
                       <button type="submit" class="btn btn-danger" onclick="return window.confirm('Xoá?');">Xoá</button>
                     </form>
                    </td>                                          
                </tr>                            
			<%i++;
			}
       		}%>
      	</table>
   	</div> 	
   	<%@ include file="/View/paginate.jsp" %>		
	</div>	
</div>
	 			