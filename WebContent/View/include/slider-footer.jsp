	<%@ page pageEncoding="utf-8" %>
	<%@page import="java.util.Vector"%>
	<%@page import="models.SanPham" %>
	
	<% @SuppressWarnings("unchecked")
	Vector<SanPham> vtspnb=(Vector<SanPham>)request.getAttribute("spnb"); %>
	<!-- phần slider footer -->
	 <div class="row">
	 	<div class="col-sm-12 col-xs-12 contai-lidersp">
	 	<div class="contai-title-lidersp">Sản Phẩm Nổi Bật</div>

	 	<div class="col-sm-12 col-xs-12 carousel slide contai-slidersp-child" data-ride="carousel" id="myCarouselSp">
      
        <ol class="carousel-indicators">
           <% int numSlider = vtspnb.size()/6;
           	  if(vtspnb.size()%6!=0) numSlider++;
           for(int i=0; i<numSlider; i++){ %>
	         <li data-target="#myCarouselSp" data-slide-to="<%=i %>" <%if(i==0){%>class="active"<%} %>></li>
           <%} %> 
        </ol>

        <div class="col-sm-12 col-xs-12 carousel-inner contai-slider-sp-img" role="listbox">
        <% int islider = 1;
        for(SanPham spnb:vtspnb) { 
        	if(islider%6 == 1) {
        		%>
        <div class="col-sm-12 col-xs-12  item <%=islider==1?"active":"" %> ">
        		<%
        	}
        	%>
        	<a href="<%=request.getContextPath()%>/sanpham/<%=spnb.getSuper_id() %>">
        	<img  src="<%=spnb.imageLink(request) %>" alt="<%=spnb.getTitle() %>" class="col-sm-12 col-xs-2">
        	</a>  
        	<%
        	if(islider%6 == 0) {
        		%>
        </div>
        		<%
        	}
        	islider++;
        }
        %>
        	       
        </div>

        </div>  
		<a class="left carousel-control" href="#myCarouselSp" role="button" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarouselSp" role="button" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	      <span class="sr-only">Next</span>
	    </a>

	 	</div>

	 </div>