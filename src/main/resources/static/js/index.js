/**
 * 系统主管理JS
 */

$(function(){
	//点击左面功能菜单处理，载入相应的代码段
	$("ul#exampleAccordion li a").on("click",function(event){
		var url=$(this).attr("href");
		$("div#content-wrapper").load(url);//载入对应的对象管理主页
		event.preventDefault();//停止对象的默认行为。
	});
});

