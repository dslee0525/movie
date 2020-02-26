<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="/resources/inc/header.jsp" %>

		<div id="lnb">
			<div class="inner">
				<ul class="location">
				<li class="on"><a href="#">HOME</a></li>
				<li><a href="#">이벤트</a></li>
				<li><a href="#">이벤트</a></li>
				</ul>
			</div>
		</div>
		<div id="content" class="inner">
			<!-- h3>무비차트 <a href="#"><i class="xi-plus"></i></a></h3-->
			<div class="view view_type1">
				<div class="info">
					<div class="title_box">
						<p class="tit">${detail.subject}</p>
						<div class="movie_info">
							<dl class="group">
							<dt><i class="xi-clock-o"></i> 작성일시. </dt> 
							<dd>${detail.wr_date}</dd>
							</dl>
							<dl class="group">
							<dt><i class="xi-eye-o"></i> 조회수. </dt> 
							<dd>${detail.cnt}</dd>
							</dl>
						</div>
						
					</div>
					<div class="view_content">
						${detail.content}
					</div>
				</div>
				<div class="btn_box">
					<a href="list" class="btn">목록</a>
					<a href="modify?no=${detail.no}" class="btn">수정</a>
					<a href="delete?no=${detail.no}" class="btn btn_gravity">삭제</a>
				</div>
			</div>
		</div>
<%@ include file ="/resources/inc/footer.jsp" %>