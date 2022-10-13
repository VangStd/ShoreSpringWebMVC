<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Row start -->
<div class="row">
    <!-- Color Open Accordion start -->
    <div class="col-lg-12">
        <div class="card">
            <div class="card-header">
                <h5 class="card-header-text">Home Shopping Cart</h5>
            </div>
            <div class="card-block accordion-block color-accordion-block">
                <br>
                <br>
                <div class="color-accordion" id="color-accordion">
                    <!-- Table start -->
                    <div class="table-responsive">
                        <table class="tablemanager table table-striped">
                            <thead>
                                <tr>
                                    <th class="disableSort"></th>
                                    <th>Customer</th>
                                    <th>UserName</th>
                                    <th>ProductName</th>
                                    <th>Image</th>
                                    <th>QuantityInShopCart</th>
                                    <th>Dates</th>
                                    <th>Status</th>
                                    <th class="disableFilterBy"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${listShop}">
                                    <tr>
                                        <td></td>
                                        <td>${item.getCustomers().getFullName()}</td>
                                        <td>${item.getCustomers().getUserName()}</td>
                                        <td>${item.getProductss().getProductName()}</td>
                                        <td><img src="${item.getProductss().getImage()}" width="150" class="img-thumbnail" /></td>
                                        <td>${item.getQuantity()}</td>
                                        <td>${item.getDates()}</td>
                                        <td>${item.getStatus()}</td>
                                        <td>
                                            <c:set var="status" value="Active" />
                                            <c:choose>
                                                <c:when test="${item.getStatus() == status}">

                                                </c:when>
                                                <c:otherwise>
                                                <td><button type="button" data-id="${item.getID()}" class="btn btn-danger deletecartbyid">Delete</button></td>
                                                <td><button type="button" data-id="${item.getCustomers().getCusID()}" class="btn btn-warning deletecartbycusid">Delete-All</button></td>
                                            </c:otherwise>
                                        </c:choose>
                                        </td>
                                    </tr><
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Color Open Accordion ends -->
</div>
<div class="container">

</div>

<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>"></script>
<!-- <script type="text/javascript" src="./js/jquery-1.12.3.min.js"></script> -->
<script type="text/javascript" src="<c:url value="/assets/admin/assets/js/tableManager.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/admin/assets/js/table.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/admin/assets/js/delete.js"/>"></script>
<script  type="text/javascript" src="<c:url value="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.24/dist/sweetalert2.all.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"/>"></script>
<script>
    import Swal from "https://cdn.jsdelivr.net/npm/sweetalert2@11.4.24/dist/sweetalert2.all.min.js";
</script>
<!-- Row end -->

