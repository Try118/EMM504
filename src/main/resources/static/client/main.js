//客户管理-注册
$("button#add").off().on("click",function(){
	$("div#dialog_client").load("client/add.html",function(){
		
		$(function(){
			$("div#dialog_client").dialog({
				title:"客户管理-注册",
				width:750			
			});
		});
		
		$(function(){
			$("form#createForm").ajaxForm(function(){
				alert("注册成功");
			});
		});
	});
});


