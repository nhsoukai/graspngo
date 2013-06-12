<html>
<head>
<link href="fic_style.css" rel="stylesheet">
<meta charset=utf-8>
<title>Menu</title>
</head>
<body>
<fieldset>
<legend> Menu list </legend> <br/>
<table><tr>
<div style="width:100%; text-align:center;">
<TABLE BORDER="4"   width="1000" align="center" >

<TR class ="champ" ALIGN="CENTER">
<TH class="nonvalide"> Delete </th><th> Modify </th><th> Id </th><th> Name </th>
<th> Type </th><th> From </th><th> to </th><th> Frequency </th><th> Quantity </th></tr>
<?php 
$db= mysql_connect("localhost","root","root");
$connexion=mysql_select_db("yumyum",$db);
$requete1="SELECT `food`.`id`,`food`.`name`,`food`.`type`,`food`.`from`,`food`.`to`,`food`.`frequency`
FROM `yumyum`.`food` GROUP by `name`";
$resultat1=mysql_query($requete1);

while( $ligne = mysql_fetch_array($resultat1))
{ 
$name=$ligne['name'];
$type=$ligne['type'];

echo "<tr><td ALIGN='CENTER'>
        <a href='deleted.php?name=".$ligne['name']."'>
         <image width=20 height=20  src=photos/drop.png></a></td>";

echo "<td ALIGN='CENTER'>
        <a href='modify.php?id=".$ligne['id']."'>
         <image width=20 height=20  src=photos/edit.png></a></td>";
echo "<td ALIGN='CENTER'> ".$ligne['id']." </td>";
echo "<td ALIGN='CENTER'>".$ligne['name']."</td>";
echo "<td ALIGN='CENTER'>".$ligne['type']."</td>";
echo "<td ALIGN='CENTER'>".$ligne['from']."</td>";
echo "<td ALIGN='CENTER'>".$ligne['to']."</td>";
echo "<td ALIGN='CENTER'>".$ligne['frequency']." min</td>";
$req2="SELECT count(*) FROM foodItem WHERE food_id LIKE ".$ligne['id'].";";
$res=mysql_query($req2);
$res2=mysql_fetch_array($res);
echo "<td width=50 ALIGN='CENTER'>".$res2['count(*)']."</td>";
echo "<td ><a href='plusQt.php?id=".$ligne['id']."'>
         <image width=20 height=20  src=photos/plus.png></a><a href='minusQt.php?id=".$ligne['id']."'>
         <image width=20 height=20  src=photos/minus.png></a></td>";

echo "</tr>";
}
mysql_close($db);
?>
</table>
</fieldset>
</br>
</br>
<fieldset>
<legend> Add new dish </legend>
<form action="added.php" method="post"> 
<table><tr>
<TABLE BORDER="4" ALIGN="CENTER" cellpadding="2" >
<TR class ="champ" ALIGN="CENTER" >
<TH class="nonvalide"> Name </th>
<th> Type </th><th> From (hh:mm:ss)</th><th> To (hh:mm:ss) </th><th> Every (min) </th></tr>

<tr><td><input type="text" name="name" size="10"/></td>

<td><input type="radio" name="type" value="drink"/>Drink <input type="radio" name="type" value="food"/>Food </td>
<td><input type="text" name="from" size="13"/></td> <td><input type="text" name="to" size="8"/></td><td><input type="text" name="frequency" size="3"/>min</td>
<td/>
<input type="submit" name="add"/> <tr/>

</table>

<br/>
</fieldset>
</body>
</html>
