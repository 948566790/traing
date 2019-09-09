//获取所有商品信息
$(function () {
    $.getJSON("/selAllGoods", {"root": "root"}, function (data) {
        var result = "";
        for (var i = 0; i < data.length; i++) {
            result += "<tr>";
            result += "<td>" + data[i].goodsId + "</td>";
            result += "<td>" + data[i].goodsName + "</td>";
            result += "<td>" + data[i].stock + "</td>";
            result += "<td>" + data[i].price + "</td>";
            result += "<td><a href='/addGoodsToCart?goodsId=" + data[i].goodsId + " '>加入购物车</a></td>";
            result += "</tr>"
        }
        $("#tbody01").html(result);
    });
});


//点击搜搜
$(function () {
    $(".a").click(function () {
        $.getJSON("/search", {"word": $(".s").val()}, function (data) {
            var result = "";
            /*if (data=null||data==""){
                $("#tbody01").html("无记录");
                $(".s").val("");
                return false;
            }*/
            for (var i = 0; i < data.length; i++) {
                result += "<tr>";
                result += "<td>" + data[i].goodsId + "</td>";
                result += "<td>" + data[i].goodsName + "</td>";
                result += "<td>" + data[i].stock + "</td>";
                result += "<td>" + data[i].price + "</td>";
                result += "<td><a href='/addGoodsToCart?goodsId=" + data[i].goodsId + " ' class='add'>加入购物车</a></td>";
                result += "</tr>"
            }
            $("#tbody01").html(result);
        })
    })
})

//点击显示所有商品
$(function () {
    $(".all").click(function () {
        $.getJSON("/selAllGoods", {}, function (data) {
            var result = "";
            for (var i = 0; i < data.length; i++) {
                result += "<tr>";
                result += "<td>" + data[i].goodsId + "</td>";
                result += "<td>" + data[i].goodsName + "</td>";
                result += "<td>" + data[i].stock + "</td>";
                result += "<td>" + data[i].price + "</td>";
                result += "<td><a href='/addGoodsToCart?goodsId=" + data[i].goodsId + " '>加入购物车</a></td>";
                result += "</tr>"
            }
            $("#tbody01").html(result);
        });
    })
})


