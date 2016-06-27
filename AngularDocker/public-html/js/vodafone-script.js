$(document).ready(function() {
	//responsiveScript();
    //check_placeHolder();
    //check_radioButton();
    //Animate_progressbar('testbar', '100');
	//Animate_progressbar('testbar2', '50');
	//Animate_progressbar('testbar3', '20');
	//Animate_progressbar('testbar4', '75');
	//Animate_progressbar('testbar5', '10');
    //custom_pagination();
});

//$(window).resize(function() {
//	responsiveScript();
//});
//
//function responsiveScript() {
//	if (document.documentElement.clientWidth >= 0 && document.documentElement.clientWidth <= 640) {
//		$('.UDB_Buy_Add_Ons_Main_Carousel').slick({
//			lazyLoad : 'ondemand',
//			slidesToShow : 1,
//			slidesToScroll : 1,
//			autoplay : true,
//			//centerMode: true,
//			//centerPadding: '40px',
//			autoplaySpeed : 3000,
//			dots : true,
//			pauseOnDotsHover : true
//		});
//		$(".ShowConformationAddSpace").click(function() {
//			$(".UDB_Conformation_AddSpace").css('display', 'block');
//			$(".Overlay_Contant_all").css('display', 'none');
//		});
//		$(".First_Tap").click(function() {
//			$(this).addClass('UDB_Tabs_inner_active');
//			$('.Sec_Tap').removeClass('UDB_Tabs_inner_active');
//			$('.Third_Tap').removeClass('UDB_Tabs_inner_active');
//			$(".Show_Time_Base_Bundle").css('display', 'block');
//			$(".Show_Mobile_Internet_Bundle").css('display', 'none');
//			$(".Show_Black_Berry_Bundle").css('display', 'none');
//		});
//		$(".Sec_Tap").click(function() {
//			$(this).addClass('UDB_Tabs_inner_active');
//			$('.First_Tap').removeClass('UDB_Tabs_inner_active');
//			$('.Third_Tap').removeClass('UDB_Tabs_inner_active');
//			$(".Show_Time_Base_Bundle").css('display', 'none');
//			$(".Show_Mobile_Internet_Bundle").css('display', 'block');
//			$(".Show_Black_Berry_Bundle").css('display', 'none');
//		});
//		$(".Third_Tap").click(function() {
//			$(this).addClass('UDB_Tabs_inner_active');
//			$('.First_Tap').removeClass('UDB_Tabs_inner_active');
//			$('.Sec_Tap').removeClass('UDB_Tabs_inner_active');
//			$(".Show_Time_Base_Bundle").css('display', 'none');
//			$(".Show_Mobile_Internet_Bundle").css('display', 'none');
//			$(".Show_Black_Berry_Bundle").css('display', 'block');
//		});
//		$(".Show_Success").click(function() {
//			$(".Show_Success_MSG").css('display', 'block');
//			$(".Show_main_MSG").css('display', 'none');
//			$(".AddSpace_Overlay").css('display', 'none');
//		});
//		$(".Next_Step").click(function() {
//			$(this).parents(':eq(2)').find(".OnDemand_Renewal").css('display', 'block');
//			$(this).parents(':eq(2)').find(".UDB_Buy_Add_Ons_Category_Options").css('display', 'none');
//		});
//		$(".step_Back").click(function() {
//			$(this).parents(':eq(2)').find(".OnDemand_Renewal").css('display', 'none');
//			$(this).parents(':eq(2)').find(".UDB_Buy_Add_Ons_Category_Options").css('display', 'block');
//		});
//	};
//	if (document.documentElement.clientWidth >= 641 && document.documentElement.clientWidth <= 1024) {
//	};
//	if (document.documentElement.clientWidth >= 1025) {
//		$('.UDB_Buy_Add_Ons_Main_Carousel').slick({
//			lazyLoad : 'ondemand',
//			slidesToShow : 4,
//			slidesToScroll : 1,
//			autoplay : true,
//			//centerMode: true,
//			//centerPadding: '40px',
//			autoplaySpeed : 3000,
//			dots : true,
//			pauseOnDotsHover : true
//		});
//
//		$(".ShowConformationAddSpace").click(function() {
//			$(".UDB_Conformation_AddSpace").css('display', 'block');
//			$(".Overlay_Contant_all").css('display', 'none');
//		});
//		$(".First_Tap").click(function() {
//			$(this).addClass('UDB_Tabs_inner_active');
//			$('.Sec_Tap').removeClass('UDB_Tabs_inner_active');
//			$('.Third_Tap').removeClass('UDB_Tabs_inner_active');
//			$(".Show_Time_Base_Bundle").css('display', 'block');
//			$(".Show_Mobile_Internet_Bundle").css('display', 'none');
//			$(".Show_Black_Berry_Bundle").css('display', 'none');
//		});
//		$(".Sec_Tap").click(function() {
//			$(this).addClass('UDB_Tabs_inner_active');
//			$('.First_Tap').removeClass('UDB_Tabs_inner_active');
//			$('.Third_Tap').removeClass('UDB_Tabs_inner_active');
//			$(".Show_Time_Base_Bundle").css('display', 'none');
//			$(".Show_Mobile_Internet_Bundle").css('display', 'block');
//			$(".Show_Black_Berry_Bundle").css('display', 'none');
//		});
//		$(".Third_Tap").click(function() {
//			$(this).addClass('UDB_Tabs_inner_active');
//			$('.First_Tap').removeClass('UDB_Tabs_inner_active');
//			$('.Sec_Tap').removeClass('UDB_Tabs_inner_active');
//			$(".Show_Time_Base_Bundle").css('display', 'none');
//			$(".Show_Mobile_Internet_Bundle").css('display', 'none');
//			$(".Show_Black_Berry_Bundle").css('display', 'block');
//		});
//		$(".Show_Success").click(function() {
//			$(".Show_Success_MSG").css('display', 'block');
//			$(".Show_main_MSG").css('display', 'none');
//			$(".AddSpace_Overlay").css('display', 'none');
//		});
//		$(".Next_Step").click(function() {
//			$(this).parents(':eq(2)').find(".OnDemand_Renewal").css('display', 'block');
//			$(this).parents(':eq(2)').find(".UDB_Buy_Add_Ons_Category_Options").css('display', 'none');
//		});
//		$(".step_Back").click(function() {
//			$(this).parents(':eq(2)').find(".OnDemand_Renewal").css('display', 'none');
//			$(this).parents(':eq(2)').find(".UDB_Buy_Add_Ons_Category_Options").css('display', 'block');
//		});
//		$(".Repurchase_Action").click(function() {
//			$('MI,body').animate({
//			scrollTop : 10000
//		}, 1000);
//		});
//		$(".Goto_TimeBased_Tab").click(function() {
//			$('.First_Tap').addClass('UDB_Tabs_inner_active');
//			$('.Sec_Tap').removeClass('UDB_Tabs_inner_active');
//			$('.Third_Tap').removeClass('UDB_Tabs_inner_active');
//			$(".Show_Time_Base_Bundle").css('display', 'block');
//			$(".Show_Mobile_Internet_Bundle").css('display', 'none');
//			$(".Show_Black_Berry_Bundle").css('display', 'none');
//			$('MI,body').animate({
//			scrollTop : 0
//		}, 1000);
//		});
//
//
//		};
//};
//function custom_pagination(){
//    $('.pagination-page-num').on('click',function(){
//        $('.pagination').children('li').removeClass('active-page').removeClass('pagination-active-page');
//        $(this).toggleClass('active-page');
//        if($(this).hasClass('active-page')){
//            $(this).addClass('pagination-active-page');
//        };
//    });
//};
//function check_radioButton() {
//    if (navigator.userAgent.search("MSIE") >= 0) {
//        $(function() {
//            $('input:radio, input:checkbox').change(function() {
//                //this.blur();
//                //this.focus();
//                //alert('test');
//                //$(this).parent().find('label').css('font-weight', 'bold');
//            });
//        });
//    };
//};
//function check_placeHolder() {
//    if (navigator.userAgent.search("MSIE") >= 0) {
//        $('input[placeholder]').each(function() {
//            var input = $(this);
//            if (input.val() == '' || input.val() == input.attr('placeholder')) {
//                input.val(input.attr('placeholder'));
//            };
//            $(input).focus(function() {
//                if (input.val() == input.attr('placeholder')) {
//                    input.val('');
//                };
//            });
//            $(input).blur(function() {
//                if (input.val() == '' || input.val() == input.attr('placeholder')) {
//                    input.val(input.attr('placeholder'));
//                };
//            });
//        });
//    };
//};

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
                //$(Complete_ID).parent().parent().find('.Flex_Remaining_TXT').css('color', '#fff');
                //$('.Flex_ConsumedAndRemaining_TXT').css('color', '#fff');
            };
        }
    });
};

