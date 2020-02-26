/**
 * aaaaaaa
 */

$(document).ready(function(){
	
	$("#eventpast").click(function(){
		alert("aaa");
		$.ajax({

		    url: "event/past",
		    type: "post",
		    success: function(data){
		    	
		    	
		    	
		    	$(".event_list").html(str)
		    	
		    	
		    },
		    error: function (request, status, error){
		    }
		  });
	});
	
});