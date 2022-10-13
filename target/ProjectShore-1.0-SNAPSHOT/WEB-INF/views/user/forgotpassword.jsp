<%-- 
    Document   : forgotpassword
    Created on : Sep 11, 2022, 9:15:15 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container d-flex flex-column">
    <div class="row align-items-center justify-content-center
         min-vh-100">
        <div class="col-12 col-md-8 col-lg-4">
            <div class="card shadow-sm">
                <div class="card-body">
                    <div class="mb-4">
                        <h5>Forgot Password?</h5>
                        <p class="mb-2">Enter your registered email ID to reset the password
                        </p>
                    </div>
                    <form:form action="/ProjectShore/forgot-password" method="post">
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" id="email" class="form-control" name="email" placeholder="Enter Your Email" required="">
                            <c:if test="${errForgotpass1!=null}">
                                <div class="alert alert-danger form-control">
                                    <strong>Email Notcorrect !</strong> 
                                </div>
                            </c:if>
                        </div>
                        <div class="mb-3 d-grid">
                            <button type="submit" class="btn btn-primary">
                                Reset Password
                            </button>
                        </div>
                        <span>Don't have an account? <a href="/ProjectShore/form-login">sign in</a></span>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
