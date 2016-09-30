package org.leanpoker.combinations;

import org.leanpoker.player.Card;
import org.leanpoker.player.CardCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ajovanovic on 9/30/16.
 */
public class Straight extends CardCombination {

  int currentBet;
  int newBet;
  public Straight(int currentBet, int newBet) {
    this.currentBet = currentBet;
    this.newBet = newBet;
  }

  @Override
  public AStoIgrati.Action action(CardCollection hand) {
    AStoIgrati.Action action = AStoIgrati.Action.FOLD;

    Map<Card.CardSign, Integer> mapa = poZnaku(hand);
    int max = getMaxOfSameColour(mapa);
    int brKarata = hand.getCardsInHand().size();


    if(max >= 5){
      return AStoIgrati.Action.ALL_IN;
    }

    if(brKarata == 2 && max == 2){
      action = AStoIgrati.Action.FOLLOW;
    }
    else if(brKarata == 5){
      if(max > 3){
        return AStoIgrati.Action.RAISE;
      }
      if(max > 2){
        return AStoIgrati.Action.FOLLOW;
      }
    }
    else if(brKarata == 6){
      if(max > 3){
        return AStoIgrati.Action.FOLLOW;
      }
      if(max > 2){
        return AStoIgrati.Action.CHECK;
      }
    }

    return action;
  }

  @Override
  protected boolean combinationHit(CardCollection hand) {
    return false;
  }

  private Map<Card.CardSign, Integer> poZnaku(CardCollection hand) {

    int[] cards = countCards(hand);

    List<Integer> nizKarataUNizu = new ArrayList<>();

    Map<Card.CardSign, Integer> mapa = new HashMap<>();

    mapa.put(Card.CardSign.DIAMONDS, 0);
    mapa.put(Card.CardSign.CLUBS, 0);
    mapa.put(Card.CardSign.HEARTS, 0);
    mapa.put(Card.CardSign.SPADES, 0);

    for (Card card : hand.getCardsInHand()) {
      Integer brojKarata = mapa.get(card.getSuit());
      brojKarata++;
      mapa.put(card.getSuit(), brojKarata);
    }

    return mapa;
  }

  private int getMaxOfSameColour(Map<Card.CardSign, Integer> mapa){
    int[] a = {mapa.get(Card.CardSign.CLUBS), mapa.get(Card.CardSign.HEARTS),mapa.get(Card.CardSign.SPADES),mapa.get(Card.CardSign.DIAMONDS)};
    int max = 0;
    for(int b : a){
      if (b > max){
        max = b;
      }
    }
    return max;


  }
}
