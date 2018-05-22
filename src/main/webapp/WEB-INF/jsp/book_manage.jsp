<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>book_manage</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="图书管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/book/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="bookname" width="50">书名</th>
            <th field="author" width="50">作者</th>
            <th field="publishyear" width="50">出版日期</th>
            <th field="pages" width="50">页数</th>
            <th field="price" width="50">价格</th>
            <th field="score" width="50">豆瓣评分</th>
            <th field="content" width="50">内容简介</th>
            <th field="authorinfo" width="50">作者简介</th>
            <th field="voUrl" width="50">查看图片</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newBook()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editBook()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyBook()">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showBook()">查看详细信息</a>
    <%--<label>按年度查询</label>--%>
    <%--<input id="Book_searchInput"--%>
           <%--name="year"--%>
           <%--class="easyui-combobox"--%>
           <%--data-options="--%>
                           <%--valueField:'ddlcode',--%>
                           <%--textField:'ddlname',--%>
                           <%--width:300,--%>
                           <%--url:'${pageContext.request.contextPath}/systemddl/list/year'" />--%>
</div>
<div id="BookDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Book-buttons">
    <div class="ftitle">图书信息填写</div>
    <form id="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label>所属分类&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="kind"
                   class="easyui-combobox"
                   data-options="
                           valueField:'bkid',
                           textField:'kind',
                           width:300,
                           url:'${pageContext.request.contextPath}/bookkind/ddllist'" />
        </div>
        <div class="fitem">
            <label>书名</label><div>&nbsp;</div>
            <input type="text" name="bookname" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>作者</label><div>&nbsp;</div>
            <input type="text" name="author" class="plainText">
        </div>
        <div class="fitem">
            <label>出版日期</label><div>&nbsp;</div>
            <input type="text" name="publishyear" class="plainText">
        </div>
        <div class="fitem">
            <label>页数</label><div>&nbsp;</div>
            <input type="text" name="pages" class="plainText">
        </div>
        <div class="fitem">
            <label>价格</label><div>&nbsp;</div>
            <input type="text" name="price" class="plainText">
        </div>
        <div class="fitem">
            <label>豆瓣评分</label><div>&nbsp;</div>
            <input type="text" name="score" class="plainText">
        </div>
        <div class="fitem">
            <label>图书图片</label><div>&nbsp;</div>
            <input type="file" name="img_file" class="plainText">
        </div>
        <div class="fitem">
            <label>内容简介</label><div>&nbsp;</div>
            <textarea name="content" class="textareaComment" placeholder="500字以内"></textarea>
        </div>
        <div class="fitem">
            <label>作者简介</label><div>&nbsp;</div>
            <textarea name="authorinfo" class="textareaComment" placeholder="500字以内"></textarea>
        </div>
    </form>
</div>
<div id="Book-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveBook()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#BookDialog').dialog('close')">取消</a>
</div>

<div id="showBookDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showBookDialog-buttons">
    <h5>书名：</h5>
    <div id="bookname_content"></div>
    <h5>作者：</h5>
    <div id="author_content"></div>
    <h5>出版日期：</h5>
    <div id="publishyear_content"></div>
    <h5>页数：</h5>
    <div id="pages_content"></div>
    <h5>价格：</h5>
    <div id="price_content"></div>
    <h5>豆瓣评分：</h5>
    <div id="score_content"></div>
    <h5>查看图片：</h5>
    <div id="voUrl_content"></div>
    <h5>内容简介：</h5>
    <div id="content_content"></div>
    <h5>作者简介：</h5>
    <div id="author_info_content"></div>
</div>

<div id="showBookDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showBookDialog').dialog('close')">好的</a>
</div>

<div id="showBookPicDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showBookPicDialog-buttons">
    <img id="att_img"/>
</div>

<div id="showBookPicDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showBookPicDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
