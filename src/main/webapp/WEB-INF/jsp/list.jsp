<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入jstl标签库 -->
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>秒杀列表页</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
    <!-- 页面显示部分 -->
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <h2>秒杀列表</h2>
            </div>
            <div class="panel-body">
                <table class="table table-hover" style="margin-bottom: 0px;">
                    <thead>
                        <tr>
                            <th style="text-align: center">名称</th>
                            <th style="text-align: center">库存</th>
                            <th style="text-align: center">开始时间</th>
                            <th style="text-align: center">结束时间</th>
                            <th style="text-align: center">创建时间</th>
                            <th style="text-align: center">详情页</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="sk" items="${list}">
                            <tr>
                                <td style="vertical-align: middle;text-align: center">${sk.name}</td>
                                <td style="vertical-align: middle;text-align: center">${sk.number}</td>
                                <td style="vertical-align: middle;text-align: center"><fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td style="vertical-align: middle;text-align: center"><fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td style="vertical-align: middle;text-align: center"><fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td style="vertical-align: middle;text-align: center"><a class="btn btn-info" href="/seckill/${sk.seckillId}/detail" target="_blank">详情页</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
