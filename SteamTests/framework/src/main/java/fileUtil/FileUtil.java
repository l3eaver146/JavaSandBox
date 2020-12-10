package fileUtil;

import browserFactory.BrowserOptions;
import browserFactory.Config;
import com.google.gson.Gson;
import logger.Logger;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
    private static String pathToProjectFolder;
    private static final String pathToConfigFile = "/framework/src/main/resources/browserConfig.json";

    private static String getPathToConfig() {
        return pathToProjectFolder;
    }

    public static String getPathToProjFolder() {
        pathToProjectFolder = System.getProperty("user.dir");
        return pathToProjectFolder.substring(0, pathToProjectFolder.length() - 12);
    }

    public static Config getFrameworkConfig() {
        Config config = new Config();
        try {
            String path = getPathToProjFolder() + pathToConfigFile;
            Reader reader = Files.newBufferedReader(Paths.get(path));
            config = new Gson().fromJson(reader, Config.class);
        } catch (IOException exception) {
            Logger.error(exception.getMessage());
            return config;
        } finally {
            return config;
        }
    }

    public static boolean checkFileExists(String fileName) {
        Logger.debug("Trying to find " + fileName + " in " + BrowserOptions.getDownloadDirectoryPath());
        return new File(BrowserOptions.getDownloadDirectoryPath(), fileName).exists();
    }
}