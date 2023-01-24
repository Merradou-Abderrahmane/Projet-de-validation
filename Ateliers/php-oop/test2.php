<?php

abstract class Person {
 public $Nom;
 public $Prenom;
 
  public function Presentation(){
    return 'is person ';
 }
}
 interface IGestionPerson   {

     public function Ajouter($data);
     public function Supprimer($data);
}
 class GestionPerson implements IGestionPerson  {
    static $compteur = 0;
     public function Ajouter($data)
    {
        self::$compteur++;
    }
     public function Supprimer($data){
        self::$compteur--;
     }
}

class Formateur extends Person {

    function __construct($nom,$prenom)
    {
        $this->Nom = $nom;
        $this->Prenom = $prenom;

        return [$this->Nom ,$this->Prenom ] ;
    }
    public function Presentation(){
      return 'is formateur';

    }

}
class Stagiaire  extends Person {
    public function Presentation(){
        return 'is stagiare';
      }
}

// programme test
$formateur = new Formateur('madani','ali');
$stagiaire = new Stagiaire;
$stagiaire->Nom= 'chami';
$stagiaire->Prenom= 'mouad';

$gestion = new GestionPerson;

$gestion->Ajouter($formateur);
$gestion->Ajouter($stagiaire);
$gestion->Ajouter($stagiaire);

echo GestionPerson::$compteur ."<br>";//echo :
$gestion2 = new GestionPerson;
$gestion2->Ajouter($formateur);
$gestion2->Ajouter($stagiaire);

echo GestionPerson::$compteur."<br>";//output : 
echo $formateur->Presentation() ."<br>" ;// is formateur
echo $stagiaire->Presentation();// is stagiare
?>