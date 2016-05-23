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
	
       	<link rel="stylesheet" href="../CSS/CssTc.css">
</head>
<body>

<div class="container contai-main">




</div>

</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script>
$(document).ready(function(){

 $(".I").click(function(){

 	var child=$(this).parents("li").find("ul");
 	// check in tag ul have exist ul child?
 	if($(this).parents("li").find("ul").length!=0){
        if(child.is(':visible'))
        {

        	child.slideUp();
        	$(this).parents("li").removeClass('li-menu-show')
        }
        else{
        	child.slideDown();
        	$(this).parents("li").addClass('li-menu-show');
        	
        }
    }
    });

 $(".menu-hide").click(function() {
 	$(this).show('slow/400/fast', function() {
 		
 	});
 });



   
    
});
</script>