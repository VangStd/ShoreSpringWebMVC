<%-- 
    Document   : sigleorder
    Created on : Sep 6, 2022, 1:50:41 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form:form modelAttribute="order" method="post" action="/ProjectShore/sigle-order-product1">

    <div class="row" style="padding-top: 100px;padding-bottom: 100px;">
        <div class="col-lg-6">
            <div class="mb-3 mt-3">
                <label for="email" class="form-label">FullName:</label>
                <input type="text" class="form-control" id="email" placeholder="Enter" readonly value="${cus.getFullName()}" name="email">
            </div>
            <div class="mb-3 mt-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" readonly value="${cus.getEmail()}" name="email">
            </div>
            <div class="mb-3 mt-3">
                <label for="email" class="form-label">PhoneShip</label>
                <form:input path="PhoneShip" cssClass="form-control" type="number" required="required" />
            </div>
            <div class="mb-3 mt-3">
                <label for="email" class="form-label">AddressShip</label>
                <form:input path="AddressShip" cssClass="form-control" />
            </div>
            <div class="mb-3 mt-3">
                <label for="email" class="form-label">Note</label>
                <form:textarea path="Note" cssClass="form-control" />
            </div>
        </div>
        <div class="col-lg-6">
            <ul>


                <c:forEach items="${shopcart}" var="item">
                    <input type="hidden" value="${item.getCustomers().getCusID()}" name="cusid" />
                    <input type="hidden" value="${item.getProductss().getProID()}" name="proid" />
                    <input type="hidden" value="${item.getQuantity()}" name="quantity" />
                    <table class="table table-borderless">
                        <tr>
                            <td><label for="email" class="form-label">Product Name</label></td>
                            <td><h6 class="text-left">${item.getProductss().getProductName()}</h6></td>
                        </tr>
                        <tr>
                            <td><label for="email" class="form-label">Image</label></td>
                            <td><img src="${item.getProductss().getImage()}" alt="alt" width="100" height="100" class="img-thumbnail"/></td>
                        </tr>
                        <tr>
                            <td><label for="email" class="form-label">Price</label></td>
                            <td>
                                <c:choose>
                                    <c:when test="${item.getProductss().getStatusSale()>0}">
                                        <h6 class="text-left">${Math.ceil(item.getProductss().getUnitPrice() - ( item.getProductss().getUnitPrice()* item.getProductss().getSaleOff().get(0).getPercents() /100 ) )}$</h6>
                                    </c:when>
                                    <c:otherwise>
                                        <h6 class="text-left">${item.getProductss().getUnitPrice()}$</h6>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Quantity</label></td>
                            <td><h6>${item.getQuantity()}</h6></td>
                        </tr>
                        <tr>
                            <td><label>TotalPrice</label></td>
                            <td>
                                <c:choose>
                                    <c:when test="${item.getProductss().getStatusSale()>0}">
                                        <h6 class="text-left">${item.getQuantity()*Math.ceil(item.getProductss().getUnitPrice() - ( item.getProductss().getUnitPrice()* item.getProductss().getSaleOff().get(0).getPercents() /100 ) )}$</h6>
                                    </c:when>
                                    <c:otherwise>
                                        <h6 class="text-left">${item.getQuantity()*item.getProductss().getUnitPrice()}$</h6>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </table>
                    <hr>
                </c:forEach>
            </ul>
        </div>
    </div>
            <div class="text-center" style="padding-bottom: 20px;">
        <button type="submit" class="btn btn-primary">Order</button>
    </div>
</form:form>


