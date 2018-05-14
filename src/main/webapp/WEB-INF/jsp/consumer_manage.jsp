<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Consumer_manage</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="客户管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/consumer/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="cid" width="50">账号</th>
            <th field="nickname" width="50">昵称</th>
            <th field="sex" width="50">性别</th>
            <th field="email" width="50">邮箱</th>
            <th field="phone" width="50">手机号码</th>
            <th field="receive" width="50">收货地址</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newConsumer()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editConsumer()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyConsumer()">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showConsumer()">查看详细信息</a>
    <%--<label>按年度查询</label>--%>
    <%--<input id="Consumer_searchInput"--%>
           <%--name="year"--%>
           <%--class="easyui-combobox"--%>
           <%--data-options="--%>
                           <%--valueField:'ddlcode',--%>
                           <%--textField:'ddlname',--%>
                           <%--width:300,--%>
                           <%--url:'${pageContext.request.contextPath}/systemddl/list/year'" />--%>
</div>
<div id="ConsumerDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Consumer-buttons">
    <div class="ftitle">客户信息填写</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>账号</label><div>&nbsp;</div>
            <input type="text" name="cid" class="plainText">
        </div>
        <div class="fitem">
            <label>密码</label><div>&nbsp;</div>
            <input type="password" name="password" class="plainText">
        </div>
        <div class="fitem">
            <label>昵称</label><div>&nbsp;</div>
            <input type="text" name="nickname" class="plainText">
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
        <div class="fitem">
            <label>收货地址</label><div>&nbsp;</div>
            <input type="text" name="receive" class="plainText">
        </div>
    </form>
</div>
<div id="Consumer-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveConsumer()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#ConsumerDialog').dialog('close')">取消</a>
</div>



<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
