package org.example;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        JobConf conf = new JobConf(App.class);
        conf.setJobName("mapperino");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(LongWritable.class);

        conf.setMapOutputKeyClass(Text.class);
        conf.setMapOutputValueClass(Text.class);

        conf.setMapperClass(CustomMapper.class);
        conf.setReducerClass(CustomReducer.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        FileInputFormat.setInputPaths(conf, new Path("hivemetastore/intermediate_task_2.db/rskills"));
        FileOutputFormat.setOutputPath(conf, new Path("outputmapred"));

        JobClient.runJob(conf);
    }
}
