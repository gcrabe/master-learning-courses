import React from 'react'
import {Component} from "react/lib/ReactBaseClasses"

class SatelliteInfo extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return(
            <div>
                <span>satellite of <b>{this.props.getParentNameById(this.props.entity.parentId)}</b></span><br/>
                <span>name</span>
                <input type="text"
                       value={this.props.entity.name}
                       onChange={event => {
                           this.props.updateSatellite(event.target.value, "name", this.props.entity.id);
                       }}
                />
                <br/>
                <span>diameterIn</span>
                <input type="text"
                       value={this.props.entity.diameterIn}
                       onChange={event => {
                           this.props.updateSatellite(event.target.value, "diameterIn", this.props.entity.id);
                       }}
                />
                <br/>
                <span>diameterOut</span>
                <input type="text"
                       value={this.props.entity.diameterOut}
                       onChange={event => {
                           this.props.updateSatellite(event.target.value, "diameterOut", this.props.entity.id);
                       }}
                />
                <br/>
                <span>rotationTime</span>
                <input type="text"
                       value={this.props.entity.rotationTime}
                       onChange={event => {
                           this.props.updateSatellite(event.target.value, "rotationTime", this.props.entity.id);
                       }}
                />
                <br/>
                <button onClick={event => {
                    this.props.deleteSatellite(this.props.entity.id);
                }}>
                    Delete
                </button>
                <br/>
            </div>
        )
    }
}

export default SatelliteInfo
