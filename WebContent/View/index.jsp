<%@page import="dao.DanhMucDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.HashMap"%>
<%@page import="models.DanhMuc"%>
<%@page import="java.util.Vector"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="w@idth=device-width, initial-scale=1.0">
        <title>Bootstrap 3 Tabs</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
       	<link rel="stylesheet" href="<%=request.getContextPath()%>/View/CSS/CssTc.css">
       	<script src="<%=request.getContextPath()%>/View/JS/myjs.js"></script>
</head>
<body>

<div class="container contai-main">
<% HashMap<Integer, ArrayList<DanhMuc>> hmAllDM=(HashMap<Integer, ArrayList<DanhMuc>>)request.getAttribute("danhmuc");
if(hmAllDM.size()>0){
	%>
	<ul>
	<%
 for(DanhMuc itemlv0:hmAllDM.get(0)){
	%>
	<li><a href="<%= itemlv0.getLink() %>>"><%= itemlv0.getTitle() %></a>
	 <% if(hmAllDM.containsKey(itemlv0.getId())){
		 %>
			<ul>
			<%
		for(DanhMuc itemlv1:hmAllDM.get(itemlv0.getId())){
	 %>
		<li><a style="color: red" href="<%= itemlv1.getLink()%>"><%= itemlv1.getTitle()%></a>
	
		</li>	

	<%}
		%>
		</ul>
		<%	
	}%>
	</li>
	
<%	 
 }	
	%>
	</ul>
	<%
}
 %>
<%-- if(arrAllDM.size()>0){
ArrayList<DanhMuc> arrParents=arrAllDM.get(0);
arrAllDM.remove(0);
for(DanhMuc itemParents:arrParents){
%>
	<ul><li><a href="<%= itemParents.getLink()%>"><%= itemParents.getTitle() %></a>
	<% if(arrAllDM.get(itemParents.getId())!=null){
		ArrayList<DanhMuc> arrlv1=arrAllDM.get(itemParents.getId());
		arrAllDM.remove(itemParents.getId());
		%>
		<ul>
		<%
		for(DanhMuc itemlv1:arrlv1){
		%>	
			<li><a href="<%= itemlv1.getLink()%>"><%= itemlv1.getTitle() %></a>
			<% if(arrAllDM.get(itemParents.getId())!=null){
				ArrayList<DanhMuc> arrlv2=arrAllDM.get(itemParents.getId());
				arrAllDM.remove(itemParents.getId());
				%>
					<ul>
					<%
					for(DanhMuc itemlv2:arrlv2){
					%>
						<li><a href="<%= itemlv2.getLink()%>"> <%= itemlv2.getTitle() %> </a></li>
					
				
					<%
						}
					%>
					</ul>
				<%
				 } 
				%>
				
				
			</li>
		<%
		}
		%>
		</ul>
		<%
	 } 
	%>
		
	</li>
	
	
	
	
	</UL>
	
	
<%
	}
} --%>

<%-- <% Vector<DanhMuc> vtdm=(Vector<DanhMuc>)request.getAttribute("danhmuc"); 
for(DanhMuc item:vtdm){ %>
<%= item.getTitle() %>
<%} %> --%>

<%@ include file="include/header.jsp" %>
<%@ include file="include/slider.jsp" %>

<!-- -----main center----- -->
<div class="row">
<div class="col-sm-12 dol-xs-12 contai-main-center">
<div class="col-sm-3 col-xs-12 main-center-left">
<!-- ---- -->
<div class="col-sm-12 col-xs-12 center-left-one">

<%@ include file="include/left-header.jsp" %>					
<%@ include file="include/left-footer.jsp" %>	

 </div>
</div> <!-- kết thúc  main-center-left được khai báo trong left-header -->
<div class="col-sm-9 col-xs-12 main-center-right"> <!-- bắt đầu phần center -->

<%@ include file="include/center.jsp" %>

</div> <!-- đóng phần main-center-right -->
</div> <!-- đóng phần contai-main-center --> 
</div> <!-- đóng phân row center -->
 <!-- -----end maincenter----- -->
 
<%@ include file="include/slider-footer.jsp" %>
<%@ include file="include/footer.jsp" %>


</div>

</body>
</html>