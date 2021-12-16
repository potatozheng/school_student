<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>【软帝集团】课表查询系统</title>
	<link rel="stylesheet" href="asserts/bootstrap-3.3.7-dist/css/bootstrap.css" />
	<link rel="stylesheet" href="asserts/bootstrapvalidator/css/bootstrapValidator.css" />
	<link rel="stylesheet" href="css/animate.css"/>
<style>
	.btn-reg{
		margin-left:50%;
		width:50%;
	}
</style>
</head>
<body>
	<div class="container animated bounceInRight">
		<div class="page-header">
			<h3>登录页面</h3>
		</div>
		<div class="col-sm-5">		
			<form action="user" method="post" class="form-horizontal form-login">
<!-- 				隐藏域用于传递操作指令到后台 -->
				<input type="hidden" name="method" value="login"/>


				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-phone"></span>
						</div>
						<input type="text" name="id" required class="form-control" value="${id}" placeholder="请输入登录账号"/>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-lock"></span>
						</div>
						<input type="password" name="pwd" required class="form-control" value="${pwd}" placeholder="请输入密码"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<div class="radio">
							<label class="radio-inline">
								<input type="radio" name="state" value="0" checked/>管理员
							</label>
							<label class="radio-inline">
								<input type="radio" name="state" value="1"/>学生
							</label>
							<label class="radio-inline">
								<input type="radio" name="state" value="2"/>老师
							</label>
						</div>
					</div>
				</div>
				<div class="form-group text-right">
					<button class="btn btn-primary btn-block btn-reg" type="submit">登录</button>
				</div>
			</form>
		</div>
	</div>
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="asserts/bootstrap/js/bootstrap.min.js"></script>
	<script src="asserts/bootstrapvalidator/js/bootstrapValidator.min.js"></script>
	<script src="asserts/bootstrapvalidator/js/language/zh_CN.js"></script>
	<script src="asserts/layer/layer.js"></script>
	<script>
		$(function(){
			$('.form-login').bootstrapValidator({
				message:'输入的字段信息有误',
				feedbackIcons:{
					valid:'glyphicon glyphicon-ok',
					invalid:'glyphicon glyphicon-remove',
					validating:'glyphicon glyphicon-refresh',	
				}
			});
			if('${msg}'){
				layer.msg('${msg}');
			}
		})
	</script>
</body>
</html>