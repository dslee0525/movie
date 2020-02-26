<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="/resources/inc/header.jsp" %>

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
			<div class="write_top">
				<h3>무비차트</h3>
				<a href="list" class="btn">목록</a>
			</div>
			<div class="write write_type1">
				<form action="write" method="post" enctype="multipart/form-data">
					<dl class="group">
					<dt>영화제목</dt> 
					<dd><input type="text" name="title" required /></dd>
					</dl>
					<dl class="group">
					<dt>영화제목(영문)</dt> 
					<dd><input type="text" name="titleEn" /></dd>
					</dl>
					<div class="wr_infomation">
						<div class="summary group">
							<dl class="left">
							<dt>관람 연령</dt> 
							<dd>
								<select name="watching_age" id="watching_age" class="select mv_watch_age" required>
				                    <option value="all">전체</option>
							        <option value="12">12</option>
						            <option value="15">15</option>
						            <option value="19">청불</option>
				                </select>
				            </dd>
				            </dl>
				            <dl class="left">
							<dt>개봉</dt> 
							<dd><input type="text" name="open_date" id="datepicker" required /></dd>
							</dl>
							<dl class="left">
							<dt>감독</dt> 
							<dd><input type="text" name="director" required /></dd>
							</dl>
							<dl class="left">
							<dt>배우</dt> 
							<dd><input type="text" name="castmates" required /></dd>
							</dl>
							<dl class="left">
							<dt>장르</dt> 
							<dd><input type="text" name="genre" required /></dd>
							</dl>
							<dl class="left">
							<dt>그외 기본정보</dt> 
							<dd><input type="text" name="etc_info" /></dd>
							</dl>
						</div>
						<div class="contentDiv">
							<textarea class="textarea" name="content"></textarea>	
						</div>
						<dl class="group">
						<dt>파일#</dt> 
						<dd><input type="file" name="file" /></dd>	
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