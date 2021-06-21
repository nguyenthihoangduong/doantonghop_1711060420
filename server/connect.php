<?php
$host="localhost";
$username="root";
$password="";
$database="thucungpetpro";
$conn = mysqli_connect($host,$username,$password,$database);
mysqli_query($conn,"SET NAMES 'utf8'");
// if($conn){
//     echo "kết nối thành công";
// }else{
//     echo"kết nối thất bại";
// }

?>
