$(function(){	
	var clientId=null;		
	var zip_code=null;
	var client_property=null;
	$("table#ClientGrid").jqGrid({
		url: 'http://127.0.0.1:8080/product/news/condition',
		datatype: "json",
		styleUI: "Bootstrap",
		colModel: [
			{ label: '维修编号', name: 'productId', key:true },
			{ label: '客户编号', name: 'clientId' },
			{ label: '产品类型', name: 'productType' },
			// { label: '机器品牌', name: 'machineRank' },
			// { label: '机器型号', name: 'machineModel' },
			// { label: '系列号', name: 'serialNum' },
			// { label: '缺少零件', name: 'shortagePart' },
			// { label: 'HDD', name: 'hdd' },
			// { label: '内存', name: 'memory' },
			// { label: '外置PC卡', name: 'pcCard' },
			// { label: 'AC适配器', name: 'acAdapter' },
			// { label: '电池', name: 'cell' },
			// { label: '外接光驱', name: 'cdRom' },
			// { label: '外接软驱', name: 'fd' },
			// { label: '开机口令', name: 'startPassword' },
			// { label: '重要资料', name: 'importData' },
			// { label: '其他', name: 'other' },
			{ label: '故障现象及错误码', name: 'machineFault' },
			{ label: '故障类型', name: 'faultType' },
			{ label: '机器外观检查', name: 'outerCheck' },
			{ label: '预约价格', name: 'bookPrice' },
			{ label: '接机日期', name: 'rcvDate' },
			{ label: '报修产品登记状态', name: 'loginStatus' },
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
		      id: "productId"},
		pager: "#ClientGridPager",
		onSelectRow:function(productId){
			clientId=productId;
			// alert(clientId);
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
			alert(clientId);
			$.ajax({
				type: 'delete',
				url: 'product/news',
				data: {productId:clientId},//'ids='+arr+'&_method=delete',
				success: function(data){
					// alert(data.message);
					reloadList();
				},
				error: function(data){
					alert(2);
				}
			});
		}
	});

	//客户管理-修改
	$("button#update").off().on("click",function(){
		if(clientId==null){
			alert("请选择客户");
		}else{
			$.get("product/news",{productId:clientId},function(ResultMessage){
				if(ResultMessage.status=="OK"){
					alert(ResultMessage.message);
					$("div#dialog_client").load("product/update.html",function(){
						$(function(){
							$("div#dialog_client").dialog({
								title:"维修产品管理-修改",
								width:750			
							});
						});
						$("input[name='productId']").val(ResultMessage.list[0].productId);
						$("input[name='loginStatus']").val(ResultMessage.list[0].loginStatus);
						$("button#subkkk").off().on("click",function(){
							var product = $("input[name='productId']").val();
							var status  = $("input[name='loginStatus']").val();
							$.ajax({
								type: 'PUT',
								url: 'product/news',
								data: {productId:product,loginStatus:status},//'ids='+arr+'&_method=delete',
								success: function(data){
									// alert(data.message);
									// alert(11111);
									$("div#dialog_client").dialog("close");
									//$("div#dialog_client").dialog("destory");
									$("div#dialog_client").html("");
									reloadList();
								},
								error: function(data){
									alert(2);
								}
							});
						});
					});					
				}
			});
		}
	});




	//客户管理-注册
	$("button#add").off().on("click",function(){
		$("div#dialog_client").load("product/add.html",function(){
			$(function(){
				$("div#dialog_client").dialog({
					title:"保修信息-添加",
					width:750			
				});
			});		
			//验证数据			
			$(function(){
				$("form#createForm").validate({
					rules:{
						productId:{
							required:true
						},
						clientId:{
							required:true
						},
						loginStatus:{
							required:true
						},
						rcvDate:{
							required:true
						},
						machineFault:{
							required:true
						}
					},
					messages:{
						productId:{
							required:"必填"
						},
						clientId:{
							required:"必填"
						},
						loginStatus:{
							required:"必填"
						},
						rcvDate:{
							required:"必填"
						},
						machineFault:{
							required:"必填"
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








