/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$('.Quantity').each(function () {
    $(this).change(function () {
        var Quantity = $(this).val();
        var ProID = $(this).data("id");
        var arr = new Array();
        arr.push({Quantity: Quantity, ProductID: ProID});
        $.each(arr, function (index, value) {
            $.ajax({
                type: 'GET',
                url: "/ProjectShore/update-shopcart",
                data: {ProductID: value.ProductID, Quantity: value.Quantity},
                success: function (data, textStatus, jqXHR) {
                    Location.href = "/ProjectShore/shop-cart";
                }
            });
        });

    });
});



