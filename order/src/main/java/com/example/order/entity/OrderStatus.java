package com.example.order.entity;

public enum OrderStatus {
  ORDERED, CANCELLED, COMPLETED;

  private String value;

  public String getValue() {
    return value;
  }

  public boolean isOrdered() {
    return this == ORDERED;
  }

  public boolean isCancelled() {
    return this == CANCELLED;
  }

  public boolean isCompleted() {
    return this == COMPLETED;
  }


}
