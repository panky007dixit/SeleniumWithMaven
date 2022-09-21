package helpers;

import java.io.File;
import java.io.IOException;

public class BatRunner {
    public static void main(String args[]) throws IOException {
        /*File dir = new File("C:\\Software\\SeleniumDrivers\\");
    ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "RunLocalBrowserstack.bat");
    pb.directory(dir);
    Process p = pb.start();*/
        Process run = Runtime.getRuntime().exec("cmd /c RunLocalBrowserstack.bat", null, new File("C:/Software/SeleniumDrivers"));
}
}
