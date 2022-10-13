<%-- 
    Document   : newpassforgot
    Created on : Sep 12, 2022, 2:10:05 PM
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
                    <form:form action="/ProjectShore/save-forgot-password" method="post">
                        <input type="hidden" value="${mail}" name="email" />
                        <div class="mb-3">
                            <label for="email" class="form-label">New Password</label>
                            <input type="password" minlength="7" max="20" id="email" class="form-control" name="password" placeholder="Enter New Password" required="">
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Confirm Password</label>
                            <input type="password" id="email" class="form-control" name="confirm" placeholder="Confirm New Password" required="">
                            <c:if test="${errForgotpass3!=null}">
                                <div class="alert alert-danger form-control">
                                    <strong>Confirm Password Notcorrect !</strong> 
                                </div>
                            </c:if>
                        </div>
                        <div class="mb-3 d-grid">
                            <button type="submit" class="btn btn-primary">
                                Confirm
                            </button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

