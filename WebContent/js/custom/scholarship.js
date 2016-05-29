$('#hdscholarship').attr("class","active");
$(document).ready(function(){
		$.post("scholarlist.json", function(data) {
			var str = "";
			for (var i = 0; i < data.length; i++) {

				str += "<tr><td id="+data[i].id+"><a href="+data[i].link+" target=_blank>" + data[i].title + "</a></td><td>"
						+ data[i].description + "</td><td>" + data[i].posted
						+ "</td><td>" + data[i].deadline
						+ "</td></tr>";
			}
			$("#tbscholarship").html(str);
			$('#listjob').dataTable({
				"lengthMenu" : [ [ 5, 10, 30, -1 ], [ 5, 10, 30, "All" ] ]
			/* Sarin add datatable */
			});
			
		});	
	});