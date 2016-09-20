package http

/**
  * Created by Basil on 20/09/2016.
  */
object Codes {

  def parseCode(code: Int): String = code match {
    case 200 => "OK"
    case i => "New Code: " + i
  }

}
