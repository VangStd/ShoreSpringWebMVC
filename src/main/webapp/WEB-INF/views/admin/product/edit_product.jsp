<%-- 
    Document   : edit_product
    Created on : Aug 11, 2022, 9:39:31 AM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form:form action="/ProjectShore/admin/edit-product" method="post" modelAttribute="product" enctype="multipart/form-data">
    <form:hidden path="ProID" />
    <form:hidden path="Image" />
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">ProductName</label>
        <form:input path="ProductName" cssClass="form-control" readonly="true" />
        <form:errors path="ProductName" cssClass="errHibernate" />
    </div>

    <div class="mb-3 mt-3">
        <label for="email" class="form-label">SupplierID</label>
        <select name="SupID" class="form-control">
            <c:choose>
                <c:when test="${empty sup}">
                    <c:forEach var="item" items="${listSup}">
                        <option value="${item.getID()}">${item.getCompanyName()}</option>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <option value="${sup.getID()}">${sup.getCompanyName()}</option>
                    <c:forEach var="item" items="${listSup}">
                        <option value="${item.getID()}">${item.getCompanyName()}</option>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </select>
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">CategorieID</label>
        <select name="CateID" class="form-control">
            <c:choose>
                <c:when test="${empty cate}">
                    <c:forEach var="item" items="${listCate}">
                        <option value="${item.getID()}">${item.getCateName()}</option>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <option value="${cate.getID()}">${cate.getCateName()}</option>
                    <c:forEach var="item" items="${listCate}">
                        <option value="${item.getID()}">${item.getCateName()}</option>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
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
        <img src="${product.getImage()}" width="150" alt="" class="img-thumbnail"/>
        <input type="file" name="FileUpload" class="form-control" />
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
</form:form>

