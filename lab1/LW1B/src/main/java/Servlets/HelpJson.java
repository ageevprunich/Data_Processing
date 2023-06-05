package Servlets;

import Entity.Refugees;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class HelpJson {
    public static JsonElement bodyParse(HttpServletRequest request) {
        JsonElement jsonElement=null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }



    public static Refugees refugeesParse(HttpServletRequest request) {
        Refugees refugees = new Refugees();
        JsonElement jsonElement = bodyParse(request);
        refugees.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        refugees.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        refugees.setAge(jsonElement.getAsJsonObject().get("age").getAsInt());
        refugees.setCity(jsonElement.getAsJsonObject().get("city").getAsString());
        return refugees;
    }

    public static int getNextId(List<Refugees> list) {
        int maxId = 0;

        Iterator<Refugees> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }

    public static int getIndexByRefugeesId(int id, List<Refugees> list) {
        int listId = id;

        Iterator<Refugees> iterator = list.iterator();
        while(iterator.hasNext()) {
            Refugees temp =iterator.next();
            if(temp.getId()==listId) {
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }
}
