package com.dimeder.llull

import cc.spray.json._
import org.springframework.stereotype.Component
import javax.ws.rs.{PathParam, Produces, GET, Path}
import java.text.SimpleDateFormat
import java.util.Date
import reflect.BeanInfo

/**
 * Created with IntelliJ IDEA.
 * User: caente
 * Date: 7/01/13
 * Time: 09:40 PM
 * To change this template use File | Settings | File Templates.
 */



@BeanInfo
case class TimeData(name: String, time: String)

@BeanInfo
case class TextData(name:String,text:String)
//
//object DataProtocol extends DefaultJsonProtocol {
//  implicit  val timeProtocol:JsonFormat[TimeData] = lazyFormat(jsonFormat(TimeData,"name","time"))
//  implicit  val textProtocol:JsonFormat[TextData] = lazyFormat(jsonFormat(TextData,"name","text"))
//}


import DataProtocols._

@Component
@Path("/data")
class TimeService  {
  val pattern = "MM.dd.yyyy HH:mm:ss"
  val df = new SimpleDateFormat(pattern)

  @GET
  @Produces(Array("application/json"))
  @Path("/time/{name}/")
  def time(@PathParam("name") name: String) = {
   (new TimeData(name, df.format(new Date()))).toJson.toString()
  }

  @GET
  @Produces(Array("application/json"))
  @Path("/text/{name}/")
  def text(@PathParam("name") name: String) = {
    (new TextData(name, "texto")).toJson.toString()
  }
}
