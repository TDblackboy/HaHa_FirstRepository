/**
 *  改变display
 */

$(document).ready(function(){
	$(".p-look").click(function(){
		$(".sea-di").css("display","block");
		$(".add-l").css("display","none");
	});
	$(".p-add").click(function(){
		$(".sea-di").css("display","none");
		$(".add-l").css("display","block");
	});
});