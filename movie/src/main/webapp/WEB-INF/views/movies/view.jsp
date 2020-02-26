<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file ="/resources/inc/header.jsp" %>
<script type="text/javascript" src="../resources/js/reply.js"></script>
		<div id="lnb">
			<div class="inner">
				<ul class="location">
				<li class="on"><a href="#">HOME</a></li>
				<li><a href="#">영화</a></li>
				<li><a href="#">개봉예정작</a></li>
				</ul>
			</div>
		</div>
		<div id="content" class="inner">
			<!-- h3>무비차트 <a href="#"><i class="xi-plus"></i></a></h3-->
			<div class="view view_type2">
				<div class="view_head group">
					<div class="thumb"><img src="../resources/upload${fn:replace(detailFile.savedPath,'\\', '/')}/${detailFile.fileName}" alt="포스터 이미지" /></div>
					<div class="info">
						<div class="title_box">
							<p class="tit">${detail.title}</p>
							<c:if test="${detail.titleEn ne null}">
								<span class="eng_tit txt_tiny">${detail.titleEn}</span>
							</c:if>
							<span class="age grade_12">${detail.watching_age}</span>
						</div>
						<div class="info_box">
							<dl class="group">
							<dt>감독 :</dt> 
							<dd>${detail.director}</dd>
							</dl>
							<dl class="group">
							<dt>배우 :</dt> 
							<dd>${detail.castmates}</dd>
							</dl>
							<dl class="group">
							<dt>장르 :</dt> 
							<dd>${detail.genre}</dd>
							</dl>
							<dl class="group">
							<dt>기본 :</dt> 
							<dd>${detail.etc_info}</dd>
							</dl>
							<dl class="group">
							<dt>개봉 :</dt> 
							<dd>${detail.open_date}</dd>
							</dl>
							<a href="#" class="bg_primary btn">상세정보</a> <a href="#" class="bg_primary btn">예매</a>
						</div>
					</div>
				</div>
				<div class="view_content">
					<div id="cont">
						<h4>영화소개</h4>
						<div>
							<p class="txt">
							${detail.content}
							</p>
						</div>
					</div>
					<div id="trailer">
						<h4>트레일러</h4>
						영화 관련 동영상 영역
					</div>
					<div id="still_cut">
						<h4>스틸컷</h4>
						영화 관련 이미지 슬라이드 영역
					</div>
				</div>
				<div class="review">
					<h4>실관람객 리뷰</h4>
					<%-- <c:if test="${sessionScope.userId !=null}"> --%>
					<div class="review_box">
						<input type="hidden" name="bno" value="${detail.no}" id="bno">
						<textarea class="textarea" name="replytxt" id="replytxt" placeholder="로그인 후  댓글 등록이 가능합니다."></textarea>
						<button type="button" id="replyAddBtn">등록</button>
					</div>
					<%-- </c:if> --%>
					<div class="reply_box">
						<p>영화 "${detail.title}"에 대해서 총 <span></span>개의 리뷰가 있습니다.</p>
						<div id ="replies">
							<c:forEach items="${list}" var="reply">
							<div class="user user${reply.rno}" data-rno="${reply.rno}">
								<div class="profile"><img src="../resources/img/img_profile.png" alt="프로필 노이미지" /></div>
								<div class="review_cont">
									<span class="bold">${reply.replyer}</span>
									<p class="tit">${reply.replytxt}</p>
								</div>
								<c:if test="${user.id == reply.replyer}">
								<div class="reply_btn_box">
									<button type="button" id="replyModBtn">수정</button>
									<button type="button" id="replyDelBtn">삭제</button>
								</div>
								</c:if>
							</div>
							</c:forEach>
							<c:if test="${empty list}">
								<div class="no_data">등록된 게시물이 없습니다.</div>
							</c:if>
						</div>
					</div>
					
				</div>
				<div class="btn_box">
					<a href="list" class="btn">목록</a>
					<%-- <c:if test="${user.id = 'admin'}"> --%>
					<a href="modify?no=${detail.no}" class="btn">수정</a>
					<a href="delete?no=${detail.no}" class="btn">삭제</a>
					<%-- </c:if> --%>
				</div>
			</div>
		</div>
<%@ include file ="/resources/inc/footer.jsp" %>