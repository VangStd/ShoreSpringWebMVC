<%-- 
    Document   : myorder
    Created on : Sep 17, 2022, 9:19:02 AM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Table start -->
<div style="padding-top: 50px;padding-bottom: 50px;">
    <c:choose>
        <c:when test="${listOdd.size()>0}">
            <div class="table-responsive">
                <table class="tablemanager table table-hover table-borderless" >
                    <thead>
                        <tr>
                            <th class="disableSort"></th>
                            <th>ProductName</th>
                            <th>OrderDate</th>
                            <th>Image</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Discount</th>
                            <th>TotalPrice</th>
                            <th class="disableFilterBy"></th>
                        </tr>
                    </thead>
                    <tbody>
                    <hr>
                    <c:forEach var="item" items="${listOdd}">
                        <tr>  
                            <td></td>
                            <td>${item.getProductod().getProductName()}</td>
                            <td>${item.getOrders().getOrderDate()}</td>
                            <td> <img src="${item.getProductod().getImage()}" width="100" height="100" class="img-fluid"></td>
                            <td>${item.getUnitPrice()}</td>
                            <td>${item.getQuantity()}</td>
                            <td>${item.getDiscount()}</td>
                            <td>${item.getTotalPrice()}</td>
                            <td></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>    
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </c:when>
        <c:otherwise>
            <h4>Oh no ! You don't have any orders <a href="shop">Go Shopping Now</a></h4>
        </c:otherwise>
    </c:choose>

</div>
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>"></script>
<!-- <script type="text/javascript" src="./js/jquery-1.12.3.min.js"></script> -->
<script type="text/javascript" src="<c:url value="/assets/admin/assets/js/tableManager.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/admin/assets/js/table.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/js/button.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/admin/assets/js/delete.js"/>"></script>
<script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"/>"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


