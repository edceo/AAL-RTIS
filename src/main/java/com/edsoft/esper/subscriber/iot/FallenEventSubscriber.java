package com.edsoft.esper.subscriber.iot;


import com.edsoft.esper.subscriber.StatementSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by edsoft on 13.01.2016.
 */
@Component
public class FallenEventSubscriber implements StatementSubscriber {

    /**
     * Logger
     */
    private static Logger LOG = LoggerFactory.getLogger(FallenEventSubscriber.class);
    String fileName = "/home/edsoft/IdeaProjects/esper-demo-nuclear/src/main/resources/fallenRule.txt";
    RandomAccessFile randomAccessFile;

    public FallenEventSubscriber() {
        try {
            randomAccessFile = new RandomAccessFile(fileName, "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getStatement() {

        // Example of simple EPL with a Time Window
        try {
            return randomAccessFile.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(Long eventMap) {

        // average temp over 10 secs

        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------");
        sb.append("\n- [FALLEN]  = " + eventMap);
        sb.append("\n---------------------------------");
        sb.append("\n" + new SimpleDateFormat("mm:ss").format(new Date()));

        LOG.debug(sb.toString());
    }
}