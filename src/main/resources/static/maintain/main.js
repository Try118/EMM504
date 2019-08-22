$(function(){	
	var productid=null;	
	//设置系统页面标题
	$("span#mainpagetille").html("维修管理");
	$("table#MaintainGrid").jqGrid({
		url: 'http://127.0.0.1:8080/Maintain/getListByAllWithPage',
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
			alert(productId);
		}
	});

	

});








