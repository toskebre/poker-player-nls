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
package org.leanpoker.player;

import java.util.List;

/**
 * Created by mtosic on 9/30/16.
 */
public class CardCollection {

  private List<Card> cardsInHand;

  public CardCollection (List<Card> cardsInHand) {
    this.cardsInHand = cardsInHand;
  }

  public CardCollection(){}

  public List<Card> getCardsInHand() {
    return cardsInHand;
  }

  public void setCardsInHand(List<Card> cardsInHand) {
    this.cardsInHand = cardsInHand;
  }

  public void addCard(Card card) {
    cardsInHand.add(card);
  }
}
