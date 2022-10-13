<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Row start -->
<div class="row">
    <!-- Color Open Accordion start -->
    <div class="col-lg-12">
        <div class="card">
            <div class="card-header">
                <h5 class="card-header-text">Home SaleOff</h5>
            </div>
            <div class="card-block accordion-block color-accordion-block">
                <a href="/ProjectShore/admin/add-saleoffs" class="btn btn-success">New Product Sale</a>
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
                                    <th>Percent</th>
                                    <th>Image</th>
                                    <th>BeginDate</th>
                                    <th>EndDate</th>
                                    <th>Status</th>
                                    <th class="disableFilterBy"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listSale}" var="item">
                                    <tr>
                                        <td></td>
                                        <td>${item.getProducts().getProductName()}</td>
                                        <td>${item.getPercents()}%</td>
                                        <td><img src="${item.getProducts().getImage()}" class="img-thumbnail" width="150" /></td>
                                        <td>${item.getBeginDate()}</td>
                                        <td>${item.getEndDate()}</td>
                                        <td>${item.getStatus()}</td>
                                        <c:set var="status" value="Active"/>
                                        <c:choose>
                                            <c:when test="${item.getStatus() eq status}">
                                                <td class=""><a href="/ProjectShore/admin/edit-saleoff?Id=${item.getID()}" class="btn btn-danger">Edit</a></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td class=""></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${item.getStatus() eq status}">
                                                <td class=""><button type="button"  data-id="${item.getID()}" id="deleteSale" class="csssale btn btn-warning">Deactive</button></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td class=""><button type="button"  data-id="${item.getID()}" id="deleteSale" class="csssale btn btn-danger">Delete</button></td>
                                                    </c:otherwise>
                                                </c:choose>
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

