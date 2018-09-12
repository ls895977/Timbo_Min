$(function(){
    var ok1=false;
    var ok2=false;
    var ok3=false;
    var ok4=false;
    var ok5=false;
    var ok6=false;

    $("input[name='credit']").blur(function(){
        var credit=$(this).val();
        if (credit == ''){
            $(".alert_box").text("信用代码不能为空").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else{
            ok1=true;
        }
    });

    //验证身份证
    $("input[name='legalPerson']").blur(function(){
        var person_id=$(this).val();
        if(person_id!=""){
            var aCity = { 11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外" };//获取证件号码
            //合法性验证
            var sum = 0;
            //出生日期
            var birthday;
            //验证长度与格式规范性的正则
            var pattern=new RegExp(/(^\d{15}$)|(^\d{17}(\d|x|X)$)/i);
            if (pattern.exec(person_id)) {
                //验证身份证的合法性的正则
                pattern=new RegExp(/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/);
                if(pattern.exec(person_id)) {
                    //获取15位证件号中的出生日期并转位正常日期
                    birthday = "19"+person_id.substring(6,8)+"-"+person_id.substring(8,10)+"-"+person_id.substring(10,12);
                } else {
                    person_id = person_id.replace(/x|X$/i,"a");
                    //获取18位证件号中的出生日期
                    birthday =person_id.substring(6,10)+"-"+person_id.substring(10,12)+"-"+person_id.substring(12,14);

                    //校验18位身份证号码的合法性
                    for (var i = 17; i >= 0; i--)
                    {
                        sum += (Math.pow(2, i) % 11) * parseInt(person_id.charAt(17 - i), 11);
                    }
                    if (sum % 11 != 1) {
                        $(".alert_box").text("身份证号码不符合国定标准，请核对！").show();
                        setTimeout(function(){
                            $(".alert_box").hide();
                        },2000);
                        $(this).val("");
                        return;
                    }
                }
                //检测证件地区的合法性
                if (aCity[parseInt(person_id.substring(0, 2))] == null)
                {
                    $(".alert_box").text("证件地区未知，请核对！").show();
                    setTimeout(function(){
                        $(".alert_box").hide();
                    },2000);
                    $(this).val("");
                    return;
                }
                var dateStr = new Date(birthday.replace(/-/g, "/"));

                if (birthday != (dateStr.getFullYear()+"-"+ Append_zore(dateStr.getMonth()+1)+"-"+ Append_zore(dateStr.getDate()))) {
                    $(".alert_box").text("证件出生日期非法！").show();
                    setTimeout(function(){
                        $(".alert_box").hide();
                    },2000);
                    $(this).val("");
                    return;
                }
                $("#birthday").val(birthday);
            } else{
                $(".alert_box").text("证件号码格式非法").show();
                setTimeout(function(){
                    $(".alert_box").hide();
                },2000);
                $(this).val("");
                return;
            }
        }else if (person_id == ''){
            $(".alert_box").text("请输入证件号").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
            $(this).val("");
        }else {
            ok2=true;
        }
    });


    //上传身份证
    $("#card").blur(function(){
        var file=$(this).val();
        $("#cardFile").val(file);
    });
    //上传营业执照
    $("#license").click(function(){
        var file=$(this).val();
        $("#licenseFile").val(file);
    });

    $("#cardFile").blur(function(){
        var cardFile=$(this).val();
        if(cardFile == ''){
            $(".alert_box").text("身份证不能为空！").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else{
            ok3=true;
        }
    });

    $("#licenseFile").blur(function(){
        var cardFile=$(this).val();
        if(cardFile == ''){
            $(".alert_box").text("营业执照不能为空！").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else{
            ok4=true;
        }
    });

    $("#address").blur(function(){
       var address= $(this).val();
        if (address==""){
            $(".alert_box").text("地址不能为空！").show();
            setTimeout(function(){
                $(".alert_box").hide();
            },2000);
        }else{
            ok5=true;
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
            ok6=true;
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
            ok7=true;
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
            ok8=true;
        }
    });


    $(".register").click(function(){
        if(ok1 && ok2 && ok3 && ok4 && ok5 && ok6 && ok7 && ok8){
            $('#formSub').submit();
        }else{
            return false
        }
    });

});