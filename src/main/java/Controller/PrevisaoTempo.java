package Controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Temperatura;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class PrevisaoTempo {

    public  Temperatura previsao(String latitude, String longitude, String unix) throws ServletException, IOException {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&units=metric&lang=pt_br&dt=" + unix + "&APPID=f35065069b65d05ae8fc4ff470d4c910");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) conexao.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();
            JsonObject objs = (JsonObject) jsonobj.get("main");
            String temp = objs.get("temp").getAsString();
            String min = objs.get("temp_min").getAsString();
            String max = objs.get("temp_max").getAsString();
            Temperatura temperatura = new Temperatura(temp, min, max);
            return temperatura;

    }

}



