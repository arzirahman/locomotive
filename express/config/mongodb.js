const { MongoClient } = require("mongodb");

class MongoDBConfig {
    constructor() {
        this.client = new MongoClient('mongodb://localhost:27017');
        this.isConnected = false;
    }

    async connect() {
        if (!this.isConnected) {
            await this.client.connect();
            this.isConnected = true;
        }
        return this.client.db('locomotifdb');
    }
}

const mongoDb = new MongoDBConfig();

const mongoDbSave = async (data) => {
    try {
        const db = await mongoDb.connect();
        const collection = db.collection('locomotif');
        await collection.insertOne(data);
    } catch (error) {
        console.error(error);
    }
};

module.exports = { mongoDbSave };