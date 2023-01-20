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
    
    render() {
        return (

        <div>
             <div class="container">
            <div class="player">
                <div class="ayah">اضغط علي السورة للاستماع اليها</div>
                <audio src="" class="quranPlayer" controls  autoplay></audio>
                <div class="buttons">
                    <div class="icon next"><i class="fas fa-forward"></i></div>
                    <div class="icon play"><i class="fas fa-play"></i></div>
                    <div class="icon prev"><i class="fas fa-backward"></i></div>
                </div>
            </div>
            <div class="surahs">

            </div>
            </div>

            <ul>
            { this.state.surahs.map(surah => <li>{surah.name}</li>)}
            </ul>
        </div>
        )
    }
    }

export default Home;