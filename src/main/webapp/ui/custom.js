function newUser() {
    $("#fm").form("clear");
    $("#userDialog").dialog("open").dialog("setTitle","新建");
    url = "/user/add";
}
function editUser() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#userDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/user/update?sid="+row.sid;
    }
}
function destroyUser() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/user/delete?sid="+row.sid,
                    success: function (res) {
                        alert(res);
                        $("#userDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveUser() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#userDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function subNewUser() {
    $.post("/user/add",{
        number:$("#number").val(),
        username:$("#username").val(),
        sex:$("input[name='sex']:checked").val(),
        classs:$("#classs").val(),
        signature:$("#signature").val(),
        email:$("#email").val(),
        phone:$("#phone").val(),
    },function (backresult) {
        alert(backresult);
    })
}

function perInf1() {
    $.post("/manager/updates/" + $("#mid").val(),
        {
            mid:$("#mid").val(),
            name:$("#name").val(),
            username:$("#username").val(),
            sex:$("input[name='sex']:checked").val(),
            phone:$("#phone").val(),
            email:$("#email").val()
        },
        function (data) {
            alert(data);
        });
}
function perPas1() {
    $.post("/manager/password",
        {
            mid:$("#mid").val(),
            oldpassword:$("#oldpass").val(),
            newpassword1:$("#newpass1").val(),
            newpassword2:$("#newpass2").val()
        },
        function (data) {
            alert(data);
        });
}

function newBookkind() {
    $("#fm").form("clear");
    $("#BookkindDialog").dialog("open").dialog("setTitle","新建");
    url = "/bookkind/addition";
}
function editBookkind() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#BookkindDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/bookkind/updates/"+row.bkid;
    }
}
function destroyBookkind() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/bookkind/deletion/"+row.bkid,
                    success: function (res) {
                        alert(res);
                        $("#BookkindDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveBookkind() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#BookkindDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newBook() {
    $("#fm").form("clear");
    $("#BookDialog").dialog("open").dialog("setTitle","新建");
    url = "/book/addition";
}
function editBook() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#BookDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/book/updates/"+row.id;
    }
}
function destroyBook() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/book/deletion/"+row.id,
                    success: function (res) {
                        alert(res);
                        $("#BookDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveBook() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#BookDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function showBook() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showBookDialog").dialog("open").dialog("setTitle",row.title);
        $("#bookname_content").html(row.bookname);
        $("#author_content").html(row.author);
        $("#publishyear_content").html(row.publishyear);
        $("#pages_content").html(row.pages);
        $("#price_content").html(row.price);
        $("#score_content").html(row.score);
        $("#voUrl_content").html(row.voUrl);
        $("#content_content").html(row.content);
        $("#author_info_content").html(row.authorinfo);
    }
}
function showBookPic(id) {
    $("#showBookPicDialog").dialog({
        title:"查看",
        width: 550,
        height: 550,
        closed: false,
        cache: false,
        modal: true
    });
    $("#att_img").attr("src","/book/img/"+id);
}


function login() {
    $("#fm").form("submit",{
        url:"/login/login",
        success:function (res) {
            window.location.href = res;
        }
    })
}
function logout() {
    $.get("/user/signout",null,function (res) {
        window.location.href = "/UI/sign";
    })
}

function newConsumer() {
    $("#fm").form("clear");
    $("#ConsumerDialog").dialog("open").dialog("setTitle","新建");
    url = "/consumer/addition";
}
function editConsumer() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#ConsumerDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/consumer/updates/"+row.cid;
    }
}
function destroyConsumer() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/consumer/deletion/"+row.cid,
                    success: function (res) {
                        alert(res);
                        $("#ConsumerDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveConsumer() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#ConsumerDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newManager() {
    $("#fm").form("clear");
    $("#ManagerDialog").dialog("open").dialog("setTitle","新建");
    url = "/manager/addition";
}
function editManager() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#ManagerDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/manager/updates/"+row.mid;
    }
}
function destroyManager() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/manager/deletion/"+row.mid,
                    success: function (res) {
                        alert(res);
                        $("#ManagerDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveManager() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#ManagerDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newOrders() {
    $("#fm").form("clear");
    $("#OrdersDialog").dialog("open").dialog("setTitle","新建");
    url = "/orders/addition";
}
function editOrders() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#OrdersDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/orders/updates/"+row.oid;
    }
}
function destroyOrders() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/orders/deletion/"+row.oid,
                    success: function (res) {
                        alert(res);
                        $("#OrdersDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveOrders() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#OrdersDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function showOrders() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showOrdersDialog").dialog("open").dialog("setTitle",row.title);
        $("#name_content").html(row.name);
        $("#time_content").html(row.time);
        $("#state_content").html(row.state);
        $("#sum_content").html(row.sum);
        $("#voCid_content").html(row.voCid);
        $("#voReceive_content").html(row.voReceive);
        $("#var_content").html(row.var);
    }
}
function setShipped(id) {
    $.post("/orders/setShipped/" + id,
        null,
        function (data) {
            alert(data);
            $('#dg').datagrid("reload");
        });
}

function newInspiration() {
    $("#fm").form("clear");
    $("#InspirationDialog").dialog("open").dialog("setTitle","新建");
    url = "/inspiration/addition";
}
function editInspiration() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#InspirationDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/inspiration/updates/"+row.inid;
    }
}
function destroyInspiration() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/inspiration/deletion/"+row.inid,
                    success: function (res) {
                        alert(res);
                        $("#InspirationDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveInspiration() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#InspirationDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function showInspiration() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showInspirationDialog").dialog("open").dialog("setTitle",row.title);
        $("#title_content").html(row.title);
        $("#content_content").html(row.content);
        $("#voPublish_content").html(row.voPublish);
        $("#voCid_content").html(row.voCid);
    }
}