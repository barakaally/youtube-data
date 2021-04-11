package youtube.data.yt.util;
import java.util.HashMap;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
/**
 * @description the BHashMap
 */
public class BHashMap {
    /**
     * 
     * @param keyValuePair 
     * @return JsonElement return the JsonElement
     */
    public static JsonElement toJsonElement(HashMap<String,Object> keyValuePair){
    
        String json=new GsonBuilder().disableHtmlEscaping().create().toJson(keyValuePair);
        return  new GsonBuilder().disableHtmlEscaping().create().fromJson(json.toString(), new TypeToken<JsonElement>(){}.getType());
       
    }
}
