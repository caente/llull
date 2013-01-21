package com.dimeder.llull.models

import org.springframework.data.neo4j.annotation.{Indexed, GraphId, NodeEntity}
import org.springframework.data.neo4j.support.index.IndexType
import reflect.BeanInfo

/**
 * Created with IntelliJ IDEA.
 * User: caente
 * Date: 14/01/13
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */

@BeanInfo
case class TextWord(text:String)

@NodeEntity
class Llull {


  @GraphId
  var id: java.lang.Long = _

  @Indexed(indexName = "name", indexType = IndexType.FULLTEXT)
  var name: String = _


  override def toString = {
    "Llull: %s".format(name)
  }
}
