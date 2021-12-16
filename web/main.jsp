<%@ page language="java"  pageEncoding="UTF-8"%>
<!-- 导入jstl标准标签库的核心标签：c标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 格式化标签 -->
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>【软帝集团】日报提交系统-日报管理</title>
	<link rel="stylesheet" href="asserts/bootstrap-3.3.7-dist/css/bootstrap.css" />
	<link rel="stylesheet" href="asserts/bootstrapvalidator/css/bootstrapValidator.min.css" />
	<link rel="stylesheet" href="css/animate.css"/>
<style>
	.navbar{
		border-radius:0;
	}
	.table td{
		vertical-align: middle;
		white-space:nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
		max-width: 200px;
	}
	.table td:last-child{
		text-align:center;
	}
	.btn-group{
		margin-bottom:10px;
	}
	textarea{
		resize:none;/*禁止改变大小*/
	}
	dl>dt,dl>dd{
		padding:5px 0;
	}
</style>
</head>
<body>
<!-- 密码修改模态框 -->
	<div class="modal animated slideInDown" id="dialogModifyPwd">
		<form action="stu" class="form-horizontal" id="stuPwdModify">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal">&times;</button>
						<h4>修改密码</h4>
					</div>
					<div class="modal-body">
						<!-- 隐藏域用于请求后台指定的方法 -->
						<input type="hidden" name="method" value="modifyPwd"/>
						<div class="form-group">
							<label class="control-label col-sm-2 sr-only">原始密码</label>
							<div class="col-sm-8">							
								<div class="input-group">
									<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
									<input type="password" class="form-control" name="oldPwd" id="oldPwd" required placeholder="原始密码" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2 sr-only">新密码</label>
							<div class="col-sm-8">							
								<div class="input-group">
									<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
									<input type="password" class="form-control" name="newPwd" id="newPwd" required placeholder="新密码" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2 sr-only">重复密码</label>
							<div class="col-sm-8">							
								<div class="input-group">
									<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
									<input type="password" class="form-control" name="rePwd" id="rePwd" required placeholder="重复密码" />
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal">取消</button>
						<button class="btn btn-danger" type="button" id="btnModifyPwd">确认修改</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	
	
	
<!-- 日报提交模态框 -->
	<div class="modal animated fadeInUp" id="dailyAdd">
		<form action="daily" class="form-horizontal" id="dailyAddForm">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4>日报提交</h4>
				</div>
				<div class="modal-body">
					<!-- 隐藏域用于请求后台指定的方法 -->
					<input type="hidden" name="method" value="submit" />
					<div class="form-group">
						<label class="control-label col-sm-2">今日收获</label>
						<div class="col-sm-8">							
							<textarea name="gain" rows="3" class="form-control" required></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">今日疑问</label>
						<div class="col-sm-8">							
							<textarea name="question" rows="3" class="form-control" required></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">意见建议</label>
						<div class="col-sm-8">							
							<textarea name="suggest"  rows="3" class="form-control" required></textarea>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-default" data-dismiss="modal">取消</button>
					<button class="btn btn-primary" type="submit">提交</button>
				</div>
			</div>
		</div>
		</form>
	</div>
	
	
	
	
<!-- 日报详情模态框 -->
	<div class="modal animated bounceIn" id="dailyInfo">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4>日报详情</h4>
				</div>
				<div class="modal-body">
					<dl class="dl-horizontal">
						<dt>今日收获:</dt>
						<dd id="d1"></dd>
						<dt>今日疑问:</dt>
						<dd id="d2"></dd>
						<dt>意见建议:</dt>
						<dd id="d3"></dd>
					</dl>
				</div>
				<div class="modal-footer">
					<button class="btn btn-danger" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
<!-- 日报修改模态框 -->
	<div class="modal animated pulse" id="dailyEdit">
		<form action="daily" class="form-horizontal" id="dailyUpdateForm">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4>日报修改</h4>
				</div>
				<div class="modal-body">
					<!-- 隐藏域用于请求后台指定的方法 -->
					<input type="hidden" name="method" value="update" />
					<input type="hidden" name="dailyid" value="" />
					<div class="form-group">
						<label class="control-label col-sm-2">今日收获</label>
						<div class="col-sm-8">							
							<textarea name="gain" rows="3" class="form-control" required></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">今日疑问</label>
						<div class="col-sm-8">							
							<textarea name="question" rows="3" class="form-control" required></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">意见建议</label>
						<div class="col-sm-8">							
							<textarea name="suggest" rows="3" class="form-control" required></textarea>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-default" data-dismiss="modal">取消</button>
					<button class="btn btn-primary" type="submit">确认修改</button>
				</div>
			</div>
		</div>
	    </form>
	</div>
	
	
	
