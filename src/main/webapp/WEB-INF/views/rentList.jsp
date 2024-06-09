<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="false" %>
<html>
<head>
	<title>도서 고객 및 대여관리 프로그램 ver 1.0</title>

	<%-- bootstrap css--%>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
	<%-- 직접 만든 css--%>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/book.css">
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
					<h2 style="text-align: center;">고객대여리스트</h2>
					<%-- 고객대여리스트 시작 --%>
					<div>
						<table class="table table-bordered">
							<tr>
								<td>고객번호</td>
								<td>대여번호</td>
								<td>도서코드</td>
								<td>대여금액</td>
								<td>대여일자<td>
							</tr>
							<c:if test="${list eq null}">
								<tr>
									<td colspan="5">등록된 고객이 없습니다.</td>
								</tr>
							</c:if>
							<c:if test="${list ne null}">
								<c:forEach var="rent" items="${list}">
									<tr>
										<td>${rent.cust_no}</td>
										<td>${rent.rent_no}</td>
										<td>${rent.book_code}</td>
										<td>${rent.rent_price}</td>
										<td><fmt:formatDate value="${rent.rent_date}" pattern="yyyy-MM-dd"/></td>
									</tr>
								</c:forEach>
							</c:if>
						</table>
					</div>
					<%-- 고객대여리스트 끝 --%>
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
