package http

import java.net.SocketTimeoutException

import scalaj.http._

/**
  * Created by Basil on 20/09/2016.
  */
object Requestors {

  def heartbeat: Option[HttpResponse[String]] = try {
    Some(Http("https://api.stockfighter.io/ob/api/heartbeat").asString)
  } catch {
    case e: SocketTimeoutException => {println("No connection available."); None}
    case _: Throwable => {println("Unknown error."); None}
  }

  def jsonTest: Option[HttpResponse[String]] = try {
    Some(Http("http://date.jsontest.com/").asString)
  } catch {
    case e: SocketTimeoutException => {println("No connection available."); None}
    case _: Throwable => {println("Unknown error."); None}
  } // "http://date.jsontest.com/"

}
