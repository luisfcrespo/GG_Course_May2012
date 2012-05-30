package com.synergyj

import grails.converters.*

class ProductRestController {

  def jdbcTemplate

  def show = {
    log.debug params
    log.debug jdbcTemplate.dump()
    def c = jdbcTemplate.queryForInt("select count(*) from product")
    log.debug "$c items en la tabla"
    if(params.id && Product.exists(params.id)){
      def p = Product.get(params.id)
      render p as JSON
    }else{
      def all = Product.list()
      render all as JSON
    }
  }

  def save = {
    log.debug params
    def p = new Product(params.product)
    log.debug(p.dump())
    if(p.validate()){
      p.save()
      render p as JSON
    }else{
      render p.errors as JSON
    }
  }

  def delete = {
    log.debug "Deleting"
    render ([]) as JSON
  }

}
