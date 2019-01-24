import React from 'react';
import {Component} from "react/lib/ReactBaseClasses";
import Entity from './Entity'

class PlanetInfo extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <span>planet name</span>
                <input type="text"
                       value={this.props.entity.name}
                       onChange={event => {
                           this.props.updatePlanet(event.target.value, "name", this.props.entity.id);
                       }}
                />
                <br/>
                <span>diameterIn</span>
                <input type="text"
                       value={this.props.entity.diameterIn}
                       onChange={event => {
                           this.props.updatePlanet(event.target.value, "diameterIn", this.props.entity.id);
                       }}
                />
                <br/>
                <span>diameterOut</span>
                <input type="text"
                       value={this.props.entity.diameterOut}
                       onChange={event => {
                           this.props.updatePlanet(event.target.value, "diameterOut", this.props.entity.id);
                       }}
                />
                <br/>
                <span>rotationTime</span>
                <input type="text"
                       value={this.props.entity.rotationTime}
                       onChange={event => {
                           this.props.updatePlanet(event.target.value, "rotationTime", this.props.entity.id);
                       }}
                />
                <br/>
                <button onClick={event => {
                    this.props.deletePlanet(this.props.entity.id);
                }}>
                    Delete
                </button>
                &nbsp;
                <button onClick={event => {
                    let planetId = this.props.entity.id;
                    let newSatellite = new Entity(planetId, false);
                    this.props.addSatellite(newSatellite);
                }}>
                    Add satellite
                </button>
                <br/>
            </div>
        )
    }

}

export default PlanetInfo
