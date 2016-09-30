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
      return AStoIgrati.Action.RAISE;
    } else {
      System.out.println("PAR NIJE NADJEN. CHECK FOLD");
      return AStoIgrati.Action.CHECK_FOLD;
    }
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
