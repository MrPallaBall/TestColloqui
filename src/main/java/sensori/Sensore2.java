package sensori;

import config.Config;
import config.Defines;
import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;


/**
 * Created by palla on 08/01/16.
 */
public class Sensore2 extends Sensori {


    public Sensore2(){
        this.configController = Config.newInstance();
    }

    @Override
    public void callSensor() {
        URL url = null;
        String response = "";
        String url_str = configController.getProperty(Defines.SENSORE_2);
        String uri = StringUtils.replace(url_str, "_APPID_", configController.getProperty(Defines.APPID) );
        try {
            url = new URL(uri);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = readRequest(url, response);

        JSONArray list = (JSONArray) jsonObject.get("list");
        JSONObject jsonObjectList = (JSONObject) list.get(0);

        setName(Defines.NAME_SENSORE_2);

        Date dt = new Date(System.currentTimeMillis());
        setTime(dt);

        JSONObject jsonObjectMain = (JSONObject) jsonObjectList.get("main");

        setTemp(((Number) jsonObjectMain.get("temp")).doubleValue());
        setTemp_max(((Number) jsonObjectMain.get("temp_max")).doubleValue());
        setTemp_min(((Number) jsonObjectMain.get("temp_min")).doubleValue());
        setHumidity(((Number) jsonObjectMain.get("humidity")).longValue());

    }


}
