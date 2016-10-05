package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by palla on 13/01/16.
 */
public class Config {

    private static Config _instance = new Config();
    private static String configFilePath = "EMPTY";
    private Properties props = null;
    private static String configFileName;

    private final static String _CONFIG = "src/main/resources/conf.properties";

    private Config() {
        init();
    }

    public static Config newInstance() {
        if (_instance == null) {
            _instance = new Config();
        }

        return _instance;
    }

    public void init() {
        try {
            props = new Properties();
            File file = new File(getConfigFileAbsolutePath(_CONFIG));

            InputStream is = new FileInputStream(file);
            props.load(is);

        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public String getProperty(String key)  {
        if (props.containsKey(key)) {
            return props.getProperty(key);
        }
        return "";
    }

    /**
     * Check if config file is present
     */
    public static boolean configFileIsPresent() throws Exception {
        File f = new File(getConfigFileAbsolutePath(configFileName));
        return f.exists();
    }

    public static String getConfigFileAbsolutePath(String fileName) {
        configFileName =  fileName;
        return configFileName;
    }
}
