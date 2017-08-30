<?php
/*
Attempt MySQL server connection. Assuming you are running MySQL
server with default setting (user 'root' with no password)
*/
$link = mysqli_connect("localhost", "root", "1234", "rahul");
 
// Check connection
if($link === false){
    die("ERROR: Could not connect. " . mysqli_connect_error());
}
	$appliance = $_POST["appliance"];
//	$power = $_POST["powerconsumption"];
//	$st = $_POST["start"];
  //    $ed = $_POST["end"];
//$appliance = "motor";
//$power = "1234";
//$st = "5";
//$ed = "12";
 
// Attempt update query execution
$sql = "delete from utility where appliance='" . $appliance."'";
if(mysqli_query($link, $sql)){
    echo "Records were updated successfully.";
} else {
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
}
 
// Close connection
mysqli_close($link);
?>