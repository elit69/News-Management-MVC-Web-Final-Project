function getResult(e){$.post("listnewscategorybymonthly.json",{c_code:window.location.search.substr(4),limit:countItems,offset:e},function(t){if(t.length>0){for(var s="",a=0;a<t.length;a++)""==t[a].news_path&&(t[a].news_path="article?id="+t[a].news_id),s+="<div class='card-1 col-sm-12 clear-paddings' id='"+t[a].news_id+"'><a href='"+t[a].news_path+"' target='_blank' id='link-1'><div class='col-md-4 col-sm-4 col-xs-4 clear-paddings'><div class='card-1-image' style='background-image: url("+t[a].news_img+"), url(img/404.jpg);' alt='item slider'></div></div><div class='col-md-8 col-sm-8 col-xs-8 card-details pull-right '><h5 class='text-h5-2 article-title' id='title-1'>"+t[a].news_title+"</h5><p class='text-3 news-description' id='des-1'>"+t[a].news_desc+"</p><div class='col-md-12 col-sm-12 col-xs-12 clear-paddings news-info' id='info-1'>អាន "+t[a].count_visited+" | "+t[a].news_published_date+" | "+t[a].full_name+"</div></div></a></div>";s+="<ul class='pager clear-padding-right'><li class='previous'><a href='#' class='btn btn-lg btn-primary'>ទំព័រមុខ</a></li><li class='next'><a href='#' class='btn btn-lg btn-primary'>ទំព័រក្រោយ</a></li></ul>",$("#panelCategory").html(s),t.length<countItems&&($(".next a").addClass("disabled"),$("body").off("click",".next a")),0==e&&($(".previous a").addClass("disabled"),$("body").off("click",".previous a"))}})}$("[id="+window.location.search.substr(4)+"]").attr("class","active"),$("body").on("click",".previous",function(){getResult(pageNumber-=countItems)}),$("body").on("click",".next",function(){getResult(pageNumber+=countItems)});var cat_code=window.location.search.substr(4),countItems=15,pageNumber=0,owl=$("#owl-demo");owl.owlCarousel({autoPlay:5e3,loop:!0,pagination:!1,slideSpeed:300,items:1,responsive:!0,responsiveRefreshRate:200,responsiveBaseWidth:window,itemsDesktop:[1199,1],itemsDesktopSmall:[979,1],itemsTablet:[750,1],afterMove:function(){var e=$(".cate-title");$(".cate-title").removeClass("category-title-active"),$(e[this.owl.currentItem]).addClass("category-title-active")}}),$.post("showNewsCategoryTop.json",{c_code:window.location.search.substr(4)},function(e){for(var t="",s="",a=0;a<e.length;a++)""==e[a].news_path&&(e[a].news_path="article?id="+e[a].news_id),t+="<div class='item'><div class='owl-image' style='background-image: url("+getBigImage(e[a].news_img)+"), url(img/404.jpg)'></div><div class='news-title-background'><p class='owl-desc clear-margin-bottom'>"+e[a].news_desc+"</p></div></div>",s+="<div class='cate-title' id='"+e[a].news_id+"'><a href='"+e[a].news_path+"' class='text-h5-2'  target='_blank'>"+e[a].news_title+"</a></div>";$(".category-head-left").html(s),owl.data("owlCarousel").addItem(t);var i=$(".cate-title");$(i[0]).addClass("category-title-active")});