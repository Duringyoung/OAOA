 $(function() {
            $(".nav-ul").on("click", "li", function() {
                var sId = $(this).data("id"); //获取data-id的值
                window.location.hash = sId; //设置锚点
                loadInner(sId);
            });
  
            function loadInner(sId) {
                var sId = window.location.hash;
                var pathn, i;
                switch(sId) {
                    case "#yuangong":
                        pathn = "user_center.html";
                        i = 0;
                        break;　　　　　　　
                    case "#bumen":
                        pathn = "user_account.html";
                        i = 1;
                        break;
                    case "#fuli":
                        pathn = "user_trade.html";
                        i = 2;
                        break;
                    case "#zhaopin":
                        pathn = "user_info.html";
                        i = 3;
                        break;　　　　　　
                    default:
                        pathn = "user_center.html";
                        i = 0;
                        break;
                }
           
                $("#zhujiemian").load(pathn,function(response,status,xhr){
                	　　if(xhr.status == 404){
                	　　　　$(this).load("404.html");
                	　　}
                	　　if(xhr.status == 500){
                	　　　　$(this).load("500.html");　　　
                	　　}
                	});
                $(".nav-ul li").eq(i).addClass("current").siblings().removeClass("current"); //当前列表高亮
            }
            var sId = window.location.hash;
            loadInner(sId);
        });
