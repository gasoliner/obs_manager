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
function newClasssInfo() {
    $("#fm").form("clear");
    $("#classsInfoDialog").dialog("open").dialog("setTitle","新建");
    url = "/classsInfo/add";
}
function editClasssInfo() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#classsInfoDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/classsInfo/update?ciid="+row.ciid;
    }
}
function destroyClasssInfo() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/classsInfo/delete?ciid="+row.ciid,
                    success: function (res) {
                        alert(res);
                        $("#classsInfoDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveClasssInfo() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#classsInfoDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function newClasssNotice() {
    $("#fm").form("clear");
    $("#noticeDialog").dialog("open").dialog("setTitle","新建");
    url = "/classsNotice/add";
}
function editClasssNotice() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#noticeDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/classsNotice/update?cnid="+row.cnid;
    }
}
function destroyClasssNotice() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/classsNotice/delete?cnid="+row.cnid,
                    success: function (res) {
                        alert(res);
                        $("#noticeDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveClasssNotice() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#noticeDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function newFile() {
    $("#fm").form("clear");
    $("#fileDialog").dialog("open").dialog("setTitle","新建");
    url = "/classsFile/add";
}
function editFile() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#fileDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/classsFile/update?cfid="+row.cfid;
    }
}
function destroyFile() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/classsFile/delete?cfid="+row.cfid,
                    success: function (res) {
                        alert(res);
                        $("#fileDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveFile() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#fileDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function perInf1() {
    $.post("/personal/update",
        {
            tid:$("#tid").val(),
            employeenum:$("#employeenum").val(),
            username:$("#username").val(),
            classs:$("#classs").val(),
            phone:$("#phone").val(),
            email:$("#email").val()
        },
        function (data) {
        alert(data);
    });
}
function perPas1() {
    $.post("/personal/password",
        {
            tid:$("#tid").val(),
            oldpassword:$("#oldpass").val(),
            newpassword1:$("#newpass").val(),
            newpassword2:$("#newpass1").val()
        },
        function (data) {
        alert(data);
    });
}
function newAchievement() {
    $("#fm").form("clear");
    $("#achievementDialog").dialog("open").dialog("setTitle","新建");
    url = "/achievement/add";
}
function editAchievement() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#achievementDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/achievement/update?aid="+row.aid;
    }
}
function destroyAchievement() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/achievement/delete?aid="+row.aid,
                    success: function (res) {
                        alert(res);
                        $("#achievementDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveAchievement() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#achievementDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function login() {
    $("#fm").form("submit",{
        url:"/user/signin",
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