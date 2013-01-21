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
//
//@BeanInfo
//case class JsonLlull(name:String)

@NodeEntity
case class Llull(n:String) {

  def this() = this(null)

  @GraphId
  var id: java.lang.Long = _

  @Indexed(indexName = "name", indexType = IndexType.FULLTEXT)
  var name: String = _

  var father:Llull = _

  var children:Set[Llull] = _

  override def equals(o:Any):Boolean = o match {
    case x:Llull =>x.id==this.id
    case _ => false
  }


  override def toString = {
    "%s".format(name)
  }
}
