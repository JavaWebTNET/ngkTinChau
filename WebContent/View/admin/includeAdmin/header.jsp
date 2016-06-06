<%@page pageEncoding="UTF-8"%>
<%@page import="models.ThongTin" %>
<% ThongTin thongtinheader=(ThongTin) request.getAttribute("thongtin"); %>


<!-- baner -->
	<div class="row">

		<div class="col-sm-12 col-xs-12 contai-baner">
		<img src="<%=request.getContextPath()%>/View/Image/anhnenbaner.png" class="img-responsive">

		<div class="col-sm-2 col-xs-2 contai-baner-logo">
			<a href="<%=request.getContextPath()%>">
			<img src="<%=thongtinheader.imageLink(request) %>"></a>

		</div>

		<div class="col-sm-10 col-xs-10 contai-baner-namecompany">
			<p class="namecompany-line1"><%= thongtinheader.getType_company()%></p>
			<p class="namecompany-line2"><%= thongtinheader.getName_company() %></p>
			<p class="namecompany-line3"><%= thongtinheader.getSlogan() %></p>
		</div>

		</div>
	</div>
	<!-- end baner -->

	<!--menu-->
	<div class="row row-manu-main">
	<div class="col-sm-12 col-xs-12 navbar-default contai-menu-main">
		<div class="navbar-header contai-navbar-header">
					<button type="button" class="navbar-toggle menu-main-button" data-toggle="collapse" data-target="#menu">
                          <span class="sr-only">Toggle navigation</span>
                          <span class="icon-bar"></span>
                          <span class="icon-bar"></span>
                          <span class="icon-bar"></span>
                     	 </button>
					<p class="navbar-brand visible-xs-block">MENU</p>
		</div>
		<div class="navbar-collapse collapse div-menu-main-collaspe" id="menu">
			<ul class="nav navbar-nav " >
				<li class="icon-alt"> <A HREF="<%=request.getContextPath() %>" >Trang Chủ</A></li>	

                      <li><a href="#"  title="SỰ KIỆN">Giới Thiệu</a></li>
                      <li><a href="#" title="THẾ GIỚI" >Sản Phẩm</a></li>
                      <li><a href="#" title="KHUYẾN MẠI"  >Dịch Vụ</a></li>
                      <li class="menu-cuoi"><a href="#" title="VISA"  >Tuyển Dụng</a></li>
                      <li class="menu-cuoi"><a href="#" title="VISA"  >Liên Hệ</a></li>
			</ul>
		</div>
	</div>
	</div>
	<!-- end baner -->