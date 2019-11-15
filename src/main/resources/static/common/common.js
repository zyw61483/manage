var SUCCESS = "0000";
var zyw = {
    checkInput:function(value,errMsg){
        if(typeof value == "undefined" || value == null || value == ""){
            toastr.error(errMsg)
            return true
        }
        return false
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
                        alert(resp.msg)
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

