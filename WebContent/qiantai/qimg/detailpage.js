// JavaScript Document

var detailPage = {
     dataArray:[],    
     prevText:'prev',
     nextText:'next',
     pageContentObj:null,
     contentContainerObj:null,
     init:function(strContent,breakPage,prevText,nextText,pageContentObj,contentContainerObj){
      //alert(strContent);
      //解决IE下，分页符变大写的情况
     // strContent=strContent.replace(breakPage.toUpperCase(),strContent);
     // alert(strContent);
        this.dataArray = strContent.split(breakPage);             
        this.prevText = prevText;
        this.nextText = nextText;
        this.pageContentObj = pageContentObj;
        this.contentContainerObj = contentContainerObj;
     },
     getPage:function(curPage)
     {
        
        var THIS = this;
        if(!curPage) curPage=1;
        //alert(detailPage.contentContainerObj);
    	
    	if(THIS.dataArray.length==1)
    	{	//不包含分页时，不显示分页标签	
            
    			return;
    	}
        
        THIS.contentContainerObj.html(THIS.dataArray[curPage-1]);
    	//显示翻页
    	var pageLabel='';
    	
    	if(curPage==1)
    	{
    		if(/http:\/\//.test(THIS.prevText))
    		{
    			pageLabel +='<img style="vertical-align:middle;" src="'+THIS.prevText+'" />　';
    		}
    		else
    		{
    			pageLabel +='<span>'+THIS.prevText+'</span>　';
    		}
    	}
    	else
    	{
    		if(/http:\/\//.test(THIS.prevText))
    		{
    			pageLabel +='<img style="vertical-align:middle; cursor:pointer;" onclick="javascript:detailPage.getPage('+eval(curPage-1)+')" src="'+THIS.prevText+'" />　';
    		}
    		else
    		{
    			pageLabel +='<a href="javascript:detailPage.getPage('+eval(curPage-1)+')">'+THIS.prevText+'</a>　';
    		}
    	}			
    		
    	for(var i=1;i<THIS.dataArray.length+1;i++)
    	{
    		if(i==curPage)
    			pageLabel +='<span class="current">'+i+'</span>　';	
    		else	
    			pageLabel += '<a href="javascript:detailPage.getPage('+i+')">'+i+'</a>　';				
    	}
       
        
    	if(curPage==THIS.dataArray.length)
    		if(/http:\/\//.test(THIS.prevText))
    		{
    			pageLabel +='<img style="vertical-align:middle;" src="'+THIS.nextText+'" />';
    		}
    		else
    		{
    			pageLabel +='<span>'+THIS.nextText+'</span>　';
    		}
    	else
    	{
    		if(/http:\/\//.test(THIS.prevText))
    		{
    			pageLabel +='<img style="vertical-align:middle; cursor:pointer;" onclick="javascript:detailPage.getPage('+eval(curPage+1)+')" src="'+THIS.nextText+'" />　';
    		}
    		else
    		{
    			pageLabel +='<a href="javascript:detailPage.getPage('+eval(curPage+1)+')">'+THIS.nextText+'</a>　';
    		}
    	}
    	THIS.pageContentObj.html(pageLabel);
     }
};