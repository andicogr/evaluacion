$(function(){
	baseURL = $("#baseURL").val();
	console.log("baseURL: " + baseURL);
});

function buscarCliente(){
	$.get(baseURL + "/api/cliente?nombre=" + $("#nombreCliente").val() + "&email=" + $("#correoCliente").val(), function(respuesta){
		console.log(respuesta);
		
		$("#contenido").html("Id: " + respuesta.id + "Nombre: " + respuesta.name + " - Correo: " + respuesta.correo);
		
		$("#idFormulario").val(respuesta.id);
		$("#idClienteEliminar").val(respuesta.id);
		$("#nameFormulario").val(respuesta.name);
		$("#correoFormulario").val(respuesta.correo);
		
	});
}

function listarClientes(){
	$.get(baseURL + "/api/cliente/listar", function(lista){
		var listaClientes = "";
		for (var i = 0; i < lista.length; i++) {
			listaClientes += "Id: " + lista[i].id + "Nombre: " + lista[i].name + " - Correo: " + lista[i].correo + " <br>";
		}
		$("#contenido").html(listaClientes);
	});
}

function eliminarCliente(){
	$.get(baseURL + "/api/cliente/eliminar?idCliente=" + $("#idClienteEliminar").val());
}

function obtenerEdad(){
	var fecha = $("#fecha").val();
	
	fecha = new Date(fecha);
	
	var diferencia = new Date().getTime() - fecha.getTime();
	console.log(diferencia);
	console.log(diferencia / (1000 * 3600 * 24 * 365));
	
	 $("#edad").val(parseInt(diferencia / (1000 * 3600 * 24 * 365)));
	 
	 $.get(baseURL + "/api/cliente/edad?fecha=" + $("#fecha").val(), function(respuestaEdad){
		 console.log("Edad Desde Java: " + respuestaEdad);
	 });
}


