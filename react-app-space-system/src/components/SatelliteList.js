import React from 'react';
import {Component} from "react/lib/ReactBaseClasses"
import SatelliteInfo from "./SatelliteInfo";

class SatelliteList extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div>
                <ul>
                    {
                        this.props.satelliteList.map(curObject =>
                            <li key={curObject.id}>
                                <SatelliteInfo
                                    entity={curObject}
                                    deleteSatellite={this.props.deleteSatellite}
                                    updateSatellite={this.props.updateSatellite}
                                    getParentNameById={this.props.getParentNameById}
                                />
                            </li>
                        )
                    }
                </ul>
            </div>
        )
    }
}

export default SatelliteList;