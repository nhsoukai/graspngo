<html>
<head>
<link href="fic_style.css" rel="stylesheet">
<meta charset=utf-8>
<title>Ajouter une personne</title>
</head>
<body>
<form action="added.php" method="post">
<fieldset>
<legend> Add food </legend> <br/><br/><br/>
Name:<br/><input type="text" name="name" size="20"/> <br/>

Type: <br/><input type="radio" name="type" value="drink"/>Drink <input type="radio" name="type" value="food"/>Food <br/> 
<input type="submit" name="envoyer"/> <br/>

From:<br/><input type="text" name="from" size="8"/>
To:<br/><input type="text" name="to" size="8"/>
Frequency: <input type="text" name="frequency" size="2"/>min
<input type="submit" name="add"/> <tr/>
</fieldset>
</form>
</body>
</html>
