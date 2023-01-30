Imports the following libraries:
React and Component from 'react'
Popup from 'reactjs-popup'
axios from 'axios'
Defines the class Home which extends Component
In the constructor method:
calls super(props) to inherit the parent's constructor
sets the initial state with properties:
surahs: an array of surahs
favorites: an array of surahs
isPopupOpen: a boolean indicating whether the popup is open or closed
The componentDidMount method makes two axios GET requests:
http://api.alquran.cloud/v1/surah to get the list of all surahs
http://127.0.0.1:8000/api/surahs to get the list of favorite surahs
The addToFavorites method makes an axios POST request to 'http://127.0.0.1:8000/api/surahs' to add a surah to the list of favorites
The removeFromFavorites method makes an axios DELETE request to 'http://127.0.0.1:8000/api/surahs/{surah.number}' to remove a surah from the list of favorites
The isFavorite method returns a boolean indicating whether a surah is in the list of favorites or not
The playSurah method plays an audio of a surah
The togglePopup method toggles the isPopupOpen state between true and false
The render method returns the JSX of the component which contains:
A player with a button to open/close the popup of favorite surahs
An audio player
Buttons to control the audio player
A list of surahs with buttons to add/remove surahs to/from the favorites list
