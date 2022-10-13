<%-- 
    Document   : edit_categorie
    Created on : Aug 9, 2022, 9:54:24 AM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form action="/ProjectShore/admin/edit-categorie" method="post" modelAttribute="categorie">
    <form:hidden path="ID" />
    <input type="hidden" name="cateName" value="${categorie.getCateName()}" />
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Categorie Name</label>
        <form:input path="CateName" cssClass="form-control" value="${cateName}" />
        <form:errors path="CateName" cssClass="errHibernate" />
    </div>
    <%
        if (request.getAttribute("editCate1") != null) { %>
    <div class="alert alert-danger form-control">
        <strong>!</strong> CategorieName Exist
    </div>
    <% }
    %>
    <div class="mb-3">
        <label for="pwd" class="form-label">Description</label>
        <form:input path="Description" cssClass="form-control" />
        <form:errors path="Description" cssClass="errHibernate" />
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form:form>
