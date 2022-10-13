<%-- 
    Document   : register
    Created on : Aug 2, 2022, 8:50:19 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<section class="w-auto p-3" style="background-color: #eee;padding-bottom: 70%;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <form:form action="/ProjectShore/submit-register" method="post" modelAttribute="customer">
                                    <div class="d-flex flex-row align-items-center mb-4 ">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:input path="FullName" cssClass="form-control" placeholder="Your Name"  />
                                            <form:errors path="FullName" cssClass="errHiber" />
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4 ">
                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:input path="Email" cssClass="form-control" placeholder="Your Mail" type="email"  />
                                            <form:errors path="Email" cssClass="errHiber" />
                                        </div>
                                    </div>
                                    <c:if test="${errRegister3!=null}">
                                        <div class="alert alert-danger form-control">
                                            <strong>!</strong> Email Exist
                                        </div>
                                    </c:if>

                                    <div class="d-flex flex-row align-items-center mb-4 col-md-10">
                                        <i class="fas fa-genderless fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <div class="form-control"><form:radiobutton path="Gender" value="0" label="" />&nbsp;Male&nbsp;&nbsp;<form:radiobutton path="Gender" value="1" label=""  />&nbsp;Female</div>  
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4 ">
                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:input path="UserName" cssClass="form-control" placeholder="Your Username" />
                                            <form:errors path="UserName" cssClass="errHiber"  />
                                        </div>
                                    </div>
                                    <c:if test="${errRegister2!=null}">
                                        <div class="alert alert-danger form-control">
                                            <strong>!</strong> Username Exist
                                        </div>
                                    </c:if>
                                    <div class="d-flex flex-row align-items-center mb-4 ">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:password path="PassWord" placeholder="Password" cssClass="form-control"  />
                                            <form:errors path="PassWord" cssClass="errHiber" />
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4 ">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input id="signupPasswordagain" type="password" maxlength="25" placeholder="Confirm Password" class="form-control" name="confirmpass" required>
                                        </div>
                                    </div>
                                    <c:if test="${errRegister1!=null}">
                                        <div class="alert alert-danger form-control">
                                            <strong>!</strong> Password again not correct
                                        </div>
                                    </c:if>
                                    <div class="form-check d-flex justify-content-center mb-5 ">
                                        <input class="form-check-input me-2" type="checkbox" value="" placeholder="" id="form2Example3c" />
                                        <label class="form-check-label" for="form2Example3">
                                            I agree all statements in <a href="#!">Terms of service</a>
                                        </label>
                                    </div>
                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">Register</button>
                                    </div>
                                    <p></p> Already have an account ? <a href="/ProjectShore/form-login">Sign in</a></p>
                                </form:form>
                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                     class="img-fluid img-responsive" alt="Sample image">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
