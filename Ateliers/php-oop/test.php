<?php

abstract class Person {  
 public $Nom;
 public $Prenom;
 



   
}
 interface IGestionPerson   {
    
     public function Ajouter($data);
     public function Supprimer($data);
     public function afficherData();
    //  public function Compteur();

}
 class GestionPerson implements IGestionPerson  {
    public $compteur = 0;
    private  $list = array();
     public function Ajouter($data)
    {
        $this->compteur++;
    
        array_push($this->list,$data[0]);
       

    }
    // public function Compteur(){
    //     echo 'total person : '. $this->$compteur;
    // }

     public function Supprimer($data){
        $this->compteur--;
        
       $arraySearch= array_search($data[0],$this->list);
       
       \array_splice($this->list,$arraySearch,1);
     }
    public function afficherData(){
       
        $data =  $this->list;
        foreach($data as $value){
            echo $value['Nom'] .' '. $value['Prenom'].' '.$value['Type'] . '<br>';
        }
    }


}
class Formateur extends Person {
    function __construct($nom,$prenom,$age)
    {
        $value="is a formateur";
        $_data =["Nom"=>$nom,"Prenom"=>$prenom,"Age"=>$age];
        $_data['Type']=$value;         
        $_data= array($_data) ;
    // var_dump($_data);
    // die();
        return $_data ;
    }
    // public function Presentation($data){
    //     $value="is a formateur";
    //     $data['Type']=$value;         
    //   $_data= array($data) ;
    
    //     return $_data ;

    // }  
    
}
class Stagiaire  extends Person {
    public function Presentation($data){
        $value="is a stagiaire";
        $data['Type']=$value;         
      $_data= array($data) ;
    
        return $_data ;

    }  
}

$formateur = new Formateur('bilal',"merado",'32');
$Stagiaire = new Stagiaire;
$Gestion = new GestionPerson;
// $AddFormateur = $formateur->Presentation(["Nom"=>'bilal',"Prenom"=>"merado","Age"=>'32']);
// $StagiaireAdd =  $Stagiaire->Presentation(["Nom"=>'nada',"Prenom"=>"stitou","Age"=>'21']);
// $StagiaireAdd2 = $Stagiaire->Presentation(["Nom"=>'hicham',"Prenom"=>"mliki","Age"=>'21']);
$Gestion->Ajouter($formateur);
$Gestion->Ajouter($StagiaireAdd);
$Gestion->Ajouter($StagiaireAdd2);
// $Gestion->Supprimer($AddFormateur);
$Gestion->afficherData();
echo $Gestion->compteur;
// display constant conteur


?>