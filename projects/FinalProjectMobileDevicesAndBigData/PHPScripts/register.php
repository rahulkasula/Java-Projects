


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

	$appliance = $_POST["appliance"];
	$power = $_POST["powerconsumption"];
	$st = $_POST["start"];
	$ed = $_POST["end"];
$usr=$_POST["username"];
//	$appliance = "motor";
//	$power = "2531";
//	$st = "5";
//	$ed = "12";
//$usr="rahul";

$sql = "insert into utility(appliance,powerconsumption,start,end,username) values('".$appliance."',".$power.",".$st.",".$ed.",'".$usr."')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>


