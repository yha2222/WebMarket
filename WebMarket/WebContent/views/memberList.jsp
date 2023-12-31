<%@page import="util.SessionMemInfo"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
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
				<td><a href="/member/detail.do?memId=<%=memVO.getMemId()%>"><%=memVO.getMemId()%></a></td>
				<td><%=memVO.getMemPass() %></td>
				<td><%=memVO.getMemName() %></td>
				<td><%=memVO.getMemTel() %></td>
				<td><%=memVO.getMemAddr() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
<script>

<%
if(session.getAttribute("dlisSuccess") != null){
	if(session.getAttribute("dlisSuccess").equals("ok")){
		session.removeAttribute("dlisSuccess");
		%>alert("회원 정보 삭제 성공");<%	
	} else if(session.getAttribute("dlisSuccess").equals("fail")){
		session.removeAttribute("dlisSuccess");
		%>alert("회원 정보 삭제 실패");<%
	}
}

if(session.getAttribute("udisSuccess") != null){
	if(session.getAttribute("udisSuccess").equals("ok")){
		session.removeAttribute("udisSuccess");
		%>alert("회원 정보 수정 성공");<%	
	} else if(session.getAttribute("udisSuccess").equals("fail")){
		session.removeAttribute("udisSuccess");
		%>alert("회원 정보 수정 실패");<%
	}
}

if(session.getAttribute("isSuccess") != null){
	if(session.getAttribute("isSuccess").equals("ok")){
		session.removeAttribute("isSuccess");
		%>alert("회원가입 성공");<%	
	} else if(session.getAttribute("isSuccess").equals("fail")){
		session.removeAttribute("isSuccess");
		%>alert("회원가입 실패");<%
	}
}


%>
</script>
</html>