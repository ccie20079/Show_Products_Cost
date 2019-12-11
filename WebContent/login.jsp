<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index.jsp</title>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="myjs/validatorForm.js"></script>
<style type="text/css">
#login{
	width: 497px;
	height: 203;
	padding: 0px;
	margin:0px;
}
</style>
<script type="text/javascript">
	window.history.forward(-1);
	$(function() {
		$("#login").dialog({
			title : '登录',
			closed : false,
			closable : false,
			modal : true,
			buttons : [ {
				text : '登  录',
				handler : function() {
					$("#loginForm").form('submit', {
						url : "loginAction!login",
						onSubmit : function() {
							return $("#loginForm").form('validate');
						},
						success : function(data) {
							var msg = eval("(" + data + ")");
							if (msg.flag) {
								window.location.href = "index.jsp";
								return;
							}
							$.messager.alert("提示：", msg.content, "");
						}
					});
				}
			}]
		});
	});
</script>
</head>
<body>
	<div id="login">
		<form id="loginForm" method="post" margin="0px" padding="" >
		  <table style="width:497px;height:203px;">
            <tr>
              <td width="35%" style="text-align:right;font-size:26px;"><label > 用户名: </label></td>
              <td width="65%"><input name="username" class="easyui-validatebox" data-options="required:true" style="height:35px;width:190px;margin-left:10px;"></td>
            </tr>
            <tr>
              <td style="text-align:right;margin:15px;font-size:26px;"><label>密   码: </label></td>
              <td><input name="password" class="easyui-validatebox" type ="password" data-options="required:true,validType:'validateEmail'" style="height:35px;width:190px;margin-left:10px;"></td>
            </tr>
          </table>
		</form>
	</div>
</body>
</html>