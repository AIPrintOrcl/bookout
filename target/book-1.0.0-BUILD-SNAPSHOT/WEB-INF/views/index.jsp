<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>도서 고객 및 대여관리 프로그램 ver 1.0</title>

	<%-- bootstrap css--%>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
	<%-- 직접 만든 css--%>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/book.css">
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
				<h2 style="text-align: center;">도서 고객 및 대여관리 프로그램</h2>
				프로그램 작성순서<br>
				1.고객정보 테이블을 생성한다.<br>
				2.대여정보 테이블을 생성한다.<br>
				3.고객정보, 대여정보 테이블에 제시된 데이터를 생성한다.<br>
				4.고객정보 입력 화면 프로그램을 작성한다.<br>
				5.고객정보 조회 프로그램을 작성한다.<br>
				6.고객대여리스트를 조회하는 프로그램을 작성한다.<br>
				7.고객별 대여금액을 조회하는 프로그램을 작성한다<br>
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
</body>
</html>
