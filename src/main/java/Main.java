import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws IOException {

        //TEST scaiagania danych z open notify api
        URL url = new URL("http://api.open-notify.org/iss-now.json");
        URLConnection urlcon = url.openConnection();


        InputStream is = urlcon.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

    }


}
