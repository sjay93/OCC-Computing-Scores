# Computing Scores from Names

This is code for calculating the scores from the list of names. The application takes the name of the file from the user as an input and returns the total score of all the names in the file.

**Clone the project:**
1.  Clone the project from this link https://github.com/sjay93/OCC-Computing-Scores
****
**Build the project:**
1.  After cloning the project, navigate to the main directory and run the following command on command line interface:  
    _mvn clean install_
****
**Run the project:**
1.  On the command line interface run the following command,
  java -jar target/computingscores-0.0.1-SNAPSHOT.jar
  
2.  Then the project will ask for user input and then specify the complete path name:

3.  The project will compute the total scores and then the scores will be displayed as:
****
**Assumptions:**
1.  The input file should contain unique names.
2.  The input file can have multiple lines.
3.  The input file can have any characters (numbers, special characters).
4.  If any name contains more than one word, then the system will handle that.
5.  User running the system should have maven and Java installed.
