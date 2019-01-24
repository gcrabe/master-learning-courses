class Entity {
    constructor(parentId, isPlanet) {
        this.id = Date.now();
        this.parentId = parentId;
        this.name = this.id;
        this.diameterIn = "";
        this.diameterOut = "";
        this.rotationTime = "";
        this.isPlanet = isPlanet;
    }
}

export default Entity
