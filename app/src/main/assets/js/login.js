
$(function(){
    var ok1=false;
    var ok2=false;
    $("#username").blur(function(){
        var username=$(this).val();
        var reg = /^[a-zA-Z0-9]{6,16}$/;
        if (username == ''){
            $(".alert_box").text("用户名不能为空").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else if(!reg.test(username)){
            $(".alert_box").text("用户名应为6-20位字母数字组成").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else{
            ok1=true;
        }
    });

    $("#password").blur(function(){
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
        if(ok1 && ok2){
            $('#loginForm').submit();
        }else{
            return false
        }
    });
});