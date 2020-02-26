<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/resources/inc/header.jsp" %>

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
		<h3>공지사항</h3>
		<div class="board_top group">
			<p class="comment">총 <span class="primary bold">${page.total}</span>개의 게시글이 있습니다.</p>
			
			<div id="board_search_form">
				<form action="" method="get">
				<input type="text" placeholder="제목을 입력해주세요." />
				<button type="button"><i class="xi-search"></i></button>
				</form>
			</div>
		</div>
		<div class="list list_type list_type1">
		    <!-- list_table -->
		    <div class="board_head m_hidden">
		        <ul class="row">
		        <li class="no">번호</li>
		        <li class="subject">제목</li>
		        <li class="date">날짜</li>
		        <li class="view">조회수</li>
		        </ul>
		    </div>
		    <div class="board_body">
		    	<c:forEach items="${list}" var="notice">
		    	<div>
			        <a href="view?no=${notice.no}">
		                <ul class="row">
		                <li class="no m_hidden">${notice.no}</li>
                        <li class="subject">
		                    <strong>${notice.subject}</strong>
		                </li>
		                <li class="date">${notice.wr_date}</li>
		                <li class="view m_hidden">${notice.cnt}</li>
		                </ul>
		            </a>
	            </div>
	            </c:forEach>
		    </div>
		
		    <!-- pagination -->
		    <div class="pagination">
		    	<c:if test="${page.prev}">
		    	<a href="list?pageNum=${page.startPage-1}&amount=${page.cri.amount}" title="1 페이지"><i class="xi-angle-left-thin"></i></a>
		    	</c:if>
		        <ul>
		        <c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
		        <li><a href="list?pageNum=${num}&amount=${page.cri.amount}" title="1 페이지">${num}</a></li>
		        </c:forEach>
		        </ul>
		        <c:if test="${page.next}">
		    	<a href="list?pageNum=${page.endPage-1}&amount=${page.cri.amount}" title="1 페이지"><i class="xi-angle-right-thin"></i></a>
		    	</c:if>
		    </div>
		    <!-- //pagination -->
		</div>
	</div>
<%@ include file ="/resources/inc/footer.jsp" %>