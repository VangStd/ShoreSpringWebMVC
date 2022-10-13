<%-- 
    Document   : profile
    Created on : Sep 10, 2022, 9:19:20 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${noti_updateprofile1!=null}">
    <script>
        alert('Update profile success');
        window.location.href = "/ProjectShore/admin/home-admin";
    </script>
</c:if>
<div>
    <div class="container">
        <form:form action="/ProjectShore/admin/admin-profile" method="POST" modelAttribute="admin" enctype="multipart/form-data">        
            <div class="row">
                <div class="col-lg-8">
                    <form:hidden path="ID" />
                    <form:hidden path="Avatar" />
                    <div class="form-group">
                        <label for="pwd">FullName</label>
                        <form:input path="FullName" cssClass="form-control"  />
                        <form:errors path="FullName" cssClass="errHibernate" />
                    </div>
                    <div class="form-group">
                        <label for="pwd">Address</label>
                        <form:input path="Address" cssClass="form-control"  />
                        <form:errors path="Address" cssClass="errHibernate" />
                    </div>
                    <div class="form-group">
                        <label for="pwd">Phone</label>
                        <form:input path="Phone" cssClass="form-control"  />
                        <form:errors path="Phone" cssClass="errHibernate" />
                    </div>
                    <div c+lass="form-group">
                        <label for="pwd">Email</label>
                        <input type="hidden" value="${admin.getEmail()}" name="mail" />
                        <form:input path="Email" cssClass="form-control" type="email"  />
                        <form:errors path="Email" cssClass="errHibernate" />
                    </div>
                    <c:if test="${upprofileadmin1!=null}">
                        <div class="alert alert-danger form-control">
                            <strong>Email Exist !</strong> 
                        </div>
                    </c:if>
                    <div class="form-group">
                        <label for="pwd">UserName</label>
                        <form:input path="UserName" cssClass="form-control" readonly="true"  />
                        <form:errors path="UserName" cssClass="errHibernate" />
                    </div>
                    <form:hidden path="PassWord" />
                    <button type="submit" class="btn btn-primary">Change</button>
                </div>
                <div class="col-lg-4">
                    <div class="form-group">
                        <label for="pwd">Avatar</label>
                        <input type="file" name="urlAvatar" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="pwd">Avatar</label>
                        <img src="${admin.getAvatar()}" width="200" class="img-fluid img-thumbnail form-control" />
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>

