/**
 * 
 */

$(function() { 
	var userIdCheck = RegExp(/^[A-Za-z0-9_\-]{5,20}$/);
	var pwCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\'",.<>\/?]).{8,16}$/);
	var nameCheck = RegExp(/^[가-힣]{2,6}$/);
	var nickNameCheck = RegExp(/^[가-힣a-zA-Z0-9]{2,10}$/);
	var emailCheck = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
	var birthdayCheck = RegExp(/^(19|20)[0-9]{2}(0[1-9]|1[1-2])(0[1-9]|[1-2][0-9]|3[0-1])$/);
	var phonNumberCheck = RegExp(/^01[0179][0-9]{7,8}$/);

	$("#id").keyup(function(){
		
		if($(this).val()==""){}
	})
});