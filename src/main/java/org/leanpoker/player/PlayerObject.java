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

/**
 * Created by mtosic on 9/30/16.
 */
public class PlayerObject {

  private String id;
  private String name;
  private Status status;
  private String version;
  private Double stack;
  private Double bet;

  public enum Status {
    ACTIVE ("active"),
    FOLDED ("folded"),
    OUT ("out");


    private String value;

    Status(String value) {
      this.value = value;
    }

    public String getValue() {
        return value;
      }
  }

  public PlayerObject() {};

  public PlayerObject(String id, String name, Status status, String version, Double stack, Double bet) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.version = version;
    this.stack = stack;
    this.bet = bet;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Double getStack() {
    return stack;
  }

  public void setStack(Double stack) {
    this.stack = stack;
  }

  public Double getBet() {
    return bet;
  }

  public void setBet(Double bet) {
    this.bet = bet;
  }
}
