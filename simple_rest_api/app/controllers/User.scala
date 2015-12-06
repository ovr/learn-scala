package controllers

import play.api.db.DB
import play.api.mvc._
import play.api.libs.json.{JsValue, JsString, Json}
import anorm._
import play.api.Play.current
import anorm.SqlParser._
import anorm._

case class UserEntity (id: Long, firstname: String)

object User extends Controller {

  def index = Action {
    DB.withConnection { implicit connection =>
      val list = SQL("SELECT id, firstname FROM users").as(userParser.*).toList
      implicit val userEntityFormat = Json.format[UserEntity]
      Ok(Json.toJson(list))
    }
  }

  private val userParser = {
    int("id") ~ get[String]("firstname") map flatten map { res =>
      UserEntity(res._1, res._2)
    }
  }

  def show(id: Long) = Action {
    DB.withConnection { implicit connection =>
      val user = SQL("SELECT id, firstname FROM users WHERE id = " + id).as(userParser.*)
      implicit val userEntityFormat = Json.format[UserEntity]

      if (user.isEmpty) {
        NotFound("User with id = " + id + " doesnot exist")
      } else {
        Ok(Json.toJson(user))
      }
    }

//    Ok(id.toString)
  }
}
