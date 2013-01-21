package com.dimeder.llull


import models.Llull
import cc.spray.json._
import org.springframework.data.neo4j.conversion.EndResult
import org.slf4j.{LoggerFactory, Logger}

/**
 * Created with IntelliJ IDEA.
 * User: caente
 * Date: 14/01/13
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */


object DataProtocols extends DefaultJsonProtocol {

  implicit object llullProtocol extends JsonFormat[Llull] {
    val logger: Logger = LoggerFactory.getLogger(classOf[JsonFormat[Llull]])

    def read(value: JsValue) = value match {
      case JsObject(List(
      JsField("name", JsString(name)),
      JsField("father", JsString(father)))) =>
        val l = new Llull
        l.name = name
        l.father = new Llull(father)
        l
      case JsObject(List(JsField("name", JsString(name)))) =>
        val l = new Llull(name)
        l.name = name
        l
      case _ =>
        throw new DeserializationException("Llull expected")
    }


    def write(obj: Llull) = {
      def buildChildren(children: Set[Llull]): List[JsValue] = children match {
        case null => List()
        case _ => (children map (ch => ch.toJson)).toList
      }

      val father: String = obj.father match {
        case null => "-"
        case _ => obj.father.name
      }
      JsObject(JsField("name", JsString(obj.name)), JsField("father", JsString(father)), JsField("children", JsArray(buildChildren(obj.children))))
    }
  }

  implicit def toIterator[T](ci: EndResult[T]) =
    new ScalaEndResult[T](ci)

}
