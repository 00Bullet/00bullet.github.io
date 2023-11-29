<?php 
header('Access-Control-Allow-Origin: *');
header("Access-Control-Allow-Headers: X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS, PUT, DELETE");
header("Allow: GET, POST, OPTIONS, PUT, DELETE");



$conexion = mysqli_connect("127.0.0.1","root","","log-in");

if (!$conexion){

die("no pudo conectarse a la base de datos ".mysqli_error());    
           } else {
                
               
            }
 ?>