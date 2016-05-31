
<%@page import="models.Slider"%>
<%@page import="java.util.Vector"%>
<%@ page pageEncoding="utf-8" %>
<% Vector<Slider> vtslider=(Vector<Slider>) request.getAttribute("slider"); %>
				<div class="center-right-title">Quản lý slider</div>

	 			<div class="col-sm-12 col-xs-12 center-right-main-admin">
	 			<div class="center-right-main-admin-child"> 			
	 			
	 			
	 			<div class="table-responsive" style="padding-left:10px;padding-right:10px;">
        <table class="table table-bordered table-condensed table-qlslider">
            <tr class="title-table" style="color:#00ff21;height:45px;background-color:#808080">
                
                <th>
                   STT
                </th>
                <th>
                  Hình Ảnh
                </th>              
                
              
                  <th style="color:red;">
                    Chức năng
                </th>
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
                        
                           <button type="button" class="btn btn-danger btn-qlslider"> <a href="${ pageContext.request.contextPath}/admin/slider/delete?id=<%= item.getId_sd()%>">Xóa</a></button>
                        </td>                        
                      
                        
                    </tr> 
                                   
					<%i++;
					}} %>
      		  </table>
   		 </div>
	 			
			 <form class="form-horizontal" role="form" enctype="multipart/form-data" action="${ pageContext.request.contextPath}/admin/slider/delete" method="post" >
			 			  <div class="form-group">
			    <label class="control-label td-title col-sm-2" >Logo</label>
			    <div class="col-sm-10"> 
			    	
			    	<div class="col-sm-8 div-uploadimage"><input type="file" name="file-image"  /></div>
			    	 <input type="submit" value="Create"/>
			       
			    </div>
			  </div>
				 			
			 				 			
		  </form>
	</div>	
</div>
	 			