<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/resources/inc/header.jsp" %>
	<div id="content" class="membership">
		<div class="memberWrap">
			<h3>로그인</h3>
			<div class="member_box">
				<form action="login" method="post">
					<div class="form_group">
						<div class="form">
							<p>
								<label for="" class="">아이디*</label>
							</p>
							<div class="inputbox">
								<input type="text" name="id" placeholder="아이디" value="" maxlength="40" class="input_normal">
							</div>
						</div>
						<div class="form">
							<p>
								<label for="" class="">비밀번호 *</label>
							</p>
							<div class="inputbox">
								<input type="password" name="pw" placeholder="비밀번호" value="" maxlength="40" class="input_normal" required="">
							</div>
						</div>
						<div class="form">
							<label for="chk_cookie" class=""><input type="checkbox" name="chk_cookie" /> 로그인 유지</label>
							<a href="find_pw">비밀번호 찾기</a>
						</div>
						<button class="bg_primary line_primary full" type="submit" class="submit" alt="로그인" title="로그인">로그인</button>
					</div>
					<!-- //form-group -->
				</form>
				<p class="go_join"><a href="join">아직 CGV회원이 아니신가요? <b>회원가입</b></a></p>
			</div>
		</div>
	</div>
<%@ include file="/resources/inc/footer.jsp" %>