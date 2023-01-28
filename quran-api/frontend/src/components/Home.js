import React, { Component } from 'react';
import axios from 'axios';

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
        surahs: [],
        };
    }
    
    componentDidMount() {
        axios.get('http://api.alquran.cloud/v1/surah')
        .then(res => {
            const surahs = res.data.data;
            this.setState({ surahs });
        })
    }

    playSurah(surah) {
        const audio = document.querySelector('.quranPlayer');
        audio.src = `http://api.alquran.cloud/v1/surah/${surah.number}/ar.alafasy`;
        audio.onloadeddata = () => {
            audio.play();
            console.log(audio);
        }
        // console log to see if audio is playing


        
        }

    // 
    
    render() {
        return (

        <div>
             <div className="container">
            <div className="player">
                <div className="ayah">اضغط علي السورة للاستماع اليها</div>
                <audio src="" className="quranPlayer" controls  autoPlay></audio>
                <div className="buttons">
                    <div className="icon next"><i className="fas fa-forward"></i></div>
                    <div className="icon play"><i className="fas fa-play"></i></div>
                    <div className="icon prev"><i className="fas fa-backward"></i></div>
                </div>
            </div>
            <div className="surahs">
                {this.state.surahs.map(surah => (
                    <div className="surah-container" onClick={() => this.playSurah(surah)}>
                        <div className="surah-name">{surah.name} - {surah.englishNameTranslation}</div>
                        <div className="favorite-icon">
                            <i className="fas fa-heart"></i>
                        </div>
                    </div>
                ))}
            </div>
            </div>

        </div>
        )
    }
    }

export default Home;