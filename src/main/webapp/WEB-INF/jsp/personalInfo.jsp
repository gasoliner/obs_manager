<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>personalInfo</title>
    <link rel="stylesheet" type="text/css" href="/ui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
    <script type="application/javascript" src="/ui/custom.js"></script>
</head>
<body>
<div style="width: 900px;height: auto;margin: 0 auto">
    <div class="messager-body" style="width: auto;height: auto;margin: 0 auto">
        <div class="messager-input" style="height: 56px; margin: 10px;">
            <p align="center" style="font-size: 16px;">
                <label for="account" >账&nbsp;&nbsp;号: </label>
                <input id="account" readonly="readonly" value="${globleUser.account}"  class="easyui-textbox" style="width: 300px;height: 32px"/>
            </p>
        </div>
        <div class="messager-input" style="height: 56px; margin: 10px;">
            <p align="center" style="font-size: 16px;">
                <label for="name" >用户名: </label>
                <input id="name" value="${globleUser.name}" class="easyui-textbox" style="width: 300px;height: 32px"/>
            </p>
        </div>
        <div class="messager-input" style="height: 56px; margin: 10px;">
            <label>性别</label><div>&nbsp;</div>
            <span class="radioSpan">
                <input name="sex" value="男" type="radio">男
                <input name="sex" value="女" type="radio">女
            </span>
        </div>
        <div class="messager-input" style="height: 56px; margin: 10px;">
            <p align="center" style="font-size: 16px;">
                <label for="email" >邮&nbsp;&nbsp;箱: </label>
                <input id="email" class="easyui-textbox" value="${globleUser.email}" style="width: 300px;height: 32px"/>
            </p>
        </div>
        <div class="messager-input" style="height: 56px; margin: 10px;">
            <p align="center" style="font-size: 16px;">
                <label for="phone" >手机号: </label>
                <input id="phone" class="easyui-textbox" value="${globleUser.phone}" style="width: 300px;height: 32px"/>
            </p>
        </div>
        <div class="messager-button" style="height: 56px; margin: 10px;">
            <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="perInf1()">
                <span style="font-size: 16px">提交</span>
            </a>
        </div>
        <div>
            <input id="mid" type="hidden" value="${globleUser.mid}"/>
        </div>
    </div>
</div>
</body>
</html>

