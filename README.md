## Exercise: EraDate (16 Points)

The project name of this exercise is **WaterState** Problem Description

The purpose of this assignment is to learn how to do comparisons using the if statement. Additionally, you get more practice on how to write all of your own code and Javadoc comments.

###Problem Description

In Japan, years are referred to using the Gregorian Calendar like we do here and also by the name of the Era (called nengou). The Era is related to the reign of the emperor and to specify a year you use the Era name combined with the year when the Era started. For example, 2014 is referred to as Heisei 26 because the current emporer of Japan's Era is called Heisei (hey-say) and it has been 26 years since the Era started.

The table below shows the last four Eras and when they started and ended*.

| Era Name | Start      | End        |
|----------|:----------:|:----------:|
| Meiji	   | 1/25/1868  | 7/30/1912  |
| Taisho   | 8/1/1912   | 12/25/1926 |
| Showa	   | 12/26/1926 | 1/7/1989   |
| Heisei   | 1/8/1989   | present    |

You are to write a program that will take a date and then print out the Japanese Era name (using something like a println)'

Your **Main.java** should contain code to implement your EraDate solution. Be sure to test the cases where one day is one Era and the next day is another (i.e. the edge cases).

Hints:

- You might want to use the GregorianCalendar object to hold your date representation.
- The GregorianCalendar object uses months from 0 to 11 rather than from 1 to 12 so adjust accordingly.
- The GregorianCalendar object defines the fields: Calendar.YEAR, Calendar.MONTH, and Calendar.DAY_OF_MONTH to be used with the get method.
- The GregorianCalendar object also has a getTimeInMillis method that returns the number of millisecond of the object. This simplifies comparisons.
- String.format is a method called by specifying the class name (String) then the method name (format). It returns a custom string using the same format string as the printf method.

### Getting Started

Like our last exercise, we are going to do this exercise by writing the source code that solves the problem first in **Main.java**. Using the techniques shown on the web page titled [How to Start Every Project in this Class](https://github.com/sbcc-cs105-spring2016/HowToStartEveryProject) create a source file called **Main.java**. This is where your code will go. 

Starting this week we don't have any code to copy for the assignment. You get to do it all! Don't forget to provide proper Javadoc documentation

Now go through Main.java, add the proper headers as in past assighments and then change the [CHANGE THIS TO YOUR INFORMATION] text to the proper items. There are two items to be changed.

Once you've written your code run the code by single clicking on **Main.java** in the package explorer and selecting **Run->Run** from the menu or using the keyboard shortcut. Examine the output. Does it do what you want? If not, how can you modify the code to do what you want?

###Running the Unit Tests

Next you'll want to run these unit tests. Start by right-clicking on the `unittest.cs105` package and selecting **Run As -> JUnit Test**. 

To go back to the project view, select the **Package Explorer** tab.

### How to turn in this exercise

The first step of turning in your code is to commit and push your code to GitHub. Once you've completed this step your code will be on GitHub in your repository, not the repository for the class. This will allow you to use all your projects later as a portfolio.

To start the process write click your project and select **Team -> Commit...** and follow the usual procedures.

####Completing the turn-in process

Now to complete the turn-in process, once you confirmed that your code is on GitHub, you need to create a **pull request** against the class GitHub repository. This action will indicate to the original project that you have finished your coding and it will create a place to give feedback on a line by line basis. 

Go to **your** repository for this assignment on GitHub and click on the **Pull Request** icon.
 
1\. Click on **New pull request**

2\. Click on **Create pull request**
