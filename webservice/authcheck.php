<?php
    	//$sdf=$_POST['a'];           
    	//echo "{'success':'done','res':'".$sdf."'}";
	
	$testUser = "123";



	$username = "root";
	$password = "";
	$hostname = "localhost"; 

	//connection to the database
	$dbhandle = mysql_connect($hostname, $username, $password) or die("Unable to connect to MySQL");


	//select a database to work with
	$selected = mysql_select_db("test",$dbhandle) or die("Could not select examples");

	//execute the SQL query and return records
	$result = mysql_query("SELECT * FROM user");

	//fetch tha data from the database
	while ($row = mysql_fetch_array($result)) {
		if($row['username'] == $testUser ){
			echo "found";
		}
	}
	//close the connection
	mysql_close($dbhandle);
?>
