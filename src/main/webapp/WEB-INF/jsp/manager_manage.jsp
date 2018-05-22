<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Consumer_manage</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="后台用户管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/manager/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="account" width="50">账号</th>
            <th field="name" width="50">昵称</th>
            <th field="sex" width="50">性别</th>
            <th field="email" width="50">邮箱</th>
            <th field="phone" width="50">手机号码</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newManager()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editManager()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyManager()">删除</a>
</div>
<div id="ManagerDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Manager-buttons">
    <div class="ftitle">后台管理用户信息填写</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>账号</label><div>&nbsp;</div>
            <input type="text" name="account" class="plainText">
        </div>
        <div class="fitem">
            <label>密码</label><div>&nbsp;</div>
            <input type="password" name="password" class="plainText">
        </div>
        <div class="fitem">
            <label>昵称</label><div>&nbsp;</div>
            <input type="text" name="name" class="plainText">
        </div>
        <div class="fitem">
            <label>性别</label><div>&nbsp;</div>
            <span class="radioSpan">
                <input name="sex" value="男" type="radio">男
                <input name="sex" value="女" type="radio">女
            </span>        </div>
        <div class="fitem">
            <label>邮箱</label><div>&nbsp;</div>
            <input type="text" name="email" class="plainText">
        </div>
        <div class="fitem">
            <label>手机号码</label><div>&nbsp;</div>
            <input type="text" name="phone" class="plainText">
        </div>
    </form>
</div>
<div id="Manager-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveManager()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#ManagerDialog').dialog('close')">取消</a>
</div>



<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
