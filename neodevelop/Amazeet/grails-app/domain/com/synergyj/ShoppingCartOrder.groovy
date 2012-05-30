package com.synergyj

class ShoppingCartOrder implements Serializable {

  //ShoppingCart shoppingCart
  ShoppingCartOrderStatus shoppingCartOrderStatus
  ShoppingCart shoppingCart
  Date dateCreated
  Date lastUpdated
  
  static hasOne = [payment:Payment]

  static constraints = {
  }
}
