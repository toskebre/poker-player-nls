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
package main.java.org.leanpoker.combinations;

import org.leanpoker.player.CardCollection;
import org.leanpoker.player.Card;

/**
 * Created by mtosic on 9/30/16.
 */
public abstract class CardCombination {

  public abstract AStoIgrati.Action action(CardCollection hand);

  protected abstract boolean combinationHit(CardCollection hand);

  protected int[] countCards(CardCollection hand) {

    int[] cards = new int[15];

    for (Card card : hand.getCardsInHand()) {
      cards[card.getRank().getIntValue()] += 1;
    }

    return cards;
  }
}
