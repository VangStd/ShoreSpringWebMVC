<%-- 
    Document   : create_supplier
    Created on : Aug 5, 2022, 9:15:36 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="/ProjectShore/admin/add-supplier" method="post" modelAttribute="supplier">
    <div class="mb-3 mt-3">
        <label>Company Name</label>
        <form:input path="CompanyName" cssClass="form-control"  />
        <form:errors path="CompanyName" cssClass="errHibernate" />
        <%
            if (request.getAttribute("errSup1") != null) { %>
        <div class="alert alert-danger form-control">
            <strong>!</strong> CompanyName Exist
        </div>
        <% }
        %>
    </div>

    <div class="mb-3">
        <label>Address</label>
        <form:input path="Address" cssClass="form-control"  />
        <form:errors path="Address" cssClass="errHibernate" />
    </div>
    <div class="mb-3">
        <label>City</label>
        <form:input path="City" cssClass="form-control"  />
        <form:errors path="City" cssClass="errHibernate" />
    </div>
    <div class="mb-3">
        <label>Country</label>
        <form:input path="Country" cssClass="form-control"  />
        <form:errors path="Country" cssClass="errHibernate" />
    </div>
    <div class="mb-3">
        <label>Phone</label>
        <form:input path="Phone" cssClass="form-control"  />
        <form:errors path="Phone" cssClass="errHibernate" />
    </div>
    <div class="mb-3">
        <label>Home Page</label>
        <form:input path="HomePage" cssClass="form-control"  />
        <form:errors path="HomePage" cssClass="errHibernate" />
    </div>
    <button type="submit" class="btn btn-primary">Create</button>
</form:form>


