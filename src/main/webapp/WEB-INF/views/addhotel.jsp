<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="templates/head.jsp"%>
</head>
<body>
<div class="container mt-5">
    <a href="/" class="btn btn-success">HOME PAGE</a>
    <br>
    <div class="row mb-3">
        <div class="col-sm-6 offset-3">
            <form action="/addhotel" method="post">

                <div class="form-group">
                    <label>
                        NAME:
                    </label>
                    <input type="text" class="form-control" name = "name">
                </div>
                <div class="form-group">
                    <label>
                        CITY:
                    </label>
                    <input type="text" class="form-control" name = "country">
                </div>
                <div class="form-group">
                    <label>
                        STARS:
                    </label>
                    <input type="text" class="form-control" name = "stars">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">ADD HOTEL</button>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>
