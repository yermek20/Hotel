<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="templates/head.jsp"%>
    </head>
    <body>
        <div class="container mt-5">
            <a href="/" class="btn btn-success">HOME</a>
            <br>
            <br>
            <div class="row mb-3">
                <div class="col-sm-12">

                    <div class="jumbotron">
                        <h4>
                            ${hotel.name}
                        </h4>
                        <p class="lead">
                            ${hotel.country}
                        </p>
                        <b>
                            ${hotel.stars} stars
                        </b>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
