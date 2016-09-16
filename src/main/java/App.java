import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App{

  public static void main(String[] args) {
    //public thing goes here if need be
    String layout = "templates/layout.vtl";

    get("/",(request,response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template","templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      String theWord = request.queryParams("word");
      Word aWord = new Word(theWord);
      




    }, new VelocityTemplateEngine());
  }
}
