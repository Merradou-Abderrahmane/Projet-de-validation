<?php
abstract class Vehicle
{
    protected $brand;
    protected $color;
    protected $year;
    protected $licensePlate;
    protected static $counter = 0;

    public function __construct($brand, $color, $year, $licensePlate)
    {
        $this->brand = $brand;
        $this->color = $color;
        $this->year = $year;
        $this->licensePlate = $licensePlate;
        self::$counter++;
    }

    public function getBrand()
    {
        return $this->brand;
    }

    public function getColor()
    {
        return $this->color;
    }

    public function getYear()
    {
        return $this->year;
    }

    public function getLicensePlate()
    {
        return $this->licensePlate;
    }

    public static function getTotalVehicles()
    {
        return self::$counter;
    }
}

class Audi extends Vehicle {
    public function __construct($brand, $color, $year, $licensePlate)
    {
        parent::__construct($brand, $color, $year, $licensePlate);
    }
}

class Mercedes extends Vehicle {
    public function __construct($brand, $color, $year, $licensePlate)
    {
        parent::__construct($brand, $color, $year, $licensePlate);
    }
}

interface VehicleManagementInterface {
    public function addVehicle(Vehicle $vehicle);
    public function deleteVehicle(Vehicle $vehicle);
    public function getTotalVehicles();
    public function displayVehicles();
}

class VehicleManagementImplementation implements VehicleManagementInterface{
    private $vehicles = array();

    public function addVehicle(Vehicle $vehicle)
    {
        array_push($this->vehicles, $vehicle);
    }

    public function deleteVehicle(Vehicle $vehicle)
    {
        $key = array_search($vehicle, $this->vehicles);
        if ($key !== false) {
            unset($this->vehicles[$key]);
        }
    }

    public function getTotalVehicles()
    {
        return count($this->vehicles);
    }

    public function displayVehicles()
    {
        foreach ($this->vehicles as $vehicle) {
            echo "I'm a " . $vehicle->getBrand() . " "  . " with license plate: " . $vehicle->getLicensePlate() . ", color: " . $vehicle->getColor() . " and year: " . $vehicle->getYear() . PHP_EOL;
        }
    }
}

$audi = new Audi("A4", "black", "2020", "ABC 123");
$mercedes = new Mercedes("S-Class", "white", "2019", "DEF 456");

$management = new VehicleManagementImplementation();
$management->addVehicle($audi);
$management->addVehicle($mercedes);
$management->deleteVehicle($audi);

echo "Total vehicles: " . $management->getTotalVehicles() . PHP_EOL;
$management->displayVehicles();