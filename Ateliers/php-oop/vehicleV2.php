<?php

abstract class Vehicle {
 public $Brand;
 public $Color;
 
  public function Presentation(){
    return 'is vehicle ';
 }
}
 interface IVehicleManagement   {

     public function Add($data);
     public function Remove($data);
}
 class VehicleManagement implements IVehicleManagement  {
    static $counter = 0;
     public function Add($data)
    {
        self::$counter++;
    }
     public function Remove($data){
        self::$counter--;
     }
}

class Car extends Vehicle {

    function __construct($brand,$color)
    {
        $this->Brand = $brand;
        $this->Color = $color;

        return [$this->Brand ,$this->Color ] ;
    }
    public function Presentation(){
      return 'is car';

    }

}
class Motorcycle  extends Vehicle {
    public function Presentation(){
        return 'is motorcycle';
      }
}

// test program
$car = new Car('Ford','Blue');
$motorcycle = new Motorcycle;
$motorcycle->Brand= 'Harley-Davidson';
$motorcycle->Color= 'Black';

$management = new VehicleManagement;

$management->Add($car);
$management->Add($motorcycle);
$management->Add($motorcycle);

echo VehicleManagement::$counter ."<br>";// echo :
$management2 = new VehicleManagement;
$management2->Add($car);
$management2->Add($motorcycle);

echo VehicleManagement::$counter."<br>";//output : 
echo $car->Presentation() ."<br>" ;// is car
echo $motorcycle->Presentation();// is motorcycle
?>