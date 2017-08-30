
<?php
mysql_connect("localhost","root","1234");

mysql_select_db("rahul");
$user_name=$_POST["login_name"];
$user_pass=$_POST["login_pass"];
//$user_name="rahul";
//$user_pass="rahul";
/*$q = sprintf("SELECT * FROM userlist 
    WHERE username='%s' AND userpass='%s'",
    mysql_real_escape_string($user_name),
    mysql_real_escape_string($user_pass));
*/
$q = "SELECT * FROM userlogin WHERE username ='". $user_name. "' and"." password='".$user_pass."'";
   // mysql_real_escape_string($user_pass));



$result = mysql_query($q);


/*if (empty($result)) {
echo "success";
   
    $message .= 'Whole query: ' . $query;
    die($message);
}*/


while ($row = mysql_fetch_assoc($result)) {
 echo "login";
//.$row['name']
  // echo $row['username'].",";
   //echo $row['tracking'].",";
   // echo $row['userpass'];
    
}


mysql_free_result($result);

mysql_close();
?>