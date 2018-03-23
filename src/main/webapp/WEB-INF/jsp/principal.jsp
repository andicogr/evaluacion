<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<input type="hidden" id="baseURL" value="<c:url value='/' />" />

Fecha Nacimiento: <input type="text" id="fecha" onchange="obtenerEdad()"/>
Edad: <input type="text" id="edad" value="0">

<hr>

Nombre: <input type="text" id="nombreCliente" value="admin"/>
<br>
Correo: <input type="text" id="correoCliente" value="admin@admin.com"/>

<input type="button" value="Buscar" onclick="buscarCliente()">

<input type="button" value="Buscar" onclick="listarClientes()">

<hr>
<div id="contenido"></div>
<hr>
Insertar
<form action="<c:url value='/' />api/cliente/insertar" method="post">
ID: <input type="text" name="id" value=""/>
<br>
Nombre: <input type="text" name="name" value=""/>
<br>
Correo: <input type="text" name="correo"value=""/>

<button type="submit">Guardar</button>
</form>

<hr>
Actualizar
<form action="<c:url value='/' />api/cliente/actualizar" method="post">
ID: <input type="text" name="id" id="idFormulario" value=""/>
<br>
Nombre: <input type="text" name="name" id="nameFormulario" value=""/>
<br>
Correo: <input type="text" name="correo" id="correoFormulario" value=""/>

<button type="submit">Guardar</button>
</form>

<hr>

ID Cliente Eliminar: <input type="text" id="idClienteEliminar" value=""/>

<input type="button" value="Eliminar" onclick="eliminarCliente()">

<script src="resources/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="resources/js/principal.js" type="text/javascript"></script>
</body>
</html>
