<?php
  mysql_connect("localhost","root","root");
  mysql_select_db("yumyum");
  $sql=mysql_query("select * from food where name like 'c%'");
  while($row=mysql_fetch_assoc($sql)) $output[]=$row;
  print(json_encode($output));
  mysql_close();
?>