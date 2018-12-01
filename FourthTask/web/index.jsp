<%--
  Created by IntelliJ IDEA.
  User: verdas
  Date: 18.11.18
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
      <title>Parsing XML</title>
  </head>
  <body>

  <form action="Controller" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="command" value="parse"/>
      <label> Введите парсер(DOM, SAX, StAX) :
        <input type="text" name="parser" size="10"/><br/>
        <input type="file" name="file" id="upload" accept=".xml"/><br/>
      </label>
        <input type="submit" value="OK"/><br/>

      ${errorLoginPassMessage}
  </form>
  </body>
</html>
