<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Favorite;

class FavoriteController extends Controller
{
    //
    public function getFavorites()
    {
        $favorites = Favorite::all();
        return response()->json($favorites);
    }
    
    public function addFavorite(Request $request)
    {
        $favorite = new Favorite;
        $favorite->surah_id = $request->surah_id;
        $favorite->name= $request->name;
        $favorite->english_name = $request->english_name;
        $favorite->save();
    }

    public function removeFavorite(Request $request, $id)
    {
        $favorite = Favorite::where('surah_id', $id)->first();
        if ($favorite) {
            $favorite->delete();
            return response()->json('Deleted');
        } else {
            return response()->json('Item not found', 404);
        }
    }
        }


