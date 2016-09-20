import http.Requests.{Heartbeat, Date}
import http.{Codes, Requestors}

/**
  * Created by Basil on 20/09/2016.
  */
object MainApp extends App {

  println("ScalaFighters App")

  println("Getting Heartbeat")

  val hb = Heartbeat
  val dt = Date

  println(hb.body)
  println(dt.body)

}
