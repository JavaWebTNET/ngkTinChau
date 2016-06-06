
<%@page import="models.Slider"%>
<%@page import="java.util.Vector"%>
<%@ page pageEncoding="utf-8" %>

<% @SuppressWarnings("unchecked")
Vector<Slider> vtslider=(Vector<Slider>) request.getAttribute("slider"); %>
<div class="center-right-title">Quản lý slider</div>

	<div class="col-sm-12 col-xs-12 center-right-main-admin">
	<div class="center-right-main-admin-child"> 				
	<%@include file="/View/flash.jsp" %>
	<div class="table-responsive" style="padding-left:10px;padding-right:10px;">
        <table class="table table-bordered table-condensed table-qlslider">
            <tr class="title-table" style="color:#00ff21;height:45px;background-color:#808080">       
                <th>STT</th>
                <th>Hình Ảnh</th>                                           
                <th style="color:red;" colspan=2>Chức năng</th>
            </tr>
       		<% if(vtslider.size()>0) {
       		int i=1;
       		for(Slider item:vtslider){
       		%>
                <tr class="title-noidung">
                    <td>
                      <%= i %>
                    </td>
                    <td class="slider-td-img">
                     <img src="<%=item.imageLink(request) %>">
                    </td>
                    <td> 
                     <form role="form" method="post" enctype="multipart/form-data"
                     action="${ pageContext.request.contextPath}/admin/slider/<%= item.getId_sd()%>/update">
                     	<div class="col-sm-10"><input class="form-control" type="file" name="file-image" /></div>
                        <div class="col-sm-2"><button type="submit" class="btn btn-info">Sửa</button></div>
                     </form>
                    </td>  
                    <td> 
                     <form role="form" method="post" 
                     action="${ pageContext.request.contextPath}/admin/slider/<%= item.getId_sd()%>/delete">
                       <button type="submit" class="btn btn-danger" onclick="return window.confirm('Xoá?');">Xoá</button>
                     </form>
                    </td>                                          
                </tr>                            
			<%i++;
			}
       		}%>
      	</table>
   	</div> 			
	<form class="form-horizontal" role="form" enctype="multipart/form-data" action="${ pageContext.request.contextPath}/admin/slider" method="post" >
	 	<div class="form-group"> 	
	    	<div class="col-sm-8"><input class="form-control" type="file" name="file-image" /></div>
	    	<div class="col-sm-4"><input class="btn btn-primary" type="submit" value="Thêm ảnh" /></div>       
	    </div>		 				 				 			
	</form>
	</div>	
</div>
	 			