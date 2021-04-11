package youtube.data.yt.util;

import java.util.HashMap;
import java.util.Map.Entry;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



public class BObject {

    public static HashMap<String,Object> toHashMap(JsonObject object){
        HashMap<String,Object> map=new HashMap<String,Object>();
        for(Entry<String, JsonElement> a :object.entrySet()){
            map.put(a.getKey(), a.getValue().toString());
        }
         
       return map;
    }
}
