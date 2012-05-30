package com.synergyj

class StoreController {

  def storeService
  
  def beforeInterceptor = {
    log.debug "Estoy en ${actionName} de ${controllerName}"
    if(!session.shoppingCart){
      def shoppingCart = new ShoppingCart(shoppingCartStatus:ShoppingCartStatus.SHOPPING)
      session.shoppingCart = shoppingCart
    }
    if(!session.shoppingCart.items){
      session.shoppingCart.items = []
    }
  }

  def index() {
    // Quiero mi catalogo de categorias para desplegar
    def products = Product.list(cache:true)
    [products:products]
  }
  
  def reviewItem = {
    // TODO:Obtener el id y mostrar el detalle del producto que escogio
    log.debug "Params: ${params}"
    redirect(controller:'product',action:'show',id:params.id)
  }
  
  def addItemAsync = {
    log.debug "hola a las ${new Date()}"
    def product = Product.get(params.long('productId'))
    def item = new ItemToPurchase(product:product,quantity:params.int('quantity'))
    session.shoppingCart.items << item
    Thread.sleep(3000)
    render template:'/store/myCart'
  }
  
  def addItem(){
    def product = Product.get(params.long('productId'))
    def item = new ItemToPurchase(product:product,quantity:params.int('quantity'))
    session.shoppingCart.items << item
    flash.message = "Has agregado un producto a tu carrito"
    redirect action:'index'
  }

  def doCheckout(){
    storeService.serviceMethod()
    redirect(action:'index')
  }
}
