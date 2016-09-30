package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.leanpoker.combinations.AStoIgrati;

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

        CardCollection kolekcija = new CardCollection();
        Card karta;
        int zbir = 0;
        int brKarata = nase_karte.size();
        for (JsonElement jsonElement : nase_karte) {
            String suit = jsonElement.getAsJsonObject().get("suit").getAsString().toUpperCase();
            String rank = jsonElement.getAsJsonObject().get("rank").getAsString().toUpperCase();
            String r = rank;
            switch (rank){
                case "A":
                    r = "14";
                    break;
                case "J":
                    r = "11";
                    break;
                case "Q":
                    r = "12";
                    break;
                case "K":
                    r = "13";
                    break;
            }
            zbir += Integer.parseInt(r);

            karta = new Card(Card.CardSign.valueOf(suit), Player.getNumber(r));
            kolekcija.addCard(karta);
        }


        int br_istih_sa_1 = 0;
        int br_istih_sa_2 = 0;

        for (JsonElement jsonElement : karte_na_stolu) {
            String suit = jsonElement.getAsJsonObject().get("suit").getAsString().toUpperCase();
            String rank = jsonElement.getAsJsonObject().get("rank").getAsString().toUpperCase();

            if(jsonElement.getAsJsonObject().get("rank").getAsString().equals(nase_karte.get(0).getAsJsonObject().get("rank").getAsString())){
                br_istih_sa_1++;
            }
            if(jsonElement.getAsJsonObject().get("rank").getAsString().equals(nase_karte.get(1).getAsJsonObject().get("rank").getAsString())){
                br_istih_sa_2++;
            }

            String r = rank;
            switch (rank){
                case "A":
                    r = "14";
                    break;
                case "J":
                    r = "11";
                    break;
                case "Q":
                    r = "12";
                    break;
                case "K":
                    r = "13";
                    break;
            }
            karta = new Card(Card.CardSign.valueOf(suit), Player.getNumber(r));
            kolekcija.addCard(karta);
        }

        AStoIgrati staIgrati = new AStoIgrati();
        AStoIgrati.Action action = staIgrati.staOdigrati(kolekcija);

        switch (action){
            case ALL_IN:
                return obj.get("current_buy_in").getAsInt() - mi.get("bet").getAsInt() + obj.get("minimum_raise").getAsInt();
            case FOLLOW:
                return obj.get("current_buy_in").getAsInt() - mi.get("bet").getAsInt();
            case RAISE:
                return obj.get("current_buy_in").getAsInt() - mi.get("bet").getAsInt() + obj.get("minimum_raise").getAsInt();
        }

        if (nase_karte.get(0).getAsJsonObject().get("rank").getAsString().equals(nase_karte.get(1).getAsJsonObject().get("rank").getAsString())){
            if (br_istih_sa_1 != 0){
                return obj.get("current_buy_in").getAsInt() - mi.get("bet").getAsInt() + obj.get("minimum_raise").getAsInt()  + obj.get("minimum_raise").getAsInt();
            }
            return obj.get("current_buy_in").getAsInt() - mi.get("bet").getAsInt() + obj.get("minimum_raise").getAsInt();
        }

        System.out.print("zbir karata je:");
        System.out.print(zbir);
        System.out.print("\nbr karata je:");
        System.out.print(brKarata);
        if (zbir > 16 || (zbir > 10 && brKarata == 1) || brKarata == 0){
            return obj.get("current_buy_in").getAsInt() - mi.get("bet").getAsInt() + obj.get("minimum_raise").getAsInt();
        }
        return 0;
    }

    public static void showdown(JsonElement game) {
    }

    public static Card.CardNumber getNumber(String number){
        switch (number){
            case "1":
                return Card.CardNumber.ONE;
            case "2":
                return Card.CardNumber.TWO;
            case "3":
                return Card.CardNumber.THREE;
            case "4":
                return Card.CardNumber.FOUR;
            case "5":
                return Card.CardNumber.FIVE;
            case "6":
                return Card.CardNumber.SIX;
            case "7":
                return Card.CardNumber.SEVEN;
            case "8":
                return Card.CardNumber.EIGHT;
            case "9":
                return Card.CardNumber.NINE;
            case "10":
                return Card.CardNumber.TEN;
            case "11":
                return Card.CardNumber.J;
            case "12":
                return Card.CardNumber.Q;
            case "13":
                return Card.CardNumber.K;
            case "14":
                return Card.CardNumber.A;
        }
    }

}
