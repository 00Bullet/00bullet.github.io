
window.addEventListener("load",()=>{
let button = document.getElementById("formulario");
let usuario = document.getElementById("usuario");
let password = document.getElementById("password");
let alert = document.getElementById("alerta");
function data(){
let datos = new FormData();
datos.append('usuario',usuario.value);
datos.append('password',password.value);
 	fetch('validar.php',{method: "POST", body: datos })

 	.then(Response => Response.json())
 	.then(({success}) => {
 		if (success === 1){
 			location.href = "inicio.php";

 		}else{

 			alerta();

 		}



 		});
}

function alerta(){
	alert.innerHTML = '<div class="alert alert-danger alert-dismissible fade show" role="alert"><strong>Datos Incorrectos</strong><button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>';
}

button.addEventListener('submit',(e )=>{
	e.preventDefault();

	data();

});

});