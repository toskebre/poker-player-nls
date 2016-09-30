//==============================================================================
// Copyright (c) 2016 by Betware.
// Holtasmári 1, Kópavogur, Iceland.
// All rights reserved.
//
// This software is the confidential and proprietary information
// of Betware ("Confidential Information").  You
// shall not disclose such Confidential Information and shall use
// it only in accordance with the terms of the license agreement
// you entered into with Betware.
//==============================================================================
package org.leanpoker.combinations;

import org.leanpoker.player.CardCollection;

/**
 * Created by mtosic on 9/30/16.
 */
public class Pair extends CardCombination {

  public AStoIgrati.Action action(CardCollection hand) {
    boolean combinationHit = combinationHit(hand);
    if (combinationHit) {
      System.out.println("NADJEN PAR. RAISE");
      int cardNumber = getPairNumber(hand);
      if (hand.getCardsInHand().size() > 5 && cardNumber > 7) {
        return AStoIgrati.Action.ALL_IN;
      }

      if (cardNumber >=13) {
        return AStoIgrati.Action.ALL_IN;
      }
      if (cardNumber >= 11 )
        return AStoIgrati.Action.RAISE;
      if (cardNumber >= 8)
        return AStoIgrati.Action.FOLLOW;
      return AStoIgrati.Action.FOLD;
    } else {
      System.out.println("PAR NIJE NADJEN. CHECK FOLD");
      return AStoIgrati.Action.FOLD;
    }
  }
  public int getPairNumber(CardCollection hand) {
    int[] cards = countCards(hand);
    int cardNumberGot = 0;
    for (int cardNumber : cards) {
      if (cardNumber == 2){
        cardNumberGot = cardNumber;
      }
    }
    return cardNumberGot;
  }


  public boolean combinationHit(CardCollection hand) {

    int[] cards = countCards(hand);

    for (int cardNumber : cards) {
      if (cardNumber == 2) {
        return true;
      }
    }

    return false;
  }
}
