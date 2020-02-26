<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/resources/inc/header.jsp" %>
	<div id="content" class="membership">
		<div class="memberWrap">
			<h3>비밀번호 찾기</h3>
			<div class="member_box">	
				<div class="guide">
					<i class="xi-lock"></i>
					<p>비밀번호를 찾고자 하는 아이디를 입력해주세요.</p>
				</div>
				<form action="" method="post">
					<div class="form_group">
						<div class="form">
							<div class="inputbox">
								<input type="text" name="wr_id" placeholder="아이디" value="" maxlength="40" class="input_normal">
							</div>
						</div>
						<button class="bg_primary line_primary full" type="submit" class="submit" alt="다음" title="다음">다음</button>
					</div>
					<!-- //form-group -->
				</form>
			</div>
		</div>
	</div>
<%@ include file="/resources/inc/footer.jsp" %>