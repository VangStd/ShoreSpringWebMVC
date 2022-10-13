<%-- 
    Document   : shop
    Created on : Jul 27, 2022, 5:02:53 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" href="<c:url value="/assets/css/dienratdemp.css" />"/>
<!-- Modal -->
<div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="w-100 pt-1 mb-5 text-right">
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <form action="" method="get" class="modal-content modal-body border-0 p-0">
            <div class="input-group mb-2">
                <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                <button type="submit" class="input-group-text bg-success text-light">
                    <i class="fa fa-fw fa-search text-white"></i>
                </button>
            </div>
        </form>
    </div>
</div>



<!-- Start Content -->
<div class="container py-5">
    <div class="row">

        <div class="col-lg-3">
            <h1 class="pb-4"><b>Shoping</b></h1>
            <ul class="list-unstyled templatemo-accordion">
                <li class="pb-3">
                    <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="#">
                        Categorie Sale <c:if test="${listSale.size() >0 }">
                            <p style="color: red;" class="text-left">*</p>
                        </c:if>
                        <i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
                    </a>
                    <ul id="collapseTwo" class="collapse list-unstyled pl-3">
                        <c:forEach items="${listSale}" var="item">
                            <li><a class="text-decoration-none" href="#">${item.getProducts().getCategorie().getCateName()}</a></li>
                            </c:forEach>
                    </ul>
                </li>
                <li class="pb-3">
                    <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="#">
                        My Categories
                        <i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
                    </a>
                    <ul id="collapseThree" class="collapse list-unstyled pl-3">
                        <c:forEach items="${listCate}" var="item">
                            <li><a class="text-decoration-none text-success">${item.getCateName()}</a></li>
                            </c:forEach>
                    </ul>
                </li>
                <li class="pd-3">

                </li>
            </ul>
        </div>
        <div class="col-lg-9">
            <div class="w-100 form-control">
                <form:form action="search-product" method="post">
                    <input type="text" name="nameprod"  placeholder="Enter Productname ..." style="width: 80%;" />
                    <button type="submit" class="btn-success"> <i class="fa fa-fw fa-search"></i></button>
                    </form:form>
            </div>
            <c:if test="${listProS.size()>0}">
                <div class="row" style="padding-top: 50px;padding-bottom: 50px;">
                    <h4>Result Search</h4>
                    <c:forEach items="${listProS}" var="item">
                        <div class="col-md-4" style="height: 100%;margin-bottom: 20px;">
                            <div class="card mb-4 product-wap rounded-0">
                                <div class="card rounded-0">
                                    <div class="w-100 p-3 " style="height: 350px;">
                                        <img class="card-img rounded-0 img-fluid" style="height: 80%" src="${item.getImage()}"> 
                                    </div>
                                    <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                        <ul class="list-unstyled">
                                            <li><a class="btn btn-success text-white" href="shop-single.html"><i class="far fa-heart"></i></a></li>
                                            <li><a class="btn btn-success text-white mt-2" href="/ProjectShore/shop-detail?idPro=${item.getProID()}"><i class="far fa-eye"></i></a></li>
                                            <li> <button type="button" class="addcart btn btn-success text-white mt-2 " id="addcart" data-id="${item.getProID()}"><i class="fas fa-cart-plus"></i></button></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <a href="/ProjectShore/shop-detail?idPro=${item.getProID()}" class="text-decoration-none"> <h6 class="text-center">${item.getProductName()}</h6></a>
                                    <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                        <li class="pt-2">
                                            <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                            <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                            <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                            <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                            <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                        </li>
                                    </ul>
                                    <ul class="list-unstyled d-flex justify-content-center mb-1">
                                        <li>
                                            <i class="text-warning fa fa-star"></i>
                                            <i class="text-warning fa fa-star"></i>
                                            <i class="text-warning fa fa-star"></i>
                                            <i class="text-muted fa fa-star"></i>
                                            <i class="text-muted fa fa-star"></i>
                                        </li>
                                    </ul>
                                    <c:choose>
                                        <c:when test="${item.getStatusSale()>0}">
                                            <p style="color: red;" class="text-center mb-0">$${Math.ceil( (item.getUnitPrice() - (item.getUnitPrice() * item.getSaleOff().get(0).getPercents() )/100 ) )}</p>
                                        </c:when>
                                        <c:otherwise>
                                            <p  class="text-center mb-0">$${item.getUnitPrice()}</p>
                                        </c:otherwise>
                                    </c:choose>

                                </div>
                            </div>
                        </div>    
                    </c:forEach>
                </div>
            </c:if>
            <div class="row" style="padding-top: 50px;padding-bottom: 50px;">
                <c:forEach items="${listSale}" var="item">
                    <div class="col-md-4 ${item.getProducts().getCategorie().getCateName()}">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <style>
                                    .testimgpo {
                                        color: white;
                                        background-color: red;
                                        position: absolute;
                                        top: 10px;
                                        border: solid 1px;
                                        border-color: red;
                                        border-radius: 10px;
                                    }
                                    .testimgpo1 {
                                        color: white;
                                        background-color: red;
                                        position: absolute;
                                        top: 70px;
                                        border: solid 1px;
                                        border-color: red;
                                        border-radius: 10px;
                                        margin-left: 130px;
                                    }
                                </style>
                                <div class="w-100 p-3 " style="height: 350px;">
                                    <h3 class="testimgpo">-${item.getPercents()}%</h3>
                                    <h5 class="testimgpo1">to ${item.getEndDate()}</h5>
                                    <img class="rounded-0 img-fluid img-thumbnail mx-auto d-block"  src="${item.getProducts().getImage()}">
                                </div>

                                <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                    <ul class="list-unstyled">
                                        <li><a class="btn btn-success text-white" style="background-color: red;" href="" ><i class="far fa-heart"></i></a></li>
                                        <li><a class="btn btn-success text-white mt-2" href="/ProjectShore/shop-detail?idPro=${item.getProducts().getProID()}"><i class="far fa-eye"></i></a></li>
                                        <li> <button type="button" class="addcart btn btn-success text-white mt-2 " id="addcart" data-id="${item.getProducts().getProID()}"><i class="fas fa-cart-plus"></i></button></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="card-body">
                                <a href="/ProjectShore/shop-detail?idPro=${item.getProducts().getProID()}" class="h3 text-decoration-none">${item.getProducts().getProductName()}</a>
                                <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                    <li class="pt-2">
                                        <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                    </li>
                                </ul>
                                <ul class="list-unstyled d-flex justify-content-center mb-1">
                                    <li>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                    </li>
                                </ul>
                                <p class="text-center mb-0"><del style="color: red;">$${item.getProducts().getUnitPrice()}</del> - $${Math.ceil((item.getProducts().getUnitPrice()-(item.getProducts().getUnitPrice()*item.getPercents()/100)))}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            
            <hr>
            <div class="row">
                <h1 class="texth1row"></h1>
                <c:forEach items="${listPro}" var="item">
                    <div class="col-md-4" style="height: 100%;margin-bottom: 20px;">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <div class="w-100 p-3 " style="height: 350px;">
                                    <img class="card-img rounded-0 img-fluid" style="height: 80%" src="${item.getImage()}"> 
                                </div>
                                <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                    <ul class="list-unstyled">
                                        <c:if test="${sessionScope['userSession']!=null}">
                                            <c:if test="${listLovePro.size() > 0}">
                                                <c:set value="0" var="begin" />
                                                <c:forEach items="${listLovePro}" begin="${begin}" var="item1" >
                                                    <c:if test="${item1.getProduct().getProID()==item.getProID()}">
                                                        <li>
                                                            <button type="button" class="btn btn-success text-white loveproduct" data-id="${item.getProID()}"><i class="fa fa-heart-broken" ></i></button>
                                                        </li>
                                                        <c:set value="${listLovePro.size()}" var="begin" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${begin==0}">
                                                    <li>
                                                        <button type="button" class="btn btn-success text-white loveproduct" data-id="${item.getProID()}"><i class="far fa-heart" ></i></button>
                                                    </li>
                                                </c:if>  
                                            </c:if>
                                            <c:if test="${listLovePro.size() == 0}">
                                                <li>
                                                    <button type="button" class="btn btn-success text-white loveproduct" data-id="${item.getProID()}"><i class="far fa-heart" ></i></button>
                                                </li>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${sessionScope['userSession']==null}">
                                            <li>
                                                <button type="button" class="btn btn-success text-white loveproduct" data-id="${item.getProID()}"><i class="far fa-heart" ></i></button>
                                            </li>
                                        </c:if>

                                        <li><a class="btn btn-success text-white mt-2" href="/ProjectShore/shop-detail?idPro=${item.getProID()}"><i class="far fa-eye"></i></a></li>
                                        <li> <button type="button" class="addcart btn btn-success text-white mt-2 " id="addcart" data-id="${item.getProID()}"><i class="fas fa-cart-plus"></i></button></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="card-body">
                                <a href="/ProjectShore/shop-detail?idPro=${item.getProID()}" class="text-decoration-none"> <h6 class="text-center">${item.getProductName()}</h6></a>
                                <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                    <li class="pt-2">
                                        <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                    </li>
                                </ul>
                                <ul class="list-unstyled d-flex justify-content-center mb-1">
                                    <li>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                    </li>
                                </ul>
                                <p class="text-center mb-0">$${item.getUnitPrice()}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div div="row">
            <ul class="pagination pagination-lg justify-content-end">
                <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 pagindex" data-id="1" id="pagindex" href="/ProjectShore/shop?pageIndex=1"><<</a>
                <c:forEach var="page" begin="1" end="${count}">
                    <li class="page-item ">
                        <c:choose>
                            <c:when test="${param.pageIndex== page}">
                                <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 pagindex active" data-id="${page}" id="pagindex" href="/ProjectShore/shop?pageIndex=${page}">${page}</a>
                            </c:when>
                            <c:otherwise>
                                <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 pagindex" data-id="${page}" id="pagindex" href="/ProjectShore/shop?pageIndex=${page}">${page}</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </c:forEach>
                <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 pagindex " data-id="${count}" id="pagindex" href="/ProjectShore/shop?pageIndex=${count}">>></a>
            </ul>
        </div>
    </div>

