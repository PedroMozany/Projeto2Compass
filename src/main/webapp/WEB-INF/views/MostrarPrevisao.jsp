<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center ">PREVISÃO DO TEMPO</h1>
<h4 style="font-family: 'Arial Black';text-align: center">${cidade.nome}</h4>


<div style="padding-left: 500px">
    <c:forEach items="${periodo}" var="tempo">
        <fmt:formatDate value="${tempo.data}" pattern="dd/MM/yyyy"/> |
        ${tempo.previsao.temp} | MININA: ${tempo.previsao.tempMin} | MAXIMA: ${tempo.previsao.tempMax}<br>
    </c:forEach>
</div>


<form style="padding-left: 500px" class="row g-3" action="PrevisaoJson" method="post">
    <div  class="col-md-6">
        <input type="hidden" name="name" value="${cidade.nome}">
        <input type="hidden" name="var" value="${periodo}">
    </div>
    <div style="padding-left: 200px" class="col-12">
        <button class="btn btn-primary" type="submit">JSON</button>
    </div>
</form>

</body>
</html>
