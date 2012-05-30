package com.synergyj

class StoreService {

  def serviceMethod() {
    Product.withSession { session ->
      log.debug session.dump()
      log.debug session.properties
    }
    Product.withTransaction { status ->
      log.debug status.dump()
      log.debug status.properties
    }
    log.debug "Estoy en el método del servicio"
  }

  def saveShoppingCart(ShoppingCart shoppingCart){
    def shoppingCartToSave = new ShoppingCart(shoppingCart.properties)
    def totalAmount = 0
    shoppingCart.items.each{ item ->
      totalAmount += (item.quantity * item.product.price)
      shoppingCartToSave.addToItems(item)
    }
    shoppingCartToSave.save()
    def payment = new Payment(
      amount:totalAmount,
      commission:0,
      description:"Pago generado",
      paymentStatus:PaymentStatus.WAITING
    )
    def shoppingCartOrder = new ShoppingCartOrder(shoppingCartOrderStatus:ShoppingCartOrderStatus.PLACED,shoppingCart:shoppingCartToSave,payment:payment)
    shoppingCartOrder.save()
    payment
  }
}
