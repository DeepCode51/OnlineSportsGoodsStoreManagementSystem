<%@ page contentType="text/html; charset=gb2312" %>
<%@page session="true"%>

<script>
	       var win=window;
            while(win.parent!=window.top)
            {
            	win=win.parent;
            }
            win.parent.location.replace("admin/login.jsp");  
</script>