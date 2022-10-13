<%-- 
    Document   : confirmcode
    Created on : Sep 12, 2022, 1:43:56 PM
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
                    <form:form action="/ProjectShore/confirm-code-forgot" method="post">
                        <input type="hidden" value="${emailconfirm}" name="email" />
                        <div class="mb-3">
                            <label for="email" class="form-label">Code</label>
                            <input type="number" id="email" class="form-control" name="Code" placeholder="Enter Your Code" required="">
                            <c:if test="${errForgotpass2!=null}">
                                <div class="alert alert-danger form-control">
                                    <strong>Code Notcorrect !</strong> 
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