<!-- 	导航区 -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="" class="navbar-brand"><img src="image/logo.png" alt="" height="100%" /></a>
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#userInfo">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse" id="userInfo">
			 <ul class="nav navbar-nav navbar-right">
		        <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown">欢迎你，${stu.name}<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="javascript:void(0)" data-toggle="modal" data-target="#dialogModifyPwd">修改密码</a></li>
		            <li><a href="javascript:void(0)" id="logout">安全退出</a></li>
		          </ul>
		        </li>
		      </ul>
			</div>
		</div>
	</nav>	
<!-- 	内容区 -->
	<div class="container-fluid">
<!-- 		路径导航 -->
		<ol class="breadcrumb">
		  <li><a href="#">日报管理</a></li>
		  <li class="active">日报列表</li>
		</ol>
		
<!-- 		按钮组 -->
<!-- 		<div class="btn-group"> -->
			<button class="btn btn-primary"  data-toggle="modal" data-target="#dailyAdd"><span class="glyphicon glyphicon-cloud-upload"></span>提交日报</button>
<!-- 			学生端禁止删除操作 -->
<!-- 			<button class="btn btn-danger volumeDel"><span class="glyphicon glyphicon-remove"></span>批量删除</button> -->
<!-- 		</div> -->
		<br /><br />
<!-- 		数据库区 -->
		<div class="data-container">
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<th><input type="checkbox" id="selectAll"/></th>
					<th>序号</th>
					<th>今日收获</th>
					<th>今日疑问</th>
					<th>意见与建议</th>
					<th>提交时间</th>
					<th>更新时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pu.list}" var="daily" varStatus="stat">
				<tr>
					<td><input type="checkbox" name="ids" value="${daily.id}"/></td>
					<td>${pu.startNum + stat.count}</td>
					<td title="${daily.gain}">${daily.gain}</td>
					<td title="${daily.question}">${daily.question}</td>
					<td title="${daily.suggest}">${daily.suggest}</td>
					<td>
						<fmt:formatDate value="${daily.subtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>
						<fmt:formatDate value="${daily.lastupdatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>
						<button class="btn btn-primary btn-sm btnInfo" data-daily-id="${daily.id}" data-toggle="modal" data-target="#dailyInfo"><span class="glyphicon glyphicon-info-sign"></span>详情</button>
						<button class="btn btn-info btn-sm btnEdit" data-daily-id="${daily.id}" data-toggle="modal" data-target="#dailyEdit"><span class="glyphicon glyphicon-edit"></span>修改</button>
						<!-- 			学生端禁止删除操作 -->
						<button class="btn btn-danger btn-sm btnDel hidden" data-daily-id="${daily.id}"><span class="glyphicon glyphicon-remove"></span>删除</button>
					</td>
				</tr>
				</c:forEach>
			</table>
<!-- 			分页标签 -->
			<div class="text-right">
				<ul class="pagination">
					<c:choose>
						<c:when test="${pu.currentPage == 1}">
							<li class="disabled"><a href="#"><span>&laquo;</span></a></li>
						</c:when>
						<c:otherwise>						
							<li><a href="daily?method=findMyDaily&cp=${pu.prev}"><span>&laquo;</span></a></li>
						</c:otherwise>
					</c:choose>
					
					<c:forEach begin="${pu.start}" end="${pu.end}"  var="i">
						<c:choose>
							<c:when test="${i == pu.currentPage}">
								<li class="active"><a href="#">${i}</a></li>												
							</c:when>
							<c:otherwise>
								<li><a href="daily?method=findMyDaily&cp=${i}">${i}</a></li>	
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<c:choose>
						<c:when test="${pu.currentPage == pu.last}">
							<li class="disabled"><a href="#"><span>&raquo;</span></a></li>
						</c:when>
						<c:otherwise>						
							<li><a href="daily?method=findMyDaily&cp=${pu.next}"><span>&raquo;</span></a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			
		</div>
	</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="asserts/bootstrap/js/bootstrap.min.js"></script>
