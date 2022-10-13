<%-- 
    Document   : singin
    Created on : Jul 27, 2022, 7:30:20 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="vh-100">
    <div class="container-fluid h-custom" >
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp" class="img-fluid" alt="Sample image">

            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <h1 style="text-align: center">Login</h1>
                <c:if test="${errLogin1!=null}">
                    <div class="alert alert-danger">
                        <strong><span>Username or Password Incorrect</span> !</strong>
                    </div>
                </c:if>
                <form:form action="/ProjectShore/submit-form" method="POST" modelAttribute="login">

                    <div class="form-outline mb-4">
                        <form:input path="UserName" cssStyle="width:100%" alt="Email" placeholder="Username"  value="${userCookie}"  />
                    </div>
                    <div class="form-outline mb-3">
                        <form:password path="PassWord" cssStyle="width:100%" placeholder="Password" value="${userCookie}" />
                    </div>
                    <div class="d-flex justify-content-between align-items-center">
                        <!-- Checkbox -->
                        <div class="form-check mb-0">
                            <form:checkbox path="Remember" id="form2Example3"/>
                            <label class="form-check-label" for="form2Example3">
                                Remember me
                            </label>
                        </div>
                        <a href="/ProjectShore/forgot-password" class="text-body">Forgot password?</a>
                    </div>
                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" class="btn btn-primary btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                        <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="/ProjectShore/form-register"class="link-danger">Register</a></p>
                    </div>
                </form:form> 
            </div>
        </div>
    </div>

</section>


