package controllers

import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import anorm._

object User extends Controller {

  def index = Action {
    SQL("SELECT id, firstname FROM users").map {
      case Row(id: Long, firstname: String) => UserModel()

      Ok(UserModel.toString())
    }

    NotFound("Ooops!")
  }

  def show(id: Long) = Action {


    Ok(id.toString)
  }
}

case class UserModel()
