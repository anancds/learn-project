package com.cds.kafkalearn;

public class KafkaProperties {
    public static final String TOPIC = "topic1";
    public static final String KAFKA_SERVER_URL = "";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final int KAFKA_PRODUCER_BUFFER_SIZE = 64 * 1024;
    public static final int CONNECTION_TIMEOUT = 1000000;
    public static final String TOPIC2 = "cds";
    public static final String TOPIC3 = "test";
    public static final String CLIENT_ID = "lowLevelApi";

    private KafkaProperties() {
    }
}
