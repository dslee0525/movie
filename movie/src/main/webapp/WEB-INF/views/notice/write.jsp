<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="/resources/inc/header.jsp" %>

		<div id="lnb">
			<div class="inner">
				<ul class="location">
				<li class="on"><a href="#">HOME</a></li>
				<li><a href="#">이벤트</a></li>
				<li><a href="#">이벤트 글쓰기</a></li>
				</ul>
			</div>
		</div>
		<div id="content" class="inner">
			<div class="write_top">
				<h3>이벤트</h3>
				<a href="list.jsp" class="btn">목록</a>
			</div>
			<div class="write write_type1">
				<form action="write" method="post">
					<dl class="group">
					<dt>제목</dt> 
					<dd><input type="text" name="subject" required /></dd>
					</dl>
					<div class="wr_infomation">
						<div class="contentDiv">
							<textarea class="textarea" name="content" id="ir1" rows="10" cols="100">
							에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면 됩니다.
							</textarea>
							
							<script type="text/javascript">
								var oEditors = [];
								nhn.husky.EZCreator.createInIFrame({
								 oAppRef: oEditors,
								 elPlaceHolder: "ir1",
								 sSkinURI: "../resources/smarteditor2/workspace/SmartEditor2Skin.html",
								 htParams : {
						              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
						              bUseToolbar : true,             
						              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
						              bUseVerticalResizer : true,     
						              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
						              bUseModeChanger : true,         
						              fOnBeforeUnload : function(){
						                   
						              }
						          }, 
						          fOnAppLoad : function(){
						              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
						              oEditors.getById["ir1"].exec("PASTE_HTML", ["기존 DB에 저장된 내용을 에디터에 적용할 문구"]);
						          },
						          fCreator: "createSEditor2"
						      });
						      
						      //저장버튼 클릭시 form 전송
						      $("#save").click(function(){
						          oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
						          $("#frm").submit();
						      });   
					
							</script>
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
	<script type="text/javascript">	
	if(editMode=='I'){
	      if(confirm("등록 하시겠습니까?")==true){
	           try{
	                oEditors.getById["popContent"].exec("UPDATE_CONTENTS_FIELD", []);
	                document.frm.action = regAddr;
	                document.frm.submit();
	                swal("","등록 되었습니다.","success");
	           }catch(exception){
	                swal("","데이터 등록을 실패하였습니다.","error");
	           }
	      }
	 }else{
	      if(confirm("수정 하시겠습니까?")==true){
	           if(deleteTarget.length > 0){ 
	 
	           document.frm.deleteTarget.value = deleteTarget;
	       }
	       try{
	            oEditors.getById["popContent"].exec("UPDATE_CONTENTS_FIELD", []);
	            document.frm.action = udtAddr;
	            document.frm.submit();
	            swal("","수정 되었습니다.","success");
	       }catch(exception){
	            swal("","데이터 수정을 실패하였습니다.","error");
	       }
	    }
	 }
	</script>
	<!-- 	<script type="text/javascript">
		// ‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.
		function submitContents(elClickedObj) {
		 // 에디터의 내용이 textarea에 적용된다.
		 oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

		 // 에디터의 내용에 대한 값 검증은 이곳에서
		 // document.getElementById("ir1").value를 이용해서 처리한다.

		 try {
		     elClickedObj.form.submit();
		 } catch(e) {}
		</script> -->
<%@ include file ="/resources/inc/footer.jsp" %>