<?php
	//$username=$_GET['username'];
	//$password=$_GET['password'];
	$username=$_POST['username'];
	$password=$_POST['password'];
	$conect = mysql_connect('localhost','root','');
	mysql_select_db('swsdb',$conect);
	$sql="select * from users where username='$username' and type='$password'";
	$result = mysql_query($sql) or die ("Erro. :" . mysql_error());
	
	if (mysql_num_rows($result)>0){
		echo '1';
		
	}
	else{
		echo '0';
		
	}
?>