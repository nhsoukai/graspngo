<?php
//turn off error reporting
error_reporting(E_ALL ^ E_NOTICE ^ E_WARNING);

//Create fields for the database
//server, username, password, database

$dbhost = "localhost"; //92.4.131.132 //127.0.0.1 //10.0.2.2
$dbuser = "root";
$dbpass = "root";
$dbdb = "yumyum";

//connect to mySQL
$connect = mysql_connect($dbhost, $dbuser, $dbpass) or die("connection error");

//Select the database
mysql_select_db($dbdb) or die("database selection error");


$requete="SELECT id, name, type, price FROM `yumyum`.`food` WHERE id in(SELECT food_id from `yumyum`.`foodItem`) ";
$resultat=mysql_query($requete);

$rows = array();
while($r = mysql_fetch_assoc($resultat)) {
    $rows[] = $r;
}

echo json_encode($rows);
mysql_close($db);


?>