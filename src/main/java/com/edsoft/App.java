package com.edsoft;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.spout.SchemeAsMultiScheme;
import backtype.storm.topology.TopologyBuilder;
import com.edsoft.storm.PrinterBolt;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.StringScheme;
import storm.kafka.ZkHosts;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ZkHosts zkHosts = new ZkHosts("192.168.1.14:2181");
        String topicName = "aalTestFour";
        String consumerGroupId = "kafka-spark-streaming-example";
        String zookeeper_root = "";
        SpoutConfig kafkaConfig = new SpoutConfig(zkHosts, topicName, zookeeper_root, consumerGroupId);

        kafkaConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
        kafkaConfig.forceFromStart = true;

        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("KafkaSpout", new KafkaSpout(kafkaConfig), 1);
        builder.setBolt("PrinterBolt", new PrinterBolt()).globalGrouping("KafkaSpout");

        Config config = new Config();

        LocalCluster cluster = new LocalCluster();

        cluster.submitTopology("KafkaConsumerTopology", config, builder.createTopology());

        try {
            Thread.sleep(60000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        cluster.killTopology("KafkaConsumerTopology");
        cluster.shutdown();
        System.out.println("Hello World!");
    }
}
