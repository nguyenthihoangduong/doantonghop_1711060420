<?php
 include "connect.php";
$mangspmoinhat = array();
$query ="SELECT * FROM sanpham ORDER BY ID DESC LIMIT 30 ";
$data = mysqli_query($conn,$query);
while ($row = mysqli_fetch_assoc($data)){
 array_push($mangspmoinhat,new Sanphammoinhat(
    $row['id'],
    $row['tensanpham'],
    $row['giasanpham'],
    $row['hinhanhsanpham'],
    $row['motasanpham'],
    $row['idsanpham']));
 }
echo json_encode($mangspmoinhat);
class Sanphammoinhat{
   function Sanphammoinhat($id,$tensanpham,$giasanpham,$hinhanhsanpham,$motasanpham,$idsanpham){
     $this->id=$id;
    $this->tensp=$tensanpham;
    $this->giasp=$giasanpham;
    $this->hinhanhsp=$hinhanhsanpham;
    $this->motasp=$motasanpham;
    $this->idsanpham=$idsanpham;
    } 
 }
?>