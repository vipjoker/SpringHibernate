<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
<head>
 <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">

  <!-- Compiled and minified JavaScript -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>

	<title>Home</title>
</head>
<body>

<div class="container">

    <h1>
    	Hello world!
    </h1>

    <div class="col s4 offset-s4">
        <table class="highlight">
            <c:forEach items="${items}" var="item">
                <tr>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.description}"/></td>
                </tr>
            </c:forEach>
        </table>


        <a href="create">Create user</a>



    </div>
</div>
</body>
</html>