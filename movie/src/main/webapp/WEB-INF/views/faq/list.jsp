<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/resources/inc/header.jsp" %>

	<div id="lnb">
		<div class="inner">
			<ul class="location">
			<li class="on"><a href="#">HOME</a></li>
			<li><a href="#">고객센터</a></li>
			<li><a href="#">자주하는질문</a></li>
			</ul>
		</div>
	</div>
	<div id="content" class="inner">
		<h3>자주하는질문</h3>
		<div class="board_top group">
			<p class="comment">총 <span class="primary bold">${total}</span>개의 게시글이 있습니다.</p>
			
			<ul class="category group">
			<li class="on"><a href="list">전체</a></li>
			<li><a href="list?category=reserve">예매/매표</a></li>
			<li><a href="list?category=guide">이용안내</a></li>
			<li><a href="list?category=pay">결제수단</a></li>
			<li><a href="list?category=sale">할인혜택</a></li>
			<li><a href="list?category=etc">기타</a></li>
			</ul>
		</div>
		<div class="list list_type list_type1">
		    <!-- list_table -->
		    <div class="board_head m_hidden">
		        <ul class="row">
		        <li class="no">번호</li>
		        <li class="category">구분</li>
		        <li class="subject">제목</li>
		        <li class="date">날짜</li>
		        <li class="view">조회수</li>
		        </ul>
		    </div>
		    <div class="board_body">
		    	<c:forEach items="${list}" var="faq">
		    	<div>
			        <a href="view?no=${faq.no}">
		                <ul class="row">
		                <li class="no m_hidden">${faq.no}</li>
		                <li class="category"><span class="primary line_primary">${faq.category}</span></li>
                        <li class="subject">
		                    <strong>${faq.subject}</strong>
		                </li>
		                <li class="date">${faq.wr_date}</li>
		                <li class="view m_hidden">${faq.cnt}</li>
		                </ul>
		            </a>
	            </div>
	            </c:forEach>
		    </div>
		
		    <!-- pagination -->
		    <div class="pagination">
		        <ul>
		        <li class="on"><a href="?page=1" title="1 페이지">1</a></li>
		        <li><a href="#" title="2 페이지">2</a></li>
		        </ul>
		    </div>
		    <!-- //pagination -->
		</div>
	</div>
<%@ include file ="/resources/inc/footer.jsp" %>