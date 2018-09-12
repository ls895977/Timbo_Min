$(function(){
    var ok1=false;
    var ok2=false;
    var ok3=false;
    var ok4=false;
    var ok5=false;
    var ok6=false;
    var ok7=false;
    var ok8=false;

    $("input[name='name']").blur(function(){
        var name=$(this).val();
        if (name == ''){
            $(".alert_box").text("姓名不能为空").show();
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

    $("select[name='year1']").blur(function(){
        var index=$(this).get(0).selectedIndex;
        if (index === 0 ) {
            $(".alert_box").text("请选择年份").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        } else {
            ok5=true;
        }
    });

    $("select[name='month1']").blur(function(){
        var index=$(this).get(0).selectedIndex;
        if (index === 0 ) {
            $(".alert_box").text("请选择月份").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        } else {
            ok6=true;
        }
    });

    $("select[name='day1']").blur(function(){
        var index=$(this).get(0).selectedIndex;
        if (index === 0 ) {
            $(".alert_box").text("请选择日期").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        } else {
            ok7=true;
        }
    });

    $("select[name='relShip_1']").blur(function(){
        var index=$(this).get(0).selectedIndex;
        if (index === 0 ) {
            $(".alert_box").text("请选择与孩子关系").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        } else {
            ok7=true;
        }
    });

    $("select[name='relShip_2']").blur(function(){
        var index=$(this).get(0).selectedIndex;
        if (index === 0 ) {
            $(".alert_box").text("请选择与孩子关系").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        } else {
            ok7=true;
        }
    });

    $("input[name='parents_1']").blur(function(){
        var parents_1=$(this).val();
        if (parents_1 == ''){
            $(".alert_box").text("家长姓名不能为空").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else{
            ok4=true;
        }
    });

    $("input[name='parents_2']").blur(function(){
        var parents_1=$(this).val();
        if (parents_1 == ''){
            $(".alert_box").text("家长姓名不能为空").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else{
            ok4=true;
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