package com.edsoft.storm;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import com.edsoft.esper.handler.iot.DataEventHandler;
import com.edsoft.iot.Data;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by edsoft on 21.01.2016.
 */
public class PrinterBolt extends BaseBasicBolt {

    @Autowired
    private DataEventHandler dataEventHandler;

    private transient Gson gson = new Gson();

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        dataEventHandler.handle(gson.fromJson(input.getString(0), Data.class));
        // dataEventHandler.handle(App.changeFormat(input.getString(0)));

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }
}
