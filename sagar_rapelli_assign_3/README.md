# CSX42: Assignment 3
## Name: Sagar Rapelli

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=<inputFile.txt> -Darg1=<deleteFile.txt> -Darg2=<outputFile1.txt> -Darg3=<outputFile2.txt> -Darg4=<outputFile3.txt> -Darg5=<Logger-Value> 

Example:

The last argument is the Logger value. 
ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=outputFile1.txt -Darg3=outputFile2.txt -Darg4=outputFile3.txt -Darg5=3



-----------------------------------------------------------------------
## Description:

Implementation of Observer Pattern
  The Node class implements the observer pattern. It implements the SubjectI and ObjectI interface.

  - When a new node is created using createNode() in TreeBuilder.java, it is cloned twice using clone() and the references of two cloned nodes are added to the observer array(backup[]) of the original node using the add(Node n) in Node.java.
  - When the orig node gets updated (i.e course is added or deleted), it calls the notifyAll(String, Operation) in Node.java which calls the update(String, Operation) on each of the observer(backup[]) references. So this makes sure whenever the node is changed its observer nodes are also updated.


Binary Search tree has been used for the tree.

An array used for storing the references of backup nodes in Node class.
  - The time complexity of insertion and searching is O(1) in this case.


The method for reading from file i.e. readLine() in FileProcessor.java 
has been implemented by using reference from
"https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html"


The method for writing to file i.e. writeToFile() in Results.java 
has been implemented by using reference from
"https://docs.oracle.com/javase/8/docs/api/index.html?java/io/FileWriter.html"


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: -- 07/07/19


