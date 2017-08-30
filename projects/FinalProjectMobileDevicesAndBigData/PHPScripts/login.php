
<?php
mysql_connect("localhost","root","1234");

mysql_select_db("userlist");
$user_name=$_POST["login_name"];
$user_pass=$_POST["login_pass"];
//$user_name="ra";
//$user_pass="ra";

/*$q = sprintf("SELECT * FROM userlist 
    WHERE username='%s' AND userpass='%s'",
    mysql_real_escape_string($user_name),
    mysql_real_escape_string($user_pass));
*/
$q = sprintf("SELECT userlist.username, packagedetails.tracking
FROM userlist, packagedetails
WHERE userlist.username= packagedetails.username AND userlist.username = '%s'",
    mysql_real_escape_string($user_name));
   // mysql_real_escape_string($user_pass));



$result = mysql_query($q);


/*if (empty($result)) {
echo "success";
   
    $message .= 'Whole query: ' . $query;
    die($message);
}*/
/*if(empty(mysql_fetch_assoc($result))){
echo "failed";
}*/

while ($row = mysql_fetch_assoc($result)) {
  echo "welcome";
//.$row['name']
//   echo $row['username'].",";
   //echo $row['tracking'].",";
   // echo $row['userpass'];
    
}


mysql_free_result($result);

mysql_close();
?>