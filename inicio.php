
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="inicio.css">
	<title></title>
</head>
<body class="contenedor">
	<div class="box">
		<header class="encabezado"> bienvenido</header>
	</div>
							<aside class="primario">
							 <div class="d_box1"> <p>amigos</p>
							 	<?php

							 	
include("conexion.php");

	$consulta = "SELECT * FROM usuarios";

	$guardar = mysqli_query($conexion,$cosulta) or die(mysqli_error());
	
	while ($row = $resultado -> fecht_array()){

		$nickname = $row echo ["nickname"];

		?>	

		<p><?php echo $row echo ["nickname"];?></p>
		<?php
	
		?>							</div>	<div class="d_box2" >
											<div class="links"><a href="">Configuracin<img src="fondo/confi.png"></a></div> <br>
											<div class="links"><a href="">Ayuda<img src="fondo/help.png"></a></div><br>
											<div class="links"><a href="">Cerrar Sesion<img src="fondo/close.png"></div></a><br>
										</div>
							</aside>
			<nav class="navegacion" > 
				<nav class="buscar">
			<input type="text" name="buscar" placeholder="Buscar">
			<img class="n_icon" src=""></nav>
	</div>
</nav>
	<div class="rgb">
		<main class="principal"><h1></h1>
			<div class="p_img"><img src="fondo/img1.jpg" width="90%" height="90%">
				<div class="p_text"> <textarea class="comentarios"></textarea>
					<input class="e_boton" type="button" name="" value="Enviar">
				</div>
				
			</div>

		</main>
	</div>
	<aside class="secundario"><div class="d2_box1"><div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
				 <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="..." class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="..." class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="..." class="d-block w-100" alt="...">
				    </div>
				  </div>
					</div>
					</div>
					<div class="d2_box2">
						
					</div>
	</aside>
	<footer class="pie">
						<p class="n">Redes Sociales</p>
						<div class="img"><img src="fondo/F.png" width="60px" height="35px"></div>
						<div class="img"><img src="fondo/W.png" width="60px" height="35px"></div>
						<div class="img"><img src="fondo/I.png" width="60px" height="35px"></div>
						<p class="contacto">Contactanos Para Mas Servicios</p>
	</footer>

</body>
</html>