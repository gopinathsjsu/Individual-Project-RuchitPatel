package ReaderWriter;


import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;


public class PropertiesReader {

    public Properties prop;


    public Properties loadPropertiesFile() throws IOException {
        InputStream iStream = null;
        prop = new Properties();
        try {
            iStream = this.getClass().getClassLoader()
                    .getResourceAsStream("main.properties");
            if(iStream == null){
                throw new IOException("File not found");
            }
            prop.load(iStream);

        } catch (IOException e ) {
            e.printStackTrace();
        }

        return prop;
    }


}
