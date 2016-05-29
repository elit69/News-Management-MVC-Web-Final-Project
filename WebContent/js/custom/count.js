$('body').on('click', '.news-title-background, .card-1, .card-2, .list-group-item',
		function() {			
			if(!$.cookie($(this).attr('id'))){
				$.post("countview.json", { newid : $(this).attr('id') });
				$.cookie($(this).attr('id'), true);
				var str = $(this).find('.news-info').text().split(' | ');
				var str1 = str[0].split(' ');
				str1[1]++;
				str[0] = str1.join(' ');
				$(this).find('.news-info').text(str.join(' | '));
			}
		});

//code to clear all cookie
/*var cookies = $.cookie();
for(var cookie in cookies) {
   $.removeCookie(cookie);
}*/