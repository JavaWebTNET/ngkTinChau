
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.HashMap"%>
<%@page import="models.DanhMuc"%>
<%@page import="java.util.Vector"%>
<%@ page pageEncoding="utf-8" %>
 

	 			<!-- menu one -->
	 				<div class="col-sm-12 col-xs-12 menu-left-one-child">
					<div class="title-left">Danh Mục Sản Phẩm</div>
					<div class="menu-left-one">
					
					
					
<% HashMap<Integer, ArrayList<DanhMuc>> hmAllDM=(HashMap<Integer, ArrayList<DanhMuc>>)request.getAttribute("danhmuc");
if(hmAllDM.size()>0){
%>

  <ul class="nav ul-menu-one">
  
	<%
 	for(DanhMuc itemlv0:hmAllDM.get(0)){
	%>
	
	 <li><a href="<%= itemlv0.getLink() %>>"><%= itemlv0.getTitle() %></a>
	 
			<!-- 	2------- -->
		 <% if(hmAllDM.containsKey(itemlv0.getId())){
		 %>
			
			<ul class="nav menu-hide">
					
				<%
				for(DanhMuc itemlv1:hmAllDM.get(itemlv0.getId())){
				%>
				  <li class="li-lv1"><a href="<%= itemlv1.getLink()%>"><%= itemlv1.getTitle()%></a></li>
					
				<!-- 	3------- -->
					 <% 
					 if(hmAllDM.containsKey(itemlv1.getId())){
					 %>
						
							<%
							for(DanhMuc itemlv2:hmAllDM.get(itemlv1.getId())){
							%>
								<li><a  href="<%= itemlv2.getLink()%>"><%= itemlv2.getTitle()%></a>								</li>
									
							<%
							}
							%>
					    
					<%	
					}
					%>
				<!-- 3	------- -->
					
			
				<%}
				%>
			 </ul>
			 
			<%				
			}
			%>
			<span class="I"></span> 
				<!-- 2	------- -->
	   </li>
		
	<%	 
	 }	
	%>

</ul>
	
	
<%
}
%>
					
					
					
					
					<!-- 
					<ul class="nav ul-menu-one">
						<li><a href="javascript:void(0)"> Cửa Nhôm XingFa </a>

						<ul class="nav menu-hide" id="1">
							<ol>Cửa đi mở quay</ol>
							<li><a href="#">Cửa đi 1 cách mở quay</a></li>
							<li><a href="#">Cửa đi 2 cánh mở quay</a></li>
							<li><a href="#">Của đi 4 cánh mở quay</a></li>
						</ul>

						<span class="I"></span> 

						<ul class="nav menu-hide" id="1">
							<ol>Cửa đi mở trượt</ol>
								<li><a href="#">Cửa đi trượt 2 cánh</a></li>
								<li><a href="#">Cửa đi trượt 4 cánh</a></li>
							
								
								<li><a href="#">Cửa nhựa lõi thép xếp trượt</a></li>
								<li><a href="#">Cửa lùa 2 cách,4 cách</a></li>
						</ul>
						<span class="I"></span> 


						</li>

						<li ><a>Cửa nhựa lõi thép</a>

						<ul class="nav menu-hide" id="1">
							<ol>Cửa đi mở quay</ol>
							<li><a href="#">Cửa đi 1 cách mở quay</a></li>
							<li><a href="#">Cửa đi 2 cánh mở quay</a></li>
							<li><a href="#">Của đi 4 cánh mở quay</a></li>
						</ul>

						<span class="I"></span> 

						<ul class="nav menu-hide" id="1">
							<ol>Cửa đi mở trượt</ol>
							<li><a href="#">Cửa đi trượt 2 cánh</a></li>
							<li><a href="#">Cửa đi trượt 4 cánh</a></li>
						
							
							<li><a href="#">Cửa nhựa lõi thép xếp trượt</a></li>
							<li><a href="#">Cửa lùa 2 cách,4 cách</a></li>
						</ul>
						<span class="I"></span> 

						</li>




						<li ><a href="#" >Mặt dựng nhôm kính</a>

						<ul class="nav menu-hide" id="1">
						<li><a href="#"> Mặt dựng nhôm kính Unitized</a></li>
						<li><a href="#"> Mặt dựng nhôm kính Stick </a></li>
						<li><a href="#"> Mặt dựng hệ AV</a></li>
						<li><a href="#"> Mặt dựng đầu số 50x60</a></li>
						<li><a href="#">Mặt dựng cover cup</a></li>
						<li><a href="#">Mặt dựng spider</a></li>
						<li><a href="#">Mặt dựng kính Stick</a></li>
						</ul>
						<span class="I"></span> 
						</li>

						<li><a href="#"> Cầu thang-lan can kính </a><span class="I"></span>  </li>
						<li><a href="#">Cửa Kính bản lề sàn</a><span class="I"></span>  </li>
						<li><a href="#">Cửa, vách kính phòng tắm</a>

						<ul class="nav menu-hide" id="1">
							<li><a href="#"> Cửa sổ mở trượt PK 800</a></li>
							<li><a href="#"> Cửa sổ mở quay lậthệ 45 </a></li>
							<li><a href="#"> Cửa sổ mở hất ngoài hệ 55</a></li>
							<li><a href="#"> Cửa sổ mở quay hệ 55</a></li>
							<li><a href="#">Cửa đi xếp trượt hệ 45</a></li>
							<li><a href="#">Cửa đi mở trượt hệ SC-95</a></li>
						</ul>

						<span class="I"></span>  
						</li>



					</ul>
					
					
					
					 -->

				</div>
				</div>
				<!-- ---------- -->