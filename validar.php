
<?php 
header('Access-Control-Allow-Origin: *');
header("Access-Control-Allow-Headers: X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS, PUT, DELETE");
header("Allow: GET, POST, OPTIONS, PUT, DELETE");


include ("conexion.php");

if (isset($_POST['usuario']) && !empty($_POST['usuario']) && isset($_POST['password']) && !empty($_POST['password'])){
	$usuario = $_POST['usuario'];
	$password = $_POST['password'];

	$query = "SELECT * FROM usuarios WHERE (usuario = '$usuario' && contraseña = '$password')";
	$result = mysqli_query($conexion,$query);
	if(mysqli_num_rows($result)>0){
      
		echo json_encode(array('success' => 1));

	}else{
		echo json_encode(array('success' => 0));
}

}

 ?>