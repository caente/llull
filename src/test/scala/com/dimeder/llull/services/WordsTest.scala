package com.dimeder.llull.security

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.ContextConfiguration
import org.junit.{Before, Test}
import org.slf4j.LoggerFactory
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.neo4j.support.Neo4jTemplate
import com.dimeder.llull.models.Word
import com.dimeder.llull.repositories.WordRepository
import com.dimeder.llull.DataProtocols._

import collection.mutable.ListBuffer

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("classpath:applicationContext-test.xml"))
class WordsTest {
         val logger = LoggerFactory.getLogger(classOf[WordsTest])

  val word:Word = new Word

  @Autowired
  var template:Neo4jTemplate = _

  @Autowired
  var wordRepository:WordRepository= _

  @Before
  @Transactional
  def save(){
    word.text = "sustancia"
    word.info ="informacion"
    template.save(word)
  }

  @Test
  @Transactional
  def searchWordId(){
    val idWord:Word = template.findOne(word.id,classOf[Word])
    assert(word.text.equalsIgnoreCase(idWord.text),"El nodo guardado es el que se obtiene")
  }

  @Test
  @Transactional
  def searchWordText(){
    val textWord:Word = wordRepository.findByPropertyValue("text",word.text)
    assert(word.info.equalsIgnoreCase(textWord.info),"El nodo guardado es el que se obtiene")
  }

  @Test
  @Transactional
  def searchAll(){
    val list:ListBuffer[Word] = new ListBuffer[Word]
    for (u <- wordRepository.findAll()) list.append(u)
    assert(list.length==1,"Estan todos los objetos")
  }

}
