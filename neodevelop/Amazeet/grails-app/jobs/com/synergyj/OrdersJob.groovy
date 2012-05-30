package com.synergyj

class OrdersJob {
  static triggers = {
    cron name:"orderTrigger", cronExpression:"0/10 * * * * ?"
  }

  def execute() {
    log.debug "OrderJob a las ${new Date()}"
  }
}
