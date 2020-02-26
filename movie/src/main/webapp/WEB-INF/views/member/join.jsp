<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/resources/inc/header.jsp" %>
<script type="text/javascript">	
$(document).ready(function() {
	
	var idchk = 0;
	
	$("#id_chk").click(function() {
		var id = $("#id").val();
		//alert(id);
		$.ajax({
			type:"post",
			data:id,
			url:"idCheck",
			dataType:"json",
			contentType:"application/json",
			success:function(data){
				if(data > 0){
					alert("해당 아이디가 존재합니다. 다른 아이디를 입력해주세요.");
					$("#id").focus();
				} else{
					alert("사용가능한 아이디입니다:)");
					$("#pw").focus();
					idchk = 1;
				}
			},
			error : function(error){
				alert("error:"+error);
			}
			
		});
		
	});

});



</script>
	<div id="content" class="membership">
		<div class="memberWrap">
			<h3>회원가입</h3>
			<div class="member_box">
				<form action="" method="post">
					<div class="form_group">
						<div class="form id_form">
							<p>
								<label for="" class="">아이디*</label>
							</p>
							<div class="inputbox">
								<input type="text" name="id" id="id" placeholder="아이디" value="" maxlength="40" class="input_normal">
								<button type="button" class="btn" id="id_chk">중복확인</button>
							</div>
							<span>8~10자 이상의 영문,숫자 조합으로 입력해주세요.</span>
						</div>
						<div class="form">
							<p>
								<label for="" class="">비밀번호 *</label>
							</p>
							<div class="inputbox">
								<input type="password" name="pw" id="pw" placeholder="비밀번호" value="" maxlength="40" class="input_normal" required="">
							</div>
							<span>너무 짧은 비밀번호입니다.</span>
						</div>
						<div class="form">
							<p>
								<label for="" class="">비밀번호 재확인*</label>
							</p>
							<div class="inputbox">
								<input type="password" name="re_pw" placeholder="비밀번호" value="" maxlength="40" class="input_normal" required="">
							</div>
							<span>비밀번호가 일치하지 않습니다.</span>
						</div>	
						<div class="form">
							<p>
								<label for="" class="">이름 *</label>
							</p>
							<div class="inputbox">
								<input type="text" name="name" placeholder="이름" value="" maxlength="40" class="input_normal" required>
							</div>
							<span>이름은 두글자 이상 입력해주세요.</span>
						</div>
						<div class="form">
							<p>
								<label for="" class="">휴대폰번호 *</label>
							</p>
							<div class="inputbox">
								<input type="text" name="phone" placeholder="-없이 입력해주세요" value="" maxlength="40" class="input_normal" required>
							</div>
							<!-- <span>이메일 주소가 맞나요?</span> -->
						</div>
						<div class="form">
							<p>
								<label for="" class="">이메일 *</label>
							</p>
							<div class="inputbox">
								<input type="email" name="email" placeholder="이메일" value="" maxlength="40" class="input_normal" required>
							</div>
							<span>이메일 주소가 맞나요?</span>
						</div>			
						<div class="form formfield">
							<div class="inputbox check_box">
								<input type="checkbox" id="agree_chk" name="" class="" value="" required>
								<label for="agree_chk" id="" class="">개인정보수집 동의에 체크해 주세요.</label>
							</div>				
						</div>
						<button class="bg_primary line_primary full" type="submit" class="submit" alt="회원가입" title="회원가입">회원가입</button>
					</div>
					<!-- //form-group -->
				</form>
			</div>
		</div>
	</div>
<%@ include file="/resources/inc/footer.jsp" %>