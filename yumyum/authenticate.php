<?php

$dbhost = "localhost"; //92.4.131.132 //127.0.0.1 //10.0.2.2
$dbuser = "root";
$dbpass = "root";
$dbdb = "yumyum";

//connect to mySQL
$connect = mysql_connect($dbhost, $dbuser, $dbpass) or die("connection error");

//Select the database
mysql_select_db($dbdb)or die("database selection error");

//Retrieve the login details via POST
$username = $_POST['user'];
$password = $_POST['pass'];

//Query the table android login
$query = mysql_query("SELECT * FROM login WHERE user='$username' AND pass='$password'");

//check if there any results returned
$num = mysql_num_rows($query);
if ($num>0)

   header( 'Location: http://localhost:8888/yumyum/yumhome.php' ) ;

else 

	header( 'Location: http://localhost:8888/yumyum/panel.php' ) ;
	?>