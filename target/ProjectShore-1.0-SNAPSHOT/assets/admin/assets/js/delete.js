/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

var dele = {
    init: function () {
        dele.registerEvents();
        dele.DeleteCus();
        dele.DeleteSup();
        dele.DeleteCate();
        dele.DeletePro();
        dele.DeleteSaleOff();
        dele.updateStatus();
        dele.DeleteCartByID();
        dele.DeleteAllByCusID();
        dele.DeleteOrder();
    },
    registerEvents: function () {

    },
    DeleteCus: function () {
        $(".cssla").each(function () {
            $(this).on("click", function () {
                console.log("kj");
                var id = $(this).data("id");
                Swal.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: 'GET',
                            url: "/ProjectShore/admin/delete-customer",
                            data: {CusID: id},
                            success: function () {
                                Swal.fire(
                                        'Deleted!',
                                        'Your file has been deleted.',
                                        'success'
                                        );
                                location.href = "/ProjectShore/admin/page-customer";
                            }
                        });

                    }
                });
            });
        });
    }, DeleteSup: function () {
        $(".csssup").each(function () {
            $(this).on("click", function () {
                var id = $(this).data("id");
                Swal.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: 'GET',
                            url: "/ProjectShore/admin/delete-supplier",
                            data: {SupID: id},
                            success: function () {
                                Swal.fire(
                                        'Deleted!',
                                        'Your file has been deleted.',
                                        'success'
                                        );
                                location.href = "/ProjectShore/admin/page-supplier";
                            }
                        });
                    }
                });
            });
        });
    }, DeleteCate: function () {
        $(".cssCate").each(function () {
            $(this).on("click", function () {
                var ID = $(this).data("id");
                Swal.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: 'GET',
                            url: "/ProjectShore/admin/delete-categorie",
                            data: {CateID: ID},
                            success: function () {
                                Swal.fire(
                                        'Deleted!',
                                        'Your file has been deleted.',
                                        'success'
                                        );
                                location.href = "/ProjectShore/admin/page-categorie";
                            }
                        });
                    }
                });
            });
        });
        //
    }, DeletePro: function () {
        $(".csspro").each(function () {
            $(this).on("click", function () {
                var ID = $(this).data("id");
                Swal.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: 'GET',
                            url: "/ProjectShore/admin/delete-product",
                            data: {ProID: ID},
                            success: function () {
                                Swal.fire(
                                        'Deleted!',
                                        'Your file has been deleted.',
                                        'success'
                                        );
                                location.href = "/ProjectShore/admin/page-product";
                            }
                        });
                    }
                });
            });
        });
    }, DeleteSaleOff: function () {
        $('.csssale').each(function () {
            $(this).on("click", function () {
                var ID = $(this).data("id");
                console.log(ID);
                Swal.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: 'GET',
                            url: "/ProjectShore/admin/delete-saleoff",
                            data: {SaleID: ID},
                            success: function () {
                                Swal.fire(
                                        'Deleted!',
                                        'Your file has been deleted.',
                                        'success'
                                        );
                                location.href = "/ProjectShore/admin/page-saleoff";
                            }
                        });
                    }
                });
            });
        });
    }, updateStatus: function () {
        $('.updateCartStatus').on("click", function () {
            Swal.fire({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        type: 'GET',
                        url: "/ProjectShore/delete-all-shopcart",
                        success: function (data, textStatus, jqXHR) {
                            location.href = "/ProjectShore/shop-cart";
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                        }
                    });
                }
            });
        });
    }, DeleteCartByID: function () {
        $('.deletecartbyid').each(function () {
            $(this).on("click", function () {
                var ID = $(this).data("id");
                Swal.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: 'GET',
                            data: {ID: ID},
                            url: "/ProjectShore/admin/delete-shopcart-by-id",
                            success: function (data, textStatus, jqXHR) {
                                window.location.href = "/ProjectShore/admin/page-shopingcart";
                            }, error: function (jqXHR, textStatus, errorThrown) {
                                window.location.href = "/ProjectShore/form-login";
                            }
                        });
                    }
                });
            });
        });
    }, DeleteAllByCusID: function () {
        $('.deletecartbycusid').each(function () {
            $(this).on("click", function () {
                var CusID = $(this).data("id");
                Swal.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: 'GET',
                            data: {CusID: CusID},
                            url: "/ProjectShore/admin/delete-all-shopcart-by-cusid",
                            success: function (data, textStatus, jqXHR) {
                                window.location.href = "/ProjectShore/admin/page-shopingcart";
                            }, error: function (jqXHR, textStatus, errorThrown) {
                                window.location.href = "/ProjectShore/form-login";
                            }
                        });
                    }
                });
            });
        });
    }, DeleteOrder: function () {
        $('.deleteorder').each(function () {
            $(this).on("click", function () {
                var id = $(this).data("id");
                Swal.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: 'GET',
                            data: {OrderID: id},
                            url: "/ProjectShore/admin/delete-order",
                            success: function (data, textStatus, jqXHR) {
                                window.location.href = "/ProjectShore/admin/user-order";
                            }, error: function (jqXHR, textStatus, errorThrown) {
                                window.location.href = "/ProjectShore/form-login";
                            }
                        });
                    }
                });
            });
        });
    }
};
dele.init();



