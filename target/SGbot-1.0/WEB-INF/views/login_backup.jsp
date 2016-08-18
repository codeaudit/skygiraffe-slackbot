<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <h1>Simple Login Page</h1>
        <form id="login" action='<%=request.getContextPath()+"/skyg/login"%>' method="post">
            Username<input type="text" disabled name="userid" value='<%= (request.getParameter("EMAIL")==null || request.getParameter("EMAIL").isEmpty()) ? String.valueOf(request.getAttribute("EMAIL")): request.getParameter("EMAIL")%>'/>
            Password<input type="password" name="pswrd"/>
            <input type="button" onclick="check(this.form)" value="Login"/>
            <input type="reset" value="Cancel"/>
            <input type="hidden" name="SUID" value='<%= (request.getParameter("SUID")==null || request.getParameter("SUID").isEmpty()) ? String.valueOf(request.getAttribute("SUID")): request.getParameter("SUID")%>'/>
            <input type="hidden" name="EMAIL" value='<%= (request.getParameter("EMAIL")==null || request.getParameter("EMAIL").isEmpty()) ? String.valueOf(request.getAttribute("EMAIL")): request.getParameter("EMAIL")%>'/>
        </form>
        <script language="javascript">
            function check(form) { /*function to check userid & password*/
                document.getElementById("login").submit();
            }
        </script>
    </body>
</html>