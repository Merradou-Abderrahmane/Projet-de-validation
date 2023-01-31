# Home.js

## Imports 
- React and Component from 'react'
- Popup from 'reactjs-popup'
- axios from 'axios'

## Define the Class
- Class Home extends Component

## Constructor Method
- calls super(props)
- sets the initial state with properties:
  - surahs: an array of surahs
  - favorites: an array of surahs
  - isPopupOpen: a boolean indicating whether the popup is open or closed

## componentDidMount Method
- Makes two axios GET requests:
  - http://api.alquran.cloud/v1/surah to get the list of all surahs
  - http://127.0.0.1:8000/api/surahs to get the list of favorite surahs

## addToFavorites Method
- Makes an axios POST request to 'http://127.0.0.1:8000/api/surahs' to add a surah to the list of favorites

## removeFromFavorites Method
- Makes an axios DELETE request to 'http://127.0.0.1:8000/api/surahs/{surah.number}' to remove a surah from the list of favorites

## isFavorite Method
- Returns a boolean indicating whether a surah is in the list of favorites or not

## playSurah Method
- Plays an audio of a surah

## togglePopup Method
- Toggles the isPopupOpen state between true and false

## Render Method
- Returns the JSX of the component which contains:
  - A player with a button to open/close the popup of favorite surahs
  - An audio player
  - Buttons to control the audio player
  - A list of surahs with buttons to add/remove surahs to/from the favorites list
