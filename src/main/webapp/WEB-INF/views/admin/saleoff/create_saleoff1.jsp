<%-- 
    Document   : create_saleoff1
    Created on : Aug 23, 2022, 8:58:26 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form action="/ProjectShore/admin/add-saleoff" method="post" modelAttribute="saleoff">
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
        <label for="email" class="form-label">Unit Price</label>
        <form:input path="BeginDate" cssClass="form-control" type="date" />
        <form:errors path="BeginDate" cssClass="errHibernate" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Quantity</label>
        <form:input path="EndDate" cssClass="form-control" type="date" />
        <form:errors path="EndDate" cssClass="errHibernate" />
    </div>
    <input type="submit" value="Create" />
</form:form>

