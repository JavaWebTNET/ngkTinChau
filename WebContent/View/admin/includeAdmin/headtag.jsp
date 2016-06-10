<%@page pageEncoding="UTF-8"%>
<%@page import="models.ThongTin" %>
<% ThongTin thongtinhtag=(ThongTin) request.getAttribute("thongtin"); %>
<link rel="icon" href="<%=thongtinhtag.imageLink(request) %>">
<title><%=thongtinhtag.getType_company() %> <%=thongtinhtag.getName_company() %> - Trang Admin</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/View/CSS/CssTc.css">
<script src="<%=request.getContextPath()%>/View/JS/myjs.js"></script>