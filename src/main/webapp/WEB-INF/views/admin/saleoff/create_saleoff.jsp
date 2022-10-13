<%-- 
    Document   : create_saleoff
    Created on : Aug 23, 2022, 7:25:24 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form action="/ProjectShore/admin/save-add-saleoffs" method="post" modelAttribute="saleoff" >
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">SupplierID</label>
        <select name="ProID" class="form-control">
            <c:forEach var="item" items="${listPro}">
                <option value="${item.getProID()}">${item.getProductName()}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Percents %</label>
        <form:input path="Percents" cssClass="form-control" type="number" />
        <form:errors path="Percents" cssClass="errHibernate" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Begin Date</label>
        <input type="date" name="start" class="form-control" />
    </div>
    <c:choose>
        <c:when test="${empty errDatebegin1}">

        </c:when>
        <c:otherwise>
            <div class="alert alert-danger form-control">
                <strong>!</strong> DateBegin Not Valid
            </div>
        </c:otherwise>
    </c:choose>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">End Date</label>
        <input type="date" name="end"  class="form-control" />
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
    <input type="submit" value="Create"/>
</form:form>
