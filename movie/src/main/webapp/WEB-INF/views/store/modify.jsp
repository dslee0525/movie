<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file ="/resources/inc/header.jsp" %>

		<div id="lnb">
			<div class="inner">
				<ul class="location">
				<li class="on"><a href="#">HOME</a></li>
				<li><a href="#">스토어</a></li>
				<li><a href="#">스토어 글쓰기</a></li>
				</ul>
			</div>
		</div>
		<div id="content" class="inner">
			<div class="write_top">
				<h3>스토어</h3>
				<a href="list" class="btn">목록</a>
			</div>
			<div class="write write_type1">
				<form action="modify" method="post" enctype="multipart/form-data">
					<input type="hidden" name="boardName" value="store" required />
					<input type="hidden" name="no" value="${detail.no}" required />
					<dl class="group">
					<dt>상품명</dt> 
					<dd><input type="text" name="subject" value="${detail.subject}" required /></dd>
					</dl>
					<div class="wr_infomation">
						<div class="summary group">
							<dl class="left">
							<dt>상품 가격</dt> 
							<dd><input type="text" name="price" value="${detail.price}" required /></dd>
							</dl>
							<dl class="left">
							<dt>상품 할인가</dt> 
							<dd><input type="text" name="sale_price" value="${detail.sale_price}" value="0" /></dd>
							</dl>
							<dl class="left">
							<dt>상품 분류</dt> 
							<dd>
								<select name="category" id="cate" class="select cate" value="${detail.category}" required>
				                    <option value="all">전체</option>
							        <option value="popcorn">팝콘</option>
							        <option value="drink">음료</option>
						            <option value="ticket">영화관람권</option>
				                </select>
				            </dd>
				            </dl>
							<dl class="left">
							<dt>상품구성</dt> 
							<dd><input type="text" name="component" value="${detail.component}" required /></dd>
							</dl>
							<dl class="left">
							<dt>상품 소개 한줄</dt> 
							<dd><input type="text" name="summary" value="${detail.summary}" required /></dd>
							</dl>
							<dl class="left">
							<dt>상품 유효기간</dt> 
							<dd><input type="text" name="expiry_date" value="${detail.expiry_date}" required /></dd>
							</dl>							
						</div>
						<div class="contentDiv">
							<dl class="group">
							<dt>유의사항 및 안내사항</dt> 
							<dd><textarea class="textarea" name="content" required>${detail.content}</textarea>	</dd>
							</dl>
						</div>
						<dl class="group">
						<dt>이미지 파일#</dt> 
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