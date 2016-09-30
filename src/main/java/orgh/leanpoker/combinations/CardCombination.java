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
package orgh.leanpoker.combinations;

import org.leanpoker.player.CardCollection;

/**
 * Created by mtosic on 9/30/16.
 */
public interface CardCombination {

  public Integer action(CardCollection hand);

  public boolean combinationHit(CardCollection hand);
}