<script src="asserts/bootstrapvalidator/js/bootstrapValidator.min.js"></script>
<script src="asserts/bootstrapvalidator/js/language/zh_CN.js"></script>
<script src="asserts/layer/layer.js"></script>
<script>
	$(function(){
		//根据是否返回消息，在页面提示信息
		if('${msg}'){
			layer.msg('${msg}');
		}
		
		//表单验证
		$('#dailyAddForm,#dailyUpdateForm,#stuPwdModify').bootstrapValidator({
			message:'输入的字段信息有误',
			feedbackIcons:{
				valid:'glyphicon glyphicon-ok',
				invalid:'glyphicon glyphicon-remove',
				validating:'glyphicon glyphicon-refresh',	
			},
			fields:{
				gain:{
					validators:{
						stringLength:{
							min:20,
							message:'输入内容不能少于20个字符'
						}
					}
				},
				question:{
					validators:{
						stringLength:{
							min:20,
							message:'输入内容不能少于20个字符'
						}
					}
				},
				suggest:{
					validators:{
						stringLength:{
							min:20,
							message:'输入内容不能少于20个字符'
						}
					}
				}
			}
			
		});
		
		//为详情按钮绑定事件{"":""}  {'':''}
		$('.btnInfo').on('click',function(){
			var tr = $(this).parents('tr');
			console.info(tr);
			$('#d1').text($(tr).find('td').eq(2).text());
			$('#d2').text($(tr).find('td').eq(3).text());
			$('#d3').text($(tr).find('td').eq(4).text());
		})
		
		//为编辑按钮绑定事件
		$('.btnEdit').on('click',function(){
			var tr = $(this).parents('tr');
			
			$('#dailyUpdateForm textarea[name=gain]').val($(tr).find('td').eq(2).text());
			$('#dailyUpdateForm textarea[name=question]').val($(tr).find('td').eq(3).text());
			$('#dailyUpdateForm textarea[name=suggest]').val($(tr).find('td').eq(4).text());
			//将日报id设置到隐藏域中
			$('#dailyUpdateForm input[name=dailyid]').val($(this).data('dailyId'));
		});
		
		//根据id删除
		$('.btnDel').on('click',function(){
			//data-daily-id
			var id = $(this).data('dailyId');
			layer.confirm('确认删除这条日志？',{
				btn:['确认','取消']
			},function(){
				//daily?method=del&id=XX
				location.href='daily?method=del&id='+id;
			});
		})
		//批量删除
		$('.volumeDel').on('click',function(){
			if($('input[name=ids]:checked').length>0){
				//获取所有被选中的复选框集合
				var cks = $('input[name=ids]:checked');
				var ids = [];
				//遍历
				$.each(cks,function(i,n){
					ids.push($(n).val());
				})
				layer.confirm('确定删除这 '+ids.length+' 条数据？',{
					btn:['确认','取消'],
					icon:0
				},function(){					
					//ids = ids.join(',');
					location.href='daily?method=volumeDel&ids='+ids;
				})
			}else{
				layer.alert('请至少选择一项删除!');
			}
		})
		
		//修改密码
		$('#btnModifyPwd').on('click',function(){
			$.ajax({
				type:'POST',
				url:'stu',
				data:$('#stuPwdModify').serialize(),
				success:function(data){
					data = JSON.parse(data);
					console.info(data);
					if(data.code == 1){
						layer.alert(data.message,function(){
							location.replace('stu?method=logout');
						})
					}else{
						layer.msg(data.message);
					}
				}
			})
		});
		
		//全选 保持其他复选框的选中状态与全选按钮的选中状态一致
		$('#selectAll').on('click',function(){
			//将所有input元素中name为ids的元素的选中状态设置为全选复选框的选中状态
			$('input[name=ids]').prop('checked',$(this).prop('checked'))
		})
		
		//安全退出
		$('#logout').on('click',function(){
			location.replace('stu?method=logout');
		})
	})
</script>
</body>
</html>