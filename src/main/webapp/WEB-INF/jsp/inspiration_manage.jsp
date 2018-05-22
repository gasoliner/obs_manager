<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_region</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="感悟与分享管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/orders/listbystate/已发货',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="title" width="50">标题</th>
            <th field="voPublish" width="50">发表时间</th>
            <th field="voCid" width="50">发表者</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newInspiration()">新建</a>--%>
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editInspiration()">编辑</a>--%>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyInspiration()">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showInspiration()">查看详细信息</a>
</div>

<div id="showInspirationDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showInspirationDialog-buttons">
    <h5>标题：</h5>
    <div id="title_content"></div>
    <h5>正文：</h5>
    <div id="content_content"></div>
    <span style="display:block; width: 500px; float:right; text-align:right;">
       <h5>发表时间：</h5>
    <div id="voPublish_content"></div>
    <h5>发表者：</h5>
    <div id="voCid_content"></div>
    </span>


</div>

<div id="showInspirationDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showInspirationDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
