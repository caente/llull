package com.dimeder.llull.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.{UsernamePasswordAuthenticationToken, AuthenticationManager}
import org.junit.After
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.Authentication
import org.springframework.test.context.ContextConfiguration

/**
 * Created with IntelliJ IDEA.
 * User: caente
 * Date: 14/01/13
 * Time: 04:03 PM
 * To change this template use File | Settings | File Templates.
 */

//@ContextConfiguration(Array("file:src/main/webapp/WEB-INF/llull-security.xml"))
class AbstractSecurityTest {
      @Autowired
      var am:AuthenticationManager =null

  @After
  def clear(){
    SecurityContextHolder.clearContext()
  }

  def login(name:String,password:String){
    val auth:Authentication = new UsernamePasswordAuthenticationToken(name,password)
    SecurityContextHolder.getContext.setAuthentication(auth)
  }
}
