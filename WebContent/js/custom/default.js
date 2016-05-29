function getBigImage(link){
	if(link.search(/.\d\d\dx\d\d\d/)!=-1)
		return link.replace(/.\d\d\dx\d\d\d/, "");
	if(link.search(/w=\d\d\d&h=\d\d\d/)!=-1)
		return link.replace(/w=\d\d\d&h=\d\d\d/, "");
	return link;
}

/*$(document).ready(function() {
    $("body").on("contextmenu",function(){
       return false;
    }); 
});*/