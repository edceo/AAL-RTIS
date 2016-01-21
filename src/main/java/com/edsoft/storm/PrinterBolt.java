package com.edsoft.storm;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

/**
 * Created by edsoft on 21.01.2016.
 */
public class PrinterBolt extends BaseBasicBolt {

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        String word = input.getString(0);
        System.out.println("Word: " + word);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }
}
