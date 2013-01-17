package com.dimeder.llull.repositories

import org.springframework.data.neo4j.repository.GraphRepository
import com.dimeder.llull.models.Word
import org.neo4j.helpers.collection.ClosableIterable
import org.springframework.data.neo4j.conversion.EndResult

/**
 * Created with IntelliJ IDEA.
 * User: caente
 * Date: 14/01/13
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */

class ScalaEndResult[T](ci: EndResult[T]) {

  def foreach[U](f: (T) => U) {
    val i = ci.iterator()
      while (i.hasNext) {
        val t = i.next()
        f(t)
      }
  }
}


