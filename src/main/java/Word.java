import java.util.List;
import java.util.ArrayList;

public class Word {
  private List<Definition> definitions;
  private String mWord;
  private int mId;
  private static List<Word> instances = new ArrayList<Word>();

  public Word(String word){
    mWord = word;
    definitions = new ArrayList<Definition>();
    instances.add(this);
    mId= instances.size();
  }

  public String getWord(){
    return mWord;
  }

  public List<Definition> getDefinitions(){
    return definitions;
  }

  public void addDefinition(Definition definition){
    definitions.add(definition);
  }

  public int getId(){
    return mId;
  }

  public static List<Word> all(){
    return instances;
  }

  public static void clear(){
    instances.clear();
  }

  public static Word find(int id){
    return instances.get(id-1);
  }
}
