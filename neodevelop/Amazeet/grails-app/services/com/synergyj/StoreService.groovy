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
}
