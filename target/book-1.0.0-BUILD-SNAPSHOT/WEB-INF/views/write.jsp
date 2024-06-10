<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>도서 고객 및 대여관리 프로그램 ver 1.0</title>

	<%-- bootstrap css--%>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
	<%-- 직접 만든 css--%>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/book.css">
	<%--jQuery--%>
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>

	<style>
		.inner-div {
			width : 700px;
			height : 200px;
			border: 1px solid #0f0f0f;
			top: 50%;
			left: 50%;
			padding: 20px;
		}
		.button {
			margin-top: 10px;
		}
	</style>
</head>
<body>
<div class="container">
	<table class="table table-bordered">
		<header>
			<tr>
				<td colspan="5" style="text-align: center;">도서 고객 및 대여관리 프로그램 ver 1.0</td>
			</tr>
		</header>
		<nav>
			<tr style="text-align: center;">
				<td><a href="/book/write">고객등록</a></td>
				<td><a href="/book/custListModify">고객목록조회/수정</a></td>
				<td><a href="/book/rentList">고객대여리스트</a></td>
				<td><a href="/book/rentPrice">고객대여금액조회</a></td>
				<td><a href="/book/">홈으로</a></td>
			</tr>
		</nav>
		<section>
			<tr>
				<td colspan="5">
					<h2 style="text-align: center;">${param.mode=="M" ? "고객수정" : "고객등록"}</h2>
					<div class="container inner-div">
						<form id="writeForm" action="">
							<div>고객번호 : <input class="onderline-border" style="color : #929090;" type="text" id="cust_no" name="cust_no" value="${param.mode=="M" ? param.cust_no : cust_no}" readonly> </div>
							<div>고객이름 : <input class="onderline-border" type="text" id="cust_name" name="cust_name" value="${param.mode=="M" ? memberDto.cust_name : ''}"> </div>
							<div>전화번호 : <input class="onderline-border" type="text" id="phone" name="phone" value="${param.mode=="M" ? memberDto.phone : ''}"> </div>
							<div>이메일 : <input class="onderline-border" type="text" id="cust_email" name="cust_email" value="${param.mode=="M" ? memberDto.cust_email : ''}"> </div>
							<div>고객등급(P,G,S) : <input class="onderline-border" type="text" id="grade" name="grade" value="${param.mode=="M" ? memberDto.grade : ''}"> </div>
							<div class="button">
								<button type="button" id="btn_write">${param.mode=="M" ? "[수정]" : "[등록]"}</button>
								<button type="button" id="btn_cancell">[취소]</button>
							</div>
						</form>
					</div>
				</td>
			</tr>
		</section>
		<footer>
			<tr>
				<td colspan="5" style="text-align: center;">나도 할 수 있는 Java&Spring 웹 개발 종합반(남상민)</td>
			</tr>
		</footer>
	</table>
</div>


<script>
	$(function (){ //ready
		let writeCheck = function () {
			let form = document.getElementById("writeForm");

			if(form.cust_name.value.trim()=="") {
				alert("고객님의 이름을 입력해주세요.");
				form.cust_name.focus();
				return false;
			}

			if(form.phone.value.trim()=="") {
				alert("전화번호를 입력해주세요.");
				form.phone.focus();
				return false;
			}

			if(form.cust_email.value.trim()=="") {
				alert("이메일을 입력해주세요.");
				form.cust_email.focus();
				return false;
			}

			if(!(form.grade.value=="P" || form.grade.value=="G" || form.grade.value=="S")) {
				alert("고객등급은 P,G,S 중에 입력하셔야합니다.");
				form.grade.focus();
				return false;
			}
			return true;
		}

		$('#btn_write').on("click", function(){
			let form = $("#writeForm");

			if(writeCheck()) {
				if(${param.mode=="M"}) { // 고객 수정
					form.attr("action", "<c:url value='/modifyEvent'/>");
					form.attr("method", "post");
					form.submit();
				}
				if(${param.mode!="M"}) {// 고객 등록
					form.attr("action", "<c:url value='/writeEvent'/>");
					form.attr("method", "post");
					form.submit();
				}
			}
		})

		$('#btn_cancell').on("click", function (){
			if(${param.mode=="M"}) { // 고객 수정
				location.href="<c:url value='/custListModify'/>"
			}
			if(${param.mode!="M"}) {// 고객 등록
				$('#cust_name').val("");
				$('#phone').val("");
				$('#cust_email').val("");
				$('#grade').val("");
			}
		})
	})//ready

</script>

</body>
</html>