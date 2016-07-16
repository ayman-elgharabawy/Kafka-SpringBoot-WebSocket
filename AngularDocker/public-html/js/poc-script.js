$(document).ready(function() {
});


function Animate_progressbar(id, value) {
    var Complete_ID;
    Complete_ID = "#" + id;
    $(Complete_ID).animate({
        width : value + "%"
    }, {
        easing : 'linear',
        duration : 5000,
        step : function(current_width) {
            if (current_width <= 15) {
                $(Complete_ID).parent().parent().find('.progress-bar_left_TXT').css('color', '#fff');
            } else if (current_width < 15 && current_width <= 50) {
                $(Complete_ID).addClass('progress-bar-success');
            } else if (current_width > 50 && current_width <= 75) {
                $(Complete_ID).removeClass('progress-bar-success');
                $(Complete_ID).addClass('progress-bar-warning');
                 $(Complete_ID).parent().parent().find('.progress-bar_ruler').css('background-position', '0 -98px');
            } else if (current_width > 75 && current_width <= 100) {

                if (current_width == 100) {
                    //alert('100');
                    $(Complete_ID).parent().parent().find('.progress-bar_right_TXT').css('color', '#fff');
                }
                $(Complete_ID).removeClass('progress-bar-warning');
                $(Complete_ID).addClass('progress-bar-danger');
                 $(Complete_ID).parent().parent().find('.progress-bar_ruler').css('background-position', '0 -109px');
            };
        }
    });
};

