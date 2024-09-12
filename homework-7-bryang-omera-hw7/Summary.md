# Summary.md

Answer all the questions. Please put your answers _after_ the
italicized instructions, as shown in the
[video](https://northeastern.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=d327c168-e0e8-4f70-9f3f-b12f0048baac).

## Planning questions

### Partial solutions

During recursive backtracking, there is a partial solution that is passed
forward. For Sudoku and the N Queens Problem, it was a partly completed board.
For the Anagram Solver, it was words that were had been applied to the input
string. For example, if the input string was "husky bear", a partial solution
might be ["hub", "sky"].

**What is the partial solution for this problem?**

_State both the general answer, and provide a specific example for the
situation in the cartoon (like I did for the anagram solver)._ [5 points]

A partial solution for this problem can just be one appetizer on the menu, so that it less than 
the price it must add up to. So a partial solution can be one that is already started like you ordering 
one side salad for 3.35 which is less than 15.05, therefore, we will pass it on to the next addition of appetizers. 
### Legal moves

For Sudoku, legal moves were found by iterating over the digits 0-9 and determining
if that digit could be placed in the first empty square without conflicting with any
digits placed earlier. For the N Queens problem, legal moves were found by
iterating over row numbers and determining if a queen could be placed in that row of
the current column without threatening a placed queen. For the Anagram Solver, we
iterated over all the words in the dictionary and rejected words that could not be
formed from letters in the initial string that had not yet been matched. To continue
the example of finding an anagram for "husky bear", after adding "hub" and "sky"
to the partial solution, the remaining letters were "ear". Consequently, the
word "acre" would not be a legal move, but "ear" would be.

**How is a legal move determined for this problem?**

_State both the general answer, and provide a specific example._ [5 points]
A legal move determined for this problem is ordering any item that is less than 15.05 when added to what was
previous order combined. Let's say tou ordered Mixed fruit at 2.15, and French Fries at 2.75. If you ordered 
another french fry for 2.75 it is a legal move because 2.15+2.75+2.75<=15.05 is true. 

### Termination condition

Recursive backtracking requires a termination condition to know when we
have found a solution. For Sudoku, it is when all the squares contain a digit.
For the N Queens Problem, it is when the column number is off the edge of
the board (implying that all of the columns on the board have been filled).
For the Anagram Solver, it is when all the words in the initial string have
been matched.

**What is the termination condition for this problem?**

_How do we know when a partial solution is complete?_ [5 points]

A termination condition would be when the price of all appetizer is equal to the price goal. 
In this situation it is when the sum of all appetizers is equal to 15.05.

## Summary questions

### Where can we find your work on github?

_Give the usernames of all teammates and the HTTPS URL of the repository._ [1 point]
https://github.com/Fundies-2-Oakland/homework-7-bryang-omera-hw7

omerasmat1
guenbr

### Did you successfully implement everything that was requested?

_Either answer "Yes" or describe what you were and were not able to
implement._ [1 point]
Yes

### Does everything work, to the best of your knowledge? This includes autograder tests.

_Answer "Yes", or state here which parts did not work or which tests did not pass._ [1 point]
Yes

### What was the total amount of time you spent on the assignment?

_Rather than giving a range, if you are unsure, give the average of the range._
[1 point]

3 hours and around 45 minutes hours

### Who did you work with and how?

_Discussing the assignment with people not on your team is fine as long as you
don't share code._ [1 points]

We worked with Dylan Vo for two hours as our peer TA

### What resources did you use?

_Please give specific URLs (not just "Stack Overflow" or "Baeldung") and
state which ones were particularly helpful._ [1 point]

No outside resources were used besides peer TA's knowledge

### Reflections

Give one or more paragraphs reflecting on your experience with the
assignment, including answering all of these questions:

* What was the most difficult part of the assignment?
* What was the most rewarding part of the assignment?
* What did you learn doing the assignment?

The most difficult part of this assignment was implementing the first method to find a single viable 
solution to the problem. Which we had a better understanding of recursion.
After that it was fairly smooth sailing since Dylan did a very good job of explaining how it worked. 
The most rewarding part of this assignment for us was creating the tests and then writing the code and watching the 
tests pass as we progressed. During this assignment we learned how hashcode works and gained a refresher on 
test driven development since the past homework did not have any testing. This definitely helped my understand of how
recursive works and the difference between the function that returns only one solution and multiple solutions. 

_Constructive and actionable suggestions for improving assignments, office hours, and
lecture are always welcome. If there was a TA or classmate who was especially helpful,
say so._ [4 points]

We think that Labs should implement more direct concepts from the homeworks themselves. Other than this 
we think everything is pretty good at this point. Shout out to Dylan Vo for explaining in well detail and using a chalkboard
to help explain.

