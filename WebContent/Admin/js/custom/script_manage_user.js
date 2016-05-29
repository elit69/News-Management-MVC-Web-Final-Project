/*------------script for focus on menu -------------- */
$("#usermenu").removeClass("parent").addClass("active");
/* $("#usermenu").addClass("active" ); */
$.post("userinfolist.json", function(data) {
	$("#listdetial").html(tblistArticle(data));

	/* sarin load data table */
	$('#list').dataTable({
		"lengthMenu" : [ [ 5, 10, 30, -1 ], [ 5, 10, 30, "All" ] ]
	});

});
$.post("usertypelist.json", function(data) {
	$("#usertype").html(usertypeDropList(data));
});
/* Function Add option to select tag */
function usertypeDropList(data) {
	var str = "";
	for (var i = 0; i < data.length; i++) {
		str += "<option value=" + data[i].user_type + ">" + data[i].user_type;
	}
	str += "</optiont>";
	return str;
}
/* Function Create table For listing User */
function tblistArticle(data) {
	var str = "";
	for (var i = 0; i < data.length; i++) {

		str += "<tr>" + "<td id=cat_code" + data[i].user_id + ">"
				+ data[i].user_name + "</td>" + "<td>" + data[i].user_type
				/*+ "</td>" + "<td style='text-align: center;' >" + btnAction(i)*/
				+ "</td>" + "<td style='text-align: center;' >" + changestatus(data[i].user_status,data[i].user_id)
				+ "</td>" + "</tr>";
	}
	return str;
}
/*function btnAction(i) {  sarin edit button to disable and enable 
	var btn = "<button class='btn btn-success btn-xs' id='btnenable" + i + "'>"
			+ "<i class='fa fa-thumbs-up'></i>"
			+ "&nbsp;&nbsp;Enable</button>&nbsp;"
			+ "<button class='btn btn-danger btn-xs delete' id='btndisable" + i
			+ "'>"
			+ "<i class='fa fa-thumbs-down'></i>&nbsp;&nbsp;Disable</button>";
	return btn;
}*/
$("#adduser").click(function() {
	var name = $("#username").val();
	var pwd = $("#repassword").val();
	var usrtype = $("#usertype option:selected").val();
	if(name == "" || pwd == "" || usrtype==""){return;}
	else{
	$.post("useradd.json", {
		user_name : name,
		user_pass : pwd,
		user_type : usrtype
	}, function(data, status) {
		
	});
	}
	//alert(222);

});




/* method changestatus for change value to Icon Active  Or Deactive  sarin */	
/* Sarin */
function changestatus(data,id){ 
	var str="";
	if(data){
		str+="<a style=' cursor:pointer;'><img src='img/t.png' style='width:30px;height:30px' id="+id+" status='"+data+"' user_id='"+id+"' onclick='checkstatus(this)' /></a>";
		
	}
	else{
		str+="<a style='cursor:pointer;'><img src='img/f.png' style='width:30px;height:30px' id="+id+" status='"+data+"'  user_id='"+id+"' onclick='checkstatus(this)' /></a>";
		
	}
	return str;
} 


/*method checkstatus for  upadate status on databases*/
var statusAction=true;
function checkstatus(data){
	
	 var status=$(data).attr("status");			 
	  var userid=$(data).attr("user_id");
	  if(status=="true"){
		  $("#"+$(data).attr("id")).attr("src","img/f.png"); 
		  $(data).attr("status","false");	
		  status="flase";
	  }else{
		  $("#"+$(data).attr("id")).attr("src","img/t.png");
		  $(data).attr("status","true");
		  status="true";
	  }
	 /* if(status){
		 status=0;
	 }
	else{
		 status=1;
	 } */
	//alert(statusAction);
	  $.post("editUserstatus.json", {
		    user_id : userid,
			user_status : status,
		}, function(data2,status) {
			
		});    
} 

