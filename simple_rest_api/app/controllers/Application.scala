package controllers

import play.api._
import play.api.libs.json.{Json, JsValue}
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    val json: JsValue = Json.obj(
      "message" -> "Not found :("
    )

    NotFound(json)
  }

}