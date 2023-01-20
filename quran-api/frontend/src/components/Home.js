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

            </div>
            </div>

            <ul>
            {/* arabic name next to englishname map */}
            { this.state.surahs.map(surah => <li>{surah.name} - {surah.englishNameTranslation}</li>)}



            {/* { this.state.surahs.map(surah => <li>{surah.name}</li>)}
            { this.state.surahs.map(surah => <li>{surah.englishNameTranslation}</li>)} */}
            
            </ul>
        </div>
        )
    }
    }

export default Home;