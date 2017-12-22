<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="../../style.css" type="text/css">
</head>
<script type="text/javascript">
function send_check() {
		var f = document.f;

		if (f.subject.value == '') {
			alert('제목을 입력하세요');
			f.subject.focus();
			return false;
		}

			f.submit();
}
</script>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table width="760" align="center">
		<tr>
			<td>
				<table width="690" height="50" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td><img src="../../img/title_04.gif"></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<form name="f" method="post" action="/updateProc">
					<table width="750" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="120" height="25" class="td_d">제목</td>
							<td class="td_d_1" colspan="3">
							<input name="subject" value="${ vo.subject }" type="text" class="search" style="width: 250px;">
							</td>
						</tr>
						<tr>
							<td class="td_d_4">내용</td>
							<td class="td_d_2" colspan="3">
							<textarea name='content' rows="9" cols="65">${ vo.content }</textarea>
							</td>
						</tr>

					</table>
					<table width="750" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="5"></td>
						</tr>
						<tr>
							<td align="center">
							<img src="../../img/btn_modify.gif" onClick="send_check();" style="cursor: pointer"> 
							<img src="../../img/btn_back.gif" onClick="location.href='/board/list.do'" style="cursor: pointer">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>