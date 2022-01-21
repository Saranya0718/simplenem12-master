// Copyright Red Energy Limited 2017

package simplenem12;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.util.Collection;

public class SimpleNem12ParserImplTest {

    private File simpleNem12File;
    private SimpleNem12Parser simpleNem12Parser;

    @Before
    public void runBeforeEveryTest() {
        simpleNem12Parser = new SimpleNem12ParserImpl();
        ClassLoader classLoader = getClass().getClassLoader();
        simpleNem12File = new File(classLoader.getResource("SimpleNem12.csv").getFile());
    }

    @After
    public void runAfterEveryTest() {
        simpleNem12Parser = null;
    }

    @Test
    public void readNullFile()
    {
        Collection<MeterRead> meterReads = simpleNem12Parser.parseSimpleNem12(null);
        assertThat(meterReads).isEmpty();
    }

    @Test
    public void readNonExistingFile()
    {
        Collection<MeterRead> meterReads = simpleNem12Parser.parseSimpleNem12(new File(""));
        assertThat(meterReads).isEmpty();
    }

    @Test
    public void readFileWithoutContents()
    {
        simpleNem12File = new File(getClass().getClassLoader().getResource("SimpleNem12_Empty.csv").getFile());
        Collection<MeterRead> meterReads = simpleNem12Parser.parseSimpleNem12(new File(""));
        assertThat(meterReads).isEmpty();
    }

    @Test
    public void readFileWithout100Record()
    {
        simpleNem12File = new File(getClass().getClassLoader().getResource("SimpleNem12_Without100.csv").getFile());
        Collection<MeterRead> meterReads = simpleNem12Parser.parseSimpleNem12(new File(""));
        assertThat(meterReads).isEmpty();
    }

    @Test
    public void readFileWithout900Record()
    {
        simpleNem12File = new File(getClass().getClassLoader().getResource("SimpleNem12_Without900.csv").getFile());
        Collection<MeterRead> meterReads = simpleNem12Parser.parseSimpleNem12(new File(""));
        assertThat(meterReads).isEmpty();
    }

    @Test
    public void readFileWithout200Record()
    {
        simpleNem12File = new File(getClass().getClassLoader().getResource("SimpleNem12_Without200.csv").getFile());
        Collection<MeterRead> meterReads = simpleNem12Parser.parseSimpleNem12(new File(""));
        assertThat(meterReads).isEmpty();
    }

    @Test
    public void readFileInvalid200Record()
    {
        simpleNem12File = new File(getClass().getClassLoader().getResource("SimpleNem12_Invalid200.csv").getFile());
        Collection<MeterRead> meterReads = simpleNem12Parser.parseSimpleNem12(new File(""));
        assertThat(meterReads).isEmpty();
    }
}
