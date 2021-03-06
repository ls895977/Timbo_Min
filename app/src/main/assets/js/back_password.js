$(function(){
    var ok1=false;
    var ok2=false;
    var ok3=false;

    $("#mobile").blur(function(){
        var mobile=$(this).val();
        var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if (mobile == ''){
            $(".alert_box").text("用户名不能为空").show();
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

    //验证码
    $("#sendCode").click(function(event){
        var mobile=$("#mobile").val();
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

    $("#pwd").blur(function(){
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
            ok2=true;
        }
    });


    $(".submit").click(function(){
        if(ok1 && ok2 && ok3){
            $('#forgetPwd').submit();
        }else{
            return false
        }
    });
});