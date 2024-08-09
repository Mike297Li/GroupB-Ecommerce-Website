<%--
  Created by IntelliJ IDEA.
  User: lifuchun
  Date: 2024-07-17
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="templates/head.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <style>
        main {
            max-width: 600px;
            margin: 0 auto;
        }
        h1 {
            font-size: 2em;
            margin-bottom: 10px;
        }
        form {
            max-width: 600px;
            margin: 0 auto;
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #333;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #555;
        }
    </style>
</head>

<body>
<div class="site-wrap">
    <jsp:include page="templates/header.jsp"/>

    <div class="bg-light py-3">
        <div class="container">
            <div class="row">
                <div class="col-md-12 mb-0"><a href="${pageContext.request.contextPath}/home">Home</a> <span class="mx-2 mb-0">/</span> <strong
                        class="text-black">Contact Us</strong></div>
            </div>
        </div>
    </div>

    <main>
        <h1>Contact Us</h1>
        <p>Have a question or feedback? Send us a message!</p>
        <form action="submitContact" method="post">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email</label>
            <input type="text" id="email" name="email" required>

            <label for="message">Message</label>
            <textarea id="message" name="message" rows="4" required></textarea>

            <input type="submit" value="Submit">
        </form>
        <!-- Display success message if available -->
        <c:if test="${not empty message}">
            <p style="color: green;">${message}</p>
        </c:if>
    </main>
    <jsp:include page="templates/footer.jsp"/>
</div>
</body>
</html>
