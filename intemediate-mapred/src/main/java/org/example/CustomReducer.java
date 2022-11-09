package org.example;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.*;

public class CustomReducer extends MapReduceBase implements Reducer<Text, Text, Text, LongWritable> {
    public final static double AVERAGE_RADIUS_OF_EARTH = 6371;

    @Override
    public void reduce(Text text, Iterator<Text> iterator, OutputCollector<Text, LongWritable> outputCollector, Reporter reporter) throws IOException {
        long counter = 0;

        List<String> found = new ArrayList<>();

        while (iterator.hasNext()) {
            String testo = iterator.next().toString();
            String[] fields = testo.split(":");

            long confLevel = Integer.parseInt(fields[1]);

            if(confLevel > 5) {
                if(found.contains(fields[0]))
                    counter++;
                else
                    found.add(fields[0]);
            }
        }

        outputCollector.collect(text, new LongWritable(counter));
    }


}
