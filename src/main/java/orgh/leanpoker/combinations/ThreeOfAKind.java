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
package main.java.orgh.leanpoker.combinations;

import org.leanpoker.player.Card;
import org.leanpoker.player.CardCollection;

/**
 * Created by mtosic on 9/30/16.
 */
public class ThreeOfAKind implements CardCombination {

  public Integer CHECK_FOLD_CARD_IN_GAME_LIMIT = 7;
  public Integer FOLLOW_CARD_IN_GAME_LIMIT = 7;
  public Integer RAISE_CARD_IN_GAME_LIMIT = 5;

  public ThreeOfAKind() {}

  public Integer action(CardCollection hand) {
//    for (Card card : hand)
    return 1;
  }

  public boolean combinationHit(CardCollection hand) {

    int[] cards = new int[15];

    for (Card card : hand.getCardsInHand()) {

    }

    return false;
  }


}
