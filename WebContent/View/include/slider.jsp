<%@page import="models.Slider"%>
<%@page import="java.util.Vector"%>
<%@page import="models.ThongTin" %>
<% ThongTin thongtinslider=(ThongTin) request.getAttribute("thongtin"); %>

<% 
Vector<Slider> vtslider=new Vector<Slider>();
if(request.getAttribute("slider")!=null){
 vtslider=(Vector<Slider>) request.getAttribute("slider"); }%>
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
			      	 <%if(vtslider.size()>0){ %>
				      <div class="item active">
				        <img src="<%= vtslider.get(0).imageLink(request) %>" >
				      </div>
				      <% 
				      for(int i=1;i<vtslider.size();i++){
				      %>
				      <div class="item">
				        <img src="<%= vtslider.get(i).imageLink(request) %>" >
				      </div>
				      <%}} %>
						 
				      
  				  </div>


	 		</div>	

	 	</div>



	 <!-- -----end Slider----- -->