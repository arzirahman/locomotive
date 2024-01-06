const express = require("express");
const { kafkaProduce } = require("../config/kafka");

const forwardRouter = express.Router();

forwardRouter.post("/forward", async (req, res) => {
    try {
        const data = req.body;
        await kafkaProduce("locomotive", data)
        res.status(200).json({
            message: "Success",
        });
    } catch (error) {
        console.log(error);
    }
})

module.exports = { forwardRouter }