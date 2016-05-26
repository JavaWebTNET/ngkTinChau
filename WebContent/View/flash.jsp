<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String fmsg = (String)request.getAttribute("flash_success");
   if(fmsg!=null){
%>
    <div class="alert alert-success">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        <strong>Success! </strong><%=fmsg%>
    </div>
<%} %>

<% fmsg = (String)request.getAttribute("flash_error");
   if(fmsg!=null){
%>
    <div class="alert alert-danger">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        <strong>Error! </strong><%=fmsg%>
    </div>
<%} %>

<% fmsg = (String)request.getAttribute("flash_info");
   if(fmsg!=null){
%>
	<div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        <strong>Info! </strong><%=fmsg%>
    </div>
<%} %>

<% String[] fvalids = (String[])request.getAttribute("flash_valid");
   if(fmsg!=null) {
%>
    <div class="alert alert-danger">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
      <%for(String fvalid:fvalids){ %>  
        <strong>Error! </strong><%=fvalid%><br/>
      <%} %>
    </div>   
<%} %>