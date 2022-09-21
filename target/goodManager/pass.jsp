<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="libs/edit.css">
	<script type="text/javascript" src="libs/jquery.min.js"></script>
	<script type="text/javascript" src="libs/layer.js"></script>

</head>
<body>
<script type="text/javascript">
function save(){
	var password1=document.getElementsByName("password1")[0].value;
	var password2=document.getElementsByName("password2")[0].value;
	if(password1.length>10||password1.length<4){
			alert("密码需在4~10位之间");
			return false;
		}else{
			var j =/^[0-9a-zA-Z]+$/;
			if(j.test(password1)){
				document.tijiao.submit();
			}else{
				alert("密码包含非字母数字");
				return false;
			}
	}
	if(password1!=password2){
		alert("两次密码不一致")
		//return false; window.location.href='login.jsp'
	} else{
		var  data=$("form").serialize();
		$.post("${pageContext.request.contextPath}/user/repass",data,function(json){
			if(json.status==1){
				alert('修改密码成功');
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index); //再执行关闭
			}
			else {
				alert('原密码错误');
				return false;
			}
		},"json");
	}
	}

</script>

<form action="${pageContext.request.contextPath}/user/repass" method="post" name="tijiao">

<div class="inputview">
	<span class="inputspan"> 
		<label class="inputtext">原密码:</label> 
		<input class="inputinput" name="password" type="password" />
		</span>
	<span class="inputspan"> 
		<label class="inputtext">新密码:</label> 
		<input class="inputinput" name="password1" type="password" />
		</span>
		<span class="inputspan"> 
		<label class="inputtext">确认密码:</label>
		<input class="inputinput" name="password2" type="password" />
		</span>
	</div>
	<div class="inputbtpanel">
		<button class="seachbt1" type="button" onclick="save()">保存</button>
		</div>
</form>

</body>
</html>
