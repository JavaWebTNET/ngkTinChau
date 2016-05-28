<%@page import="dao.ThongTinDAO"%>
<%@page import="models.ThongTin"%>
<%@ page pageEncoding="utf-8" %>
<%
ThongTin thongtin=null;
if(request.getAttribute("thongtinsua")!=null){
 thongtin= (ThongTin) request.getAttribute("thongtinsua"); 
}%>
<div class="center-right-title">Quản lý thông tin</div>

<div class="col-sm-12 col-xs-12 center-right-main-admin">
  <div class="center-right-main-admin-child"> 	
  
  
  	<div class="table-responsive" style="padding-left:10px;padding-right:10px;">
  	 <form name="suathongtin" action="" method="post"> 
        <table class="table table-bordered table-suathongtin">
       		<% if(thongtin!=null){ %>
        	<tr>
        		<td>Tên Công Ty   :</td> <td><input type="text" name="name-company" value="<%= thongtin.getName_company() %>"></td>      
        		<td>Loại hình    :</td><td><input type="text" name="type-company" value="<%= thongtin.getType_company() %>"></td>    
        		<td>Địa Chỉ :</td><td><input type="text" name="type-company" value="<%= thongtin.getAdd_company() %>"></td>   
        		<td>Tell :</td><td><input type="text" name="type-company" value="<%= thongtin.getTel() %>"></td>      
        		 <td>Fax :</td><td><input type="text" name="type-company" value="<%= thongtin.getFax() %>"></td>    
        		 <td>Email :</td><td><input type="text" name="type-company" value="<%= thongtin.getEmail()%>"></td>    
        		 <td>Hotline :</td><td><input type="text" name="type-company" value="<%= thongtin.getHotline() %>"></td>  
        		 <td>Slogan :</td><td><input type="text" name="type-company" value="<%= thongtin.getSlogan() %>"></td>   
        		 <td>Word_run :</td><td><input type="text" name="type-company" value="<%= thongtin.getWord_run() %>"></td>       
        		 <td>Logo :</td><td><input type="text" name="type-company" value="<%= thongtin.getLogo() %>"></td>    
        
       	    </tr>
       	 	<%} %>
      </table> 
      </form>   
    </div>
  
  
  </div>
</div>
