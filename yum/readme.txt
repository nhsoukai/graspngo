This is the client side of Yumyum project.
It uses Android SDK 4.2.2.
The application contains three activities:
In all of them we need to set connections to the server to receive/send data.
The connection to the server cannot be made in the main thread. Thus, we use a subclass extending AsyncTask to 
set the connection in the background.
"MainActivity" for authentifying. 
"DisplayMessageActivity" looks for the food that is still in stock and display the name and price of each
 in the a listView with a checkbox in each row. Then, send the id of the checked food to the next activity.
"Reservation" look for the earlier items of the ordered so as to estimate the time of availability. 
and delete this item from the "fooditem" table. 

