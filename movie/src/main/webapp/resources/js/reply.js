/**

 * 

 */

/*$.getJSON("../replies/all/"+bno, function(data){
	//alert("data:"+data);
	console.log(data.length);

	$(data).each(function(){
		str += "<li data-rno='"+this.rno+"' class='replyli'>"
			+this.rno+" : <span>"+this.replytext
			+"</span> <button type='button'>더보기</button></li>";
	});

	$("#replies").html(str);

});*/

$(document).ready(function(){
	$("#replyAddBtn").on("click", function(){
		//alert("replyAddBtn");
		var bno = $("#bno").val();
		alert(bno);
		//var replyer = $("#replyer").val();
		var replytxt = $("#replytxt").val();

		console.log("bno:"+bno);
		//console.log("replyer:"+replyer);
		console.log("replytext:"+replytxt);
		
		$.ajax({
			type:"post",
			url:"../replies",
			contentType:"application/json",
			//dataType:"JSON",
			dataType:"text",
			data:JSON.stringify({bno:bno,replytxt:replytxt}),
			success:function(data){
				alert("정상 처리되었습니다.");
				location.reload();
			},
			error:function(err){
				alert("정상 처리되지 못했습니다.");
			}
		})

	});

	$("#modDiv").hide();

	$("#replies").on("click", ".replyli button", function(){
		//alert("replyAddBtn");
		var reply = $(this).parent();
		var rno = reply.attr("data-rno");
		var replytext = reply.children("span").text();

		//alert(rno+" : "+replytext);

		$(".modal-title").html(rno);
		$("#replytext").val(replytext);
		$("#modDiv").show("slow");

	});

	

	$("#replyModBtn").on("click", function(){
		//alert("replyAddBtn");
		var rno = $(".modal-title").html();
		var replytxt = $("#replytxt").val();

		console.log("rno:"+rno);
		console.log("replytxt:"+replytxt);

		$.ajax({
			type:"put",
			url:"../replies/"+rno,
			contentType:"application/json",
			//dataType:"JSON",
			dataType:"text",
			data:JSON.stringify({rno:rno,replytxt:replytxt}),
			success:function(data){
				if(data=="Modify"){
					alert("정상 처리되었습니다.");
					location.reload();
				}
			},
			error:function(err){
				alert("정상 처리되지 못했습니다.");
			}
		})
	});

	$("#replyDelBtn").on("click", function(){
		//alert("replyAddBtn");

		var rno = $(".modal-title").html();
		console.log("rno:"+rno);
		$.ajax({
			type:"delete",
			url:"../replies/"+rno,
			contentType:"application/json",
			//dataType:"JSON",
			dataType:"text",
			data:JSON.stringify({replytext:replytext}),
			success:function(data){
				if(data=="Delete"){
					alert("정상 처리되었습니다.");
					location.reload();
				}
			},
			error:function(err){
				alert("정상 처리되지 못했습니다.");
			}
		})

	});

})


