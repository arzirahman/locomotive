const { Kafka } = require('kafkajs')

const kafkaConfig = new Kafka({
    clientId: 'locomotive_kafka',
    brokers: ['localhost:9094'],
});

const kafkaProduce = async (topic, data) => {
    const producer = kafkaConfig.producer();
    try {
        await producer.connect();
        await producer.send({ topic, messages: [{ value: JSON.stringify(data) }] });
    } catch (error) {
        console.error(error);
    } finally {
        await producer.disconnect();
    }
}

const kafkaConsume = async (topic, callback) => {
    const consumer = kafkaConfig.consumer({ groupId: 'locomotive-group' });
    await consumer.subscribe({ topic, fromBeginning: true });
    await consumer.run({
        eachMessage: async ({ topic, _, message }) => {
            callback(message.value.toString())
        },
    });
}

module.exports = { kafkaProduce, kafkaConsume }