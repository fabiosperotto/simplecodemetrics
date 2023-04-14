package org.engmetrics.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class provide a way to execute commands in operation system users. 
 */
public class TerminalProcess {

    private String configXMLPath;
    private String programFile;
    private String outputText;
    private String commandPrefix;
    private String commandEndFile;
    private String commandLine;
    
    public TerminalProcess(){
        this.commandLine = "";
        
    }

    /**
     * TerminalProcess Constructor
     * @param prefix String initial part of the command (exam java -jar)
     * @param program String the main program used in command execution
     * @param endFile String folder or file to be the parameter value of the program
     * Example: <code>
     * TerminalProcess Constructor terminal = new TerminalProcess("java -jar", "tools/checkstyle.jar", "file.java")
     * </code>
     * 
     */
    public TerminalProcess(String prefix, String program, String endFile) {
        this.commandPrefix = prefix;
        this.programFile = program;
        this.commandEndFile = endFile;
        this.outputText = "";
        this.commandLine = "";
    }

    /**
     * TerminalProcess Constructor
     * @param prefix String initial part of the command (exam java -jar)
     * @param program String the main program used in command execution
     * @param configFile String program settings file 
     * @param endFile String folder or file to be the parameter value of the program
     * Example: <code>
     * TerminalProcess Constructor terminal = new TerminalProcess("java -jar", "tools/checkstyle.jar", tools/config.xml, "file.java")
     * </code>
     */
    public TerminalProcess(String prefix, String program, String configFile, String endFile) {
        this.configXMLPath = configFile;
        this.commandPrefix = prefix;
        this.programFile = program;
        this.commandEndFile = endFile;
        this.outputText = "";
        this.commandLine = "";
    }

    public String getConfigXMLPath() {
        return configXMLPath;
    }

    public void setConfigXMLPath(String configXMLPath) {
        this.configXMLPath = configXMLPath;
    }

    public String getProgramFile() {
        return programFile;
    }

    public void setProgramFile(String programFile) {
        this.programFile = programFile;
    }

    public String getCommandPrefix() {
        return commandPrefix;
    }

    public void setCommandPrefix(String commandPrefix) {
        this.commandPrefix = commandPrefix;
    }
    
    public String getCommandEndFile() {
        return commandEndFile;
    }

    public void setCommandEndFile(String commandEndFile) {
        this.commandEndFile = commandEndFile;
    }
    
    public String getOutputText() {
        return this.outputText;
    }

    public String getCommandLine() {
        return commandLine;
    }
    
    

    /**
     * This method executes a command line from the object constructor configuration.
     * @return boolean true if the command was successfully executed, false otherwise
     */
    public boolean runCommand() {
        
        if (this.commandPrefix == null || this.programFile == null || this.configXMLPath == null) return false;
        
      
        this.commandLine = String.format("%s ./%s -c %s %s", this.commandPrefix, this.programFile, this.configXMLPath, this.commandEndFile);
        
       
        try {
            
            ProcessBuilder processBuilder = new ProcessBuilder();
            boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
            if (isWindows) {
                processBuilder.command("cmd", "/c", this.commandLine);
                
            } else {
                processBuilder.command("sh", "-c", this.commandLine);
                //processBuilder.command("sh", "-c", "java -jar ./checkstyle/checkstyle.jar -c ./checkstyle/checks.xml /home/fsp/NetBeansProjects/ExemplosiText/src/main/java/com/mycompany/itext/jornal/Jornal.java");
            }
            
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF8"));
            String line = "";
            this.outputText = "";
            while ((line = reader.readLine()) != null) {
                this.outputText += "\n" + line;
            }

            return true;
        } catch (IOException ex) {
            Logger.getLogger(TerminalProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
