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



<div class="row">
    <form class="col s12" method="POST" action="message">
      <div class="row">
        <div class="input-field col s12">
          <textarea id="textarea1" class="materialize-textarea"></textarea>
          <label for="textarea1">Textarea</label>
        </div>
      </div>
    </form>
  </div>






    <p>
    	Messages
    </p>




    <div class="col s4 offset-s4">
        <table class="highlight">
            <c:forEach items="${messages}" var="message">
                <tr>
                    <td><c:out value="${message.text}"/></td>
                    <td><c:out value="${message.time}"/></td>
                </tr>
            </c:forEach>
        </table>


        <a href="create">Create user</a>



    </div>
</div>
</body>
</html>