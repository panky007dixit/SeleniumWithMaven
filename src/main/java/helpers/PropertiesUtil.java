package helpers;
import java.util.*;
import java.io.*;
public class PropertiesUtil {
    private static String prop;
    public static String getProperties(String properties)throws Exception{
        FileReader reader=new FileReader("testdata//Project.properties");
        Properties p=new Properties();
        p.load(reader);
        prop= p.getProperty(properties);
        return prop;
    }
}
