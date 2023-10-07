<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td {
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
	<h1>회원 정보 입력 폼</h1>
	<form name="fileForm" action="/member/memInsert.do" method="post"
		enctype="multipart/form-data">
		<table>
			<tbody>
				<tr>
					<td>회원 ID</td>
					<td><input type="text" name="memId" />
						<button type="submit" class="idCheck">중복확인</button></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="memPass" /></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="text" name="memPassRepeat" /></td>
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
					<td>
						<p>
							<input type="file" name="memPhoto" />
						</p>
					</td>
				</tr>
				<tr>
					<td class="btns" colspan="2">
						<button type="submit" id="memAdd">저장</button>
						<input type="button" value="취소" />
						<input type="button" value="목록으로" onclick="location.href='../member/list.do'" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script>
		$('.idCheck').on('click', function() {
			
			event.preventDefault();
			
 			let memId = $('[name="memId"]').val();
			if(memId === ''){
				alert("아이디를 입력해주세요");
				return;
			}
 			
 			
			$.ajax({
				type : 'post',
				url : '../member/idcheck.do',
				data : {
					'memId' : memId
				},
				success : function(res) {
					if (res.isExist == "ok") {
						alert("이미 존재하는 ID입니다.")
					} else {
						alert("가입 가능한 ID입니다.")
					}
					console.log(res);
				},
				error : function(xhr) {
					console.log(xhr);
				},
				dataType : 'json'
			});
		});
		
	</script>

</body>
</html>