import java.util.List;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @After
    public void tearDown(){
      Definition.clear();
  }
  @Test
  public void definition_createDefinition_true(){
    Definition definitionTest = new Definition("a glial cell similar to an astrocyte but with fewer protuberances, concerned with the production of myelin in the central nervous system.");
    assertTrue(definitionTest instanceof Definition);
  }

  @Test
  public void getDefinition_RetrievesTheDefinition_String(){
    Definition definitionTest = new Definition("a glial cell similar to an astrocyte but with fewer protuberances, concerned with the production of myelin in the central nervous system.");
    String expectedOutcome = "a glial cell similar to an astrocyte but with fewer protuberances, concerned with the production of myelin in the central nervous system.";
    assertEquals(expectedOutcome, definitionTest.getDefinition());
  }

  @Test
  public void all_ShowsAllWords_List(){
    Definition definitionTest = new Definition("speed up the progress of; facilitate");
    Definition testDefinition = new Definition("having or showing arrogant superiority to");
    assertTrue(Definition.all().contains(definitionTest));
    assertTrue(Definition.all().contains(testDefinition));
  }

  @Test
  public void clear_ClearsTheArray_0(){
    Definition definitionTest = new Definition("speed up the progress of; facilitate");
    Definition.clear();
    assertEquals(0,Definition.all().size());
  }

  @Test
  public void getId_GetsIdOfCurrentDefinition_1(){
    Definition definitionTest = new Definition("speed up the progress of; facilitate");
    assertEquals(1,definitionTest.getId());
  }

  @Test
  public void find_FindsASpecificWord_2(){
    Definition definitionTest = new Definition("speed up the progress of; facilitate");
    Definition testDefinition = new Definition("having or showing arrogant superiority to");
    assertEquals(testDefinition, Definition.find(testDefinition.getId()));
  }



}
