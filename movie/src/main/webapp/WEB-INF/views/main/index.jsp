<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file ="/resources/inc/header.jsp" %>

		<script type="text/javascript">	
		$(document).ready(function() {
			//mainvisual
			$('.visual_list').slick({
				slidesToShow: 1,
				slidesToScroll: 1,
				dots: true,
				adaptiveHeight: true,
				autoplay: true,
				autoplaySpeed: 3000
			});
			
			//영화순위
			$('.movie_list').slick({
				slidesToShow: 4,
				slidesToScroll: 1,
				//dots: true,
				adaptiveHeight: true,
				autoplay: true,
				autoplaySpeed: 3500
			});
			
			//동영상 썸네일
			$('.teaser_list').slick({
				centerMode: true,
				slidesToShow: 5,
				slidesToScroll: 1,
				adaptiveHeight: true,
				autoplay: true,
				autoplaySpeed: 3500
			});
		
		});
		
		</script>
		<div id="msec1" class="section">
			<div class="visualarea">
				<div class="visual_list">
					<div class="img bg1"></div>
					<div class="img bg2"></div>
					<div class="img bg3"></div>
				</div>
			</div>
			<div class="shourtCut"><a href="../notice/view?no=${notice.no}"><i class="xi-volume-mute"></i> ${notice.subject}<span class="date">${notice.wr_date}</span></a></div>
		</div>
		<div id="msec2" class="section">
			<div class="inner">
				<h3>인기 무비차트 <a href="../movies/list"><i class="xi-plus-thin"></i></a></h3>
				<div class="movie_list group">
					<c:forEach items="${movie}" var="movie" varStatus="status">
					<div class="movie">
						<div class="thumb"><a href="../movies/view?no=${movie.no}"><img src="../resources/upload${movie.fileName}" alt="포스터 이미지" /><em>${status.count}</em></a></div>
						<div class="info">
						<p class="tit">${movie.title}</p>
						<span class="age grade_12">${movie.watching_age}</span>
						<ul>
						<li><a href="../movies/view?no=${movie.no}">상세정보</a></li> 
						<li><a href="#">예매</a></li>
						</ul>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div id="msec3" class="section">
			<div class="inner">
				<h3>이벤트 <a href="../event/list"><i class="xi-plus-thin"></i></a></h3>
				<div class="event_list group">
					<c:forEach items="${event}" var="event">
					<div class="event">
						<a href="../movies/view?no=${event.no}">
							<div class="thumb">
								<img src="../resources/upload${event.fileName}" alt="이벤트 이미지" />
								<i class="xi-plus-thin"></i>
							</div>
							<div class="info">
								<p class="tit">${event.subject}</p>
								<p class="date"><i class="xi-clock-o"></i> ${event.open_date} ~ ${event.end_date}</p>
							</div>
						</a>
					</div>
					</c:forEach>
					
				</div>
			</div>
		</div>
		<div id="msec4" class="section">
			<div class="teaser_list">
				<div class="thumb">
					<a href="https://youtu.be/RnM_o5_UQvw" target="_black" title="작은 아씨들 예고편">
						<img src="../resources/img/teaser_LittleWomen.jpg" alt="작은 아씨들" />
						<i class="xi-play-circle-o"></i>
					</a>
				</div>	
				<div class="thumb">
					<a href="https://youtu.be/eGWJ87_8jpg" target="_black" title="정직한 후보 예고편">
						<img src="../resources/img/teaser_HONESTCANDIDATE.jpg" alt="정직한 후보" />
						<i class="xi-play-circle-o"></i>
					</a>
				</div>	
				<div class="thumb">
					<a href="https://youtu.be/jBdRhhSt3Bc" target="_black" title="기생충 예고편">
						<img src="../resources/img/teaser_PARASITE.jpg" alt="기생충" />
						<i class="xi-play-circle-o"></i>
					</a>
				</div>
				<div class="thumb">
					<a href="https://youtu.be/BIKz5KQpiog" target="_black" title="님산의 부장들 예고편">
						<img src="../resources/img/teaser_TheManStandingNext.jpg" alt="님산의 부장들" />
						<i class="xi-play-circle-o"></i>
					</a>
				</div>
				<div class="thumb">
					<a href="https://youtu.be/gTLpDaGm7-Y" target="_black" title="닥터두리틀 예고편">
						<img src="../resources/img/teaser_Dolittle.jpg" alt="닥터두리틀" />
						<i class="xi-play-circle-o"></i>
					</a>
				</div>	
				<div class="thumb">
					<a href="https://youtu.be/FKAbTcss1ow" target="_black" title="백두산 예고편">
						<img src="../resources/img/teaser_ASHFALL.jpg" alt="백두산" />
						<i class="xi-play-circle-o"></i>
					</a>
				</div>
				<div class="thumb">
					<a href="https://youtu.be/FIOmZ9TJBTQ" target="_black" title="천문 예고편">
						<img src="../resources/img/teaser_ForbiddenDream.jpg" alt="천문" />
						<i class="xi-play-circle-o"></i>
					</a>
				</div>		
				<div class="thumb">
					<a href="https://youtu.be/B748wxz0aXw" target="_black" title="시동 예고편">
						<img src="../resources/img/teaser_startup.jpg" alt="시동" />
						<i class="xi-play-circle-o"></i>
					</a>
				</div>	
				<div class="thumb">
					<a href="https://youtu.be/eSEs4B4H-EA" target="_black" title="겨울왕국2 예고편">
						<img src="../resources/img/teaser_Frozen2.jpg" alt="겨울왕국2" />
						<i class="xi-play-circle-o"></i>
					</a>
				</div>	
			</div>
		</div>
		<div id="msec5" class="section">
			<div class="inner group">
				<div class="shourt">
					<h4>스토어</h4>
					<div class="box">
						<a href="../store/list">
						<div class="thumb">
							<img src="../resources/img/img_shourtcut1.jpg" alt="스토어이미지" />
						</div>
						<div class="info">
							<p class="tit">Tiket &amp; POPCORN STORE</p>
							<p class="txt">영화 그 이상의 즐거움, CGV에서는 영화관람권 뿐만 아니라 영화 관람시 함께 하면 즐거움이 더욱 커지는  팝콘, 음료 및 콤보 상품도 선보이고 있습니다.<br />
							 CGV 스토어와 함께 CGV에서 즐거움을 누려보세요. </p>
							<span>자세히 보기<i class="xi-long-arrow-right"></i></span>
						</div>
						</a>
					</div>
				</div>
				<div class="shourt">
					<h4>포토티켓</h4>
					<div class="box">
						<a href="../phototicket/phototicket">
							<div class="thumb">
								<img src="../resources/img/img_shourtcut2.jpg" alt="포토티켓이미지" />
							</div>
							<div class="info">
								<p class="tit">Photo Tiket</p>
								<p class="txt">영화볼 땐 CGV, 영화를 본 순간을 기억하고 싶다면 포토티켓<br />
								소중한 순간을 포토티켓에 담아보세요.<br />
								여러분의 첫 포토티켓 제작을 기념하여 무료 이용 쿠폰을 드립니다.</p>
								<span>자세히 보기<i class="xi-long-arrow-right"></i></span>
							</div>
						</a>
					</div>
				</div>
			</div>
			<!-- <div id="msec6" class="section">
				<div class="inner">
				<div class="contact">
					
					<div class="group">
						<div class="left">
							<h4>CGV 고객센터</h4>
							<span class="bg_primary">영화, 그 이상의 감동</span>
							<p class="txt">	
								<strong>즐거운 경험은 언제나 CGV에서!</strong><br />
								서비스 이용에 필요한 경우에는 고객센터에 문의해주세요!<br />
								언제나 고객님들의 편리한 경험을 위해 노력하는 CGV가 되겠습니다.
							</p>
						</div>
						<div class="right box">
							<p class="tel"><i class="xi-mobile primary"></i> 1544-1122</p>
							<p class="tiny">상담가능 시간 : 09:00~21:00</p>
						</div>
					</div>
				</div>
				</div>
			</div> -->
		</div>
	<%@ include file ="/resources/inc/footer.jsp" %>