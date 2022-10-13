var chartlib = {
    init: function () {
        chartlib.chartEvent();
        chartlib.LoadData();
    }, chartEvent: function () {

    }, LoadData: function () {
        $('#myChart').ready(function () {
            $.ajax({
                type: 'GET',
                url: "/ProjectShore/admin/data-chart",
                success: function (responseText) {
                    var arr = responseText;
                    var yValues = new Array();
                    $.each(arr, function (index, value) {
                        yValues.push(value);
                    });
                    var xValues = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 'Month'];
                    new Chart("myChart", {
                        type: "line",
                        data: {
                            labels: xValues,
                            datasets: [{
                                    fill: false,
                                    lineTension: 0,
                                    backgroundColor: "rgba(0,0,255,1.0)",
                                    borderColor: "rgba(255, 0, 0, 0.8)",
                                    data: yValues
                                }]
                        },
                        options: {
                            legend: {display: false},
                            scales: {
                                yAxes: [{ticks: {min: 100, max: 100000}}],
                            }
                        }
                    });
                }
            });

        });
    }
};
chartlib.init();