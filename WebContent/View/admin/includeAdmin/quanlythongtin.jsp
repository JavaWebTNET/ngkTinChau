<%@page import="dao.ThongTinDAO"%>
<%@page import="models.ThongTin"%>
<%@ page pageEncoding="utf-8" %>
<%ThongTinDAO thongtinDAO=new ThongTinDAO();
  ThongTin thongtin=thongtinDAO.AllThongTin();
%>
				<div class="center-right-title">Quản lý thông tin</div>

	 			<div class="col-sm-12 col-xs-12 center-right-main-admin">
	 			<div class="center-right-main-admin-child"> 			
	 			
	 			
	 			<div class="table-responsive" style="padding-left:10px;padding-right:10px;">
        <table class="table table-bordered table-thongtin">
            <tr class="title-table" style="color:#00ff21;height:45px;background-color:#808080">
                
                <th>
                   Tên Công Ty
                </th>
                <th>
                  Loại Hình
                </th>
                <th>
                   Địa chỉ
                </th>
                <th>
                    Tel
                </th>
                <th>
                   Fax
                </th>
                <th>
                    Email
                </th>
                <th>
                   Hotline
                </th>
                 <th>
                   Slogan
                </th>
                <th>
                    Word_run
                </th>
                <th>
                    logo
                </th>
                <th style="color:red;">
                    Chức năng
                </th>
            </tr>

            		<% if(thongtin!=null) {
            		
            		%>
                    <tr class="title-noidung">
                        <td>
                          <%= thongtin.getName_company() %>
                        </td>
                        <td>
                            <%= thongtin.getType_company() %>
                        </td>
                        <td>
                           <%= thongtin.getAdd_company() %>
                        </td>
                        <td>
                            <%= thongtin.getTel() %>
                        </td>
                        <td>
                            <%= thongtin.getFax() %>
                        </td>
                        <td>
                           <%= thongtin.getEmail() %>
                        </td>
                        
                        <td>
                           <%= thongtin.getHotline()  %>                          
                        </td>
                        <td>
                           <%= thongtin.getSlogan() %>

                          
                        </td>
                        <td>
                           <%= thongtin.getWord_run() %>

                          
                        </td>
                        
                        <td>
                           <%= thongtin.getLogo()%>                          
                        </td>
                        
                        <td>
                           <button type="button" class="btn btn-danger btn-sua"><a href="${ pageContext.request.contextPath}/admin/suathongtin">Sửa</a></button>                   
                        </td>
                        
                    </tr>                
					<%} %>
      		  </table>
   		 </div>
	 			
	 			
	 			
	 			
	 				 			
	 			
	 			</div>	

	 				
	 			</div>
	 			