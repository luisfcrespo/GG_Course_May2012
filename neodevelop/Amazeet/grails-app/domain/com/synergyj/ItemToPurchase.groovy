package com.synergyj

class ItemToPurchase implements Serializable {

  Product product
  Integer quantity
  Date dateCreated
  Date lastUpdated
  
  static belongsTo = [shoppingCart:ShoppingCart]
  
  static constraints = {
    quantity range:1..10
  }
}
