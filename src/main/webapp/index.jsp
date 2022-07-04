<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Busca Previsao</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body style="padding-top: 60px">
<h1 style="text-align: center"><%= "PREVISÃO DO TEMPO DAS CAPITAIS" %>
</h1>
<br/>
<form style="padding-left: 400px" class="row g-3" action="previsao" method="post">
    <div  class="col-md-6">
        <input type="text" class="form-control" placeholder="NOME DA CIDADE" name="nome" required>
    </div>
    <div style="padding-left: 200px" class="col-12">
        <button class="btn btn-primary" type="submit">FINALIZAR</button>
    </div>
</form>
</body>
</html>