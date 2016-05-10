package com.cds.kafkalearn;

//import kafka.utils.ShutdownableThread;
//import org.apache.kafka.clients.consumer.*;
//import org.apache.kafka.common.TopicPartition;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//public class Consumer extends ShutdownableThread {
//    private final KafkaConsumer<Integer, String> consumer;
//    private final String topic;
//
//    public Consumer(String topic) {
//        super("KafkaConsumerExample", false);
//        Properties props = new Properties();
////        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "smallest");
////        props.put(ConsumerConfig.main();)
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "207.207.77.62:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group");
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
//        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
//        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
//            "org.apache.kafka.common.serialization.IntegerDeserializer");
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
//            "org.apache.kafka.common.serialization.StringDeserializer");
//
//        consumer = new KafkaConsumer<>(props);
//
//        this.topic = topic;
//    }
//
//    @Override public void doWork() {
//
//        System.out.println(this.topic);
//        consumer.subscribe(Collections.singletonList(this.topic));
////        consumer.subscribe(Collections.singletonList("ExcepHalarm"));
//        consumer.commitAsync(new OffsetCommitCallback() {
//            @Override public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets,
//                Exception exception) {
//                System.out.println(offsets.entrySet());
//                System.out.println();
//                System.out.println("ok");
//            }
//        });
//        System.out.println(consumer.partitionsFor(this.topic));
//        System.out.println(consumer);
//
////        consumer.commitAsync();
////        consumer.commitSync();
////        System.out.println(consumer.metrics());
//
//        ConsumerRecords<Integer, String> records = consumer.poll(1000);
//        System.out.println(records.count());
//        for (ConsumerRecord<Integer, String> record : records) {
//            System.out.println(
//                "Received message: (" + record.key() + ", " + record.value() + ") at offset "
//                    + record.offset());
//        }
//    }
//
//    @Override public String name() {
//        return null;
//    }
//
//    @Override public boolean isInterruptible() {
//        return false;
//    }
//}
