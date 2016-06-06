<%@page import="models.ThongTin" %>
<% ThongTin thongtinfooter=(ThongTin) request.getAttribute("thongtin"); %>
<%@ page pageEncoding="utf-8" %>
<!-- beging footer -->
<div class="row">
	<div class="col-sm-12 col-xs-12 contai-footer">
		<img src="<%=request.getContextPath()%>/View/Image/anhnenbaner.png">
		<div class="contai-p">
		<p>
		<span class="footer-name-company"><%=thongtinfooter.getType_company()%> <%= thongtinfooter.getName_company() %><br>
		Địa chỉ: <%=thongtinfooter.getAdd_company()%></span><br>
		<span class="footer-lv2"> Tel: <span class="footer-lh"><%=thongtinfooter.getTel()%></span> Fax: <span class="footer-lh"><%=thongtinfooter.getFax()%></span> <br>
		Hotline: <span class="footer-lh"><%=thongtinfooter.getHotline()%></span><br>
		Email: <%=thongtinfooter.getEmail()%> </span>  </p>
		</div>
	</div>
</div>

 <!-- -------------- -->
