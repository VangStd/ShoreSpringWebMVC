<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- Row start -->
<div class="row tabcartuser" id="" >
    <!-- Color Open Accordion start -->
    <div class="col-lg-12">
        <div class="card">
            <div class="text-center">
                <h3 class=" h3cartuser">My Shopping Cart</h3>
            </div>
            <c:if test="${cart.size()<=0}">
                <h4>There are no products in the cart  <a href="shop">Shopping Now</a> </h4>
            </c:if>
            <c:if test="${cart.size()>0}">
                <c:if test="${applicationScope['errCheck1']!=null}">
                    <script>
                        alert('Please Choose Product Order ! ');
                    </script>
                    <c:remove  var="errCheck1"/>
                </c:if>
                <form:form action="/ProjectShore/sigle-order-product" method="POST">
                    <div class="card-block accordion-block color-accordion-block">
                        <div class="color-accordion" id="color-accordion">
                            <!-- Table start -->
                            <div class="table-responsive">
                                <table class="tablemanager table table-hover table-borderless" >
                                    <thead>
                                        <tr>
                                            <th class="disableSort"></th>
                                            <th>ProductName</th>
                                            <th class="disableFilterBy">Image</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Dates</th>
                                            <th class="disableFilterBy"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <hr>
                                    <c:forEach var="item" items="${cart}">
                                        <tr>  
                                            <td><input id="inputcheckboxshopcart" type="checkbox" value="${item.getProductss().getProID()}" name="orderPro" /></td>
                                            <td>${item.getProductss().getProductName()}</td>
                                            <td ><img src="${item.getProductss().getImage()}" width="100" class="img-thumbnail" /></td>
                                                <c:choose>
                                                    <c:when test="${item.getProductss().getStatusSale() == 1}">
                                                    <td>${Math.ceil(item.getProductss().getUnitPrice() - (item.getProductss().getSaleOff().get(0).getPercents()))}</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>${item.getProductss().getUnitPrice()}$  </td>  
                                                </c:otherwise>
                                            </c:choose>

                                            <td>
                                                <input type="number" min="1" max="${item.getProductss().getUnitInStock()}"  value="${item.getQuantity()}" style="width: 50px;text-align: center;"  class="Quantity" data-id="${item.getProductss().getProID()}" id="quantity" />
                                            <td>${item.getDates()}</td>
                                            <td><a href="/ProjectShore/delete-shopcart?Id=${item.getID()}"><i class="fa fa-trash"></i></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <td><input type="submit" value="Order" class="btn btn-success"  /></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>    
                                            <td></td>
                                            <td></td>
                                            <td><button type="button" class="updateCartStatus btn btn-danger">Delete All</button></td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </div>
                </form:form>
            </c:if>
        </div>
    </div>
</div>

<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/admin/assets/js/tableManager.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/admin/assets/js/table.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/js/button.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/admin/assets/js/delete.js"/>"></script>
<script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"/>"></script>

<!-- Row end -->


