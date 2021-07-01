package com.crisestudios.timebot.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileManager {

    private static final String BASE_PATH = "./data/";
    private static HashMap<String, Object> CACHED_CONFIGS = new HashMap<>();


    public static void Init() {
        File file = new File(BASE_PATH);
        if(!file.exists())
            file.mkdirs();
    }


    public static boolean configExists(String path) {
        return new File(BASE_PATH+path).exists();
    }
    public static Object createConfig(String path, Object data) {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        File file = new File(BASE_PATH+path);

        String[] split = path.split("/");
        String fileName = split[split.length-1];
        String filePath = "";
        for(int i = 0; i < split.length-1; i++)
            filePath += "/"+split[i];

        if(filePath.length() > 0) {
            File fileDir = new File(BASE_PATH+filePath);
            if (!fileDir.exists())
                fileDir.mkdirs();
        }

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try(FileWriter writer = new FileWriter(file)) {
            writer.write(gson.toJson(data));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(CACHED_CONFIGS.containsKey(path))
           CACHED_CONFIGS.remove(path);
        CACHED_CONFIGS.put(path, data);

        return data;
    }
    public static Object getConfig(String path, Class<?> clazz) {
        File file = new File(BASE_PATH+path);
        if(!file.exists())
            return null;

        if(CACHED_CONFIGS.containsKey(path))
            return CACHED_CONFIGS.get(path);

        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        Object data = null;
        try(FileReader reader = new FileReader(file)) {
            data = gson.fromJson(reader, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!CACHED_CONFIGS.containsKey(path) && data != null)
            CACHED_CONFIGS.put(path, data);

        return data;
    }
    public static Object getOrCreateConfig(String path, Class<?> clazz, Object data) {
        Object dataLoaded = getConfig(path, clazz);

        if(dataLoaded == null)
            dataLoaded = createConfig(path, data);

        return dataLoaded;
    }
    public static Object saveConfig(String path, Object data) {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        File file = new File(BASE_PATH+path);

        String[] split = path.split("/");
        String fileName = split[split.length-1];
        String filePath = "";
        for(int i = 0; i < split.length-1; i++)
            filePath += "/"+split[i];

        if(filePath.length() > 0) {
            File fileDir = new File(BASE_PATH+filePath);
            if (!fileDir.exists())
                fileDir.mkdirs();
        }

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try(FileWriter writer = new FileWriter(file)) {
            writer.write(gson.toJson(data));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(CACHED_CONFIGS.containsKey(path))
            CACHED_CONFIGS.remove(path);
        CACHED_CONFIGS.put(path, data);

        return data;
    }

    public static File createDir(String path) {
        File dir = new File(BASE_PATH+path);
        if(!dir.exists())
            dir.mkdirs();
        return dir;
    }
    public static boolean deleteDir(String path) {
        File dir = new File(BASE_PATH+path);
        return dir.delete();
    }
    public static boolean deleteFile(String path) {
        File dir = new File(BASE_PATH+path);
        return dir.delete();
    }
}
