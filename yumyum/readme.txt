This is the server side of Yumyum project.
It uses web service and phpMyAdmin database.
The web pages under the folder 'yumyum' are:
authenticate.php for authentifying the administrator in order to redirect to yumhome.php.
yumhome.php: is the  iterface from which the admin can add food to the menu, modify and 
see the current situation of the stock.
the informations required for adding food are:
	-the name
	-the type
	-the time of availability (from/to)
	-the frequency of production
	-the price
the food is then added to database under phpMyAdmin in the food table with an auto-incremented index. 
At the same time, every single item of a product produced in a exact time between "from" and "to"
is stored in the table foodItem.
This will help later for estimating the time to take for the client.
andlogin.php, getmenu.php and reserve.php are reached by HTTP request from the android app.
The php script andlogin.php is for retrieving login data for the client. 
getmenu.php is for retrieving the list of food from database for the client. 
and reserve.php sends the time estimated for food availability and delete the corresponding item from database.