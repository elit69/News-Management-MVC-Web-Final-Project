function createTable(data) {
	 var str="";
	 for (var i = 0; i < data.myArrayList.length; i++) {
		str+="<tr><td>"+data.myArrayList[i].map.user_name +"</td><td>" + data.myArrayList[i].map.user_type +"</td>";
		str+="<td style='text-align:center;'>"+actionbutton()+"</td></tr>";
	 } 
	return str;  
}  

function list(){
	$.post("list.news", function(data,staus) {
		$("#listdetial").html(createTable(data));
		$('#list').dataTable({	
		});
		
	});
}
list();

/*$("#adduser").click(function() {
	var username=$("#username").val();
	var password=$("#password").val();
	var usertype=$("#usertype option:selected").val();
	$.post("index.news", {
		user_name : username,
		user_pass : password,
		user_type : usertype
	}, function(data, status) {
		alert(status);
	});
});*/


function actionbutton(){
	var btn="<div class='form-group'>";
	btn+="<button type='button' class='btn btn-success'  onclick='EditOption(this)'>";		
	btn+="<span class='glyphicon glyphicon-edit'></span></button><span style='margin-left:10px'></span>";
	btn+="<button type='button' class='btn btn-danger'  onclick='DeleteOption(this)'>";
	btn+="<span class='glyphicon glyphicon-trash'></span></button></div>";
	return btn;
}

$("#file_image").change(function(){
    readURL(this);
  
});

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
        	$('#img_thumnail').attr('src', e.target.result).fadeIn('slow');
        };
        reader.readAsDataURL(input.files[0]);
    }
}
