import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class WordTest {

  @After
  public void tearDown(){
    Word.clear();
  }

  @Test
  public void newWord_CreatesANewWord_true(){
    Word wordTest = new Word("Amygdala");
    assertTrue(wordTest instanceof Word);
  }

  @Test
  public void getWord_ReturnsWord_Amygdala(){
    Word wordTest = new Word("Amygdala");
    String expectedOutcome = "Amygdala";
    assertEquals(expectedOutcome, wordTest.getWord());
  }

  @Test
  public void getDefinitions_ReturnsAllDefinition_List(){
    Word wordTest = new Word("Amygdala");
    assertEquals(0,wordTest.getDefinitions().size());
  }

  @Test
  public void addDefinition_AddsANewDefinition_1(){
    Word wordTest = new Word("Amygdala");
    Definition definitionTest = new Definition("a roughly almond-shaped mass of gray matter inside each cerebral hemisphere, involved with the experiencing of emotions.");
    wordTest.addDefinition(definitionTest);
    assertEquals(1,wordTest.getDefinitions().size());
  }

  @Test
  public void getId_RetrievesTheId_1(){
    Word wordTest = new Word("Amygdala");
    assertEquals(1,wordTest.getId());
  }

  @Test
  public void clear_ClearsTheArray_0(){
    Word wordTest = new Word("Amygdala");
    Word.clear();
    assertEquals(0,Word.all().size());
  }

  @Test
  public void all_findsWords_true(){
    Word wordTest = new Word("Amygdala");
    Word testWord = new Word("Oligodendrocyte");
    assertTrue(Word.all().contains(wordTest));
    assertTrue(Word.all().contains(testWord));
  }

  @Test
  public void find_FindsASpecificWord(){
    Word wordTest = new Word("Amygdala");
    Word testWord = new Word("Oligodendrocyte");
    assertEquals(testWord, Word.find(testWord.getId()));
  }
}
