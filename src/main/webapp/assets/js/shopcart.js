var shopcart = {
    init: function () {
        shopcart.registerEvents();
        shopcart.AddShopCart();
        shopcart.loveProduct();
    },
    registerEvents: function () {

    },
    AddShopCart: function () {
        $('.addcart').each(function () {
            $(this).on("click", function () {
                var ID = $(this).data("id");
                console.log(ID);
                $.ajax({
                    type: 'GET',
                    data: {ProID: ID},
                    url: "/ProjectShore/add-shopcart",
                    success: function (data, textStatus, jqXHR) {
                        Swal.fire(
                                'Add Shopping Cart!',
                                'You clicked the button!',
                                'success'
                                )
                    },
                    error: function () {
                        location.href = "/ProjectShore/form-login";
                        console.log("That Bai");
                    }
                });
            });
        });
    }, loveProduct: function () {
        $('.loveproduct').each(function () {
            $(this).on("click", function () {
                var id = $(this).data("id");
                console.log(id);
                $.ajax({
                    type: 'GET' ,
                    url: "/ProjectShore/love-product",
                    data: {ProID : id},
                    success: function (data, textStatus, jqXHR) {
                        $('.texth1row').text("Hello");
                        location.reload();
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        window.location.href ="/ProjectShore/form-login";
                    }
                });
            });
        });
    }
};
shopcart.init();






