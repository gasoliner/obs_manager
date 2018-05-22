<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<style type="text/css">
    .menu-last {
        margin-bottom: 5px;
    }
</style>
<body>
<div class="easyui-accordion" style="width:auto;border: 0px;">
    <ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
        <li>
            <span>图书相关管理</span>
            <ul>
                <li data-options="attributes:{'url':'book_manage'}">图书管理</li>
                <li data-options="attributes:{'url':'book_kind_manage'}">图书类别管理</li>
            </ul>
        </li>
        <li>
            <span>订单管理</span>
            <ul>
                <li data-options="attributes:{'url':'order_zhifu_manage'}">查询已支付订单</li>
                <li data-options="attributes:{'url':'order_fahuo_manage'}">查询已发货订单</li>
                <li data-options="attributes:{'url':'order_shouhuo_manage'}">查询已收货订单</li>
                <li data-options="attributes:{'url':'order_manage'}">全部订单</li>
            </ul>
        </li>
        <li>
            <span>用户管理</span>
            <ul>
                <li data-options="attributes:{'url':'consumer_manage'}">客户管理</li>
                <li data-options="attributes:{'url':'manager_manage'}">后台管理用户管理</li>
            </ul>
        </li>
        <li>
            <span>个人相关操作</span>
            <ul>
                <%--<li data-options="attributes:{'url':'personalInfo'}">个人信息</li>--%>
                <li data-options="attributes:{'url':'personalPass'}">密码修改</li>
            </ul>
        </li>
    </ul>
</div>

<script type="text/javascript">
    $(function(){
        $('#menu').tree({
            onClick: function(node){
                if($('#menu').tree("isLeaf",node.target)){
                    if ($('#tt').tabs('exists', node.text)){
                        $('#tt').tabs('select', node.text);
                    } else {
                        var content = '<iframe scrolling="auto" frameborder="0"  src="'+node.attributes.url+'" style="width:100%;height:100%;"></iframe>';
                        $('#tt').tabs('add',{
                            title:node.text,
                            content:content,
                            closable:true
                        });
                    }
                }
            }
        });
    });
</script>
</body>
