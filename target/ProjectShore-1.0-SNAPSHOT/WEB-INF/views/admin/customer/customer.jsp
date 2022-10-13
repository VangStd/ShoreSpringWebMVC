<%-- 
    Document   : customer
    Created on : Aug 4, 2022, 12:27:47 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Row start -->
<div class="row">
    <!-- Color Open Accordion start -->
    <div class="col-lg-12">
        <div class="card">
            <div class="card-header">
                <h5 class="card-header-text">Home Customer</h5>
            </div>
            <div class="card-block accordion-block color-accordion-block">
                <a href="/ProjectShore/admin/add-customer" class="btn btn-success">New Customer</a>
                <br>
                <br>
                <div class="color-accordion" id="color-accordion">
                    <!-- Table start -->
                    <div class="table-responsive">
                        <table class="tablemanager table table-striped">
                            <thead>
                                <tr>
                                    <th class="disableSort"></th>
                                    <th>Full Name</th>
                                    <th>Phone</th>
                                    <th>Address</th>
                                    <th>Email</th>
                                    <th>Avatar</th>
                                    <th>Gender</th>
                                    <th>UserName</th>
                                    <th class="disableFilterBy"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listCus}" var="item">
                                    <tr>
                                        <td></td>
                                        <td class="" id="">${item.getFullName()}</td>
                                        <td class="">${item.getPhone()}</td>
                                        <td class="">${item.getAddress()}</td>
                                        <td class="">${item.getEmail()}</td>
                                        <td><img src="${item.getAvatar()}" width="100" class="rounded-circle" /></td>
                                        <td class="">
                                            <c:choose>
                                                <c:when test="${item.getGender()==0}">
                                                    Male
                                                </c:when>
                                                <c:otherwise>
                                                    Female
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="">${item.getUserName()}</td>
                                        <td class=""><a href="/ProjectShore/admin/edit-customer?idCus=${item.getCusID()}" class="btn btn-danger">Edit</a></td>
                                        <td class=""><button type="button"  data-id="${item.getCusID()}" id="deleteCus" class="cssla btn btn-danger">Delete</button></td>
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
<script type="text/javascript" src="<c:url value="/assets/admin/assets/js/deleteCate.js"/>"></script>
<script  type="text/javascript" src="<c:url value="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.24/dist/sweetalert2.all.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"/>"></script>
<script>
    import Swal from "https://cdn.jsdelivr.net/npm/sweetalert2@11.4.24/dist/sweetalert2.all.min.js";
</script>
<!-- Row end -->
