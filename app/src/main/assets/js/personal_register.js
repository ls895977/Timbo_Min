$(function(){
    var ok1=false;
    var ok2=false;
    var ok3=false;
    var ok4=false;
    var ok5=false;
    var ok6=false;
    var ok7=false;
    var ok8=false;

    $("input[name='mobile']").blur(function(){
        var mobile=$(this).val();
        var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if (mobile == ''){
            $(".alert_box").text("手机号不能为空").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }
        if(!reg.test(mobile)){
            $(".alert_box").text("手机号码有误").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else{
            ok1=true;
        }
    });
    $("input[name='code']").blur(function(){
        var code= $(this).val();
        if (code =="" ){
            $(".alert_box").text("验证码不能为空").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else {
            ok2=true;
        }
    });
    $(".code_btn").click(function(event){
        var mobile=$("input[name='mobile']").val();
        if(mobile!=""){
            var time=60;
            var t = setInterval(function () {
                time--;
                $(".code_btn").html("重新发送" + time + "s");
                if (time == 0) {
                    clearInterval(t);
                    $(".code_btn").html("重新获取");
                }
            }, 1000);
            ok3=true;
        }
        event.preventDefault();
    });


    $("input[name='password']").blur(function(){
        var password=$(this).val();
        var reg = /^[a-zA-Z0-9]{6,20}$/;
        if (password == ''){
            $(".alert_box").text("密码不能为空").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else if(!reg.test(password)){
            $(".alert_box").text("密码为6-20位字母数字组成").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else{
            ok4=true;
        }
    });

    $("#province").blur(function(){
        var index=$(this).get(0).selectedIndex;
        if (index === 0 ) {
            $(".alert_box").text("请选择城市").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        } else {
            ok5=true;
        }
    });

    $("#city").blur(function(){
        var index=$(this).get(0).selectedIndex;
        if (index === 0 ) {
            $(".alert_box").text("请选择省份").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        } else {
            ok6=true;
        }
    });

    $("#area").blur(function(){
        var index=$(this).get(0).selectedIndex;
        if (index === 0 ) {
            $(".alert_box").text("请选择区").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        } else {
            ok7=true;
        }
    });

    $(".agree").each(function () {
        if (!$(this).is(':checked')) {
            $(".alert_box").text("请勾选用户服务协议").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else {
            ok8=true;
        }
    });

    $(".next").click(function(){
        if(ok1 && ok2 && ok3 && ok4 && ok5 && ok6 && ok7 && ok8){
            $('#forgetPwd').submit();
        }else{
            return false
        }
    });

});