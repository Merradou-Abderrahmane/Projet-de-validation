<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\FavoriteController;

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
Route::get('/surahs', [FavoriteController::class, 'getFavorites']);
Route::post('/surahs', [FavoriteController::class, 'addFavorite']);
Route::delete('/surahs/{id}', [FavoriteController::class, 'removeFavorite']);

Route::get('ListFavorite', [FavoriteController::class, 'ListFavorite']);
Route::get('getAll', [FavoriteController::class, 'getAll']);
Route::post('store', [FavoriteController::class, 'store']);
Route::get('delete/{id}', [FavoriteController::class, 'delete']);
