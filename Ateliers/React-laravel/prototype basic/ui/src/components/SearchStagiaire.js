import React, { Component } from 'react';
import axios from 'axios';

class SearchStagiaire extends Component {
    constructor(props) {
        super(props);
        this.state = {
            stagiaire: [],
            nom: '',
            error: '',
            exists:''
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({ nom: event.target.value });
        this.search();
    }
   
    search() {
        axios.get(`http://127.0.0.1:8000/api/stagiaire/${this.state.nom}`)
            .then(res => {
                if (res.data.length === 0) {
                    this.setState({ error: "n'existe pas" });
                }
                else {
                    this.setState({ error: "exists" });
                }
                const stagiaire = res.data;
                this.setState({ stagiaire });
            })
    }

    handleSubmit(event) {
        event.preventDefault();
        this.search();
    }
    
    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Nom:
                        <input type="text" value={this.state.nom} onChange={this.handleChange} />
                    </label>
                </form>
                <ul>
                    {this.state.error}
                </ul>
                
            </div>
        );
    }
}

export default SearchStagiaire;
