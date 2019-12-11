<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- The page is designed by 董魁 -->
<title>customerList.jsp</title>
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../myjs/DGAutoSize.js"></script>
<style type="text/css">
#addDialog,#editDialog {
	width: 500px;
	height: 156px;
	padding: 15px;
}
</style>
<script type="text/javascript">
	$(function() {
	// init datagrid
		$("#dg").datagrid({
			fit : true,
			nowrap : false,
			fitColumns : true,
			rownumbers : true,
			striped : true,
			toolbar : "#tb",
			pagePosition : true,
			pagination : true,
			url : "V_Products_C_And_Pic_Summary_Action!get_V_Products_C_And_Pic_Summary_Info.action",
			frozenColumns : [ [ {
				checkbox : true,
				field : "cb"
			}, {
				field : "product_Name",
				title : "产品名称",
				width:  fixWidth(1/6),
				align : "center"
			},
			{
				field : "total_man_hours",
				title : "总工时",
				width:  fixWidth(1/6),
				align : "center"
			},
			{
				field : "total_labour_cost",
				title : "总工价",
				width:  fixWidth(1/6),
				align : "center"
			},{
				field : "supplier",
				title : "提供者",
				width:  fixWidth(1/6),
				align : "center"
			},{
				field : "latest_update_time",
				title : "最近更新时间",
				width:  fixWidth(1/6),
				align : "center"
			},{
				field : "picture_name",
				title : "产品图片",
				width:  fixWidth(1/6),
				align : "center",
				formatter:_showPhoto
			}
			] ]
		});	
		function _showPhoto(value,row,index){
			if(value){
				//return "<img src='C:\\JPG\\A03402.JPG' style = 'width:100px;height:40px' />" ;
				//return '<img style = "width:30px;height:30px" src = "'+value+'" />';
				return '<img src="../Products_Pic/' + value+ '" width="159" height="129" >';
							
			}else{
				return null;
			}
		}
		$("#addCombogrid").combogrid({
			panelWidth : 669,
			editable : false,
			nowrap : false,
			multiple : true,
			url : 'ordersAction!findWithPage.action',
			pagination : true,
			rownumbers : true,
			singleSelect : false,
			striped : true,
			fitColumns : true,
			idField : 'id',
			textField : 'orderNumber',
			columns : [ [ {
				checkbox : true,
				field : 'cx'
			}, {
				field : 'orderNumber',
				title : '订单编号',
				width : 80,
				align : 'center'
			}, {
				field : 'orderDate',
				title : '订单日期',
				width : 80,
				align : 'center'
			}, {
				field : 'orderCount',
				title : '订单数量',
				width : 80,
				align : 'center'
			}, {
				field : 'purName',
				title : '商品名称',
				width : 80,
				align : 'center'
			}, {
				field : 'custName',
				title : '客户名称',
				width : 80,
				align : 'center'
			} ] ]
		});
		//init addDialog
		$("#addDialog").dialog({
			modal : true,
			closable : false,
			closed : true,
			title : "添加",
			buttons : [ {
				text : "添加",
				iconCls : "icon-add",
				handler : function() {
					$("#form1").form("submit", {
						//提交保存
						url : "customerAction!saveCustomerInfo.action",
						onSubmit : function() {
							return $("#form1").form("validate");
						},
						success : function(data) {
							var flag = eval("(" + data + ")");
							if (flag) {
								$.messager.show({
									title : "提示",
									msg : "添加成功",
									timeout : 1300,
									showType : "slide"
								});
								//clear the form
								$("#form1").form("clear");
								//reload the datagrid
								$("#dg").datagrid("reload");
							} else {
								$.messager.alert("提示", "添加失败", "error");
							}
						}
					});
				}
			}, {
				text : "退出",
				iconCls : "icon-cancel",
				handler : function() {
					//clear the form
					$("#form1").form("clear");
					//close the addDialog
					$("#addDialog").dialog({
						closed : true
					});
				}
			} ]
		});
		$("#editDialog").dialog({
			title : '客户信息修改',
			modal : true,
			closable : false,
			closed : true,
			iconCls : 'icon-edit',
			buttons : [ {
				text : '修改',
				iconCls : 'icon-ok',
				handler : function() {
					$("#form2").form("submit", {
						url : 'customerAction!updateCustomerInfo',
						onSubmit : function() {
							return $("#form2").form("validate");
						},
						success : function(data) {
							var flag = eval("(" + data + ")");
							if (flag) {
								$.messager.show({
									title : '提示：',
									msg : '修改成功',
									timeout : 1500,
									showType : 'slide'
								});
								//reload the datagrid
								$("#dg").datagrid("reload");
								$("#form2").form("clear");
								$("#editDialog").dialog({
									closed : true
								});
							}
						}
					});
				}
			}, {
				text : '取消',
				iconCls : 'icon-cancel',
				handler : function() {
					$("#form2").form("clear");
					$("#editDialog").dialog({
						closed : true
					});
					$("#dg").datagrid("unselectAll");
				}
			} ]
		});

		//form2 载入数据成功事件
		$("#form2").form({
			onLoadSuccess : function(data) {
				var val = $("#desComId").combogrid("getText");
				//若文本值为数值，则转换为对应文本
				//这块有报错，问下老师吧。。。
				if ($.type(eval(val)) === "number") {
					$("#desComId").combogrid("setText", data.desCom.desname);
				}
			}
		});
		//模糊查詢事件
		$("#searchBtn").click(function() {
			$("#dg").datagrid("reload", {
				custName : $("#custName").val()
			});
		});
		//删除事件 
		$("#removeBtn").click(function() {
			var array = $("#dg").datagrid("getSelections");
			if (array.length == 0) {
				$.messager.alert("提示：", "请选择要删除的数据", "info");
				return;
			}
			//待删信息的ID组成的数组。
			var arrayOfID = [];
			for ( var i in array) {
				arrayOfID.push(array[i].id);
			}
			//调用删除方法,注意数组名必须后边跟[],否则数组不能在后台正确获取。
			$.getJSON("customerAction!deleteCustomerByIDArray.action", {
				"arrayOfID" : arrayOfID
			}, function(msg) {
				$.messager.show({
					width : 360,
					title : "提示:",
					msg : msg.content,
					timeout : 4000,
					showType : "slide"
				});
				//reload the datagrid
				$("#dg").datagrid("reload");
			});
		});

		//添加事件
		$("#addBtn").click(function() {
			//display the dialog;
			$("#addDialog").dialog({
				closed : false
			});
		});

		//修改事件
		$("#editBtn").click(
				function() {
					//判断选中的行数。
					var rows = $("#dg").datagrid("getSelections");
					if (rows.length != 1) {
						$.messager.alert("提示：", "请选择一条数据进行编辑", "question");
						$("#dg").datagrid("unselectAll");
						return;
					}
					var fid = rows[0].id;
					//载入相关数据。
					$("#form2").form("load",
							"customerAction!findCustomerById?fid=" + fid);
					$("#editDialog").dialog({
						closed : false
					});
				});

		$("#reloadBtn").click(function() {
			$("#dg").datagrid("reload");
		});
	});
