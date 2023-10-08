<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO memVO = (MemberVO)request.getAttribute("memVO");
	//out.print(memVO.getMemId());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpate</title>
<style>
table{
	border: 1px solid blue;
}
tr {
	border: 1px solid blue;
}
tr > td > div > img{
	margin-left: 10%;
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
<h1>회원 정보 수정 폼</h1>
	<form name="fileForm" action="/member/update.do" method="post"
		enctype="multipart/form-data">
		<table>
			<tbody>
				<tr>
					<td colspan="2">
						<div>
							<img alt="" src="../images/<%=memVO.getMemPhoto() %>">
						</div>
					</td>
				</tr>
				<tr>
					<td>회원 ID</td>
					<td><%=memVO.getMemId() %><input type="hidden" name="memId" value="<%=memVO.getMemId() %>"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="memPass" /></td>
				</tr>
				<tr>
					<td>회원 이름</td>
					<td><input type="text" name="memName" /></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="memTel" /></td>
				</tr>
				<tr>
					<td>회원 주소</td>
					<td><input type="text" name="memAddr" /></td>
				</tr>
				<tr>
					<td>프로필 사진</td>
					<td><input type="file" name="memPhoto" /></td>
				</tr>
				<tr>
					<td class="btns" colspan="2">
						<input type="submit" value="저장" onclick="location.href='../member/list.do'" >
						<input type="button" value="취소" onclick="location.href='../member/detail.do?memId=<%=memVO.getMemId() %>'" />
						<input type="button" value="목록으로" onclick="location.href='../member/list.do'" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>