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

/**
 * Created by mtosic on 9/30/16.
 */
public class Card {

  private CardSign suit;
  private CardNumber rank;

  public Card(CardSign suit, CardNumber rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public Card() {}

  public enum CardSign {
    HEARTS ("hearts"),
    SPADES ("spades"),
    CLUBS ("clubs"),
    DIAMONDS ("diamonds");


    private String value;

    CardSign(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }


  public enum CardNumber {
    ONE ("1"),
    TWO ("2"),
    THREE ("3"),
    FOUR ("4"),
    FIVE ("5"),
    SIX ("6"),
    SEVEN ("7"),
    EIGHT ("8"),
    NINE ("9"),
    TEN ("10"),
    J ("12"),
    A ("11"),
    Q ("13"),
    K ("14");


    private String value;

    CardNumber(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    public Integer getIntValue() { return Integer.parseInt(value);}
  }

  public CardSign getSuit() {
    return suit;
  }

  public void setSuit(CardSign suit) {
    this.suit = suit;
  }

  public CardNumber getRank() {
    return rank;
  }

  public void setRank(CardNumber rank) {
    this.rank = rank;
  }
}
