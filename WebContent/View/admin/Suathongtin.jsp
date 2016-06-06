<%@page import="dao.ThongTinDAO"%>
<%@page import="models.ThongTin"%>
<%@ page pageEncoding="utf-8" %>
<%
ThongTin thongtin= (ThongTin) request.getAttribute("thongtinsua"); 
%>
<div class="center-right-title">Quản lý thông tin</div>
<%@ include file="/View/flash.jsp" %>	
<div class="col-sm-12 col-xs-12 center-right-main-admin">
  <div class="center-right-main-admin-child"> 	
  
  			<% if(thongtin!=null){ %>
  
		  <form class="form-horizontal" role="form" enctype="multipart/form-data" action="${ pageContext.request.contextPath}/admin/thongtin/update" method="post" >
		  <input type="hidden" id="id_tt" name="id_tt"  value="<%= thongtin.getId_tt()%>">
		  <div class="form-group">
		  
		    <label class="control-label td-title col-sm-2" >Tên Công Ty (*)</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="name_company" name="name_company"  value="<%= thongtin.getName_company()%>">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label td-title col-sm-2" >Loại hình (*)</label>
		    <div class="col-sm-10"> 
		      <input type="text" class="form-control" id="type_company" name="type_company"  value="<%= thongtin.getType_company()%>">
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <label class="control-label td-title col-sm-2" >Địa chỉ (*)</label>
		    <div class="col-sm-10"> 
		      <input type="text" class="form-control" id="add_company" name="add_company"  value="<%= thongtin.getAdd_company()%>">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="control-label td-title col-sm-2">Tell (*)</label>
		    <div class="col-sm-10"> 
		      <input type="text" class="form-control" id="tell" name="tell"  value="<%= thongtin.getTel()%>" >
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="control-label td-title col-sm-2" >Fax (*)</label>
		    <div class="col-sm-10"> 
		      <input type="text" class="form-control" id="fax" name="fax" value="<%= thongtin.getFax()%>">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="control-label td-title col-sm-2">Email (*)</label>
		    <div class="col-sm-10"> 
		      <input type="text" class="form-control" id="email" name="email" value="<%= thongtin.getEmail()%>">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="control-label td-title col-sm-2">Hotline (*)</label>
		    <div class="col-sm-10"> 
		      <input type="text" class="form-control" id="hotline" name="hotline" value="<%= thongtin.getHotline()%>">
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <label class="control-label td-title col-sm-2">Slogan</label>
		    <div class="col-sm-10"> 
		      <input type="text" class="form-control" id="slogan" name="slogan" value="<%= thongtin.getSlogan()%>">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="control-label td-title col-sm-2">Word_run (*)</label>
		    <div class="col-sm-10"> 
		      <input type="text" class="form-control" id="word_run" name="word_run" value="<%= thongtin.getWord_run()%>" >
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <label class="control-label td-title col-sm-2" >Logo</label>
		    <div class="col-sm-10"> 
		    	 <div class="col-sm-2 div-stt-imglogo"> <img src="<%= thongtin.imageLink(request) %>" ></div>
		    	<div class="col-sm-8 div-uploadimage"><input type="file" name="file-image"  /></div>
		    	<!--   <input type="file" name="file-image" value=""/> -->
		       
		    </div>
		  </div>
		
		  <div class="form-group"> 
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-success btn-suathongtin" id="btn-suathongtin">Submit</button>
		    </div>
		  </div>
		</form>
		  <%} %>
  </div>
</div>

<script >

	$(document).ready(function(){
    
    $('#btn-suathongtin').click(function(){
    	var name_company = $('#name_company').val();
    	var type_company = $('#type_company').val();
    	var add_company = $('#add_company').val();
    
    	var tell = $('#tell').val();
    	var fax = $('#fax').val();
    	var email = $('#email').val();
    	var hotline = $('#hotline').val();
    	var slogan = $('#slogan').val();
    	var hotline = $('#hotline').val();
    	var word_run =$('#word_run').val();
    	
    	
    	if(name_company==""){
    		 alert("Bạn phải nhập đầy đủ thông tin ở các trường (*)"); 
    		 $('#name_company').focus();
    		 return false;
    	}
    	if(type_company==""){
   		 alert("Bạn phải nhập đầy đủ thông tin ở các trường (*)"); 
   		 $('#type_company').focus();
   		 return false;
   		}
    	
    	if(add_company==""){
      		 alert("Bạn phải nhập đầy đủ thông tin ở các trường (*)"); 
      		 $('#add_company').focus();
      		 return false;
      		}
    	    	
    	if(fax==""){
    		 alert("Bạn phải nhập đầy đủ thông tin ở các trường (*)"); 
    		 $('#fax').focus();
    		 return false;
    		}
    	
    	if(email==""){
   		 alert("Bạn phải nhập đầy đủ thông tin ở các trường (*)"); 
   		 $('#email').focus();
   		 return false;
   		}
    	
   	
    	if(word_run==""){
      		 alert("Bạn phải nhập đầy đủ thông tin ở các trường (*)"); 
      		 $('#word_run').focus();
      		 return false;
      		}
 
    	if(tell==""){
     		 alert("Bạn phải nhập đầy đủ thông tin ở các trường (*)"); 
     		 $('#tell').focus();
     		 return false;
     		}
    	if(hotline==""){
    		 alert("Bạn phải nhập đầy đủ thông tin ở các trường (*)"); 
    		 $('#hotline').focus();
    		 return false;
    		}
    	
    	
    	
    	if(!isEmail(email)){
     		 alert("Email không đúng định dạng..!"); 
     		 $('#email').focus();
     		 return false;
     		}
    	return true;
  
    
    });
	});

	 function isEmail(emailStr)
	 {
	         var emailPat=/^(.+)@(.+)$/
	         var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]"
	         var validChars="\[^\\s" + specialChars + "\]"
	         var quotedUser="(\"[^\"]*\")"
	         var ipDomainPat=/^\[(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\]$/
	         var atom=validChars + '+'
	         var word="(" + atom + "|" + quotedUser + ")"
	         var userPat=new RegExp("^" + word + "(\\." + word + ")*$")
	         var domainPat=new RegExp("^" + atom + "(\\." + atom +")*$")
	         var matchArray=emailStr.match(emailPat)
	         if (matchArray==null) {
	                 return false
	         }
	         var user=matchArray[1]
	         var domain=matchArray[2]
	  
	         // See if "user" is valid
	         if (user.match(userPat)==null) {
	             return false
	         }
	         var IPArray=domain.match(ipDomainPat)
	         if (IPArray!=null) {
	             // this is an IP address
	                   for (var i=1;i<=4;i++) {
	                     if (IPArray[i]>255) {
	                         return false
	                     }
	             }
	             return true
	         }
	         var domainArray=domain.match(domainPat)
	         if (domainArray==null) {
	             return false
	         }
	  
	         var atomPat=new RegExp(atom,"g")
	         var domArr=domain.match(atomPat)
	         var len=domArr.length
	  
	         if (domArr[domArr.length-1].length<2 ||
	             domArr[domArr.length-1].length>3) {
	            return false
	         }
	  
	         if (len<2)
	         {
	            return false
	         }
	  
	         return true;
	 }	
</script>
