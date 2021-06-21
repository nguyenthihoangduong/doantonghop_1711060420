<?php
 include "connect.php";
 $page = $_GET['page'];
 //$idsp = $_POST['idsanpham']; 
 $idsp = 3;
 $space = 16; 
 $limit =($page -1 ) * $space;
 $mangsanpham = array();
$query ="SELECT * FROM sanpham where idsanpham = $idsp LIMIT  $limit,$space ";
$data = mysqli_query($conn,$query);
while ($row = mysqli_fetch_assoc($data)){
 array_push($mangsanpham,new Sanpham(
    $row['id'],
    $row['tensanpham'],
    $row['giasanpham'],
    $row['hinhanhsanpham'],
    $row['motasanpham'],
    $row['idsanpham']));
 }
echo json_encode($mangsanpham);
class Sanpham{
 function __construct($id,$tensanpham,$giasanpham,$hinhanhsanpham,$motasanpham,$idsanpham){
    $this->id=$id;
    $this->tensanpham=$tensanpham;
    $this->giasanpham=$giasanpham;
    $this->hinhanhsanpham=$hinhanhsanpham;
    $this->motasanpham=$motasanpham;
    $this->idsanpham=$idsanpham;
    } 
 }
?>