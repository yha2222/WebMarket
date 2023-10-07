<%@page import="util.SessionMemInfo"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SessionMemInfo info = SessionMemInfo.getInstance();

	List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
	<title>memberList</title>
<style>
table{
	width: 1000px;
	height : 50px;
	border : 1px solid blue;
}
td, th {
	border: 1px solid blue;
	font-size:25px;
}
button{
	font-size:25px;
	margin: 5px;
	float: right;
}
</style>
</head>
<body>
	<h1>회원 목록 보기</h1>

	<table>
		<thead>
			<tr class="col-button">
				<td colspan="5">
				<button type="button" onclick="location.href='../views/memberAdd.jsp';" >회원추가</button>
				</td>
			</tr>
			
			<tr class="table-head">
				<th>ID</th>
				<th>비밀번호</th>
				<th>이 름</th>
				<th>전 화</th>
				<th>주 소</th>
			</tr>
		</thead>
		<tbody>
			<%for (MemberVO memVO : memberList) { %>
			<tr>
				<td><a href="#"><%=memVO.getMemId()%></a></td>
				<td><%=memVO.getMemPass() %></td>
				<td><%=memVO.getMemName() %></td>
				<td><%=memVO.getMemTel() %></td>
				<td><%=memVO.getMemAddr() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>