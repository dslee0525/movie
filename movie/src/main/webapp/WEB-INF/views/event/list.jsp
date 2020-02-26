<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/inc/header.jsp" %>
<!-- <script type="text/javascript" src="../resources/js/list.js"></script> -->
		<div id="lnb">
			<div class="inner">
				<ul class="location">
				<li class="on"><a href="#">HOME</a></li>
				<li><a href="#">이벤트</a></li>
				<li><a href="#">진행중인 이벤트</a></li>
				</ul>
			</div>
		</div>
		<div id="content" class="inner">
			<h3>이벤트</h3>
			<div class="board_top group">
				<p class="comment">총 <span class="primary bold">${total}</span>개의 이벤트가 있습니다.</p>
				
				<ul class="category group">
				<li class="on"><a href="list">진행중인 이벤트</a></li>
				<li><a href="past">지난 이벤트</a></li>
				</ul>
			</div>
			<div class="event_list gallery_list group">
				<c:forEach items="${list}" var="event">
				<div class="item">
					<a href="view?no=${event.no}">
						<div class="thumb"><img src="../resources/upload${event.fileName}" alt="이벤트 이미지" /></div>
						<div class="info">
							<p class="tit">${event.subject}</p>
							<p class="date"><i class="xi-clock-o"></i> ${event.open_date} ~ ${event.end_date}</p>
						</div>
					</a>
				</div>
				</c:forEach>
				<c:if test="${empty list}">
					<div class="no_data">등록된 게시물이 없습니다.</div>
				</c:if>
			</div>
		</div>
	<%@ include file ="/resources/inc/footer.jsp" %>