package tests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GraphReaderTest.class, GraphTest.class, VertexTest.class, EdgeTest.class })
public class AllTests {

}
