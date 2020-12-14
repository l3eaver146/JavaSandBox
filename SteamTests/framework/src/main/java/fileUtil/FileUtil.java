package fileUtil;

import browserFactory.Config;
import com.google.gson.Gson;
import logger.Logger;
import org.apache.commons.io.FileExistsException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
    private static String pathToProjectFolder;
    private static final String PATH_TO_BROWSER_CONFIG_FILE = "/framework/src/main/resources/browserConfig.json";
    private static final String SYSTEM_PROPERTY = "user.dir";
    private static final int BEGIN_OF_THE_STRING = 0;
    private static final int EXTRA_CHARACTERS_IN_PATH = 12;
    private static final String PATH_TO_DOWNLOAD_DIRECTORY = "\\framework\\src\\main\\resources\\";

    private static String getPathToConfig() {
        return pathToProjectFolder;
    }
    public static String getPathToDownloadDirectory() {
        return FileUtil.getPathToProjFolder() + PATH_TO_DOWNLOAD_DIRECTORY;
    }

    public static String getPathToProjFolder() {
        pathToProjectFolder = System.getProperty(SYSTEM_PROPERTY);
        return pathToProjectFolder.substring(BEGIN_OF_THE_STRING, pathToProjectFolder.length() - EXTRA_CHARACTERS_IN_PATH);
    }

    public static Config getFrameworkConfig() {
        Config config = new Config();
        try {
            String path = getPathToProjFolder() + PATH_TO_BROWSER_CONFIG_FILE;
            Reader reader = Files.newBufferedReader(Paths.get(path));
            config = new Gson().fromJson(reader, Config.class);
            reader.close();
        } catch (IOException exception) {
            Logger.error(exception.getMessage());
        }
        return config;
    }

    public static boolean checkFileExists(String fileName) {
        Logger.debug("Trying to find " + fileName + " in " + PATH_TO_DOWNLOAD_DIRECTORY);
        return new File(getPathToProjFolder() + PATH_TO_DOWNLOAD_DIRECTORY, fileName).exists();
    }
}