<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file ="/resources/inc/header.jsp" %>

		<div id="lnb">
			<div class="inner">
				<ul class="location">
				<li class="on"><a href="#">HOME</a></li>
				<li><a href="#">이벤트</a></li>
				<li><a href="#">이벤트 수정</a></li>
				</ul>
			</div>
		</div>
		<div id="content" class="inner">
			<div class="write_top">
				<h3>이벤트</h3>
				<a href="list" class="btn">목록</a>
			</div>
			<div class="write write_type1">
				<form action="modify" method="post" enctype="multipart/form-data">
					<input type="hidden" name="boardName" value="movies" required />
					<input type="hidden" name="no" value="${detail.no}" required />
					<dl class="group">
					<dt>제목</dt> 
					<dd><input type="text" name="subject" value="${detail.subject}" required /></dd>
					</dl>
					<div class="wr_infomation">
						<div class="summary group">
							<dl class="left">
							<dt>이벤트 시작일</dt> 
							<dd><input type="text" name="open_date" id="datepicker" value="${detail.open_date}" required /></dd>
							</dl>
							<dl class="left">
							<dt>이벤트 종료일</dt> 
							<dd><input type="text" name="end_date" id="datepicker2" value="${detail.end_date}" required /></dd>
							</dl>						
						</div>
						<div class="contentDiv">
							<textarea class="textarea" name="content">${detail.content}</textarea>	
						</div>
						<dl class="group">
						<dt>파일#</dt> 
						<dd>
							<input type="hidden" name="fno" value="${detailFile.fno}" />
							<input type="file" name="file" />
							<a href="../resources/upload${fn:replace(detailFile.savedPath,'\\', '/')}/${detailFile.fileName}" target="_blank">기존 파일:${detailFile.originalName}</a>
						</dd>	
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