/*hàm xử lý ẩn hiện của menu-left*/
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
