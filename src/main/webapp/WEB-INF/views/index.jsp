<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="templates/head.jsp"%>
    </head>
    <body>

        <div class="container mt-5">

            <div class="row mb-3">
                <div class="col-sm-8 offset-2">
                    <a href="/addhotel" class="btn btn-success">ADD HOTEL</a>
                    <p></p>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">City</th>
                            <th scope="col">Stars</th>
                            <th scope="col">Edit</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${hotels}" var="h">
                            <tr>
                                <th scope="row">${h.id}</th>
                                <td>${h.name}</td>
                                <td>${h.country}</td>
                                <td>${h.stars}</td>
                                <td><a href="/edithotel/${h.id}">edit</a> </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </body>
</html>
