//计算并显示商品总价
function sumPrice() {
    var sum = 0;
    $('table tr').each(function () {
        if ($(this).find("td:eq(3)").text() != '' && $(this).find("td:eq(3)").text() != null) {
            sum += parseInt($(this).find("td:eq(4)").text());
        }
    })
    return sum;
}

function choseSum() {
    var sum = 0;
    $('table tr').each(function () {
        if ($(this).find("td:eq(3)").text() != '' && $(this).find("td:eq(3)").text() != null) {
            if ($(this).find("td:eq(0)").children(".chose").is(':checked')) {
                sum += parseInt($(this).find("td:eq(4)").text());
            }
        }
    })
    return sum;
}

//加载页面时显示
$(function () {
    $(".total").text("总价：" + sumPrice());
    $(".chose_total").text("选中商品总价：" + choseSum());
});

//计算并显示选中商品总价
$(function () {
    $(".chose").click(function () {
        $(".chose_total").text("选中商品总价：" + choseSum());
    })
});

$(function () {
    $("#choseAll").click(function () {
        $(".chose_total").text("选中商品总价：" + choseSum());
    })
});
//购物车商品全选框
function choseAll() {
    if ($("#choseAll").is(':checked')) {
        $(".chose").prop("checked", true);
    } else {
        $(".chose").prop("checked", false);
    }
}

//数量减少
$(function () {
    $(".min").click(function () {
        var count = "";
        var ts = $(this);
        count = $(this).next().val();
        if (count > 0) {
            $(this).next().val(parseInt(count) - 1);
        }
        $.getJSON("/upd", {
            "goodsId": $(this).parent().prev().prev().text(),
            "count": $(this).next().val()
        }, function (goods) {
            ts.parent().next().text((ts.next().val()) * (goods.price));
            $(".total").text("总价：" + sumPrice());
            $(".chose_total").text("选中商品总价：" + choseSum());
        })
    });
});

//数量增加
$(function () {
    $(".add").click(function () {
        var count = "";
        var ts = $(this);
        count = $(this).prev().val();
        $(this).prev().val(parseInt(count) + 1);
        count = $(this).prev().val();
        $.getJSON("/upd", {
            "goodsId": $(this).parent().prev().prev().text(),
            "count": $(this).prev().val()
        }, function (goods) {
            if (count > goods.stock) {
                alert("库存不足");
                ts.prev().val(goods.stock);
            }
            ts.parent().next().text(parseInt(ts.prev().val()) * parseInt(goods.price));
            $(".total").text("总价：" + sumPrice());
            $(".chose_total").text("选中商品总价：" + choseSum());
        })
    });

});

//直接填入数量
$(function () {
    $(".count").keyup(function () {
        var ts = $(this);
        var reg = /^[0-9]*$/;
        if (!reg.test(ts.val())) {
            alert("输入错误，请输入数字！！！！");
            return false;
        }
        $.getJSON("/upd", {"goodsId": $(this).parent().prev().prev().text(), "count": $(this).val()}, function (goods) {
            if (ts.val() > goods.stock) {
                alert("库存不足");
                ts.val(goods.stock);
            }
            ts.parent().next().text(parseInt(ts.val()) * parseInt(goods.price));
            $(".total").text("总价：" + sumPrice());
            $(".chose_total").text("选中商品总价：" + choseSum());
        });
    });
});

$(function () {
    $(".push").click(function () {
        var list = [];//用来保存数据的列表
        $("input[name='chose']:checked").each(function () {//将被选中的行的数据保存在列表中
            list.push($(this).val());
        })
        if (list == "") {//列表为空时，即没有选中的商品
            alert("请选择要提交的商品！");
        } else {//发送请求
            $.get("/push", {"goodsIdList[]": list,"chosePrice":choseSum()}, function (msg) {//弹出提醒信息，刷新此页面
                alert(msg);
                window.location.reload();//刷新
            });
        }

    })
})