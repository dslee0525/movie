<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
							<dt><i class="xi-clock-o"></i> 기간. </dt> 
							<dd>${detail.open_date} ~ ${detail.end_date}</dd>
							</dl>
							<dl class="group">
							<dt><i class="xi-eye-o"></i> 조회수. </dt> 
							<dd>${detail.cnt}</dd>
							</dl>
						</div>
						
					</div>
					<div class="view_content">
						<img src="../img/img_event5_detail.jpg" alt="2019년 연말정산 이미지" />
					</div>
				</div>
				<div class="btn_box">
					<a href="list" class="btn">목록</a>
					<a href="modify?no=${detail.no}" class="btn">수정</a>
					<a href="delete?no=${detail.no}" class="btn">삭제</a>
				</div>
			</div>
		</div>
<%@ include file ="/resources/inc/footer.jsp" %>