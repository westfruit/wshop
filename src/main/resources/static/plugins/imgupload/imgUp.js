﻿//*******************************************
//2017年2月24日 0:05 由 向立凯 结束编写
//初步功能实现，仅做参考使用
//生产中使用需要继续完善，无js注入防御
//2017年8月28日 由 郭旺成改写
//*******************************************


var IMG_LENGTH = 1;//图片最大1MB
var IMG_MAXCOUNT = 5;//最多选中图片张数
var IMG_AJAXPATH = "/upload/base64/session";//异步传输服务端位置 session需要在页面初始化的时候改写

//打开文件选择对话框
$(document.body).on('click','.div_imgfile', function () {
    //当前上传组
    var lookImgs=$(this).siblings(".div_imglook").find(".lookimg");
    IMG_MAXCOUNT=$(this).attr("data-max");
    if (lookImgs&&lookImgs.length >= IMG_MAXCOUNT) {
        alert("一次最多上传" + IMG_MAXCOUNT + "张图片");
        return;
    }

    var imgfile=$(this).siblings(".imgfile");
    var _CRE_FILE = null;
    if (!imgfile||imgfile.length<1) {//个数不足则新创建对象imgfile.length <= lookImgs.length
        _CRE_FILE = document.createElement("input");
        _CRE_FILE.setAttribute("type", "file");
        _CRE_FILE.setAttribute("class", "imgfile");
        _CRE_FILE.setAttribute("accept", ".png,.jpg,.jpeg");
        _CRE_FILE.setAttribute("num", lookImgs.length);//记录此对象对应的编号
        $(this).after(_CRE_FILE);

    }
    else { //否则获取最后未使用对象
        _CRE_FILE = imgfile.last();
        _CRE_FILE.attr("num",lookImgs.length);//记录此对象对应的编号
    }
    return $(_CRE_FILE).click();//打开对象选择框
});

//创建预览图，在动态创建的file元素onchange事件中处理
$(document.body).on('change','.imgfile', function () {
    if ($(this).val().length > 0) {//判断是否有选中图片

        //判断图片格式是否正确
        var FORMAT = $(this).val().substr($(this).val().length - 3, 3);
        if (FORMAT != "png"&&FORMAT != "gif" && FORMAT != "jpg" && FORMAT != "peg") {
            alert("文件格式不正确！！！");
            return;
        }

        //判断图片是否过大，当前设置1MB
        var file = this.files[0];//获取file文件对象
        if (file.size > (IMG_LENGTH * 1024 * 1024)) {
            alert("图片大小不能超过" + IMG_LENGTH + "MB");
            $(this).val("");
            return;
        }

        //创建预览外层
        var _prevdiv = document.createElement("div");
        _prevdiv.setAttribute("class", "lookimg");
        //创建内层img对象
        var preview = document.createElement("img");
        $(_prevdiv).append(preview);
        //创建删除按钮
        var IMG_DELBTN = document.createElement("div");
        IMG_DELBTN.setAttribute("class", "lookimg_delBtn");
        IMG_DELBTN.setAttribute("title", "删除图片");
        IMG_DELBTN.innerHTML = "x";
        $(_prevdiv).append(IMG_DELBTN);

        //创建进度条
        var IMG_PROGRESS = document.createElement("div");
        IMG_PROGRESS.setAttribute("class", "lookimg_progress");
        $(IMG_PROGRESS).append(document.createElement("div"));
        $(_prevdiv).append(IMG_PROGRESS);

        //记录此对象对应编号
        _prevdiv.setAttribute("num", $(this).attr("num"));

        //对象注入界面
        var imgfile=this;
        var lookImgs=$(this).siblings(".div_imglook");
        $(lookImgs).children("div:last").before(_prevdiv);

        var skuinput=$(this).siblings(".skuimg").last();


        //预览功能 start
        var reader = new FileReader();//创建读取对象
        reader.onloadend = function () {
            preview.src = reader.result;//读取加载，将图片编码绑定到元素
            var lookimgList=$(lookImgs).find(".lookimg");
            var NOWLOOK = lookimgList.last();//当前操作的图片预览对象
            NOWLOOK.index = lookimgList.length-1;


            //如果当前图片已经上传，则不再重复上传


            //上传图片准备
            var IMG_BASE = reader.result; //要上传的图片的base64编码
            var IMG_IND = NOWLOOK.attr("num");
            var IMG_ROUTE=$(imgfile).eq(0).val()
            var IMG_ENDFOUR = IMG_ROUTE.substr(IMG_ROUTE.length - 4, 4);//截取路径后四位，判断图片类型
            var IMG_FOMATE = "jpeg"; //图片类型***
            if (IMG_ENDFOUR.trim() == ".jpg")
                IMG_FOMATE = "jpg";
            else if (IMG_ENDFOUR.trim() == ".png")
                IMG_FOMATE = "png";

            //图片正式开始上传
            $.ajax({
                type: "POST",
                url: IMG_AJAXPATH,
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({ 'imgBase': IMG_BASE, 'imgFormat': IMG_FOMATE, 'lookIndex': NOWLOOK.index }),
                dataType: "json",
                success: function (data) {
                    if (data.Code == "1") {
                        //图片上传成功回调
                        var UPTIME = Math.ceil(Math.random() * 400) + 400;//生成一个400-800的随机数，假设进图条加载时间不一致
                        $(lookimgList).eq([NOWLOOK.index]).attr("ISUP", "1");//记录此图片已经上传
                        $(lookimgList).eq([NOWLOOK.index]).children(".lookimg_progress").eq(0).children("div").eq(0).animate({ width: "100%" }, UPTIME, function () {
                            $(this).css("background-color", "#00FF00");
                        });

                        preview.src=data.ImgUrl;

                        var imgArry=skuinput.val().length>0?skuinput.val().split(','):[];

                        imgArry.push(data.ImgUrl);
                        skuinput.val(imgArry.length==1?data.ImgUrl:imgArry.join());
                        console.info(imgArry);

                    }
                    else {//图片未上传成功回调
                        $(lookimgList)[NOWLOOK.index].children(".lookimg_progress").eq(0).children("div").eq(0).css("width", "100%").css("background-color", "red").text("上传失败");
                    }
                },
                error: function (err) {
                    //服务器连接失败报错处理
                    alert("error");
                    //alert(err.responseText);
                },
                beforeSend: function () {
                    //图片上传之前执行的操作，当前为进度条显示
                    NOWLOOK.children(".lookimg_progress").eq(0).css("display", "block");//进度条显示
                }
            });

        }
        if (file) {//如果对象正确
            reader.readAsDataURL(file);//获取图片编码
        } else {
            preview.src = "";//返回空值
        }
        //预览功能 end

    }


});

//删除选中图片
$(document.body).on('click','.lookimg_delBtn',function () {
    $(".imgfile[num=" + $(this).parent().attr("num") + "]").remove();//移除图片file
    var skuinput=$(this).closest(".div_imglook").siblings(".skuimg").last();
    var imgsrc=$(this).siblings("img").attr("src");
    var imgArry=skuinput.val().split(',');
    imgArry.splice($.inArray(imgsrc,imgArry),1);
    skuinput.val(imgArry.join(','))

    $(this).parent().remove();//移除图片显示
});