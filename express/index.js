const express = require("express");
const { kafkaConsume } = require("./config/kafka");
const { mongoDbSave } = require("./config/mongodb");
const { forwardRouter } = require("./route/forward");

const APP_PORT = 3050;
const app = express();

kafkaConsume("locomotive", (data) => {
    const jsonData = JSON.parse(data)
    mongoDbSave({
        _id: jsonData?.locoCode,
        locoName: jsonData?.locoName,
        locoDimension: jsonData?.locoDimension,
        status: jsonData?.status,
        time: jsonData?.time,
    })
})

app.use(express.json())

app.use(forwardRouter)

app.listen(APP_PORT, () => {
    console.log("Server is running on port", APP_PORT)
})