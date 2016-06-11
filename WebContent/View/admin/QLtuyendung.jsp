
<%@page import="models.TuyenDung"%>
<%@page import="java.util.Vector"%>
<%@ page pageEncoding="utf-8" %>
<% @SuppressWarnings("unchecked")
Vector<TuyenDung> vtTD=(Vector<TuyenDung>) request.getAttribute("tuyendung"); %>
<div class="center-right-title">Quản lý Tuyển Dụng</div>

	<div class="col-sm-12 col-xs-12 center-right-main-admin">
	<div class="center-right-main-admin-child"> 				
	<%@include file="/View/flash.jsp" %>
	<form role="form" action="${ pageContext.request.contextPath}/admin/tuyendung/create" method="get" >
	 	<div class="form-group"> 	
	    	<div class="col-sm-4"><input class="btn btn-primary" type="submit" value="Thêm tuyển dụng" /></div>       
	    </div>		 				 				 			
	</form>
	<div class="table-responsive" style="padding-left:10px;padding-right:10px;">
        <table class="table table-bordered table-condensed table-qlslider">
            <tr class="title-table" style="color:#00ff21;height:45px;background-color:#808080">       
                <th>STT</th>
                <th>Tiêu đề</th>                                           
                <th style="color:red;" colspan=2>Chức năng</th>
            </tr>
       		<% if(vtTD.size()>0) {
       		int i=1;
       		for(TuyenDung item:vtTD){
       		%>
                <tr class="title-noidung">
                    <td>
                      <%= i %>
                    </td>
                    <td>
                    	<%=item.getTitle() %>
                    </td>
                    <td> 
                     <form role="form" method="get" 
                     action="${ pageContext.request.contextPath}/admin/tuyendung/<%= item.getId()%>/edit">
                        <button type="submit" class="btn btn-info">Sửa</button>
                     </form>
                    </td>  
                    <td> 
                     <form role="form" method="post" 
                     action="${ pageContext.request.contextPath}/admin/tuyendung/<%= item.getId()%>/delete">
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
	 			