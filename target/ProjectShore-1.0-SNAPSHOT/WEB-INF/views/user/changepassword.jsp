<%-- 
    Document   : changepassword
    Created on : Aug 3, 2022, 10:52:08 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<br>
<div>
    <form:form action="/ProjectShore/save-change-pass" method="post"  modelAttribute="customer">
        <div class="mb-3">
            <label for="pwd" class="form-label">Your PassWord</label>
            <input type="password" value="hsdg$#%^$DASK" class="form-control" readonly/>
        </div>
        <div class="mb-3">
            <label for="pwd" class="form-label">Confirm your PassWord</label>
            <input type="password" name="yourpass"  required class="form-control" />
        </div>
        <c:if test="${errChangePass1!=null}">
            <div class="alert alert-danger form-control">
                <strong>!</strong> Incorrect confirm old password
            </div>
        </c:if>
        <div class="mb-3">
            <label for="pwd" class="form-label">New PassWord</label>
            <input type="password" name="newpass" value="${newpass}" required class="form-control" />
        </div>
        <div class="mb-3">
            <label for="pwd" class="form-label">Confirm PassWord</label>
            <input type="password" name="confirm" value="${confirm}" required class="form-control" />
        </div>
        <c:if test="${errChangePass2!=null}">
            <div class="alert alert-danger form-control">
                <strong>!</strong> Incorrect confirm new password
            </div>
        </c:if>
        <form:hidden path="CusID" />
        <form:hidden path="FullName" />
        <form:hidden path="Phone" />
        <form:hidden path="Address" />
        <form:hidden path="Email" />
        <form:hidden path="Gender" />
        <form:hidden path="UserName" />
        <form:hidden path="PassWord" />
        <button type="submit" class="btn btn-primary">Update</button>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
<c:if test="${ssChangePass != null}">
    <script>
        Swal.fire(
                'Change Password success ! ',
                'You clicked the button!',
                'success'
                );
        location.href = "/ProjectShore/home";
    </script>
</c:if>
