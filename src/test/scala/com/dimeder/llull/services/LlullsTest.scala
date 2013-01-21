package com.dimeder.llull.services

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.ContextConfiguration
import org.junit.{Before, Test}
import org.slf4j.LoggerFactory
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.neo4j.support.Neo4jTemplate
import com.dimeder.llull.models.Llull
import com.dimeder.llull.repositories.LlullRepository
import com.dimeder.llull.DataProtocols._

import collection.mutable.ListBuffer

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("classpath:applicationContext-test.xml"))
class LlullsTest {
         val logger = LoggerFactory.getLogger(classOf[LlullsTest])

  val llull:Llull = new Llull

  @Autowired
  var template:Neo4jTemplate = _

  @Autowired
  var llullRepository:LlullRepository= _

  @Before
  @Transactional
  def save(){
    llull.name = "lever"
    template.save(llull)
  }

  @Test
  @Transactional
  def searchWordId(){
    val idLlull:Llull = template.findOne(llull.id,classOf[Llull])
    assert(llull.name.equalsIgnoreCase(idLlull.name),"El nodo guardado es el que se obtiene")
  }

  @Test
  @Transactional
  def searchWordText(){
    val nameLlull:Llull = llullRepository.findByPropertyValue("name",llull.name)
    assert(llull.id == nameLlull.id,"El nodo guardado es el que se obtiene")
  }

  @Test
  @Transactional
  def searchAll(){
    val list:ListBuffer[Llull] = new ListBuffer[Llull]
    for (u <- llullRepository.findAll()) list.append(u)
    assert(list.length==1,"Estan todos los objetos")
  }

  @Test
  @Transactional
  def children(){

  }

}
