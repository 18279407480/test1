
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


   <div id="wsMsg" className="msgDialog msgDiv">
                      <div className="msgContent"  ><a onClick ={this.closeMsg}> X&nbsp;</a></div>
                        {this.state.wsMessage}
                   </div>
</body>
<script>

</script>
</html>
