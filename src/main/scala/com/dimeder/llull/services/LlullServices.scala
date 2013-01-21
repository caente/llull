package com.dimeder.llull.services

import org.springframework.stereotype.Component
import javax.ws.rs.{PathParam, Produces, GET, Path}
import com.dimeder.llull.models.Llull
import cc.spray.json._
import org.springframework.beans.factory.annotation.Autowired
import com.dimeder.llull.repositories.LlullRepository
import com.dimeder.llull.DataProtocols._
import org.slf4j.LoggerFactory

/**
 * Created with IntelliJ IDEA.
 * User: caente
 * Date: 14/01/13
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
 */

@Component
@Path("/words")
@Autowired
class LlullServices() {

  val logger = LoggerFactory.getLogger(classOf[LlullServices])

  @Autowired
  var llullRepository:LlullRepository= _


  @GET
  @Produces(Array("application/json"))
  @Path("/word/{name}/")
  def time(@PathParam("name") name: String) = {
    logger.info(llullRepository.toString)

    val llull = new Llull
    llull.name="josesito"
    llull.id=1

    val child = new Llull
    child.name = "nene"
    child.id=2

    val father= new Llull
    father.name="darth"
    father.children=Set(child,llull)

    llull.father=father
    child.father=father
    father.toJson.toString()
  }
}
