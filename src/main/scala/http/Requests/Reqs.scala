package http.Requests

import java.net.SocketTimeoutException
import scalaj.http._

/**
  * Created by Basil on 20/09/2016.
  */
case class Reqs(val url: String) {
  def code: Int = response._1 match {
    case None => 0
    case Some(r) => r.code
  }
  def body: String = response._1 match {    //Map[String, Any]
    case None => ""
    case Some(r) => r.body
  }
  def err: Boolean = response._1 match {
    case None => true
    case Some(y) => false
  }
  def message: String = response._2

  private lazy val response: (Option[HttpResponse[String]],String) = try {
    (Some(Http(url).asString),"OK")
  } catch {
    case e: SocketTimeoutException => (None, "No connection available.")
    case e: Throwable => (None, "Unknown error: " + e.getMessage)
  }
}

trait Gets {
  def code: Int
  def url: String
}

// facade?

case object Heartbeat extends Gets {
  override def url: String = "https://api.stockfighter.io/ob/api/heartbeat"
  override def code = req.code
  def ok: Boolean = body("ok")
  def error: String = body("error")
  private val req = Reqs(url)

}

case object Date extends Gets {
  override def url: String = "http://date.jsontest.com/"
  override def code = req.code
  def ok: Boolean = body("ok")
  def error: String = body("error")
  private val req = Reqs(url)
}
