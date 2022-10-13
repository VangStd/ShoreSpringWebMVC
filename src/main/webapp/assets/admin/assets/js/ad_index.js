var index = {
    init: function () {
        index.adminEvents();
        index.choseMonth();
    },
    adminEvents: function () {

    }, choseMonth: function () {
        $('.monthadmin').on("change", function () {
            var val = $(this).val();
            console.log(val);
            $.ajax({
                type: 'POST',
                data: {month: val},
                dataType: 'json',
                url: "/ProjectShore/admin/chose-month",
                success: function (responseText) {
                    console.log(responseText);
                    if(responseText === 0){
                        responseText = " No Data ! ";
                    }
                    $('.ad_salemonth').text("$" + responseText);
                }, error: function (responseText) {
                    window.location.href = "/ProjectShore/form-login";
                }
            });
        });
    }
};

index.init();