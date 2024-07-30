<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="templates/head.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>

<body>
<div class="site-wrap">
    <jsp:include page="templates/header.jsp"/>

    <div class="hero-section" style="background-image: url('${pageContext.request.contextPath}/static/images/hero_1.jpg');">
        <div class="container">
            <div class="row align-items-center justify-content-center text-center text-md-left">
                <div class="col-md-6">
                    <h1 class="display-4 mb-4">Finding Your Perfect Shoes</h1>
                    <p class="lead mb-4">Explore our exclusive collection of shoes with free shipping and returns.</p>
                    <a href="shop.jsp" class="btn btn-primary btn-lg">Shop Now</a>
                </div>
            </div>
        </div>
    </div>

    <div class="features-section py-5">
        <div class="container">
            <div class="row text-center">
                <div class="col-md-4 mb-4">
                    <div class="feature-box">
                        <span class="icon icon-truck"></span>
                        <h3>Free Shipping</h3>
                        <p>Enjoy free shipping on all orders with no minimum purchase required.</p>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="feature-box">
                        <span class="icon icon-refresh2"></span>
                        <h3>Free Returns</h3>
                        <p>Easy returns with a 30-day window to make sure you’re completely satisfied.</p>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="feature-box">
                        <span class="icon icon-help"></span>
                        <h3>Customer Support</h3>
                        <p>24/7 customer support to assist you with any queries or concerns.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="templates/collections-section.jsp"/>
    <jsp:include page="templates/featured-products.jsp"/>

    <div class="sale-section py-5 bg-light">
        <div class="container">
            <div class="row text-center mb-5">
                <div class="col-md-12">
                    <h2>Big Sale!</h2>
                </div>
            </div>
            <div class="row align-items-center">
                <div class="col-lg-6 mb-4 mb-lg-0">
                    <a href="#"><img src="static/images/blog_1.jpg" alt="Big Sale" class="img-fluid rounded shadow"></a>
                </div>
                <div class="col-lg-6 text-center text-lg-left">
                    <h3><a href="#">50% Off All Items</a></h3>
                    <p class="mb-4">Don't miss out on our biggest sale of the year. Save big on your favorite items now!</p>
                    <a href="shop" class="btn btn-primary btn-lg">Shop Now</a>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="templates/footer.jsp"/>
</div>

<jsp:include page="templates/scripts.jsp"/>
</body>
</html>
