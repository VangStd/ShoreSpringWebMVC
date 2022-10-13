<%-- 
    Document   : create_customer
    Created on : Aug 4, 2022, 7:13:06 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container" style="padding-top: 20px;padding-bottom: 50px;">
    <div class="row">
        <div class="">
            <div class="">
                <form:form action="/ProjectShore/admin/add-customer" method="post" modelAttribute="customer">
                    <div class="form-group">
                        <h2>Register account</h2>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupName">Full Name</label>
                        <form:input path="FullName" cssClass="form-control"  />
                        <form:errors path="FullName" cssClass="errHibernate" />
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupEmail">Email</label>
                        <form:input path="Email" cssClass="form-control" type="email"  />
                        <form:errors path="Email" cssClass="errHibernate" />
                    </div>
                    <%
                        if (request.getAttribute("errRegister3") != null) { %>
                    <div class="alert alert-danger form-control">
                        <strong>!</strong> Username Exist
                    </div>
                    <% }
                    %>
                    <div class="form-group">
                        <label class="control-label" for="signupName">Gender</label>
                        <div><form:radiobutton path="Gender" value="0" label="" />&nbsp;Male&nbsp;&nbsp;<form:radiobutton path="Gender" value="1" label=""  />&nbsp;Female</div>  
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupName">UserName</label>
                        <form:input path="UserName" cssClass="form-control"  />
                        <form:errors path="UserName" cssClass="errHibernate" />
                    </div>
                    <%
                        if (request.getAttribute("errRegister2") != null) { %>
                    <div class="alert alert-danger form-control">
                        <strong>!</strong> Username Exist
                    </div>
                    <% }
                    %>
                    <div class="form-group">
                        <label class="control-label" for="signupPassword">Password</label>
                        <form:password path="PassWord" cssClass="form-control"  />
                        <form:errors path="PassWord" cssClass="errHibernate" />
                    </div>
                    <div class="form-group" style="padding-top: 20px">
                        <button id="signupSubmit" type="submit" class="btn btn-info btn-block">Create your account</button>
                    </div>
                    <hr>
                </form:form>
            </div>
        </div>
    </div>
</div>


