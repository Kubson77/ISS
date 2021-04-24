import model.ISSPosition;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        //TEST scaiagania danych z open notify api
        URL url = new URL("http://api.open-notify.org/iss-now.json");
        URLConnection urlcon = url.openConnection();
        InputStream input = urlcon.getInputStream();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(input));

        JSONObject skr = (JSONObject) new JSONParser().parse(buffer);
        ISSPosition position = new ISSPosition();

        position.setUnixTime((long) skr.get("timestamp"));
        Map coordinates = ((Map) skr.get("iss_position"));
        position.setLatitude((String)coordinates.get("latitude"));
        position.setLongitude((String)coordinates.get("longitude"));

        System.out.println(position);
    }

}
