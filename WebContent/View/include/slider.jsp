<%@page import="models.ThongTin" %>
<% ThongTin thongtinslider=(ThongTin) request.getAttribute("thongtin"); %>
<%@ page pageEncoding="utf-8" %>

<!----- wordrun------>
	<div class="row">
	<div class="col-sm-12 col-xs-12 contai-wordrun">

	 <marquee loop="-1" >
            <center><%= thongtinslider.getWord_run() %></center>
    </marquee>


	</div>

	</div>
	<!-----end  wordrun------>

	 <!-- - Slider-  -->
	 	<div class="row ">
	 	<div class="col-sm-12 col-xs-12 carousel slide contai-slider" data-ride="carousel" id="myCarousel">

	 		
	 			<ol class="carousel-indicators">
			     
	 			 <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			      <li data-target="#myCarousel" data-slide-to="1"></li>
			      <li data-target="#myCarousel" data-slide-to="2"></li>
			      
			    </ol>

			      <div class="carousel-inner contai-slider-img" role="listbox">
				      <div class="item active">
				        <img src="<%=request.getContextPath()%>/View/Image/slider1.jpg" alt="Chania">
				      </div>

				      <div class="item">
				        <img src="<%=request.getContextPath()%>/View/Image/slider2.jpg" alt="Chania">
				      </div>
				    
				      <div class="item">
				        <img src="<%=request.getContextPath()%>/View/Image/slider3.jpg" alt="Flower">
				      </div>

				      
  				  </div>


	 		</div>	

	 	</div>



	 <!-- -----end Slider----- -->