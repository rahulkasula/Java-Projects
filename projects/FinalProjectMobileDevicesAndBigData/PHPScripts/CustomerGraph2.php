<?php
   $dbhost = 'localhost';
   $dbuser = 'root';
   $dbpass = '1234';
   
   $conn = mysql_connect($dbhost, $dbuser, $dbpass);
   
   if(! $conn )
   {
      die('Could not connect: ' . mysql_error());
   }
 $usr=$_POST["username"];
//$usr="rahul";
   $sql = "SELECT * FROM temp WHERE username ='". $usr. "'";
   mysql_select_db('rahul');
   $retval = mysql_query( $sql, $conn );
   
   if(! $retval )
   {
      die('Could not get data: ' . mysql_error());
   }
//echo $usr;
   echo "[";
   while($row = mysql_fetch_array($retval, MYSQL_ASSOC))
   {

 echo json_encode($row);
echo ",";

      //echo "powerconsumption :{$row['powerconsumption']}  <br> ".
        // "start : {$row['start']} <br> ".
         //"end : {$row['end']} <br> ".
         //"--------------------------------<br>";
   }
   echo"]";
   echo "Fetched data successfully\n";
   
   mysql_close($conn);
?>