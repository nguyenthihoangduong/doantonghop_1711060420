<?php

    include "connect.php";
    $query ="SELECT * FROM loaiisanpham";
    $data = mysqli_query($conn,$query);
    $mangloaisanpham = array();
    while ($row = mysqli_fetch_assoc($data)){       
      array_push($mangloaisanpham,new Loaisp(
        $row['id'],
        $row['tenloaisanpham'],
        $row['hinhanhloaisanpham']));          
      }
      echo json_encode($mangloaisanpham);
  class Loaisp{
    function __construct ($id,$tenloaisanpham,$hinhanhloaisanpham){
      $this->id = $id;
      $this->tenloaisp= $tenloaisanpham;
      $this->hinhanhloaisanpham = $hinhanhloaisanpham;
    }
  }

 ?>

