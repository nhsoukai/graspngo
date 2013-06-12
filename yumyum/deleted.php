<html>
<head>
<meta charset="utf-8">
<link href="fic_style.css" rel="stylesheet">
<title>Deleted food</title>
</head>
<body>

<?php
$name=$_POST['name'];
$db= mysql_connect("localhost","root","root");
$connexion=mysql_select_db("yumyum",$db);

$requete="DELETE FROM `yumyum`.`food` WHERE `food`.`name` = '$name' LIMIT 1";

$resultat=mysql_query($requete) or die("err");
echo "</br></br>$name is deleted from menu.";
include "yumhome.php";
?>

<br/></br>
<a href="delete.php" > Delete other food </a>
<br/>
<a href="home.php" > Back to Home </a><br/>

</body>
</html>