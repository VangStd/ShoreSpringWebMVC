<%-- 
    Document   : changepassword
    Created on : Sep 9, 2022, 9:41:57 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${notiChangpass!=null}">
    <script>
        window.alert('Change PassWord Success!');
        window.location.href = "/ProjectShore/admin/home-admin";
    </script>
</c:if>
<div>
    <form:form action="/ProjectShore/admin/update-password" method="POST" modelAttribute="admin">
        <form:hidden path="ID" />
        <form:hidden path="FullName" />
        <form:hidden path="Address" />
        <form:hidden path="Phone" />
        <form:hidden path="Email" />
        <form:hidden path="UserName" />
        <form:hidden path="PassWord" />
        <div class="form-group">
            <label for="email">Old Password</label>
            <input type="text" class="form-control" value="**********" readonly id="email">
        </div>
        <div class="form-group">
            <label for="pwd">Confirm Old Password</label>
            <input type="password" class="form-control" placeholder="Enter password" value="${confirmold}" name="confirmoldpass" required id="pwd">
            <c:if test="${ad_err_changepass_2 != null}">
                <div class="alert alert-danger form-control">
                    <strong>Old Password Notcorrect !</strong> 
                </div>
            </c:if>
        </div>
        <div class="form-group">
            <label for="pwd">New Password</label>
            <form:password path="NewPassword" cssClass="form-control" value="${newpass}" />
            <form:errors path="NewPassword" cssClass="errHibernate" />
        </div>
        <div class="form-group">
            <label for="pwd">Confirm New Password</label>
            <form:password path="confirmNewPassword" cssClass="form-control" value="${confirmnewpass}" required="required" />
            <c:if test="${ad_err_changepass_1 != null}">
                <div class="alert alert-danger form-control">
                    <strong>New Password Notcorrect !</strong>
                </div>
            </c:if>
        </div>
        <button type="submit" class="btn btn-primary">Change</button>
    </form:form>
</div>

