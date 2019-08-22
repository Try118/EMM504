$(function(){	
	var clientId=null;		
	var zip_code=null;
	var client_property=null;
	$("table#ClientGrid").jqGrid({
		url: 'http://127.0.0.1:8080/client/getListByAllWithPage',
		datatype: "json",
		styleUI: "Bootstrap",
		colModel: [
			{ label: '客户编号', name: 'client_id', key:true },
			{ label: '身份证号', name: 'identify_id' },  
			{ label: '客户送机时间', name: 'rec_time' },  
			{ label: '客户属性', name: 'client_property' },  
			{ label: '单位名称', name: 'unit_name' },  
			{ label: '座机', name: 'phone_number' },  
			{ label: '移动电话', name: 'mobile_number' },  
			{ label: '客户地址', name: 'client_address' },  
			{ label: '邮编', name: 'zip_code' },  
			{ label: '联系人', name: 'connect_people' },  
			{ label: 'Email', name: 'email' },  
		],
		viewrecords: true, 
		autowidth: true,
		height: 400,
		rowNum: 10,
		rowList:[10,20,30],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "client_id"},
		pager: "#ClientGridPager",
		onSelectRow:function(client_id){
			clientId=client_id;
			//alert(clientId);
		}
	});

	function reloadList()
	{
		$("table#ClientGrid").jqGrid('setGridParam',{postData:{zip_code:zip_code,client_property:client_property}}).trigger("reloadGrid");
	}


	//客户管理-删除
	$("button#delete").off().on("click",function(){
		if(clientId==null){
			alert("请选择客户");
		}else{
			$.post("client/delete",{client_id:clientId},function(ResultMessage){
				if(ResultMessage.status=="OK"){
					alert(ResultMessage.message);
					reloadList();
				}
			});
		}
	});
	//客户管理-修改
	$("button#update").off().on("click",function(){
		if(clientId==null){
			alert("请选择客户");
		}else{
			$.post("client/getByClientId",{client_id:clientId},function(ResultMessage){
				if(ResultMessage.status=="OK"){
					//alert(ResultMessage.message);					
					$("div#dialog_client").load("client/update.html",function(){
						$(function(){
							$("div#dialog_client").dialog({
								title:"客户管理-修改",
								width:750			
							});
						});
						$("input[name='client_id']").val(ResultMessage.model.client_id);
						$("input[name='identify_id']").val(ResultMessage.model.identify_id);
						$(function(){
							$("form#updateForm").ajaxForm(function(ResultMessage){
								if(ResultMessage.status=="OK"){
									alert(ResultMessage.message);
									//刷新List
									reloadList();
								}else{
									alert("修改客户失败");
								}
								$("div#dialog_client").dialog("close");
								//$("div#dialog_client").dialog("destory");
								$("div#dialog_client").html("");
								//reloadList();
							});
						});
					});					
				}
			});
		}
	});
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
					reloadList();
	//				BootstrapDialog.show({
	//					title:'客户管理',
	//					message:'sadada'
	//				});
					$("div#dialog_client").dialog("close");
					//$("div#dialog_client").dialog("destory");
					$("div#dialog_client").html("");
				});
			});
		});
	});
	
	//填充邮编下拉框
	$.post("client/getZipCode",function(ResultMessage){
		if(ResultMessage.status=="OK"){
			//alert(ResultMessage.message);
			var list = ResultMessage.list;
			if(list){
				$.each(list,function(index,cm){
					$("div#div_zip_code").append("<a class='dropdown-item' href='#' id='"+cm.zip_code+"'>"+cm.zip_code+"</a>");
					//下拉框选择邮编
					$("div#div_zip_code a").off().on("click",function(){
						zip_code = $(this).attr("id");
						//reloadList();
					});
				});
			}
		}
	});
	
		
	//下拉框选择客户属性
	$("div#div_client_property a").off().on("click",function(){
		client_property = $(this).attr("id");
		//alert(client_property);
		//reloadList();
	});
	
	//查询按钮
	$("button#btn_select").off().on("click",function(){
		reloadList();
	});
});








