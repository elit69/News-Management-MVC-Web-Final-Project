/*-------------------------- script for get text editor summernote
 * http://cdnjs.cloudflare.com/ajax/libs/summernote/0.5.1/summernote.min.js
 * http://cdnjs.cloudflare.com/ajax/libs/summernote/0.5.1/summernote.css
 * */
$.getScript('js/summernote_text_editor.js',
						function() {
							$('#news_con_detail').summernote({
								height : 300,
							});
						});

		$('#listarticle').dataTable();
		/* $("#adduser").click(function() {
			//alert($("#newstitle").val());
			$("#test").html($("#newsdescription").code());
		}); */
		
		
		/*------------script for focus on menu -------------- */
		 $("#main_menu_article").removeClass("parent" ).addClass("active parent" );
		//$("#main_menu_article").removeClass("parent" ).addClass("active" );
		$("#sub_menu_managearticle").addClass( "active" );