<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file ="/resources/inc/header.jsp" %>

<script type="text/javascript">
$(document).ready(function(){
	//alert($(".form_count").text());
	//alert($("#totalprice span").text());
	
	var p=parseInt($("#totalprice span").text());
	$("#totalprice span").text(p.toLocaleString());
	
});
$(function(){
	var cnt=parseInt($(".form_count").text());
	$('.btn_minus').on("click", function(e){
		e.preventDefault();
		if(cnt > 0){
			cnt--;
		} else{
			alert('현재 수량은 0입니다.');
		}
		$(".form_count").text(cnt);
	});
	$('.btn_plus').on("click", function(e){
		e.preventDefault();
		if(cnt < 10){
			cnt++;
		} else{
			alert('최대 구매 수량은 10개입니다.');
		}
		$(".form_count").text(cnt);
	});
	
	var price = parseInt($("#totalprice span").text().replace(/[^\d]+/g, ""));
	var total = 0;
	$(".form_count").bind("DOMSubtreeModified", function(){
		total = price * cnt;
		$("#totalprice span").text(total.toLocaleString());
	});
});
</script>
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
			<!-- h3>무비차트 <a href="#"><i class="xi-plus"></i></a></h3-->
			<div class="view view_type2 store">
				<div class="view_head group">
					<div class="thumb">
						<img src="../resources/upload${fn:replace(detailFile.savedPath,'\\', '/')}/${detailFile.fileName}" alt="상품 이미지" />
					</div>
					<div class="info">							
						<div class="title_box">
							<p class="tit">${detail.subject}</p>
							<span class="txt_tiny">${detail.summary}</span>
						</div>
						<div class="info_box">
							<dl class="group">
							<dt>상품구성</dt> 
							<dd>${detail.component}</dd>
							</dl>
							<dl class="group">
							<dt>유효기간</dt> 
							<dd>${detail.expiry_date}</dd>
							</dl>
							<dl class="group">
							<dt>상품교환처</dt> 
							<dd>모든 CGV 영화관에서 사용가능</dd>
							</dl>
						</div>
						<div class="product_detail info_box">
							<form action="">
								<div class="purchase_info group">
									<p class="product_name">${detail.subject}</p>
									<div class="form_number left">                      
										<a href="#none" onclick="" class="btn_minus">-</a>               		
										<span class="form_count">1</span>                      
										<a href="#none" onclick="" class="btn_plus">+</a>          	
									</div>
									<p class="total_price right" id="totalprice">
										<c:choose>
										<c:when test="${detail.sale_price > 0}">
											<span>${detail.sale_price}</span>원
										</c:when>
										<c:otherwise>
											<span>${detail.price}</span>원
										</c:otherwise>
										</c:choose>
										
									</p>
								</div>
								<div class="btn_box btns_2">
									<button type="button" class="bg_primary line_primary" alt="장바구니" title="장바구니">장바구니</button>
									<button type="submit" class="submit btn_gravity" alt="구매하기" title="구매하기">구매하기</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="view_content">
					<div id="cont">
						<h4>이용안내</h4>
						<ul>
						<li>• 해당 기프트콘은 오프라인 매점에서 실제 상품으로 교환할 수 있는 온라인 상품권입니다.</li>
						<li>• 구매 후 전송받으신 기프트콘은,
						사용가능한 CGV의 매점에서 지정된 해당 상품으로만 교환이 가능합니다.<br />
						(사용가능 CGV는 '상품교환'에서 확인 가능하며, 추가 상품을 포함하여 구매 시 지점에 따라 사용이 불가 할 수 있으니 발송되는 기프트콘의 정보를 확인해주시기 바랍니다.)<br />
						해당 상품 내에서 팝콘 맛 혹은 사이즈 변경 시 추가 비용 발생합니다.<br />
						교환 완료한 상품의 환불 및 반품은 불가합니다.</li>
						<li>• 유효기간 연장을 신청하는 경우,
						유효기간은 발급일로부터 5년 이내 횟수 제한 없이 기간 연장 가능하며, 1회 연장 시 3개월(92일) 단위로 유효기간이 연장됩니다.<br /> 
						단, 이벤트 경품 및 프로모션 상품의 경우 유효기간 연장이 불가할 수 있습니다.<br />
						유효기간 만료 이후에는 결제금액의 90% 환불이 가능합니다.</li> 
						<li>• 매점상품 기프트콘은 극장 매점에서 상품 교환 후 수령한 영수증으로 CJ ONE 적립이 가능합니다.<br />
						(모바일App,웹 > MY > 매점적립 or 홈페이지> My CGV > 매점이용 포인트 적립)
						<li>• 상기 이미지는 실제와 다를 수 있습니다.</li>
						</ul>
					</div>
				</div>
				<div class="btn_box">
					<a href="list" class="btn">목록</a>
					<a href="modify?no=${detail.no}" class="btn">수정</a>
					<a href="delete?no=${detail.no}" class="btn">삭제</a>
				</div>
			</div>
		</div>
<%@ include file ="/resources/inc/footer.jsp" %>
