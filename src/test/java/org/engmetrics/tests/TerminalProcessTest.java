
package org.engmetrics.tests;

import org.engmetrics.cli.TerminalProcess;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TerminalProcessTest {
    
    public TerminalProcess terminalCommand;
    
    public TerminalProcessTest() {
    }
    
    
    @BeforeEach
    public void setUp() {
        
        this.terminalCommand = new TerminalProcess();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testIfConfigXMLExists() {
        
        String expResult = "tools/config.xml";
        this.terminalCommand.setConfigXMLPath(expResult);
        String result = this.terminalCommand.getConfigXMLPath();
        assertEquals(expResult, result, "config file pattern was violated");
    }
    
    /**
     * Check if exists the initial portion of a command
     */
    @Test
    public void testIfCommandPrefixExists() {
        
        String expResult = "java -jar";
        this.terminalCommand.setCommandPrefix(expResult);
        String result = this.terminalCommand.getCommandPrefix();
        assertEquals(expResult, result, "initial portion of a command not expected");
    }
    
    @Test
    public void testIfProgramExecutableWasSet() {
        
        String expResult = "tools/checkstyle.jar";
        this.terminalCommand.setProgramFile(expResult);
        String result = this.terminalCommand.getProgramFile();
        assertEquals(expResult, result, "program executable not find in command line");
    }

    /**
     * Test of getCommandEndFile method, of class TerminalProcess.
     */
    @Test
    public void testCommandLineStructureIsOk() {
        
        this.terminalCommand.setCommandPrefix("java -jar");
        this.terminalCommand.setProgramFile("tools/checkstyle.jar");
        this.terminalCommand.setConfigXMLPath("tools/config.xml");
        this.terminalCommand.setCommandEndFile("path/to/directory");
        TerminalProcess instance = null;
        String expResult = "java -jar ./tools/checkstyle.jar -c tools/config.xml path/to/directory";
        this.terminalCommand.runCommand();
        String result = this.terminalCommand.getCommandLine();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testRunCommandWithoutSetterConfig(){
        boolean execution = this.terminalCommand.runCommand();
        assertEquals(false, execution);
    }
    
}
