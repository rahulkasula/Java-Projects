<?php
$servername = "localhost";
$username = "root";
$password = "1234";
$dbname = "rahul";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

//	$appliance = $_POST["appliance"];
//	$power = $_POST["powerconsumption"];
//	$st = $_POST["start"];
  //      $ed = $_POST["end"];
$appliance = "motor";
$power = "1234";
$st = "5";
$ed = "12";
$sql = "UPDATE utility 
            SET powerconsumption = ' ".$power. "',
            start = '".$st."',
            end = '".$ed." '
            WHERE appliance='" . $appliance;
if ($conn->query($sql) === TRUE) {
    echo "update";
} else {
    echo "Error updating record: " . $conn->error;
}

$conn->close();
?>