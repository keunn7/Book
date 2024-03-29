<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<link href="<c:url value='/resources/css/common.css'/>" rel="stylesheet" type="text/css">
<style>
	body{background:#eeeeee}
	.g-top{
	    background:#595959; color:#fff; 
	    margin:0; padding: 5px 0;
	    text-align:center; line-height:35px;
	    height:35px; position:relative;
	}
	.g-top .btn{
	    position:absolute; 
	    left:10px; top:10px; 
	    background:#acacac; 
	    color:#ffffff; font-size:11px; }
	.top-img img{ width:100%; }
	.g-cont{padding:30px 15px; background-color:#f1f1f1}
	.g-cont ul li{margin:0 0 10px;}
	.g-cont ul li input,
	.g-cont ul li textarea{border:0;background:#fff;}
	.g-cont .name{float:left; width:100%;}
	.g-cont .password{float:right; width:48%;}
	.g-cont .msg
	.g-cont .msg .form-control{word-break: break-all;}
	.g-cont .btn{
	    background:#595959; color:#ffffff; 
	    font-size:13px; font-weight:bold; 
	    display:block;
	}
	.guestbook .cont{
	    background-color:#595959; 
	    margin:8px 0px 0; margin-top:0;
	}
	.guestbook .cont li{
	    padding:15px; 
	    border-bottom:1px dotted #fff; 
	    text-align:left; 
	}
	.guestbook .cont li:last-child{border-bottom:0;}
	.guestbook .cont,
	.guestbook .cont a{color:#fff; font-size:11px; line-height:16px; }
	.guestbook .cont .name{display:inline-block; padding-right:3px;}
	.guestbook .cont .name:after{content: " | "; opacity:0.5}
	.guestbook .cont .date{display:inline-block; padding-left:3px;}
	.guestbook .cont .memo{
	    font-weight:bold; 
	    display:block; 
	    padding-top:5px; 
	    word-break: break-all;
	}
	.guestbook .cont .write{text-align:right;}
</style>
</head>
<body>
	<h4 class="g-top">구디 방명록</h4>
	<div class="top-img">
	</div>
	<form action="/book" method="post" id="frm">
		<div class="g-cont">
			<ul>
				<li class="name">
					<input name="g_writer" type="text" placeholder="이름" class="form-control">
				</li>
				<li class="msg">
					<textarea name="g_content" placeholder="내용을 입력해주세요" class="form-control"></textarea>
				</li>
			</ul>
			<p class="btn btn-lg" onclick="document.getElementById('frm').submit();">방명록 남기기</p>
		</div>
	</form>
	<div class="guestbook list" style="display: block;">
		<c:if test="${not empty resultList}">
			<c:forEach var="item" items="${resultList}">
				<ul class="cont">
					<li>
						<p class="name">${item.g_writer}</p>
						<p class="date">${item.g_reg_date}</p>
						<p class="memo">${item.g_content}</p>
					</li>
				</ul>				
			</c:forEach>
		</c:if>
	</div>
</body>
</html>