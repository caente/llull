package com.dimeder.llull

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


