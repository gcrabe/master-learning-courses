import React from 'react';
import {Component} from "react/lib/ReactBaseClasses";

class PlanetMap extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        const satelliteAreaStyleExample = {
            width: '32px',
            marginLeft: '-64px'
        };

        const satelliteWrapperStyleExample = {
            transformOrigin: '80px center 0px',
            animationDuration: '3s',
            animationDirection: 'normal'
        };

        const satelliteInnerStyleExample = {
            animationDuration: '3s',
            animationDirection: 'reverse',
            background: 'rgb(170, 221, 238)'
        };

        const sunRadius = 50;

        return (
            <div className={"space"}>
                <div className="sun">Sun</div>
                {
                    this.props.planetList.map((planet) => {
                        let areaStyle = {
                            width: planet.diameterIn + 'px',
                            marginLeft: - planet.diameterOut + 'px'
                        };
                        let wrapperStyle = {
                            transformOrigin: (parseInt(planet.diameterOut) + planet.diameterIn / 2.0) + 'px center 0px',
                            animationDuration: planet.rotationTime + 's',
                            animationDirection: 'normal'
                        };
                        let innerStyle = {
                            animationDuration: planet.rotationTime + 's',
                            animationDirection: 'reverse',
                            background: 'rgb(170, 221, 238)'
                        };

                        let satellites = this.props.getAllSatellitesByParentId(planet.id);

                        return (
                            <div className="satellite-area" style={areaStyle}>
                                <div className="satellite-wrapper" style={wrapperStyle}>
                                    <div className="satellite-inner" style={innerStyle}>
                                        {planet.name}
                                        {
                                            satellites.map((satellite) => {
                                                let subAreaStyle = {
                                                    width: satellite.diameterIn + 'px',
                                                    marginLeft: - satellite.diameterOut + 'px'
                                                };
                                                let subWrapperStyle = {
                                                    transformOrigin: (parseInt(satellite.diameterOut) + satellite.diameterIn / 2.0) + 'px center 0px',
                                                    animationDuration: satellite.rotationTime + 's',
                                                    animationDirection: 'reverse'
                                                };
                                                let subInnerStyle = {
                                                    animationDuration: satellite.rotationTime + 's',
                                                    animationDirection: 'normal'
                                                };

                                                return (
                                                    <div className={"satellite-area"} style={subAreaStyle}>
                                                        <div className={"satellite-wrapper"} style={subWrapperStyle}>
                                                            <div className={"satellite-inner"} style={subInnerStyle}>
                                                                {satellite.name}
                                                            </div>
                                                        </div>
                                                    </div>
                                                )
                                            })
                                        }
                                    </div>
                                </div>
                            </div>
                        )
                    })
                }
            </div>
        )
    }

}

export default PlanetMap
