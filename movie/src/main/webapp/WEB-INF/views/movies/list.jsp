<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/inc/header.jsp" %>

		<div id="lnb">
			<div class="inner">
				<ul class="location">
				<li class="on"><a href="#">HOME</a></li>
				<li><a href="#">영화</a></li>
				<li><a href="#">무비차트</a></li>
				</ul>
			</div>
		</div>
		<div id="content" class="inner">
			<h3>무비차트 <a href="#"><i class="xi-plus"></i></a></h3>
			<div class="board_top group">
				<p class="comment">총 <span class="primary bold">12</span>개의 영화가 있습니다.</p>
				
				<ul class="category group">
				<li class="on"><a href="#">상영작</a></li>
				<li><a href="#">인기순</a></li>
				<li><a href="#">개봉예정작</a></li>
				</ul>
			</div>
			<div class="movie_list group">
				<c:forEach items="${list}" var="movie">
				<div class="movie">
					<div class="thumb"><a href="view?no=${movie.no}"><img src="../resources/upload${movie.fileName}" alt="포스터 이미지" /><em>1</em></a></div>
					<div class="info">
						<p class="tit">${movie.title}</p>
						<span class="age grade_12">${movie.watching_age}</span>
						<ul>
						<li><a href="view?no=${movie.no}">상세정보</a></li>
						<li><a href="view?no=${movie.no}">예매</a></li>
						</li>
						</ul>
					</div>
				</div>
				</c:forEach>
				<c:if test="${empty list}">
					<div class="no_data">등록된 게시물이 없습니다.</div>
				</c:if>
			</div>
		</div>
	<%@ include file ="/resources/inc/footer.jsp" %>