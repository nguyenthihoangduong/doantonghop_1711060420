<?php

    include "connect.php";
    $query ="SELECT * FROM dichvu";
    $data = mysqli_query($conn,$query);
    $mangdichvu = array();
    while ($row = mysqli_fetch_assoc($data)){       
      array_push($mangdichvu,new Dichvu(
        $row['id'],
        $row['tendichvu'],
        $row['hinhanhdichvu']));          
      }
      echo json_encode($mangdichvu);
  class Dichvu{
    function __construct ($id,$tendichvu,$hinhanhdichvu){
      $this->id = $id;
      $this->tendichvu= $tendichvu;
      $this->hinhanhdichvu = $hinhanhdichvu;
    }
  }

 ?>

