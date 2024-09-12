# SUMMARY

## List timing questions

DATASET TIMER RESULTS BELOW
Add each to front
Nanoseconds for LinkedListDataset: 387309
Nanoseconds for ArrayListDataset:  1050781 (663472 nanoseconds more)

Add each to back
Nanoseconds for LinkedListDataset: 184512
Nanoseconds for ArrayListDataset:  103669 (-80843 nanoseconds more)

Access random elements
Nanoseconds for LinkedListDataset: 5690335
Nanoseconds for ArrayListDataset:  22627 (-5667708 nanoseconds more)

Sort
Nanoseconds for LinkedListDataset: 835109
Nanoseconds for ArrayListDataset:  505930 (-329179 nanoseconds more)

### Which type of list is faster for adding to the front? Why?

_Please explain in a sentence or two._ [2 points]
A LinkedListDataset was faster for adding to the front. Because LinkedListDataset took 387309 nanoseconds while
ArrayListDataset took 1050781 nanoseconds.

### Which type of list is faster for accessing a random element? Why?

_Please explain in a sentence or two._ [2 points]
the ArrayListDataset was faster for accessing random elements because it takes 22627 nanoseconds while LinkedListDataset
took 5690335 nanoseconds.

### Why is Dataset an abstract class?

_Please explain in a sentence or two._ [2 points]
The reason why Dataset is an abstract class is because we do not use the dataset class, however, we use
ArrayListDataset and LinkedListDataset.

## Reflection questions

### Where can we find your work on Github?

_Give the usernames of all teammates and the URL of the repository._ [1 point]
Omer Asmat (omerasmat1)
Bryan Guen (guenbr)
https://github.com/Fundies-2-Oakland/homework-4-bryanguen_omerasmat

### Did you successfully implement everything that was requested?

_Either answer "Yes" or describe what you were and were not able to
implement._ [1 point]
Yes

### Does everything work, to the best of your knowledge?

_If the answer is not "Yes", please state here which parts did not work or
which tests did not pass._ [1 point]
Yes

### What was the total amount of time you spent on the assignment?

_Rather than giving a range, if you are unsure, give the average of the range. Use hours._
[1 point]
6-8 hours

### Who did you work with and how?

_Discussing the assignment with people not on your team is fine as long as you
don't share code._ [1 point]
This assignment was worked specifically between us while going to office hours. Dylan, Anish, and Daniel
assisted us when we had questions about compareTo and random as they helped bounce ideas with us.

### What resources did you use?

_Please give specific URLs and state which ones were particularly helpful.
You do not need to cite course materials._ [1 point]
https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#nextInt-int-

### Test coverage

_Did your tests cover every line of the `addToFront()`s, `getRandomRow()`,
`sortDataset()`, and `Row`'s `compareTo()` (and any helper methods you
created for them)? Did you submit a screenshot?
If not, please explain._ [1 point]
Yes, submitted screenshots through gradescope

### Reflections

_Give a few sentences reflecting on your experience with the assignment,
including what you learned and how TDD affects your development experience,
if at all. Suggestions for improving assignments, office hours, and lecture are
always welcome._

This assignment was a very good experience to writing the tests and fully understanding what the functions does before
implementing them. I like how we created sub classes and implementing them with abstract class. This assignment was
a good balance between challenging and medium. I think office hours were great as we attended them. However, I think
it would be beneficial i they were hosted not in dorms because the sign in is hard if you don't know anyone
that lives there.
[3 points]