import React, { Component } from 'react';
import axios from 'axios';

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
        surahs: [],
        favorites: [],
        };
    }
    
    componentDidMount() {
        axios.get('http://api.alquran.cloud/v1/surah')
        .then(res => {
            const surahs = res.data.data;
            this.setState({ surahs });
        })    
        
        axios.get('http://127.0.0.1:8000/api/surahs')
        .then(res => {
            const favorites = res.data;
            this.setState({ favorites });
        })       

        }    
        
        addToFavorites(surah) {
            axios.post('http://127.0.0.1:8000/api/surahs', {
                surah_id: surah.number,
                name: surah.name,
                english_name: surah.englishNameTranslation
            })
            .then(res => {
                this.setState({
                    favorites: [...this.state.favorites, surah]
                });
            });
        }

        removeFromFavorites(surah) {
            axios.delete(`http://127.0.0.1:8000/api/surahs/${surah.number}`)
            .then(res => {
                this.setState({
                    favorites: this.state.favorites.filter(favorite => favorite.number !== surah.number)
                });
            });
        }
        
        isFavorite(surah) {
            return this.state.favorites.some(favorite => favorite.number === surah.number);
        }
    
    

        playSurah(surahNumber) {
            const audioPlayer = document.querySelector('.quranPlayer');
            const paddedSurahNumber = `00${surahNumber}`.slice(-3);
            audioPlayer.src = `https://server11.mp3quran.net/a_ahmed/${paddedSurahNumber}.mp3`;
            audioPlayer.play();
          }
              
    // 
    
    render() {
        return (
          <div>
            <div className="container">
              <div className="player">
                <div className="ayah">اضغط علي السورة للاستماع اليها</div>
                <audio src={this.state.surahAudio} className="quranPlayer" controls  autoPlay></audio>
                <div className="buttons">
                  <div className="icon next">
                    <i className="fas fa-forward"></i>
                  </div>
                  <div className="icon play">
                    <i className="fas fa-play"></i>
                  </div>
                  <div className="icon prev">
                    <i className="fas fa-backward"></i>
                  </div>
                </div>
              </div>
              <div className="surahs">
                {this.state.surahs.map(surah => (
                  <div className="surah-container" onClick={() => this.playSurah(surah.number)}>
                    <div className="surah-name">
                      {surah.name} - {surah.englishNameTranslation}
                    </div>
                    {this.isFavorite(surah) ? (
                      <div className="favorited" onClick={() => this.removeFromFavorites(surah)}>
                        <i className="fas fa-heart"></i>
                      </div>
                    ) : (
                      <div className="favorite" onClick={() => this.addToFavorites(surah)}>
                        <i className="far fa-heart"></i>
                      </div>
                    )}
                  </div>
                ))}
              </div>
            </div>
          </div>
        );
    }
}
    

export default Home;