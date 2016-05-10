package com.cds.kafkalearn;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ConsumerTest extends Thread {
    private final ConsumerConnector consumer;
    private final String topic;

    public ConsumerTest(String topic) {
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(createConsumerConfig());
        this.topic = topic;
    }

    private static ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        props.put("auto.offset.reset", "smallest");
        //        props.put("zookeeper.connect", "208.208.102.212:2181,208.208.102.213:2181,208.208.102.214:2181");
        props.put("zookeeper.connect", "207.207.77.62:2181");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("group.id", "test-consumer-group");
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");

        return new ConsumerConfig(props);

    }


    public void run() {

        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        //        topicCountMap.put(topic, 1);
        topicCountMap.put("test", 1);
        //        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
        //        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap =
            consumer.createMessageStreams(topicCountMap);


        //        Map<String, List<KafkaStream<String, String>>> consumerMap =
        //            consumer.createMessageStreams(topicCountMap, keyDecoder,valueDecoder);
        System.out.println("-");

        //        KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
        KafkaStream<byte[], byte[]> stream1 = consumerMap.get("test").get(0);
        //        System.out.println("+");
        ConsumerIterator<byte[], byte[]> it = stream1.iterator();
        while (it.hasNext()) {
            System.out.println(new String(it.next().message()));


        }

        //        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        ////        topicCountMap.put(topic, 1);
        //        topicCountMap.put("test", 1);
        //        //        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
        //        //        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());
        //        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap =
        //            consumer.createMessageStreams(topicCountMap);
        //
        //
        //        //        Map<String, List<KafkaStream<String, String>>> consumerMap =
        //        //            consumer.createMessageStreams(topicCountMap, keyDecoder,valueDecoder);
        //        System.out.println("-");
        //
        ////        KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
        //        KafkaStream<byte[], byte[]> stream1 = consumerMap.get("test").get(0);
        ////        System.out.println("+");
        //        ConsumerIterator<byte[], byte[]> it = stream1.iterator();
        //        boolean flag = false;
        //        while (it.hasNext() ) {
        //            System.out.println("ok");
        ////            it.next().message();
        ////            consumer.shutdown();
        ////            return;
        ////            if (!flag) {
        ////                try {
        ////                    consumer.shutdown();
        ////                    Thread.sleep(5000);
        ////                } catch (InterruptedException e) {
        ////                    e.printStackTrace();
        ////                }
        ////                flag = true;
        ////            } else {
        ////                System.out.println(new String(it.next().message()));
        ////                System.out.println("ok");
        ////            }
        //
        //
        ////            return;
        //        }
        //
        ////        System.out.println("++");
        //        for (MessageAndMetadata<byte[], byte[]> aStream : stream1) {
        //            System.out.println("+++");
        //////            System.out.println(new String(aStream.message()));
        ////            System.out.println(aStream.offset());
        //        }
        //
        //        System.out.println("return");
    }

    public static void main(String[] args) {

        //        ProducerTest producerTest = new ProducerTest("topi");
        //        producerTest.start();
        ConsumerTest test = new ConsumerTest("cds");
        test.start();
    }
}
