<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="/ProjectShore/admin/edit-customer" method="post" modelAttribute="customer">
    <form:hidden path="CusID" />
    <form:hidden path="Avatar" />
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">FullName</label>
        <form:input path="FullName"  cssClass="form-control" readonly="true" />
        <form:errors path="FullName"  />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Phone</label>
        <form:input path="Phone"  cssClass="form-control" readonly="true" />
        <form:errors path="Phone"  />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Address</label>
        <form:input path="Address"  cssClass="form-control" readonly="true"  />
        <form:errors path="Address"  />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Email</label>
        <form:input path="Email"  cssClass="form-control" type="email"  />
        <form:errors path="Email" cssClass="errHibernate" />
    </div>
    <%
        if (request.getAttribute("errEditCus1") != null) { %>
    <div class="alert alert-danger form-control">
        <strong>!</strong> Email Exist
    </div>
    <% }
    %>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">UserName</label>
        <form:input path="UserName"  cssClass="form-control" readonly="true"  />
        <form:errors path="UserName" cssClass="errorHibernate" />
    </div>
    <form:hidden path="Gender" />
    <form:hidden path="PassWord" />
    <button type="submit" class="btn btn-primary">Update</button>
</form:form>