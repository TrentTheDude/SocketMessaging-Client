package me.trent.client.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FileUtils {


    private static HashMap<String, Object> dataCache = new HashMap<>();
    private static HashMap<String, File> fileCache = new HashMap<>();
    private static HashMap<File, List<String>> fileLinesCache = new HashMap<>();

    public static void reloadFileCache(){
        fileCache.clear();
        dataCache.clear();
        fileLinesCache.clear();


    }

    public static Object getValue(String fileName, String key){

        if (dataCache.containsKey(key)){
            return dataCache.get(key);
        }

        File file = null;
        if (fileCache.containsKey(fileName)){
            file = fileCache.get(fileName); // cached
        }else{
            try {
                file = getResourceFile(fileName);
                fileCache.put(fileName, file);
            }catch(URISyntaxException e){
                e.printStackTrace();
            }
        }
        if (file == null) return null;
        try {
            List<String> lines = null;
            if (fileLinesCache.containsKey(file)){
                lines = fileLinesCache.get(file);
            }else{
                lines = Files.readAllLines(Paths.get(file.getPath()));
                fileLinesCache.put(file, lines);
            }

            /*
            Data FORMAT...
            KEY:VALUE

            colon separated data...
             */

            if (lines != null){
                for (String line : lines){
                    String dataKey = line.split(":")[0];
                    String dataValue = line.split(":")[1];
                    if (!dataCache.containsKey(dataKey)){
                        dataCache.put(dataKey, dataValue); // cache the data...
                    }
                    if (dataKey.equalsIgnoreCase(key)){
                        //matched... return our value we want...
                        return dataValue;
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }


    public static File getResourceFile(String fileName) throws URISyntaxException {
        Utils.log("FileName: "+fileName);

        URL url = FileUtils.class.getClassLoader().getResource(fileName);
        Utils.log("URL: "+url);

        File file = new File(url.getFile());
        if (file.exists()){
            Utils.log("Valid File");
        }else{
            Utils.log("NOT valid File");
        }


        return file;
    }

}