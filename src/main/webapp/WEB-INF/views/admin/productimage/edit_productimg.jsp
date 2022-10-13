<%-- 
    Document   : create_productimg
    Created on : Aug 12, 2022, 9:10:04 PM
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form action="/ProjectShore/admin/edit-imgproduct" method="post" modelAttribute="product" enctype="multipart/form-data">
    <form:hidden path="ID" />
    <input type="hidden" value="${ProID}" name="ProID" />
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Image 1</label>
        <form:hidden path="Image1" />
        <img src="${product.getImage1()}" width="150" alt="" class="img-thumbnail" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Image 2</label>
        <form:hidden path="Image2" />
        <img src="${product.getImage2()}" width="150" alt="" class="img-thumbnail"/>
        <input type="file" name="FileUpload2" class="form-control" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Image 3</label>
        <form:hidden path="Image3" />
        <img src="${product.getImage3()}" width="150" alt="" class="img-thumbnail"/>
        <input type="file" name="FileUpload3" class="form-control" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Image 4</label>
        <form:hidden path="Image4" />
        <img src="${product.getImage4()}" width="150" alt="" class="img-thumbnail"/>
        <input type="file" name="FileUpload4" class="form-control" />
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Image 5</label>
        <form:hidden path="Image5" />
        <img src="${product.getImage5()}" width="150" alt="" class="img-thumbnail"/>
        <input type="file" name="FileUpload5" class="form-control" />
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form:form>
