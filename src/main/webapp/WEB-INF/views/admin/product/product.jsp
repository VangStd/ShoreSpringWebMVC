<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Row start -->
<div class="row">
    <!-- Color Open Accordion start -->
    <div class="col-lg-12">
        <div class="card">
            <div class="card-header">
                <h5 class="card-header-text">Home Product</h5>
            </div>
            <div class="card-block accordion-block color-accordion-block">
                <a href="/ProjectShore/admin/add-product" class="btn btn-success">New Product</a>
                <br>
                <br>
                <div class="color-accordion" id="color-accordion">
                    <!-- Table start -->
                    <div class="table-responsive">
                        <table class="tablemanager table table-striped">
                            <thead>
                                <tr>
                                    <th class="disableSort"></th>
                                    <th>Product Name</th>
                                    <th>SupplierID</th>
                                    <th>CategoriID</th>
                                    <th>UnitPrice</th>
                                    <th>UnitInStock</th>
                                    <th>UnitInOrder</th>
                                    <th class="disableFilterBy">Image</th>
                                    <th>StatusSale</th>
                                    <th class="disableFilterBy"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listPro}" var="item">
                                    <tr>
                                        <td></td>
                                        <td class="" id="">${item.getProductName()}</td>
                                        <td class="">${item.getSupplier().getCompanyName()}</td>
                                        <td class="">${item.getCategorie().getCateName()}</td>
                                        <td class="">${item.getUnitPrice()}</td>
                                        <td class="">${item.getUnitInStock()}</td>
                                        <td class="">${item.getUnitInOrder()}</td>
                                        <td><img src="${item.getImage()}" width="150" alt="" class="img-thumbnail"/></td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${item.getStatusSale() == 0}">
                                                    NotSale
                                                </c:when>
                                                <c:otherwise>
                                                    Sale
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class=""><a href="/ProjectShore/admin/edit-product?idPro=${item.getProID()}" class="btn btn-danger">Edit</a></td>
                                        <td class=""><button type="button"  data-id="${item.getProID()}" id="deletePro" class="csspro btn btn-danger">Delete</button></td>
                                    </tr>
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

