<% 
    String message = (String) session.getAttribute("msg");
    if (message != null) {
        if (message.contains("Successfully")) {
%>    
            <span style="color: green"><p class="server-message"><%= message %></p></span>
<%
        } else {
%>
            <span style="color: red"><p class="server-message"><%= message %></p></span>
<%
        }
        session.removeAttribute("msg");
    }
%>
