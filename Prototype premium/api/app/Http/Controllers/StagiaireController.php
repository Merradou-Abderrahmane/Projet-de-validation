<?php

namespace App\Http\Controllers;

use App\Models\Stagiaire;
use Illuminate\Http\Request;

class StagiaireController extends Controller
{
    //
    public function search($nom)
    {
     return Stagiaire::where('nom', 'like', $nom.'%')->get();
    }
}
