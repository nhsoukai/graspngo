<html>
<head>
<link href="fic_style.css" rel="stylesheet">
<meta charset="utf-8">
<title>Food added</title>
</head>
<body>
<?php
$name=$_POST['name'];
$type=$_POST['type'];
$from=$_POST['from'];
$to=$_POST['to'];
$frequency=$_POST['frequency'];

$db= mysql_connect("localhost","root","root");
$connexion=mysql_select_db("yumyum",$db);



$requete="INSERT INTO `yumyum`.`food` (`id`, `name`, `type`,`from`,`to`,`frequency`) 
VALUES (NULL, '$name', '$type','$from','$to','$frequency');";

$resultat=mysql_query($requete) or die("err");
$id=mysql_insert_id();

$start=$from;
while ($start<$to) {
$requete1="INSERT INTO `yumyum`.`foodItem` (`id`, `time`, `status`,`food_id`) 
VALUES (NULL, '$start', 'available','$id');";

$resultat1=mysql_query($requete1) or die("err");
$start = date("H:i:s", strtotime("+".$frequency." min", strtotime($start)));
}
echo '<font color="#0FFF00" size="5" align="center">'.$name." added to menu".'</font>';

include "yumhome.php";


?>

</body>
</html>