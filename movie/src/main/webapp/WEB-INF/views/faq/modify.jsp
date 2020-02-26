<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="/resources/inc/header.jsp" %>

		<div id="lnb">
			<div class="inner">
				<ul class="location">
				<li class="on"><a href="#">HOME</a></li>
				<li><a href="#">고객센터</a></li>
				<li><a href="#">공지사항</a></li>
				</ul>
			</div>
		</div>
		<div id="content" class="inner">
			<div class="write_top">
				<h3>공지사항</h3>
				<a href="list.jsp" class="btn">목록</a>
			</div>
			<div class="write write_type1">
				<form action="modify" method="post">
					<input type="hidden" name="no" value="${detail.no}" required />
					<dl class="group">
					<dt>제목</dt> 
					<dd><input type="text" name="subject" value="${detail.subject}" required /></dd>
					</dl>
					<div class="wr_infomation">
						<div class="content">
							<textarea class="textarea" name="content">${detail.content}</textarea>	
						</div>
						<dl class="group">
						<dt>파일#</dt> 
						<dd><input type="file" name="file" /></dd>	
						</dl>
					</div>
					<div class="btn_box">
						<button type="submit" class="submit" alt="작성 완료" title="작성 완료">작성 완료</button>
						<button type="reset" class="cancel" alt="작성 취소" title="작성 취소">취소</button>
					</div>
				</form>
			</div>
		</div>
<%@ include file ="/resources/inc/footer.jsp" %>