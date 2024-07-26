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
    <meta charset="UTF-8">
    <title>Contact Us - Shoppers</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
        }
        header {
            background-color: #333;
            color: white;
            padding: 10px 0;
            text-align: center;
        }
        main {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
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
<header>
    <h1>Shoppers</h1>
    <nav>
        <a href="index.jsp" style="color: white; margin: 0 10px;">Home</a>
        <a href="about.jsp" style="color: white; margin: 0 10px;">About</a>
    </nav>
</header>

<div class="container">
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
</div>

<footer>
    <p>&copy; 2024 Shoppers. All rights reserved.</p>
</footer>
</body>
</html>
