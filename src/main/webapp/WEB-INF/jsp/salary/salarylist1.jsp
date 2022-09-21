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
    <title>品牌房源管理</title>
</head>
<body>

<script type="text/javascript">




    function changersearch(o){
        var type=$(o).val();
        if(type==0){
            $("[name=dates]").css("display","inline").removeAttr("disabled");
            $("[name=dates1]").css("display","none").attr("disabled","disabled");
            $("[name=dates2]").css("display","none").attr("disabled","disabled");
        }else{
            $("[name=dates1]").css("display","inline").removeAttr("disabled");
            $("[name=dates2]").css("display","inline").removeAttr("disabled");
            $("[name=dates]").css("display","none").attr("disabled","disabled");
        }
    }


</script>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 工资条管理 <span class="c-gray en">&gt;</span> 工资条列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <form action="${pageContext.request.contextPath}/salary/selectall1" method="post">
            <div class="text-c">
             <span class="btn-upload form-group">
            <select class="input-text upload-url" size="1"  style="width:150px" name="id" onchange="changersearch(this)">
                <option value="0" >日期查询</option>
                <option value="1" >日期区间查询</option>
            </select>
            </span>
            <input type="text" placeholder="请输入年月 例:2022/8" name="dates" value="${search.dates}" class="input-text upload-url" style="width:200px">
            <span class="btn-upload form-group">
                <input type="text" placeholder="下限" name="dates1" value="${search.dates1}" class="input-text upload-url" style="width:200px" >
                 <input type="text" placeholder="上限" name="dates2" value="${search.dates2}" class="input-text upload-url" style="width:200px">

            </span>

             <%--   <input type="text" class="input-text" style="width:200px" placeholder="请输入年月 例:2022/8"  name="dates" >--%>
                <button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont" >&#xe665;</i> 搜工资</button>
            </div>
        </form>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-sort">
            <thead>
            <tr class="text-c">

                <th width="50">职工号</th>
                <th width="50">职工名</th>
                <th width="50">年月</th>
                <th width="50">基本工资</th>
                <th width="50">课时费</th>
                <th width="50">基础绩效</th>
                <th width="50">工龄工资</th>
                <th width="50">电话补助</th>
                <th width="50">交通补助</th>
                <th width="50">加班补助</th>
                <th width="50">劳动保险</th>
                <th width="50">失业保险</th>
                <th width="50">医疗保险</th>
                <th width="50">个人所得税</th>
                <th width="50">扣公积金</th>
                <th width="50">应发合计</th>
                <th width="50">扣款合计</th>
                <th width="50">实发工资</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${salaryinfo.list}" var="h">
            <tr class="text-c">

                <td>${h.username}</td>
                <td>${h.staffname}</td>
                <td>${h.dates}</td>
                <td>${h.base_wage}</td>
                <td>${h.class_fee}</td>
                <td>${h.base_performance}</td>
                <td>${h.age_pay}</td>
                <td>${h.phone_subsidy}</td>
                <td>${h.traffic_subsidy}</td>
                <td>${h.overtime_subsidy}</td>
                <td>${h.labour_insurance}</td>
                <td>${h.unemployment_insurance}</td>
                <td>${h.medical_insurance}</td>
                <td>${h.income_tax}</td>
                <td>${h.accumulation_fund}</td>
                <td>${h.should_wage}</td>
                <td>${h.deduct_wage}</td>
                <td>${h.real_wage}</td>

               </tr>
            </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-primary upload-btn" href="${pageContext.request.contextPath}/house/selectall?pageNo=1">首页</a>
        <a class="btn btn-primary upload-btn" href="${pageContext.request.contextPath}/house/selectall?pageNo=${requestScope.houseinfo.prePage}">上一页</a>
        <a class="btn btn-primary upload-btn" href="${pageContext.request.contextPath}/house/selectall?pageNo=${requestScope.houseinfo.nextPage}">下一页</a>
        <a class="btn btn-primary upload-btn" href="${pageContext.request.contextPath}/house/selectall?pageNo=${requestScope.houseinfo.pages}">末页</a>
    </div>
<%--    <button type="button" class="btn btn-success" id="" name="" onClick="location.href='savehouse'"><i class="Hui-iconfont">&#xe600;</i> 添加</button>--%>
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
