<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>index.jsp</title>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	window.history.forward(-1);

	$(function() {
		var mydata = [ {
			text : '成衣成本信息',
			state : 'closed',
			children : [ {
				text : '成本信息',
				attributes : {
					url : 'jsp/productCostSummary.jsp'
				}
			}]
		}];

		$("#tree").tree({
			data : mydata,
			lines : true,
			onClick : function(node) {
				if (node.attributes) {
					openTabs(node.text, node.attributes.url);
				}
			}
		});

		function openTabs(text, url) {
			if ($("#tabs").tabs('exists', text)) {
				$("#tabs").tabs('select', text);
			} else {
				var myContent = "<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="
						+ url + "></iframe>";
				$("#tabs").tabs('add', {
					content : myContent,
					title : text,
					closable : true
				});
			}
		}
	});
</script>
</head>
<body class="easyui-layout">
	<%
		String username = (String) session.getAttribute("username");
		if ("".equals(username) || username == null) {
			response.sendRedirect("login.jsp");
			return;
		}
	%>
	<div region="north" style="height: 120px" title="成衣成本系统" split="true">
		<div><img alt="" src="image/dukepu_Logo.JPG" height="68px"></div>
		<div align="right">
			<a href="loginAction!logout">退出</a>
		</div>
	</div>
	<div region="west" style="width: 160px" title="导航菜单" split="true">
		<div id="tree"></div>
	</div>
	<div region="center" title="显示数据">
		<div id="tabs" class="easyui-tabs" fit="true">
			<div title="首页"></div>
		</div>
	</div>
</body>
</html>