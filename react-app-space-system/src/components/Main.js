import React from 'react';
import {Component} from "react/lib/ReactBaseClasses";
import PlanetList from './PlanetList';
import SatelliteList from './SatelliteList'
import PlanetMap from './PlanetMap'

class Main extends Component {

    state = {
        planetList : [],
        satelliteList : []
    };

    constructor(props) {
        super(props);
        this.addPlanet = this.addPlanet.bind(this);

        for (let i = 0; i < localStorage.length; i++) {
            let key = localStorage.key(i);
            let valueObject = JSON.parse(localStorage.getItem(key))
            if (valueObject.isPlanet) {
                this.state.planetList.push(valueObject);
            } else {
                this.state.satelliteList.push(valueObject);
            }
        }
    }

    updatePlanet = (newValue, parameter, planetId) => {
        for (let i = 0; i < this.state.planetList.length; i++) {
            if (this.state.planetList[i].id === planetId) {
                this.state.planetList[i][parameter] = newValue;
                localStorage.setItem(planetId, JSON.stringify(this.state.planetList[i]))
            }
        }

        this.setState(this.state);
    };

    addPlanet(planetItem) {
        this.state.planetList.push(planetItem);
        localStorage.setItem(planetItem.id, JSON.stringify(planetItem));
        this.setState(this.state);
    };

    deletePlanet = (planetId) => {
        console.log("planetId = " + planetId)

        for (let i = 0; i < this.state.planetList.length; i++) {
            if (this.state.planetList[i].id === planetId) {
                this.state.planetList.splice(i, 1);
                break;
            }
        }

        let i = 0;

        while (i < this.state.satelliteList.length) {
            if (this.state.satelliteList[i].parentId === planetId) {
                localStorage.removeItem(this.state.satelliteList[i].id);
                this.state.satelliteList.splice(i, 1);
            } else {
                i++;
            }
        }

        localStorage.removeItem(planetId);
        this.setState(this.state);
    };

    addSatellite = (satelliteItem) => {
        this.state.satelliteList.push(satelliteItem);
        localStorage.setItem(satelliteItem.id, JSON.stringify(satelliteItem));
        this.setState(this.state);
    };

    deleteSatellite = (satelliteId) => {
        for (let i = 0; i < this.state.satelliteList.length; i++) {
            if (this.state.satelliteList[i].id === satelliteId) {
                this.state.satelliteList.splice(i, 1);
                break;
            }
        }

        localStorage.removeItem(satelliteId);
        this.setState(this.state)
    };

    updateSatellite = (newValue, parameter, satelliteId) => {
        for (let i = 0; i < this.state.satelliteList.length; i++) {
            if (this.state.satelliteList[i].id === satelliteId) {
                this.state.satelliteList[i][parameter] = newValue;
                localStorage.setItem(satelliteId, JSON.stringify(this.state.satelliteList[i]))
            }
        }

        this.setState(this.state);
    };

    getParentNameById = (parentId) => {
        for (let i = 0; i < this.state.planetList.length; i++) {
            if (this.state.planetList[i].id === parentId) {
                return this.state.planetList[i].name;
            }
        }
    };

    getAllSatellitesByParentId = (parentId) => {
        let result = [];

        for (let i = 0; i < this.state.satelliteList.length; i++) {
            if (this.state.satelliteList[i].parentId === parentId) {
                result.push(this.state.satelliteList[i])
            }
        }

        return result
    };

    render() {
        const fsColumnId = "col1";
        const scColumnId = "col2";
        const tdColumnId = "col3";

        return (
            <div>
                <table width="90%" cellPadding={5} cellSpacing={0}>
                    <tbody>
                    <tr>
                        <td id={fsColumnId}>
                            <PlanetList
                                planetList={this.state.planetList}
                                addPlanet={this.addPlanet}
                                deletePlanet={this.deletePlanet}
                                updatePlanet={this.updatePlanet}
                                addSatellite={this.addSatellite}
                            />
                        </td>
                        <td id={scColumnId}>
                            <SatelliteList
                                satelliteList={this.state.satelliteList}
                                deleteSatellite={this.deleteSatellite}
                                updateSatellite={this.updateSatellite}
                                getParentNameById={this.getParentNameById}
                            />
                        </td>
                        <td id={tdColumnId}>
                            <PlanetMap
                                planetList={this.state.planetList}
                                satelliteList={this.state.satelliteList}
                                getAllSatellitesByParentId={this.getAllSatellitesByParentId}
                            />
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    }
}

export default Main;