</div>
</div>
<!-- End Content -->
<!-- Start Brands -->
<section class="bg-light py-5">
    <div class="container my-4">
        <div class="row text-center py-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">Our Brands</h1>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    Lorem ipsum dolor sit amet.
                </p>
            </div>
            <div class="col-lg-9 m-auto tempaltemo-carousel">
                <div class="row d-flex flex-row">
                    <!--Controls-->
                    <div class="col-1 align-self-center">
                        <a class="h1" href="#multi-item-example" role="button" data-bs-slide="prev">
                            <i class="text-light fas fa-chevron-left"></i>
                        </a>
                    </div>
                    <!--End Controls-->

                    <!--Carousel Wrapper-->
                    <div class="col">
                        <div class="carousel slide carousel-multi-item pt-2 pt-md-0" id="multi-item-example" data-bs-ride="carousel">
                            <!--Slides-->
                            <div class="carousel-inner product-links-wap" role="listbox">

                                <!--First slide-->
                                <div class="carousel-item active">
                                    <div class="row">
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                        </div>
                                    </div>
                                </div>
                                <!--End First slide-->

                                <!--Second slide-->
                                <div class="carousel-item">
                                    <div class="row">
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                        </div>
                                    </div>
                                </div>
                                <!--End Second slide-->

                                <!--Third slide-->
                                <div class="carousel-item">
                                    <div class="row">
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                        </div>
                                    </div>
                                </div>
                                <!--End Third slide-->

                            </div>
                            <!--End Slides-->
                        </div>
                    </div>
                    <!--End Carousel Wrapper-->

                    <!--Controls-->
                    <div class="col-1 align-self-center">
                        <a class="h1" href="#multi-item-example" role="button" data-bs-slide="next">
                            <i class="text-light fas fa-chevron-right"></i>
                        </a>
                    </div>
                    <!--End Controls-->
                </div>
            </div>
        </div>
    </div>
</section>
<!--End Brands-->
<script src="<c:url value="/assets/js/jquery-1.11.0.min.js" /> "></script>
<script src="<c:url value="/assets/js/main.js"/>"></script>
<script src="<c:url value="/assets/js/shopcart.js"/>"></script>
<script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"/>"></script>