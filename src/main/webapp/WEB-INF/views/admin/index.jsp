<%-- 
    Document   : index
    Created on : Jul 30, 2022, 10:23:44 AM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="row">
    <!-- task, page, download counter  start -->
    <div class="col-xl-3 col-md-6">
        <div class="card">
            <div class="card-block">
                <div class="row align-items-center">
                    <div class="col-8">
                        <h4 class="text-c-purple">${totalOrder}</h4>
                        <h6 class="text-muted m-b-0">Total Order</h6>
                    </div>
                    <div class="col-4 text-right">
                        <i class="fa fa-file-text-o f-28"></i>
                    </div>
                </div>
            </div>
            <div class="card-footer bg-c-purple">
                <div class="row align-items-center">
                    <div class="col-9">
                        <p class="text-white m-b-0"></p>
                    </div>
                    <div class="col-3 text-right">
                        <i class="fa fa-line-chart text-white f-16"></i>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6">
        <div class="card">
            <div class="card-block">
                <div class="row align-items-center">
                    <div class="col-8">
                        <h4 class="text-c-green">${totalViewpage}+</h4>
                        <h6 class="text-muted m-b-0">Page Views</h6>
                    </div>
                    <div class="col-4 text-right">
                        <i class="fa fa-eye f-28"></i>
                    </div>
                </div>
            </div>
            <div class="card-footer bg-c-green">
                <div class="row align-items-center">
                    <div class="col-9">
                        <p class="text-white m-b-0">% change</p>
                    </div>
                    <div class="col-3 text-right">
                        <i class="fa fa-line-chart text-white f-16"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6">
        <div class="card">
            <div class="card-block">
                <div class="row align-items-center">
                    <div class="col-8">
                        <h4 class="text-c-red">$${totalPriceOnInvoice}</h4>
                        <h6 class="text-muted m-b-0">Money</h6>
                    </div>
                    <div class="col-4 text-right">
                        <i class="fa fa-money f-28"></i>
                    </div>
                </div>
            </div>
            <div class="card-footer bg-c-red">
                <div class="row align-items-center">
                    <div class="col-9">
                        <p class="text-white m-b-0"></p>
                    </div>
                    <div class="col-3 text-right">
                        <i class="fa fa-line-chart text-white f-16"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6">
        <div class="card">
            <div class="card-block">
                <div class="row align-items-center">
                    <div class="col-8">
                        <h4 class="text-c-blue">${totalCustomer}</h4>
                        <h6 class="text-muted m-b-0">Member</h6>
                    </div>
                    <div class="col-4 text-right">
                        <i class="fa fa-user f-28"></i>
                    </div>
                </div>
            </div>
            <div class="card-footer bg-c-blue">
                <div class="row align-items-center">
                    <div class="col-9">
                        <p class="text-white m-b-0"></p>
                    </div>
                    <div class="col-3 text-right">
                        <i class="fa fa-line-chart text-white f-16"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- task, page, download counter  end -->


    <!--  sale analytics start -->
    <div class="col-xl-8 col-md-12">
        <div class="card">
            <div class="card-header">
                <h5>Sales Analytics</h5>
                <span class="text-muted">Get 15% Off on <a href="https://www.amcharts.com/" target="_blank">amCharts</a> licences. Use code "codedthemes" and get the discount.</span>
                <div class="card-header-right">
                    <ul class="list-unstyled card-option">
                        <li><i class="fa fa fa-wrench open-card-option"></i></li>
                        <li><i class="fa fa-window-maximize full-card"></i></li>
                        <li><i class="fa fa-minus minimize-card"></i></li>
                        <li><i class="fa fa-refresh reload-card"></i></li>
                        <li><i class="fa fa-trash close-card"></i></li>
                    </ul>
                </div>
            </div>
            <div class="card-block">
                <canvas id="myChart" style="height: 400px;"></canvas>
            </div>
        </div>
    </div>
    <div class="col-xl-4 col-md-12">
        <div class="card">
            <div class="card-block">
                <div class="row">
                    <div>

                    </div>

                    <div class="col">
                        <form:form>
                            <label>Month</label>
                            <select name="month" class="form-bg-primary form-control monthadmin">
                                <c:forEach var="item" items="${listMonth}">
                                    <c:if test="${month == item}">
                                        <option value="${item}" selected="">${item}</option>
                                    </c:if>
                                    <c:if test="${month != item}">
                                        <option value="${item}">${item}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </form:form>
                        <br/>
                        <h4 class="ad_salemonth">$${sales}</h4>
                        <p class="text-muted">This Month </p>
                    </div>
                </div>
                <div class="row">

                </div>
            </div>
        </div>
        <div class="card quater-card">
            <div class="card-block">
                <h6 class="text-muted m-b-15">This Quarter</h6>
                <h4>$3,9452.50</h4>
                <p class="text-muted">$3,9452.50</p>
                <h5>87</h5>
                <p class="text-muted">Online Revenue<span class="f-right">80%</span></p>
                <div class="progress"><div class="progress-bar bg-c-blue" style="width: 80%"></div></div>
                <h5 class="m-t-15">68</h5>
                <p class="text-muted">Offline Revenue<span class="f-right">50%</span></p>
                <div class="progress"><div class="progress-bar bg-c-green" style="width: 50%"></div></div>
            </div>
        </div>
    </div>
    <!--  sale analytics end -->

    <!--  project and team member start -->
    <div class="col-xl-8 col-md-12">
        <div class="card table-card">
            <div class="card-header">
                <h5>Projects</h5>
                <div class="card-header-right">
                    <ul class="list-unstyled card-option">
                        <li><i class="fa fa fa-wrench open-card-option"></i></li>
                        <li><i class="fa fa-window-maximize full-card"></i></li>
                        <li><i class="fa fa-minus minimize-card"></i></li>
                        <li><i class="fa fa-refresh reload-card"></i></li>
                        <li><i class="fa fa-trash close-card"></i></li>
                    </ul>
                </div>
            </div>
            <div class="card-block">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>
                                    <div class="chk-option">
                                        <div class="checkbox-fade fade-in-primary">
                                            <label class="check-task">
                                                <input type="checkbox" value="">
                                                <span class="cr">
                                                    <i class="cr-icon fa fa-check txt-default"></i>
                                                </span>
                                            </label>
                                        </div>
                                    </div>
                                    Assigned</th>
                                <th>Name</th>
                                <th>Due Date</th>
                                <th class="text-right">Priority</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <td>
                                    <div class="chk-option">
                                        <div class="checkbox-fade fade-in-primary">
                                            <label class="check-task">
                                                <input type="checkbox" value="">
                                                <span class="cr">
                                                    <i class="cr-icon fa fa-check txt-default"></i>
                                                </span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="d-inline-block align-middle">
                                        <img src="assets/images/avatar-4.jpg" alt="user image" class="img-radius img-40 align-top m-r-15">
                                        <div class="d-inline-block">
                                            <h6>John Deo</h6>
                                            <p class="text-muted m-b-0">Graphics Designer</p>
                                        </div>
                                    </div>
                                </td>
                                <td>Able Pro</td>
                                <td>Jun, 26</td>
                                <td class="text-right"><label class="label label-danger">Low</label></td>
                            </tr>

                            <tr>
                                <td>
                                    <div class="chk-option">
                                        <div class="checkbox-fade fade-in-primary">
                                            <label class="check-task">
                                                <input type="checkbox" value="">
                                                <span class="cr">
                                                    <i class="cr-icon fa fa-check txt-default"></i>
                                                </span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="d-inline-block align-middle">
                                        <img src="assets/images/avatar-5.jpg" alt="user image" class="img-radius img-40 align-top m-r-15">
                                        <div class="d-inline-block">
                                            <h6>Jenifer Vintage</h6>
                                            <p class="text-muted m-b-0">Web Designer</p>
                                        </div>
                                    </div>
                                </td>
                                <td>Mashable</td>
                                <td>March, 31</td>
                                <td class="text-right"><label class="label label-primary">high</label></td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="chk-option">
                                        <div class="checkbox-fade fade-in-primary">
                                            <label class="check-task">
                                                <input type="checkbox" value="">
                                                <span class="cr">
                                                    <i class="cr-icon fa fa-check txt-default"></i>
                                                </span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="d-inline-block align-middle">
                                        <img src="assets/images/avatar-3.jpg" alt="user image" class="img-radius img-40 align-top m-r-15">
                                        <div class="d-inline-block">
                                            <h6>William Jem</h6>
                                            <p class="text-muted m-b-0">Developer</p>
                                        </div>
                                    </div>
                                </td>
                                <td>Flatable</td>
                                <td>Aug, 02</td>
                                <td class="text-right"><label class="label label-success">medium</label></td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="chk-option">
                                        <div class="checkbox-fade fade-in-primary">
                                            <label class="check-task">
                                                <input type="checkbox" value="">
                                                <span class="cr">
                                                    <i class="cr-icon fa fa-check txt-default"></i>
                                                </span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="d-inline-block align-middle">
                                        <img src="assets/images/avatar-2.jpg" alt="user image" class="img-radius img-40 align-top m-r-15">
                                        <div class="d-inline-block">
                                            <h6>David Jones</h6>
                                            <p class="text-muted m-b-0">Developer</p>
                                        </div>
                                    </div>
                                </td>
                                <td>Guruable</td>
                                <td>Sep, 22</td>
                                <td class="text-right"><label class="label label-primary">high</label></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-4 col-md-12">
        <div class="card ">
            <div class="card-header">
                <h5>Website New Members - </h5>
                <div class="card-header-right">
                    <ul class="list-unstyled card-option">
                        <li><i class="fa fa fa-wrench open-card-option"></i></li>
                        <li><i class="fa fa-window-maximize full-card"></i></li>
                        <li><i class="fa fa-minus minimize-card"></i></li>
                        <li><i class="fa fa-refresh reload-card"></i></li>
                        <li><i class="fa fa-trash close-card"></i></li>
                    </ul>
                </div>
            </div>
            <div class="card-block">
                <c:forEach items="${listTopNewCus}" var="item">
                    <div class="align-middle m-b-30">
                        <img src="${item.getAvatar()}" alt="none" class="img-radius img-40 align-top m-r-15">
                        <div class="d-inline-block">
                            <h6>${item.getFullName()}</h6>
                            <p class="text-muted m-b-0">${item.getPhone()}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <!--  project and team member end -->
</div>
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/admin/assets/js/ad_index.js"/>"></script>
