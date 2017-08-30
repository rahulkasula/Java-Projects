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
//$track=$_POST["track"]; 

//$track="a"; 
// Attempt select query execution
//$sql = "SELECT * FROM nodes where node1 is not null";
//$sql="select node1,node2 from nodes where node1 is not null and node2 is not null and tracking ='$track'";
$sql="SELECT * FROM utility";

if($result = mysqli_query($link, $sql)){
   $rows = array();
    if(mysqli_num_rows($result) > 0){
            while($row = mysqli_fetch_array($result)){
           $return_clean[] = array_filter($row); 
             //$rows[]= $row;
          
        }
       
        
        mysqli_free_result($result);
    } else{
        echo "No records matching your query were found.";
    }
} else{
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
}




 
// Close connection
mysqli_close($link);
//echo json_encode($rows);
echo json_encode($return_clean);



?>