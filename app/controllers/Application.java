package controllers;

import play.*;
import play.data.*;
import play.mvc.*;
import views.html.*;

import static play.data.Form.form;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Home"));
    }
    public static Result login() {
        return ok(
                login.render(form(Login.class))
        );
    }
    public static class Login {

        public String email;
        public String password;

    }
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        return ok();
    }

    public static Result register(){
        return ok(register.render());
    }

}
