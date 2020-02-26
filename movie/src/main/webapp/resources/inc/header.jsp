<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../resources/js/slick-1.8.1/slick/slick.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="http://design.inplus21.com/design/sample/Free-Business-001/share/css/xeicon/xeicon.min.css">
<link rel="stylesheet" type="text/css" href="../resources/js/slick-1.8.1/slick/slick-theme.css" />
<link rel="stylesheet" type="text/css" href="../resources/js/slick-1.8.1/slick/slick.css" />
<link rel="stylesheet" type="text/css" href="../resources/css/board.css" />
<link rel="stylesheet" type="text/css" href="../resources/css/layout.css" />

<c:if test="${'isMain' eq page}">
<link rel="stylesheet" type="text/css" href="../resources/css/main.css" />
</c:if>
<c:if test="${isWrite eq true}">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="../resources/js/commons_form.js"></script>
<script type="text/javascript" src="../resources/smarteditor2/workspace/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</c:if>

</head>
<body>

<div id="wrap">
	<div id="header">
		<div id="headerWrap" class="inner">
			<h1 class="logo"><a href="../main/index"></a></h1>
			<div id="search_form">
				<form>
					<input type="text" placeholder="영화제목을 입력해주세요." />
					<button type="button"><i class="xi-search"></i></button>
				</form>
			</div>
		</div>
		<div class="util group">
			<div class="inner">
				<ul class="group">
				<c:choose>
				<c:when test="${user.id==null}">
				<li><a href="../member/login">로그인</a></li>
				<li><a href="../member/join">회원가입</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="../member/logout">로그아웃</a></li>
				</c:otherwise>
				</c:choose>
				<li><a href="../member/mypage">My Page</a></li>
				
				</ul>
			</div>
		</div>
		<div id="gnb">
			<ul class="group">
			<li>
				<a href="../movies/list">영화</a>
				<ul>
				<li><a href="../movies/list">상영작</a></li>
				<li><a href="#">예고편</a></li>
				</ul>
			</li>
			<li>
				<a href="../reservation/list">예매</a>
				<ul>
				<li><a href="#">상영시간표</a></li>
				</ul>
			</li>
			<li>
				<a href="../event/list">이벤트</a>
				<ul>
				<li><a href="../event/list">이벤트</a></li>
				</ul>
			</li>
			<li>
				<a href="../store/list">스토어</a>
				<ul>
				<li><a href="../store/list">스토어</a></li>
				</ul>
			</li>
			<li>
				<a href="../notice/list">고객센터</a>
				<ul>
				<li><a href="../notice/list">공지사항</a></li>
				<li><a href="../faq/list">자주묻는질문</a></li>
				</ul>
			</li>
			</ul>
		</div>
		
	</div>
	<div id="containner">