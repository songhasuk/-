<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="EUC-KR">

<title>로그인 페이지</title>
<style>

.view{
	border-style:solid;
	
	width:24%;
	height:25%;
}
.mid{
	text-align: center;
}


a{
text-decoration-line : none;
}

.pan input{
 display:inline-block;
 width:45%	;
}

.size{
 font-size : 50%;
 margin:0 0 13px 0;
 
 }


  
 
 
h1{ 
 border-width: thin;
 border-style: solid;
}
 
</style>

</head>

<body>
	
	
	
	<div class = "view mid">
		<img src ="goole.jpg" width ="100px"  height="30px" style="margin: 13px 0 0 0">
		<h1>【로그인】</h1>
		
		<from>

			 <fieldset>
			<legend>입력양식</legend>
	
			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ㅁ
				
				
				
				<div>
				<input type = "email" placeholder ="사용자 이름" value="gmail.com" style="width:95%;  text-align:right; margin:13px 0 0 0;"><br/>
				</div>
				
				<div>
				<p class = "size" style="width:190px;">문자, 숫자, 마침표를 사용할 수 있습니다</p>
				</div>
				
				<div class = "pan">	
				<input type = "text" placeholder ="아이디"> 
				<input type = "password" placeholder ="비밀번호">
				</div>
				
				<div>
				<p class = "size" style="width:240px;";>문자, 숫자, 기호를 조합하여 8자 이상을 사용하세요</p><br>
				</div>
				
								
				<div>
				<input type = "checkbox" value="passwordlook" style="margin:0 0 20px 0">비밀번호 표시<br/>
				</div>	
				<div>
				<a href="login.html" style="color: blue; float:left;">대신 로그인하기</a>
				<input type="submit" value="다음"  style = "float:right; background-color:#6799FF; color:#FFFFFF;" onClick="location.href='nextstep.html'">
				</div>
		
	
	</fieldset>		

	</from>	
	</div>
 

</body>

</html>