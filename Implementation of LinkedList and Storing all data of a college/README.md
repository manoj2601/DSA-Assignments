# Data Structure and Algorithms Assignment1
1. Implementation of LinkedList using class "Node".
Total Classes : Course, CourseFullName, CourseGrade, Department, GradeInfo, Hostel, LinkedList, LinkedListIterator, newI, Node, Student.

Total LinkedLists : allHostels, allDepartments, allCourses, StuList, l2

allHostels: object-Hostel;
allDepartments: object-Department;
allCourses: object-Course;

function "getData" takes input of studentfilename and coursefilename;


Algorithm:
First, store all Students' data of file student.txt in a linkedlist named "StuList".

store the objects of "StuList" which belong to a perticular hostel. Store them in a linkedlist and store the name of the hostel and the list in linkedlist "allHostels".

store the objects of "StuList" which belong to a perticular Department. Store them in a linkedlist and store the name of the Department and the list in linkedlist "allDepartments".

store the objects of "StuList" which belong to a perticular course. Store them in a linkedlist and store the name of the course and the list in linkedlist "allCourses".

CGPA and completed credits are calculated individually.

In linkedlist l2, objects of class CourseFullName have been stored. Each object contains two strings, one denotes the name of a course and the other is the title of that course.

FileReader and BufferedReader have been used to read a text file.

Bubble Sort method has been applied to sort an array.

On each iteration of a linkedlist, First I checked the head element individually and later I iterated the whole list.



DETAILED EXPLANATION:
1. after creating the classes with corresponding interfaces, I created 5 LinkedLists allHostels, allDepartments, allCourses, StuList and l2.
2. Then I created a private void function getData, which stores all the information in above mentioned linkedlists.
3. For reading files, I used FileReader and BufferedReader.
4. By split function, I created a String array, in which I stored the information of each student. After this, I created an object of Student class and stored the information which is given in students.txt file. and add this object to StuList linkedList. 
5. For each student, I checked his/her hostel with the parellel of 4th step and if that hostel is not present in allHostels linkedlist already, then I created a new linkedlist and add that student in the list. And created an object of class Hostel and add that hostel's name and that new linkedlist in the object. And add that object to allHostels linkedlist.
6. If someone's hostel is already present in allHostels linkedlist, then I added that student's object of StuList in the list of the object of allHostels corresponding to that hostel.
7. I did the same thing for all Departments and allCourses.
8. And in linkedlist l2, I filled the list with the objects of CourseFullName class with the coursename and title.

9. In the private function, "answerQueries" first I took input of file query.txt and store all queries in an array using split function.
10. After this, I excuted reverse-for loop for query array. And got all queries in reverse order.
11. I assumed three conditions, for the queries, which starts with "COURSETITLE", I excuted l2 linkedList and took output of Course title.
12. If query starts with "SHARE", I first checked allHostels whether the third word of the query is matched with the name of a hostel or not.
13. Same thing did with linkedlists allCourses and allDepartments.
14. If the third word matches with any of these three lists, store all entryNos of the list of corresponding object except the given entryNo, and sort them with bubbleSort and take output of all entryNos except the given entryNo and break the loop.
15. If the query start with "INFO" then we have to provide complete information of that given student. For Name, EntryNo, Department, hostel, and CGPA with the help of list StuList.
16. For the courses and their grade, I created new object of CourseGrade class and create two different arrays of String. 
17. I filled the name of all courses in the first array and corresponding course title in the second array with same index.
18. Now for the laxicographic order of those coursenames, I used BubbleSort with for first array and changed the index of second array same as first array.
19. Finally took output of both arrays using for loop.

//Syntax reference : 
LinkedLst concept : GeeksForGeeks
Sorting of an array : BubbleSort
split of a string concept : GeeksForGeeks
Reading of a file: JavaPoint
CGPA upto two decimal digits : discussed with a friend.



Thanks
Manoj Kumar
2018CS50411
http://web.iitd.ac.in/~csz188551/COL106_2019/assignment1/assignment1.html
