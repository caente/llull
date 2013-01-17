package com.dimeder.llull


import models.TextWord
import cc.spray.json._
import org.springframework.data.neo4j.conversion.EndResult
import repositories.ScalaEndResult

/**
 * Created with IntelliJ IDEA.
 * User: caente
 * Date: 14/01/13
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */
object DataProtocols  extends DefaultJsonProtocol{
  implicit  val timeProtocol:JsonFormat[TimeData] = lazyFormat(jsonFormat(TimeData,"name","time"))
  implicit  val textProtocol:JsonFormat[TextData] = lazyFormat(jsonFormat(TextData,"name","text"))

  implicit  val wordProtocol:JsonFormat[TextWord] = lazyFormat(jsonFormat(TextWord,"word"))

  implicit def toIterator[T](ci: EndResult[T]) =
    new ScalaEndResult[T](ci)

}
