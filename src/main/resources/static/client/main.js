//客户管理-注册
$("button#add").off().on("click",function(){
	$("div#dialog_client").load("client/add.html",function(){		
		$(function(){
			$("div#dialog_client").dialog({
				title:"客户管理-注册",
				width:750			
			});
		});		
		//验证数据
		
		$(function(){
			$("form#createForm").validate({
				rules:{
					client_id:{
						required:true
					},
					identify_id:{
						required:true
					}
				},
				messages:{
					client_id:{
						required:"客户编号为空"
					},
					identify_id:{
						required:"身份证号为空"
					}
				}
			});
		});
		//拦截表单提交
		$(function(){
			$("form#createForm").ajaxForm(function(ResultMessage){
				alert(ResultMessage.message);
//				BootstrapDialog.show({
//					title:'客户管理',
//					message:'sadada'
//				});
				$("div#dialog_client").dialog("close");
				$("div#dialog_client").dialog("destory");
				$("div#dialog_client").html("");
			});
		});
	});
});


