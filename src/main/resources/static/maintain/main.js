$(function(){	
	var productid=null;	
	var maintainStatus=null
	var processDate=null;
	var startDate=null;
	var endDate=null;
	//设置系统页面标题
	$("span#mainpagetille").html("维修管理");
	$("table#MaintainGrid").jqGrid({
		url: 'http://localhost:8080/Maintain/getListByAllWithPage',
		datatype: "json",
		styleUI: "Bootstrap",

		colModel: [
			{ label: '维修编号', name: 'productId', width:75 },
			{ label: '维修状态', name: 'maintainStatus',width:75 },  
			{ label: '维修记录', name: 'maintainNote',width:75 },  
			{ label: '检测记录', name: 'checkNote' ,width:75},  
			{ label: '维修工人', name: 'maintainMan' ,width:75},  
			{ label: '检测日期', name: 'processDate' ,width:75},  
			{ label: '维修器件', name: 'usedParts' ,width:75},  
			{ label: '工作量', name: 'workload' ,width:75},   
		],
		caption:"员工列表",
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
		pager: "#MaintainGridPager",
		onSelectRow:function(productId){
			productid=productId;
			//alert(productId);
		}
	});
	
	
	//点击检索事件处理
	$("a#MaintainSelectButton").on("click",function(){
		maintainStatus=$("select#maintainStatusSelection").val();
		startDate=$("input#startDate").val();
		endDate=$("input#endDate").val();
		if(startDate==""){
			startDate=null;
		}
		if(endDate==""){
			endDate=null;
		}
		reloadMaintainList();
	});
	
	
	//设置检索参数，更新jQGrid的列表显示
	function reloadMaintainList()
	{
		$("table#MaintainGrid").jqGrid('setGridParam',{postData:{maintainStatus:maintainStatus,startDate:startDate,endDate:endDate}}).trigger("reloadGrid");
		
	}

	//维修任务删除
	$("a#delete").off().on("click",function(){
		if(productid==null){
			alert("请选择客户");//
		}else{
			alert(666666);
			$.ajax({
				type: 'delete',
				url: 'Maintain/delete',
				data: {productId:productid},//'ids='+arr+'&_method=delete',
				success: function(data){
					// alert(data.message);
					reloadMaintainList();
					alert(555);
				},
				error: function(data){
					alert(2);
				}
			});
		}
	});
});








