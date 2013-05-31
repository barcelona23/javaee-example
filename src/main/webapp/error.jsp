<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <title>Ooops Error</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>
<body>
Ha ocurrido un error en la aplicacion :<%=exception.getMessage()%>
Error Interno:<%=exception.getCause().getMessage()%>
</body>
</html>