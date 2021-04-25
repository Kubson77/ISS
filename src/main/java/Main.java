import dao.Dao;
import model.ISSPosition;
import model.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        //TEST scaiagania danych z open notify api
        URL url = new URL("http://api.open-notify.org/iss-now.json");
        URLConnection urlcon = url.openConnection();
        InputStream input = urlcon.getInputStream();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(input));

        JSONObject location = (JSONObject) new JSONParser().parse(buffer);
        ISSPosition position = new ISSPosition();

        position.setUnixTime((long) location.get("timestamp"));
        Map coordinates = (Map) location.get("iss_position");
        position.setLatitude((String) coordinates.get("latitude"));
        position.setLongitude((String) coordinates.get("longitude"));

        Dao daoIssPosition = new Dao();
//        daoIssPosition.addIssPosition(position);
//        System.out.println(daoIssPosition.getLastIssCoordinates());
//        System.out.println(daoIssPosition.getIssSpeed());
//        System.out.println(daoIssPosition.getOneBeforeLastIssCoordinates());


        url = new URL("http://api.open-notify.org/astros.json");
        urlcon = url.openConnection();
        input = urlcon.getInputStream();
        buffer = new BufferedReader(new InputStreamReader(input));
        JSONObject astros = (JSONObject) new JSONParser().parse(buffer);

        JSONArray people = (JSONArray) astros.get("people");
        List<Person> astronauts = new ArrayList<>();
        for (Object o : people) {
            Person person = new Person();
            JSONObject astronaut = (JSONObject) o;
            String fullName = (String) astronaut.get("name");
            String[] splitName = fullName.split(" ");
            if (splitName.length > 1) {
                person.setFirstName(splitName[0]);
                StringBuilder lastName = new StringBuilder();
                for (int i = 1; i < splitName.length; i++) {
                    lastName.append(splitName[i]);
                    if (splitName.length - 1 > i) {
                        lastName.append(" ");
                    }
                }
                person.setLastName(lastName.toString());
                astronauts.add(person);
            }
        }
        System.out.println(astronauts);



    }
}
