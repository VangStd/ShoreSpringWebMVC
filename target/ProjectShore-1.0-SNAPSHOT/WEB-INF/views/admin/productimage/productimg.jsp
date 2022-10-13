<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Row start -->
<div class="row">
    <!-- Color Open Accordion start -->
    <div class="col-lg-12">
        <div class="card">
            <div class="card-header">
                <h5 class="card-header-text">Image Product</h5>
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
                                    <th>Product Name</th>
                                    <th class="disableSort disableFilterBy">Image</th>
                                    <th class="disableSort disableFilterBy">Image</th>
                                    <th class="disableSort disableFilterBy">Image</th>
                                    <th class="disableSort disableFilterBy">Image</th>
                                    <th class="disableSort disableFilterBy">Image</th>
                                    <th class="disableFilterBy"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listImg}" var="item">
                                    <tr>
                                        <td></td>
                                        <td class="">${item.getProducts().getProductName()}</td>
                                        <td><img src="${item.getImage1()}" width="150" alt="" class="img-thumbnail disableFilterBy"/></td>
                                        <td><img src="${item.getImage2()}" width="150" alt="" class="img-thumbnail disableFilterBy"/></td>
                                        <td><img src="${item.getImage3()}" width="150" alt="" class="img-thumbnail disableFilterBy"/></td>
                                        <td><img src="${item.getImage4()}" width="150" alt="" class="img-thumbnail disableFilterBy"/></td>
                                        <td><img src="${item.getImage5()}" width="150" alt="" class="img-thumbnail disableFilterBy"/></td>
                                        <td><button class="btn btn-danger"><a href="/ProjectShore/admin/edit-imgproduct?idPro=${item.getProducts().getProID()}">Edit</a></button></td>
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


