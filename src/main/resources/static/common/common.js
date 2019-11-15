var SUCCESS = "0000";
const Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 3000
    });
var zyw = {
    checkInput:function(value,errMsg){
        if(typeof value == "undefined" || value == null || value == ""){
            toastr.error(errMsg)
            return true
        }
        return false
    },
    doing:function(){
        Toast.fire({
            type:'info',
            title:' 功能开发中...敬请期待 '
        })
        //toastr.error("")
    },
    errorMsg:function(msg){
        toastr.error(msg)
    },
    dateFormat:function(fmt,date){
         let ret;
            let opt = {
                "Y+": date.getFullYear().toString(),        // 年
                "m+": (date.getMonth() + 1).toString(),     // 月
                "d+": date.getDate().toString(),            // 日
                "H+": date.getHours().toString(),           // 时
                "M+": date.getMinutes().toString(),         // 分
                "S+": date.getSeconds().toString()          // 秒
                // 有其他格式化字符需求可以继续添加，必须转化成字符串
            };
            for (let k in opt) {
                ret = new RegExp("(" + k + ")").exec(fmt);
                if (ret) {
                    fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
                };
            };
            return fmt;
    },
    post:function(url,json,func){
             $.ajax({
               url:url,
               type:"POST",
               dataType: 'json',
               contentType: 'application/json',
             data:JSON.stringify(json),
             success:function(resp){
                    if(resp.code =="0000"){
                        func(resp.data)
                    }else{
                        toastr.error(resp.msg)
                    }
                }
             });
         }
};

//$.ajax({
//      url:"../user/login",
//      type:"POST",
//      dataType: 'json',
//      contentType: 'application/json',
//    data:JSON.stringify({
//        username:$("#username").val(),
//        password:$("#password").val()
//    }),
//    success:function(data){
//        //alert(data.code+" "+data.msg);
//        if(data.code == SUCCESS){
//            $(location).attr('href', '/page/index');
//        }else{
//
//        }
//    }
//    });

