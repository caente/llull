package com.dimeder.llull.security

import org.junit.runner.RunWith
import org.junit.Test
import org.springframework.mock.web.{MockFilterChain, MockHttpServletResponse, MockHttpServletRequest}
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created with IntelliJ IDEA.
 * User: caente
 * Date: 14/01/13
 * Time: 01:39 PM
 * To change this template use File | Settings | File Templates.
 */




//@RunWith(classOf[SpringJUnit4ClassRunner])
//@ContextConfiguration(Array("file:src/main/webapp/WEB-INF/llull-security.xml"))
class TestSecurity extends AbstractSecurityTest{

//  @Test
  def sec(){
       val request = new MockHttpServletRequest
    request.setServletPath("/services/words/word/mat")
        val response = new MockHttpServletResponse
        val chain = new MockFilterChain
        chain.doFilter(request,response)


  }
}
