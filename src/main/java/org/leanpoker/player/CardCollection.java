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
package main.java.org.leanpoker.player;

import javax.smartcardio.Card;
import java.util.List;

/**
 * Created by mtosic on 9/30/16.
 */
public class CardCollection {

  private List<main.java.org.leanpoker.player.Card> cardsInHand;

  public CardCollection (List<main.java.org.leanpoker.player.Card> cardsInHand) {
    this.cardsInHand = cardsInHand;
  }

  public CardCollection(){}

  public List<main.java.org.leanpoker.player.Card> getCardsInHand() {
    return cardsInHand;
  }

  public void setCardsInHand(List<main.java.org.leanpoker.player.Card> cardsInHand) {
    this.cardsInHand = cardsInHand;
  }

  public void addCard(main.java.org.leanpoker.player.Card card) {
    cardsInHand.add(card);
  }
}
