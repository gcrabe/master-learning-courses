import React, {Component} from 'react';
import PlanetInfo from './PlanetInfo'
import Entity from './Entity'

class PlanetList extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <button id={"addPlanetBtn"}
                        onClick={event => {
                            let newPlanet = new Entity(-1, true);
                            this.props.addPlanet(newPlanet);
                        }}
                >
                    Add planet
                </button>
                <ul>
                    {
                        this.props.planetList.map(curObject =>
                            <li key={curObject.id}>
                                <PlanetInfo
                                    deletePlanet={this.props.deletePlanet}
                                    entity={curObject}
                                    updatePlanet={this.props.updatePlanet}
                                    addSatellite={this.props.addSatellite}
                                    getParentNameById={this.props.getParentNameById}
                                />
                            </li>
                        )
                    }
                </ul>
            </div>
        );
    }
}

export default PlanetList;
