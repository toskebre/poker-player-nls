package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        JsonObject obj = request.getAsJsonObject();
        int ind = obj.get("in_action").getAsInt();
        JsonArray igraci = obj.getAsJsonArray("players");
        JsonObject mi = igraci.get(ind).getAsJsonObject();
        JsonArray nase_karte = mi.get("hole_cards").getAsJsonArray();
        if (nase_karte.get(0).getAsJsonObject().get("rank").getAsString() == nase_karte.get(0).getAsJsonObject().get("rank").getAsString()){
            return obj.get("current_buy_in").getAsInt() - mi.get("bet").getAsInt() + obj.get("minimum_raise").getAsInt();
        }
        return 0;
    }

    public static void showdown(JsonElement game) {
    }
}
