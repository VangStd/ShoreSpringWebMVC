<%-- 
    Document   : edit_supplier
    Created on : Aug 6, 2022, 10:06:53 AM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form action="/ProjectShore/admin/edit-supplier" method="post" modelAttribute="supplier">
    <form:hidden path="ID" />
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">CompanyName</label>
        <form:input path="CompanyName"  cssClass="form-control" readonly="true"/>
        <form:errors path="CompanyName" cssClass="errHibernate" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Address</label>
        <form:input path="Address"  cssClass="form-control" />
        <form:errors path="Address" cssClass="errHibernate" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">City</label>
        <form:input path="City"  cssClass="form-control" readonly="true"/>
        <form:errors path="City" cssClass="errHibernate" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Country</label>
        <form:input path="Country"  cssClass="form-control" readonly="true"/>
        <form:errors path="Country" cssClass="errHibernate" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Phone</label>
        <form:input path="Phone"  cssClass="form-control" />
        <form:errors path="Phone" cssClass="errHibernate" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">HomePage</label>
        <form:input path="HomePage"  cssClass="form-control"  />
        <form:errors path="HomePage" cssClass="errHibernate" />
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form:form>
