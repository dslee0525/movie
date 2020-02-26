<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/inc/header.jsp" %>

		<div id="lnb">
			<div class="inner">
				<ul class="location">
				<li class="on"><a href="#">HOME</a></li>
				<li><a href="#">스토어</a></li>
				<li><a href="#">스토어</a></li>
				</ul>
			</div>
		</div>
		<div id="content" class="inner">
			<h3>스토어 <a href="#"><i class="xi-plus"></i></a></h3>
			<div class="board_top group">
				<p class="comment">총 <span class="primary bold">6</span>개의 상품이 있습니다.</p>
				<ul class="category group">
				<li class="on"><a href="#">전체</a></li>
				<li><a href="list?category=popcorn">팝콘</a></li>
				<li><a href="list?category=drink">음료</a></li>
				<li><a href="list?category=ticket">영화관람권</a></li>
				</ul>
			</div>
			<div class="event_list gallery_list group">
				<c:forEach items="${list}" var="store">
				<div class="item">
					<a href="view?no=${store.no}">
						<div class="thumb"><img src="../resources/upload${store.fileName}" alt="상품 이미지" /></div>
						<div class="info">
							<p class="tit">${store.subject}</p>
							<p class="txt">${store.summary}</p>
							<div class="price_box">
								<c:choose>
								<c:when test="${store.sale_price > 0}">
								<span class="ori_price">${store.price}원</span>
								<span class="price">${store.sale_price}원</span>
								</c:when>
								<c:otherwise>
								<span class="price">${store.price}원</span>
								</c:otherwise>
								</c:choose>
							</div>
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