</script>
</head>
<body>
	<!--datagrid -->
	<div id="dg"></div>
	<div id="tb">
		<table>
			<tr>
				<td><label>产品名称：</label></td>
				<td><input id="productName" class="easyui-validatebox" /></td>
				<td><a id="searchBtn" class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-search'">查询</a></td>
			</tr>
		</table>
		<a id="addBtn" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'icon-add'">添加</a> <a id="editBtn"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'icon-edit'">修改</a> <a
			id="removeBtn" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'icon-remove'">删除</a> <a
			id="reloadBtn" class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',plain:true">刷新</a>
	</div>
	<!--define the addDialog -->
	<div id="addDialog">
		<form id="form1" method="post">
			<table border="0" align="center" cellspacing="2">
				<tr>
					<td align="right"><label>客户姓名:</label></td>
					<td><input name="custName" class="easyui-validatebox"
						data-options="required:true"></td>
					<td align="right"><label>客户性别:</label></td>
					<td><select name="custSex" class="easyui-combobox"
						data-options="editable:false,required:true" style="width: 100%">
							<option value="1">男</option>
							<option value="0">女</option>
					</select></td>
				</tr>
				<tr>
					<td align="right"><label>客户电话:</label></td>
					<td><input name="custTel" class="easyui-validatebox"
						data-options="validType:'validataTel'" /></td>
					<td align="right"><label>客户地址:</label></td>
					<td><input name="custAddress" class="easyui-validatebox" /></td>
				</tr>

				<tr>
					<td align="right"><label>出生日期:</label></td>
					<td><input name="custBirthday" class="easyui-datebox" /></td>
					<td align="right"><label>身份证号码:</label></td>
					<td><input name="custCardnumber" class="easyui-validatebox" /></td>
				</tr>

				<tr>
					<td align="right"><label>电子邮件:</label></td>
					<td><input name="custEmail" class="easyui-validatebox" /></td>
					<td align="right"><label>是否VIP:</label></td>
					<td><select name="custVip" class="easyui-combobox"
						data-options="editable:false,required:true" style="width: 100%">
							<option value="0">是</option>
							<option value="1">否</option>
					</select></td>
				</tr>

				<tr>
					<td align="right"><label>注册时间:</label></td>
					<td><input name="custRegisterTime" class="easyui-datebox"></td>
					<td align="right"><label>客户描述:</label></td>
					<td><input name="custDesc" class="easyui-validatebox" /></td>
				</tr>
				<tr>
					<!-- orderNumber; orderDate; orderCount; custName; purName; -->
					<td align="right"><label>订单编号:</label></td>
					<td><select id="addCombogrid" name="orderIdStr"
						style="width: 100%"></select></td>
				</tr>
			</table>
		</form>
	</div>

	<!-- 		; custName; custSex; custTel; custAddress; custBirthday; -->
	<!-- 			custCardnumber; custEmail; custVip;// 0是1,否 custRegisterTime; -->
	<!-- 			custDesc; orderNumber; -->
	<div id="editDialog">
		<form id="form2" method="post">
			<table border="0" align="center">
				<tr>
					<td><input name="id" type="hidden" /></td>
				</tr>
				<tr>
					<td align="right"><label>客户姓名：</label></td>
					<td><input name="custName" class="easyui-validatebox"
						data-options="required:true"></td>
					<td align="right"><label>电话：</label></td>
					<td><input name="custTel" class="easyui-validatebox"
						data-options="required:true,validType:'validataTel'"></td>
				</tr>
				<tr>
					<td align="right"><label>地址：</label></td>
					<td><input name="custAddress" class="easyui-validatebox"></td>
					<td align="right"><label>出生日期：</label></td>
					<td><input name="custBirthday" class="easyui-datebox"></td>
				</tr>
				<tr>
					<td align="right"><label>身份证号：</label></td>
					<td><input name="custCardnumber" class="easyui-validatebox"></td>
					<td align="right"><label>电子邮件：</label></td>
					<td><input name="custEmail" class="easyui-validatebox"></td>
				</tr>
				<tr>
					<td align="right"><label>是否VIP：</label></td>
					<td><select name="custVip" class="easyui-combobox"
						style="width: 100%" data-options="editable:false">
							<option value="0">是</option>
							<option value="1">否</option>
					</select></td>
					<td align="right"><label>注册时间：</label></td>
					<td><input name="custRegisterTime" class="easyui-datebox"></td>
				</tr>
				<tr>
					<td align="right"><label>性别：</label></td>
					<td><select name="custSex" class="easyui-combobox"
						style="width: 100%">
							<option value="0">女</option>
							<option value="1">男</option>
					</select></td>
					<td align="right"><label>描述：</label></td>
					<td><input name="custDesc" class="easyui-validatebox"></td>
				</tr>
				<tr>
					<td><label>所有订单：</label></td>
					<td><input name="orderIdStr" class="easyui-combogrid"
						data-options="
						panelWidth:1033,
						editable:false,
						pagination:true,
						rownumbers:true,
						fitColumns:true,
						multiple:true,
						idField:'id',
						textField:'orderNumber',
						url:'ordersAction!findWithPage',
						columns:[[
							{
								field:'orderNumber',
								title:'订单编号',
								width:80,
								align:'center'
							}
						]]
					"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>