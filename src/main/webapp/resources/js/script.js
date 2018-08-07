var button_top = $('.button_top');

$(window).scroll(function () {
    ($(this).scrollTop() > 177)
        ? button_top.css('opacity', 1)
        : button_top.css('opacity', 0);
});

button_top.click(function () {
    $('html, body').animate({scrollTop: 0}, 'slow');
});

$('#button-tema').click(function(){
    $('#cadastrar-tema').toggle();
});

$('#button-postagem').click(function(){
    $('#cadastrar-postagem').toggle();
});
