import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App{

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/",(request,response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template","templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words", (request,response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("words",Word.all());
      model.put("template","templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      String theWord = request.queryParams("word");
      Word aWord = new Word(theWord);
      model.put("words",Word.all());
      model.put("template","templates/index.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    get("/words/:id",(request,response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      Word aWord = Word.find(Integer.parseInt(request.params(":id")));
      Definition.clear();
      model.put("word", aWord);
      if(aWord != null){
        model.put("definitions",aWord.getDefinitions());
      }
      model.put("template","templates/definitions.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    get("/words/:id/definition/add", (request,response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      Word aWord = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word",aWord);
      model.put("template","templates/definition-form.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    post("/words/:id", (request,response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      Word aWord = Word.find(Integer.parseInt(request.queryParams("wordId")));
      String strDefinition = request.queryParams("definition");
      Definition aDefinition = new Definition(strDefinition);
      aWord.addDefinition(aDefinition);
      model.put("definitions",Definition.all());
      model.put("word",aWord);
      model.put("template","templates/definitions.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

  }
}
