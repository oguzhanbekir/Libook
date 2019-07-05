<?php
include_once 'connection.php';
	
	class User {
		
		private $db;
		private $connection;
		
		function __construct() {
			$this -> db = new DB_Connection();
			$this -> connection = $this->db->getConnection();
		}
		
		public function does_user_exist($okulNo,$password)
		{
			$query = "Select * from users where okulNo='$okulNo' and password = '$password' ";
			$result = mysqli_query($this->connection, $query);
			if(mysqli_num_rows($result)>0){
				$json['success'] = ' Welcome '.$okulNo;
				echo json_encode($json);
				mysqli_close($this -> connection);
			}else{
				$query = "insert into USERS (okulNo, password) values ( '$okulNo','$password')";
				$inserted = mysqli_query($this -> connection, $query);
				if($inserted == 1 ){
					$json['success'] = 'Acount created';
				}else{
					$json['error'] = 'Wrong password';
				}
				echo json_encode($json);
				mysqli_close($this->connection);
			}
			
		}
		
	}
	
	
	$user = new User();
	if(isset($_POST['okulNo'],$_POST['password'])) {
		$okulNo = $_POST['okulNo'];
		$password = $_POST['password'];
		
		if(!empty($okulNo) && !empty($password)){
			
			$encrypted_password = md5($password);
			$user-> does_user_exist($okulNo,$password);
			
		}else{
			echo json_encode("you must type both inputs");
		}
		
	}
?>