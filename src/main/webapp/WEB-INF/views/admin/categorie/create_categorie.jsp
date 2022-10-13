<%-- 
    Document   : create_categorie
    Created on : Aug 8, 2022, 9:35:13 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form:form action="/ProjectShore/admin/add-categorie" method="post" modelAttribute="categorie">
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Categorie Name</label>
        <form:input path="CateName" cssClass="form-control" />
        <form:errors path="CateName" cssClass="errHibernate" />
    </div>
    <c:if test="${addCate1!=null}">
        <div class="alert alert-danger form-control">
            <strong>!</strong> CategorieName Exist
        </div>
    </c:if>
    <div class="mb-3">
        <label for="pwd" class="form-label">Description</label>
        <form:input path="Description" cssClass="form-control" />
        <form:errors path="Description" cssClass="errHibernate" />
    </div>
    <button type="submit" class="btn btn-primary">Create</button>
</form:form>