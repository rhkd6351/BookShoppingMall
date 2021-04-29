
    $(function(){
    var slider = $(".slider");
    firstSlide = slider.find(".slide-img").first()
    .animate({'opacity':1},200);

    function nextSlide() {
    slider.find(".slide-img").first().appendTo(slider);
    slider.find(".slide-img").last().animate({'opacity':0}, 400);
    slider.find(".slide-img").first().animate({'opacity':1}, 400);
}

    function prevSlide() {
    slider.find(".slide-img").last().prependTo(slider);
    slider.find(".slide-img").eq(1).animate({'opacity':0}, 400);
    slider.find(".slide-img").first().animate({'opacity':1}, 400);
}

    var interval;
    function startSlide(){
    interval = setInterval(nextSlide,3000);
}
    function stopSlide(){
    clearInterval(interval);
}
    $(".content-aside-center").hover(function(){
    $(".arrow").first().animate({"opacity":1},100);
    $(".arrow").eq(1).animate({"opacity":1},100);
    stopSlide();
}, function(){
    $(".arrow").first().animate({"opacity":0},100);
    $(".arrow").eq(1).animate({"opacity":0},100);
    $(".arrow").attr("opacity", 0);
    startSlide();
});


    startSlide();

    $(".right").on("click",function(){
    nextSlide();
})
    $(".left").on("click",function(){
    prevSlide();
})

});