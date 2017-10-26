$(function () {
    $.ajax({
        type: 'POST',
        url: contextPath+'/lz_zwfw/getData',
        //type:'json',
        success: function (data) {
            //console.log(data.data.length);
            var html = '';
            for (var i = 0; i < data.data.length; i++) {
                if (i === 0) {
                    html += '<div class="box" style="display: block" >' +
                        '<div class="innerBox">' +
                        '<div class="boxTop h22">' +
                        '<div class="name fl">' + data.data[i].top[0] + '</div>' +
                        ' <div class=" fr">' +
                        ' <ul>' +
                        '<li>' +
                        '<p class="f10">' + data.data[i].top[1] + '</p>' +
                        '<p class="f16">' + data.data[i].top[2] + '</p>' +
                        '</li>' +
                        '<li class="line">' +
                        '</li>' +
                        '<li>' +
                        '<p class="f10">' + data.data[i].top[3] + '</p>' +
                        '<p class="f16 fColor">' + data.data[i].top[4] + '</p>' +
                        '</li>' +
                        '</ul>' +
                        '</div>' +
                        '</div>' +
                        '<div class="boxBottom h78">'
                    html += ' <ul id="' + i + '">'
                    for (var j = 0; j < data.data[i].row.length; j++) {
                        if (j % 2 == 0) {
                            html += '<li class="h20 bgColor4"> <i></i>' + data.data[i].row[j] + '</li>'
                        } else {
                            html += '<li class="h20 bgColor1"> <i></i>' + data.data[i].row[j] + '</li>'
                        }
                    }
                    html += ' </ul>' +
                        ' </div>' +
                        '</div>' +
                        '</div>'
                } else {
                    html += '<div class="box" style="display: none">' +
                        '<div class="innerBox">' +
                        '<div class="boxTop h22">' +
                        '<div class="name fl">' + data.data[i].top[0] + '</div>' +
                        ' <div class=" fr">' +
                        ' <ul>' +
                        '<li>' +
                        '<p class="f10">' + data.data[i].top[1] + '</p>' +
                        '<p class="f16">' + data.data[i].top[2] + '</p>' +
                        '</li>' +
                        '<li class="line">' +
                        '</li>' +
                        '<li>' +
                        '<p class="f10">' + data.data[i].top[3] + '</p>' +
                        '<p class="f16 fColor">' + data.data[i].top[4] + '</p>' +
                        '</li>' +
                        '</ul>' +
                        '</div>' +
                        '</div>' +
                        '<div class="boxBottom h78">'
                    html += ' <ul id="' + i + '">'
                    for (var j = 0; j < data.data[i].row.length; j++) {
                        if (j % 2 == 0) {
                            html += '<li class="h20 bgColor4"> <i></i>' + data.data[i].row[j] + '</li>'
                        } else {
                            html += '<li class="h20 bgColor1"> <i></i>' + data.data[i].row[j] + '</li>'
                        }
                    }
                    html += ' </ul>' +
                        ' </div>' +
                        '</div>' +
                        '</div>'
                }

            }
            $("#hand").append(html);
        }
    });

    var index = 0;
    var time = null;
    time = setInterval(function () {
        $(".box").css("display", "none");
        $(".box").eq(index).css("display", "block");
        index++;
        if (index == count) {//这里的数值要根据委办局的个数得到的
            index = 0;
        }
    }, 3000);
    $("#hand").on("mouseover", function () {
        clearInterval(time);
    })
    $("#hand").on("mouseout", function () {
        time = setInterval(function () {
            $(".box").css("display", "none");
            $(".box").eq(index).css("display", "block");
            index++;
            if (index == count) {
                index = 0;
            }
        }, 3000);
    })


})
