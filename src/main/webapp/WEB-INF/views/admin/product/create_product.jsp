<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form action="/ProjectShore/admin/add-product" method="POST" modelAttribute="product" enctype="multipart/form-data" >
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Product Name</label>
        <form:input path="ProductName" cssClass="form-control" />
        <form:errors path="ProductName" cssClass="errHibernate" />
    </div>
    <c:if test="${errAddPro1!=null}">
        <div class="alert alert-danger form-control">
            <strong>!</strong> ProductName Exist
        </div>
    </c:if>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">SupplierID</label>
        <select name="SupID" class="form-control">
            <c:forEach var="item" items="${listSup}">
                <option value="${item.getID()}">${item.getCompanyName()}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">CategorieID</label>
        <select name="CateID" class="form-control">
            <c:forEach var="item" items="${listCate}">
                <option value="${item.getID()}">${item.getCateName()}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Unit Price</label>
        <form:input path="UnitPrice" cssClass="form-control" />
        <form:errors path="UnitPrice" cssClass="errHibernate" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Quantity</label>
        <form:input path="UnitInStock" cssClass="form-control" />
        <form:errors path="UnitInStock" cssClass="errHibernate" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Image</label>
        <input type="file" name="FileUpload" class="form-control" required />
    </div>
    <input type="submit" class="btn btn-primary" value="Add"/>
</form:form>
