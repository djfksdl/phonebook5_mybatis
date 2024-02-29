<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호부</h1>

	<h2>수정폼2-map사용</h2>

	<p>
		전화번호를 수정하려면<br> 아래 항목을 기입하고 "수정" 버튼을 클릭하세요
	</p>

	<form action="/phonebook5/phone/modify" method="get">
		<div>
			<label>이름(name)</label> <input type="text" name="name" value="${requestScope.pMap.name}"><!-- vo로 쓰면 getter,setter로 작동하기 때문에 vo안에 꼭 있어야하는데, map으로 불러오면 g,s가 없기 때문에 get("name")이라는 메소드로 작동함. -->
		</div>

		<div>
			<label>핸드폰(hp)</label> <input type="text" name="hp" value="${requestScope.pMap.hp}"><!-- requestScope는 생략가능.실전에서는 잘 안씀. 지금은 구별하려고 공부중이라 씀. -->
		</div>

		<div>
			<label>회사(company)</label> <input type="text" name="company" value="${requestScope.pMap.company}">
		</div>

		<input type="text" name="personId" value="${pMap.personId }"><br>
		<button type="submit">수정</button>

	</form>

	<br>
	<br>
	<a href="/phonebook5/pbc/list">리스트페이지로 이동</a>

</body>
</html>