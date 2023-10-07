<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td{
	border : 1px solid blue;
	padding : 10px;
	margin : 0;
	font-size:20px;
}
.btns {
	text-align: center;
	font-size:20px;
}

</style>
</head>
<body>
<h1>회원 정보 입력 폼</h1>

	<table>
		<tbody>
			<tr>
				<td>회원 ID</td>
				<td><input type="text" /> <button>중복확인</button></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" /> </td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="text" /> </td>
			</tr>
			<tr>
				<td>회원 이름</td>
				<td><input type="text" /> </td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td>회원 주소</td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td>프로필 사진</td>
				<td>
					<form name="fileForm" action="fileupload_process.jsp" 
					 method="post" enctype="multipart/form-data">
					 	<p><input type="file" name="filename" /></p>
					 </form>
				</td>
			</tr>
			<tr>
			 <td class="btns" colspan="2">
			 	<button>저장</button>
			 	<button>취소</button>
			 	<button>회원 목록</button>
			 </td>
			</tr>
		</tbody>
	</table>

</body>
</html>