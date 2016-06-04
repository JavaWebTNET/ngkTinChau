
<%@page import="models.SanPham"%>
<%@page import="models.DanhMuc"%>
<%@page import="java.util.Vector"%>
<%@ page pageEncoding="utf-8" %>
<% Vector<SanPham> vtsanpham=(Vector<SanPham>) request.getAttribute("sanpham"); %>
<% DanhMuc damm = (DanhMuc) request.getAttribute("dam"); %>
<div class="center-right-title">Quản lý Sản Phẩm</div>

	<div class="col-sm-12 col-xs-12 center-right-main-admin">
	<div class="center-right-main-admin-child"> 				
	<%if(damm != null) {%>
	<form role="form" action="${ pageContext.request.contextPath}/admin/danhmuc/<%=damm.getId()%>/create" method="get" >
	 	<div class="form-group"> 	
	    	<div class="col-sm-4"><input class="btn btn-primary" type="submit" value="Thêm Sản Phẩm" /></div>       
	    </div>		 				 				 			
	</form>
	<%} %>
	<div class="table-responsive" style="padding-left:10px;padding-right:10px;">
        <table class="table table-bordered table-condensed table-qlslider">
            <tr class="title-table" style="color:#00ff21;height:45px;background-color:#808080">       
                <th>STT</th>
                <th>Hình ảnh</th> 
                <th>Tiêu đề</th>                                           
                <th style="color:red;" colspan=3>Chức năng</th>
            </tr>
       		<% if(vtsanpham.size()>0) {
       		int i=1;
       		for(SanPham item:vtsanpham){
       		%>
                <tr class="title-noidung">
                    <td>
                      <%= i %>
                    </td>
                    <td class="slider-td-img">
                     <img src="<%=item.imageLink(request) %>">
                    </td>
                    <td>
                    	<%=item.getTitle() %>
                    </td>
                    <td> 
                     <form role="form" method="post" 
                     action="${ pageContext.request.contextPath}/admin/danhmuc/<%= item.getId()%>/prosp">
                        <button type="submit" class="btn btn-<%=item.isProminent()?"info":"primary" %>">
                        <%=item.isProminent()?"Tắt nổi bật":"Chọn nổi bật" %></button>
                     </form>
                    </td>  
                    <td> 
                     <form role="form" method="get" 
                     action="${ pageContext.request.contextPath}/admin/danhmuc/<%= item.getId()%>/edit">
                        <button type="submit" class="btn btn-info">Sửa</button>
                     </form>
                    </td>  
                    <td> 
                     <form role="form" method="post" 
                     action="${ pageContext.request.contextPath}/admin/danhmuc/<%= item.getId()%>/deletesp">
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
	 			