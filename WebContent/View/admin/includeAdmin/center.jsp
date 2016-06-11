
	<%@ page pageEncoding="utf-8" %>
	<% String center = (String) request.getAttribute("center"); %>
	<%if(center.equals("index")) { %>
	<%@ include file="/View/admin/index.jsp"%>
	<% } else if(center.equals("changepw")) { %>
	<%@ include file="/View/admin/changepw.jsp"%>
	<% } else if(center.equals("QLthongtin")) { %>
	<%@ include file="/View/admin/QLthongtin.jsp"%>
	<% } else if(center.equals("Suathongtin")) { %>
	<%@ include file="/View/admin/Suathongtin.jsp"%>
	<% } else if(center.equals("QLslider")) { %>
	<%@ include file="/View/admin/QLslider.jsp"%>
	<% } else if(center.equals("QLdanhmuc")) { %>
	<%@ include file="/View/admin/QLdanhmuc.jsp"%>
	<% } else if(center.equals("QLdichvu")) { %>
	<%@ include file="/View/admin/QLdichvu.jsp"%>
	<% } else if(center.equals("Themdanhmuc")) { %>
	<%@ include file="/View/admin/Themdanhmuc.jsp"%>
	<% } else if(center.equals("Themdichvu")) { %>
	<%@ include file="/View/admin/Themdichvu.jsp"%>
	<% } else if(center.equals("Themsanpham")) { %>
	<%@ include file="/View/admin/Themsanpham.jsp"%>
	<% } else if(center.equals("Suadanhmuc")) { %>
	<%@ include file="/View/admin/Suadanhmuc.jsp"%>
	<% } else if(center.equals("Suadichvu")) { %>
	<%@ include file="/View/admin/Suadichvu.jsp"%>
	<% } else if(center.equals("Suasanpham")) { %>
	<%@ include file="/View/admin/Suasanpham.jsp"%>
	<% } else if(center.equals("Suatrangtt")) { %>
	<%@ include file="/View/admin/Suatrangtt.jsp"%>
	<% } else if(center.equals("Error")) { %>
	<%@ include file="/View/admin/Error.jsp"%>
	<% } else if(center.equals("QLtintuc")) { %>
	<%@ include file="/View/admin/QLtintuc.jsp"%>
	<% } else if(center.equals("Themtintuc")) { %>
	<%@ include file="/View/admin/Themtintuc.jsp"%>
	<% } else if(center.equals("Suatintuc")) { %>
	<%@ include file="/View/admin/Suatintuc.jsp"%>
	<% } else if(center.equals("QLtuyendung")) { %>
	<%@ include file="/View/admin/QLtuyendung.jsp"%>
	<% } else if(center.equals("Themtuyendung")) { %>
	<%@ include file="/View/admin/Themtuyendung.jsp"%>
	<% } else if(center.equals("Suatuyendung")) { %>
	<%@ include file="/View/admin/Suatuyendung.jsp"%>
	<% } %>	
