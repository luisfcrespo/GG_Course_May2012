// Place your Spring DSL code here
import org.springframework.jdbc.core.JdbcTemplate
import grails.spring.BeanBuilder

beans = {
  jdbcTemplate(JdbcTemplate){
    dataSource = ref("dataSource")
  }
}
