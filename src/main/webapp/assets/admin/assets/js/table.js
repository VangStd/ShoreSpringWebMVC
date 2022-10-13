/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


// basic usage
$('.tablemanager').tablemanager({
    firstSort: [[3, 0], [2, 0], [1, 'asc']],
    disable: ["last"],
    appendFilterby: true,
    dateFormat: [[4, "mm-dd-yyyy"]],
    debug: true,
    vocabulary: {
        voc_filter_by: ' &nbsp&nbsp Filter By &nbsp&nbsp',
        voc_type_here_filter: 'Search...',
        voc_show_rows: 'Rows&nbsp&nbsp'
    },
    pagination: true,
    showrows: [5, 10, 20, 50, 100],
    disableFilterBy: [1]
});
// $('.tablemanager').tablemanager();

try {
    fetch(new Request("https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js", {method: 'HEAD', mode: 'no-cors'})).then(function (response) {
        return true;
    }).catch(function (e) {
        var carbonScript = document.createElement("script");
        carbonScript.src = "//cdn.carbonads.com/carbon.js?serve=CK7DKKQU&placement=wwwjqueryscriptnet";
        carbonScript.id = "_carbonads_js";
        document.getElementById("carbon-block").appendChild(carbonScript);
    });
} catch (error) {
    console.log(error);
}

var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-36251023-1']);
_gaq.push(['_setDomainName', 'jqueryscript.net']);
_gaq.push(['_trackPageview']);

(function () {
    var ga = document.createElement('script');
    ga.type = 'text/javascript';
    ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(ga, s);
})();
