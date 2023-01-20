import React, { Component } from 'react';
import axios from 'axios';

class SearchStagiaire extends Component {
    constructor(props) {
        super(props);
        this.state = {
            stagiaire: [],
            nom: '',
            error: '',
            selected: [],
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

    //
    addToSelection(stagiaire) {
        // check if the stagiaire is already selected
        if (this.state.selected.includes(stagiaire)) {
            // if it is, remove it from the selected array
            this.setState({ selected: this.state.selected.filter(s => s !== stagiaire) });
        } else {
            // if it isn't, add it to the selected array
            this.setState({ selected: [...this.state.selected, stagiaire] });
        }
        this.setState({stagiaire: this.state.stagiaire.filter(s => s !== stagiaire)});
        console.log(this.state.selected);
    }
    
removefromSelection(stagiaire) {
    // check if the stagiaire is already selected
    if (this.state.selected.includes(stagiaire)) {
        // if it is, remove it from the selected array
        this.setState({ selected: this.state.selected.filter(s => s !== stagiaire) });
    }
    this.setState({stagiaire: [...this.state.stagiaire, stagiaire]});
    console.log(this.state.selected);
}

    handleSubmit(event) {
        event.preventDefault();
        this.search();
    }

    render() {
        return (
            <div className='container'>
                <div className='row'>
                    <div className='col-md-6'>
                        <div className='card'>
                            <div className='card-header'>
                                <form onSubmit={this.handleSubmit}>
                                    <label>
                                        Nom:
                                        <input type="text" value={this.state.nom} onChange={this.handleChange} />
                                    </label>
                                </form>
                            </div>
                            <div className='card-body'>
                                <table className='table'>
                                    <thead>
                                        <tr>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {this.state.stagiaire.map(stagiaire => <tr><td>{stagiaire.nom}</td><td onClick={() => this.addToSelection(stagiaire)}>+</td></tr>)}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div className='col-md-6'>
                        <div className='card'>
                            <div className='card-header'>
                                <h3>Selected</h3>
                            </div>
                            <div className='card-body'>
                                <table className='table'>
                                    <thead>
                                        <tr>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {this.state.selected.map(stagiaire => <tr><td>{stagiaire.nom}</td><td onClick={() => this.removefromSelection(stagiaire)}>-</td></tr>)}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default SearchStagiaire;