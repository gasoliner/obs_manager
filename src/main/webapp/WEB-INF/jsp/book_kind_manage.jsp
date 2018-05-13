<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Bookkind_manage</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="图书类别管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/bookkind/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="bkid" width="50">类别ID</th>
            <th field="kind" width="50">类别</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newBookkind()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editBookkind()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyBookkind()">删除</a>
</div>
<div id="BookkindDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Bookkind-buttons">
    <div class="ftitle">图书类别信息填写</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>类别名称</label><div>&nbsp;</div>
            <input type="text" name="kind" placeholder="100字以内" class="plainText">
        </div>
    </form>
</div>
<div id="Bookkind-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveBookkind()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#BookkindDialog').dialog('close')">取消</a>
</div>
<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
