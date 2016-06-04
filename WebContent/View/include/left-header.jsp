
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
	
	 <li><a href="#"><%= itemlv0.getTitle() %></a>
	 
			<!-- 	2------- -->
		 <% if(hmAllDM.containsKey(itemlv0.getId())){
		 %>
			
			<ul class="nav menu-hide">
					
				<%
				for(DanhMuc itemlv1:hmAllDM.get(itemlv0.getId())){
				%>
				  <li class="li-lv1"><a href="#"><%= itemlv1.getTitle()%></a></li>
					
				<!-- 	3------- -->
					 <% 
					 if(hmAllDM.containsKey(itemlv1.getId())){
					 %>
						
							<%
							for(DanhMuc itemlv2:hmAllDM.get(itemlv1.getId())){
							%>
								<li><a  href="#"><%= itemlv2.getTitle()%></a>								</li>
									
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
					

</div>
</div>
<!-- ---------- -->