<%--
  Created by IntelliJ IDEA.
  User: lifuchun
  Date: 2024-07-17
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About Us - Shoppers</title>
    <jsp:include page="templates/head.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
<div class="site-wrap">
    <jsp:include page="templates/header.jsp"/>

    <div class="bg-light py-3">
        <div class="container">
            <div class="row">
                <div class="col-md-12 mb-0"><a href="${pageContext.request.contextPath}/home">Home</a> <span class="mx-2 mb-0">/</span> <strong
                        class="text-black">About</strong></div>
            </div>
        </div>
    </div>
    <div>
        <div class="container" style="padding-top: 20px; padding-bottom: 20px;">
            <h1>About Us</h1>
            <br>
            <p>Welcome to Shoppers, your number one source for all things shoes, electronics, etc. We're dedicated to providing you the very best of products, with an emphasis on quality, customer service, and uniqueness.</p>
            <p>Founded in 2024 by GroupB, Shoppers has come a long way from its beginnings in  Mississauga. When GroupB first started out, their passion for eco-friendly products drove them to start their own business.</p>
            <p>We hope you enjoy our products as much as we enjoy offering them to you. If you have any questions or comments, please don't hesitate to contact us.</p>
            <br>
            <p>Sincerely,<br>GroupB</p>
        </div>
    </div>
    <jsp:include page="templates/footer.jsp"/>
</div>
</body>
</html>

