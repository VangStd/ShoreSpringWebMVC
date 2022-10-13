<%-- 
    Document   : edit_saleoff
    Created on : Aug 23, 2022, 10:15:20 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form action="/ProjectShore/admin/edit-saleoff" method="post" modelAttribute="sale" >
    <form:hidden path="ID" />
    <form:hidden path="Status" />
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Products</label>
        <input type="text" value="${sale.getProducts().getProductName()}" class="form-control" readonly="true" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Percents %</label>
        <form:input path="Percents" cssClass="form-control" type="number" />
        <form:errors path="Percents" cssClass="errHibernate" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Begin Date</label>
        <input type="date" name="start" class="form-control" value="${sale.getBeginDate()}" readonly="true" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">End Date</label>
        <input type="date" name="end"  class="form-control" value="${sale.getEndDate()}" />
    </div>
    <c:choose>
        <c:when test="${empty errDatebegin2}">

        </c:when>
        <c:otherwise>
            <div class="alert alert-danger form-control">
                <strong>!</strong> DateEnd must greater today 
            </div>
        </c:otherwise>
    </c:choose>
    <input type="submit" value="Update"/>
</form:form>