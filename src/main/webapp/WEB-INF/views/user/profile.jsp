<%-- 
    Document   : profile
    Created on : Aug 3, 2022, 6:29:37 PM
    Author     : kyqua
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<link rel="stylesheet" href="<c:url value="/assets/css/dienratdemp.css" />"/>
<div class="container"id="formcsspadding" class="formcsspadding">
    <form:form action="/ProjectShore/save-change-user" method="post" modelAttribute="customer" enctype="multipart/form-data" >
        <div class="row">
            <div class="col-lg-8">
                <div>
                    <form:hidden path="CusID" />
                    <form:hidden path="PassWord" />
                    <form:hidden path="Avatar" />
                    <div class="mb-3 mt-3 ">
                        <label for="email" class="form-label">Full Name</label>
                        <form:input path="FullName" cssClass="form-control" />
                        <form:errors path="FullName" cssClass="errHiber" />
                    </div>

                    <div class="mb-3">
                        <label for="pwd" class="form-label">Phone</label>
                        <form:input path="Phone" cssClass="form-control"  />
                        <form:errors path="Phone" cssClass="errHiber" />
                    </div>
                    <div class="mb-3">
                        <label for="pwd" class="form-label">Address</label>
                        <form:input path="Address" cssClass="form-control"  />
                        <form:errors path="Address" cssClass="errHiber" />
                    </div>
                    <div class="mb-3">
                        <label for="pwd" class="form-label">Email</label>
                        <form:input path="Email" cssClass="form-control" readonly="true" />
                        <form:errors path="Email" cssClass="errHiber" />
                    </div>
                    <c:if test="${errChangeUser1!=null}">
                        <div class="alert alert-danger form-control">
                            <strong>!</strong> Email Exist
                        </div>
                    </c:if>
                    <div class="mb-3">
                        <label for="pwd" class="form-label">Gender</label>
                        <div class="form-control"><form:radiobutton path="Gender" value="0" label="" />&nbsp;Male&nbsp;&nbsp; <form:radiobutton path="Gender" value="1" label="" />&nbsp;Female</div>
                    </div>
                    <div class="mb-3">
                        <label for="pwd" class="form-label">UserName</label>
                        <form:input path="UserName" cssClass="form-control" readonly="true"  />
                        <form:errors path="UserName" cssClass="errHiber" />
                    </div>
                    <center>
                        <button type="submit" class="cssload btn btn-primary">Change</button>
                    </center>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="mb-3" style="padding-top: 10px">
                    <label for="pwd" class="form-label">Avatar</label>
                    <input type="file" name="avatarUrl" class="form-control" />
                </div>
                <div class="mb-3" style="padding-top: 10px">
                    <label for="pwd" class="form-label">Avatar</label>
                    <img src="${customer.getAvatar()}" width="300" class="rounded-circle form-control" alt="alt"/>
                </div> 
            </div>
        </div>
    </form:form>   
</div> 
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
<c:if test="${ssSaveProfile!=null}">
    <script>
        Swal.fire(
                'Change Success ! ',
                'You clicked the button!',
                'success'
                );
        window.location.href = "/ProjectShore/home";
    </script>
</c:if>
