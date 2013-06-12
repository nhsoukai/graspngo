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

//Retrieve the login details via POST
$id = $_POST['id'];


$query1=mysql_query("SELECT MIN(time) FROM `yumyum`.`foodItem` where  `foodItem`.`food_id` LIKE $id");
$rows = array();
while($r = mysql_fetch_assoc($query1)) {
    
    $output = $r['MIN(time)'];

        //encode the returned data in JSON format
        echo $output;
        $query2=mysql_query("DELET FROM `yumyum`.`foodItem` where  `foodItem`.`time` LIKE $output");
}

?>