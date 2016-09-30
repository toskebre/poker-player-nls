package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "good ol' betware";

    public static int betRequest(JsonElement request) {
        JsonObject obj = request.getAsJsonObject();
        int ind = obj.get("in_action").getAsInt();
        JsonArray igraci = obj.getAsJsonArray("players");
        JsonObject mi = igraci.get(ind).getAsJsonObject();
        JsonArray nase_karte = mi.get("hole_cards").getAsJsonArray();
        JsonArray karte_na_stolu = obj.get("community_cards").getAsJsonArray();
        int br_istih_sa_1 = 0;
        int br_istih_sa_2 = 0;

        for (JsonElement jsonElement : karte_na_stolu) {
            if(jsonElement.getAsJsonObject().get("rank").getAsString() == nase_karte.get(0).getAsJsonObject().get("rank").getAsString()){
                br_istih_sa_1++;
            }
            if(jsonElement.getAsJsonObject().get("rank").getAsString() == nase_karte.get(1).getAsJsonObject().get("rank").getAsString()){
                br_istih_sa_2++;
            }
        }

        if (nase_karte.get(0).getAsJsonObject().get("rank").getAsString() == nase_karte.get(1).getAsJsonObject().get("rank").getAsString()){
            if (br_istih_sa_1 != 0){
                return obj.get("current_buy_in").getAsInt() - mi.get("bet").getAsInt() + obj.get("minimum_raise").getAsInt()  + obj.get("minimum_raise").getAsInt();
            }
            return obj.get("current_buy_in").getAsInt() - mi.get("bet").getAsInt();
        }
        return 0;
    }

    public static void showdown(JsonElement game) {
    }
}
