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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mtosic on 9/30/16.
 */
public class AStoIgrati {

  public enum Action {
     CHECK_FOLD ("1"),
     FOLLOW ("2"),
     RAISE ("3"),
     ALL_IN ("4");

     private String value;

     Action(String value) {
       this.value = value;
     }

     public Integer getValue() { return Integer.parseInt(value);}
   }


  private List<CardCombination> cardCombinations = new ArrayList<CardCombination>();

  public AStoIgrati() {
    cardCombinations.add(new ThreeOfAKind());
    cardCombinations.add(new Pair());
    cardCombinations.add(new TwoPairs());
  }

  public Action staOdigrati(CardCollection hand) {
    Action currentAction = Action.CHECK_FOLD;

    for (CardCombination cardCombination : cardCombinations) {
      Action action = cardCombination.action(hand);

      if (action.getValue() > currentAction.getValue()) {
        currentAction = action;
      }
    }

    System.out.println("ODIGRATI: " + currentAction.toString());
    return currentAction;
  }
}
