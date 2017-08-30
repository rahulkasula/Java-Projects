<?php
$db_user="root";
$db_pass="1234";
$db_host="localhost";
$db_name="rahul";
$mysqli=new mysqli($db_host,$db_user,$db_pass,$db_name);
if(mysqli_connect_errno()){
printf("connect failed: %s\n",mysqli_connect_error());
exit();
}
$usr=$_POST["username"];
//$usr="rahul";
$mysqli->query("set names 'utf8'");
$sql="SELECT * FROM utility WHERE username ='". $usr. "'";
//"SELECT * FROM utility WHERE username ='". $usr. "'"
$result=$mysqli->query($sql);
while($e=mysqli_fetch_assoc($result)){
$output[]=$e;
}
print(json_encode($output));
$mysqli->close();
?>