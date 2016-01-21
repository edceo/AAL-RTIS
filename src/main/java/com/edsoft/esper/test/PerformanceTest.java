package com.edsoft.esper.test;


import com.edsoft.esper.event.AHeart;
import com.edsoft.iot.Data;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by edsoft on 14.01.2016.
 */
public class PerformanceTest {
    private RandomAccessFile randomAccessFile;
    private RandomAccessFile randomAccessFileTwo;
    private String fileName;
    private String fileNameTwo;
    private Gson gson;
    private static int FRC;

    public static void main(String[] args) {
        PerformanceTest p = new PerformanceTest();
        //p.average();
        p.firstResult();//ortalama mesaj sayısı
    }

    public PerformanceTest() {
        fileNameTwo = "/home/edsoft/IdeaProjects/esper-demo-nuclear/src/main/resources/deneme_1_part2.json";
        fileName = "/home/edsoft/IdeaProjects/esper-demo-nuclear/src/main/resources/deneme_1.json";
        try {
            this.randomAccessFile = new RandomAccessFile(fileName, "r");
            this.randomAccessFileTwo = new RandomAccessFile(fileNameTwo, "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }//
        FRC = 500000;
        gson = new Gson();
    }

    public void firstResult() {
        try {
            for (int i = 0; i < 2; i++) {
                randomAccessFile.readLine();
                randomAccessFileTwo.readLine();
            }
            String a = randomAccessFile.readLine();
            Data c = gson.fromJson(a, Data.class);
            String k = randomAccessFileTwo.readLine();
            randomAccessFileTwo.seek(randomAccessFileTwo.length() - k.length() - 2);
            String b = randomAccessFileTwo.readLine();
            AHeart d = gson.fromJson(b, AHeart.class);

            System.out.println("Sonuc : " + ((d.getL().get(0) - c.getTimeList().get(0)) / 1000000000));
            System.out.println("Bir saniyede gelen olay sayısı : " + FRC / ((d.getL().get(0) - c.getTimeList().get(0)) / 1000000000));

//            System.out.println(a + "\n" + b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void average() {
        long t1t2 = 0;
        long t2t3 = 0;
        double sum1 = 0;
        double sum2 = 0;
        int count = 0;

        for (int i = 0; i < FRC - 1; i++) {
            try {
                if (count > 2) {
                    String a = randomAccessFile.readLine();
                    Data c = gson.fromJson(a, Data.class);
                    t1t2 = c.getTimeList().get(1) - c.getTimeList().get(0);
                    String b = randomAccessFileTwo.readLine();
                    AHeart h = gson.fromJson(b, AHeart.class);
                    t2t3 = h.getL().get(0) - c.getTimeList().get(1);
                    sum1 += t1t2;
                    sum2 += t2t3;
                } else {
                    count++;
                    randomAccessFile.readLine();
                    randomAccessFileTwo.readLine();
                }
                //System.out.println(t1t2 + "\t" + t2t3);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("AVG -> " + (sum1 / FRC) / 1000000 + "\t" + (sum2 / FRC) / 1000000);
    }
}
