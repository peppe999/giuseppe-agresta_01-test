package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;

public class HadoopManager {
    private static HadoopManager instance = null;
    private final FileSystem fs;

    private final String path;

    private HadoopManager() {
        try {
            fs = FileSystem.get(new Configuration());
            path = "humanres/" + System.currentTimeMillis() + ".json";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static HadoopManager getInstance() {
        if(instance == null) {
            instance = new HadoopManager();
        }
        return instance;
    }

    public boolean fileExists(String path) {
        try {
            return fs.exists(new Path(path));
        } catch (IOException e) {
            System.err.println("Ops! There is a problem!");
            return false;
        }
    }

    public void appendRowInFile(String row) {
        FSDataOutputStream out;
        try {
            if(!fileExists(path))
                out = fs.create(new Path(path));
            else
                out = fs.append(new Path(path));

            out.writeBytes(row + "\n");
            out.close();
        } catch (IOException ignored) {
        }
    }
}
