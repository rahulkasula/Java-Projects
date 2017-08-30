
<?php
mysql_connect("localhost","root","1234");

mysql_select_db("rahul");
$user_name=$_POST["login_name"];

//$user_name="ac";
//$user_pass="rahul";
/*$q = sprintf("SELECT * FROM userlist 
    WHERE username='%s' AND userpass='%s'",
    mysql_real_escape_string($user_name),
    mysql_real_escape_string($user_pass));
*/
$q = "SELECT * FROM utility WHERE appliance ='". $user_name. "'";
   // mysql_real_escape_string($user_pass));



$result = mysql_query($q);


/*if (empty($result)) {
echo "success";
   
    $message .= 'Whole query: ' . $query;
    die($message);
}*/


while ($row = mysql_fetch_assoc($result)) {
// echo "login";
//.$row['name']
   echo $row['powerconsumption'].",";
   echo $row['start'].",";
   echo $row['end'].",";
    
}


mysql_free_result($result);

mysql_close();
?>