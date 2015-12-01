package controllers

import play.api.libs.json.{JsValue, Json}
import play.api.mvc._

object User extends Controller {

  def index = Action {
    val json: JsValue = Json.obj(
      "data" -> "Not found :("
    )

    NotFound(json)
  }

  def show(id: Long) = Action {
    Ok(id.toString)
  }
}
