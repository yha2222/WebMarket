<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO memVO = (MemberVO)request.getAttribute("memVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDetail</title>
<style>
table{
	border: 1px solid blue;
}
tr > td > div > img{
	margin-left: 30%;
	width: 300px;
}
.cont {
	border: 1px solid blue;
	padding: 10px;
	margin: 0;
	font-size: 20px;
}
.btns {
	text-align: center;
	font-size: 20px;
}
</style>
</head>
<body>
<h1>회원 정보 상세보기</h1>
	<table>
			<tbody>
				<tr>
					<td>
						<div>
							<img alt="" src="../images/<%=memVO.getMemPhoto() %>">
						</div>
					</td>
				</tr>
				<tr>
					<td class="cont">회원 ID</td>
					<td class="cont"><%=memVO.getMemId()%></td>
				</tr>
				<tr>
					<td class="cont">비밀번호</td>
					<td class="cont"><%=memVO.getMemPass() %></td>
				</tr>
				<tr>
					<td class="cont">회원 이름</td>
					<td class="cont"><%=memVO.getMemName() %></td>
				</tr>
				<tr>
					<td class="cont">전화번호</td>
					<td class="cont"><%=memVO.getMemTel() %></td>
				</tr>
				<tr>
					<td class="cont">회원 주소</td>
					<td class="cont"><%=memVO.getMemAddr() %></td>
				</tr>
				<tr>
					<td class="btns cont" colspan="2">
						<button type="submit" onclick="location.href='../member/update.do?memId=<%=memVO.getMemId() %>';" >수정</button>
						<input type="button" value="삭제" onclick="location.href='../member/delete.do?memId=<%=memVO.getMemId() %>';" />
						<input type="button" value="목록으로" onclick="location.href='../member/list.do'" />
					</td>
				</tr>
			</tbody>
		</table>
</body>
<script>
<%
if(session.getAttribute("isSuccess") != null){
	if(session.getAttribute("isSuccess").equals("ok")){
		session.removeAttribute("isSuccess");
		%>alert("회원 정보 수정 성공");<%	
	} else if(session.getAttribute("isSuccess").equals("fail")){
		session.removeAttribute("isSuccess");
		%>alert("회원 정보 수정 실패");<%
	}
}
%>
</script>
</html>