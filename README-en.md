# Simple Code Metrics

Simple Code Metrics is a project to provide a simple program for Software Engineering students and researchers. The main idea is without prior knowledge, use this program in projects to obtain metrics from code structures. Currently only analyzes projects developed in Java.

[Click here to README in english](README-en.md)

![program screenshot](screenshot.png)

## Why?

The [Checkstyle.org](https://checkstyle.sourceforge.io/) project provides a complete tool to evaluate if Java code structures follow an implementation pattern (thank you very much contributors!). It is an excellent tool. But it requires a lot of configurations so that we can use it:  through its .jar executable or integrated into development environments (IDEs). The idea here is to use their rule-checking parsing to evaluate code metrics without extra configuration. All this through a simplified interface. Despite the objective of providing an analysis tool for those who are starting in the area of programming, others can benefit from it.

There is a future intention to be able to analyze projects implemented in other programming languages.


## Features
- Calculate the Cyclomatic Complexity of all project classes.


## How to use
Download the latest version. Needs only the Java JDK installed on the machine. The application directory has the .jar executable and a tools directory that has the necessary configuration files for the software to work. Run the .jar file and follow the onscreen instructions.

## Compatibility
- Java JDK 18 or above (there is an executable for Java 8);
- Operation Systems: Linux and Windows;

## Development
The project is developed in Java using [Maven](https://maven.apache.org/what-is-maven.html) as dependency manager. Check for settings and versions in pom.xml. JUnit5 is used in unit tests.

### How to contribute (development)
- Fork this project.
- Open or use an issue to exchange ideas (this helps to record what you are developing).
- Create a branch with the feature/fix description. Include the issue number in the branch name.
- Make the pull request.

### How to contribute (other ways)
- Report bugs;
- Propose improvements (include drawings or other specifications with as much detail as possible).

