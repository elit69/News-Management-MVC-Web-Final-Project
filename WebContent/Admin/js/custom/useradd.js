 $('#list').dataTable({});
$(function() {
	
	function createTable(data) {
		var str = "";
		for (var i = 0; i < data.myArrayList.length; i++) {
			str += "<tr><td>" + data.myArrayList[i].map.user_name + "</td><td>"
					+ data.myArrayList[i].map.user_type + "</td>";
			str += "<td style='text-align:center;'>" + actionbutton()
					+ "</td></tr>";
		}
		return str;
	}

	function list() {
		$.post("list.news", function(data, status) {
			$("#listdetial").html(createTable(data));
			$('#list').dataTable({
				  "lengthMenu": [[5, 10, 30, -1], [5, 10, 30, "All"]]
			});
		});
	}
	list();

	$("#adduser").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var usertype = $("#usertype option:selected").val();
		if(username == "" || password == "" || usertype==""){return;}
		else{
		$.post("useradd.news", {
			user_name : username,
			user_pass : password,
			user_type : usertype
		}, function(data, status) {
			
		});
		}
		/*
		 * $.post("index.news", { user_name : username, user_pass : password,
		 * user_type : usertype }, function(data, status) { alert(status); });
		 */
	});

	function actionbutton() {
		var btn = "<div class='form-group'>";
		btn += "<button type='button' class='btn btn-success'  onclick='EditOption(this)'>";
		btn += "<span class='glyphicon glyphicon-edit'></span></button><span style='margin-left:10px'></span>";
		btn += "<button type='button' class='btn btn-danger'  onclick='DeleteOption(this)'>";
		btn += "<span class='glyphicon glyphicon-trash'></span></button></div>";
		return btn;
	}

	$("#wizard-picture").change(function() {
		readURL(this);
	});

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#wizardPicturePreview').attr('src', e.target.result).fadeIn(
						'slow');
			};
			reader.readAsDataURL(input.files[0]);
		}
	}
});



