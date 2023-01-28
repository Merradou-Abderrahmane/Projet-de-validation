<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\SurahController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});
// get all surahs favorite
Route::get('/surahs', [SurahController::class, 'getFavorite']);
Route::post('/surahs', [SurahController::class, 'addFavorite']);
Route::delete('/surahs/{id}', [SurahController::class, 'removeFavorite']);
