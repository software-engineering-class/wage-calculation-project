<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/23/0023
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../lib/html5shiv.js"></script>
    <script type="text/javascript" src="../lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="../lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>工资项目</title>
</head>
<body>

<script type="text/javascript">

    function del(projectid){
        if(confirm("是否删除?")){
            open("delete?projectid="+projectid,"_self");
        }
    }


</script>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 工资项目 <span class="c-gray en">&gt;</span> 工资项列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <form class="Huiform" method="post" action="${pageContext.request.contextPath}/wageproject/selectall">
            <input type="text" placeholder="请输入项目名称" name="projectname" class="input-text" style="width:200px">
            <button type="button" class="btn btn-success"  name="" onClick="location.href='savewageproject'"><i class="Hui-iconfont">&#xe600;</i> 添加</button>
            <button type="submit" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 查询</button>
        </form>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-sort">
            <thead>
            <tr class="text-c">

                <th width="50">项目名称</th>
                <th width="200">类型</th>
                <th width="200">备注</th>
                <th width="100">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${wageprojectinfo.list}" var="h">
                <tr class="text-c">


                    <td>${h.projectname}</td>
                    <td>${h.typesname}</td>
                    <td>${h.note}</td>

                    <td class="f-14 product-brand-manage">
                        <a style="text-decoration:none" href="${pageContext.request.contextPath}/wageproject/selectWageprojectById/${h.projectid}" title="编辑">
                            <i class="Hui-iconfont">&#xe6df;</i>
                        </a>
                        <a style="text-decoration:none" class="ml-5" href="javascript:del(${h.projectid});" title="删除">
                            <i class="Hui-iconfont">&#xe6e2;</i>
                        </a>
                    </td>



                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

    <a class="btn btn-primary upload-btn" href="${pageContext.request.contextPath}/wageproject/selectall?pageNo=1">首页</a>
    <a class="btn btn-primary upload-btn" href="${pageContext.request.contextPath}/wageproject/selectall?pageNo=${requestScope.wageprojectinfo.prePage}">上一页</a>
    <a class="btn btn-primary upload-btn" href="${pageContext.request.contextPath}/wageproject/selectall?pageNo=${requestScope.wageprojectinfo.nextPage}">下一页</a>
    <a class="btn btn-primary upload-btn" href="${pageContext.request.contextPath}/wageproject/selectall?pageNo=${requestScope.wageprojectinfo.pages}">末页</a>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<%--<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>--%>
<%--<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>--%>
<script type="text/javascript">
    $('.table-sort').dataTable({
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "bStateSave": true,//状态保存
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable":false,"aTargets":[0,6]}// 制定列不参与排序
        ]
    });
</script>
</body>
</html>
