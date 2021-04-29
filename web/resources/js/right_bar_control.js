$(window).scroll(function(){ //오른쪽 컨텐츠 스크롤시 고정
    var height = $(document).scrollTop();
    if(height >= 235){
        $(".content-aside-right").css("position","fixed").css("margin-left","1120px").css("top","10px");
    }else{
        $(".content-aside-right").css("position","relative").css("margin-left","0").css("top","0");
    }
})