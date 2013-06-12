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
$username = $_POST['user'];
$password = $_POST['pass'];

//Query the table android login
$query = mysql_query("SELECT * FROM login WHERE user='$username' AND pass='$password'");

//check if there any results returned
$num = mysql_num_rows($query);

//If a record was found matching the details entered in the query
if($num == 1){
    //Create a while loop that places the returned data into an array
    while($list=mysql_fetch_assoc($query)){
        //Store the returned data into a variable
        $output = $list;

        //encode the returned data in JSON format
        echo json_encode($output);

    }
    //close the connection
    mysql_close();


}

?>