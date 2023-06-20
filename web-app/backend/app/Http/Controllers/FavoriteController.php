<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Favorite;
use GuzzleHttp\Client;

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
        $favorite->name = $request->name;
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

    function getAll()
    {
        $client = new Client();

        $response = $client->request('GET', 'http://api.alquran.cloud/v1/surah');

        $surahs = json_decode($response->getBody(), true);

        $array = array();
        foreach ($surahs['data'] as $value) {
            $array[] = array("number" => $value['number'], "name" => $value['name'], "englishNameTranslation" => $value['englishNameTranslation']);
        }
        return $array;
    }

    function store(Request $request)
    {
        $favorite = new Favorite;
        $favorite->surah_id = $request->number;
        $favorite->name = $request->name;
        $favorite->english_name = $request->englishNameTranslation;
        $favorite->save();

        return true;
    }
    function  ListFavorite()
    {
        $favorites = Favorite::all();
        return $favorites;
    }
    function  delete($id)
    {
        $favorites = Favorite::where('surah_id', $id)->delete();
        return true;
    }
}
