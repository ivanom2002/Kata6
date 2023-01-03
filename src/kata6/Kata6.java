package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import static java.util.stream.Collectors.joining;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Kata6 {
    
    public static void main(String[] args) throws IOException, JAXBException {
        String json = read("https://www.fruityvice.com/api/fruit/apple");
        Gson gson = new Gson();
        Apple apple = gson.fromJson(gson.fromJson(json, JsonObject.class).getAsJsonObject(), Apple.class);
        System.out.println(apple);
        
        JAXBContext context = JAXBContext.newInstance(Apple.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(apple, System.out);      
    }

    private static String read(String url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            return reader.lines().collect(joining());
        }
    }
}
