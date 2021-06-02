# Tri3Drone
# [p1-Drone Deployed Website](http://ec2-34-217-90-30.us-west-2.compute.amazonaws.com/) on AWS EC2

[p1-Drone Project Idea](https://docs.google.com/document/d/1XclmN6p6ZTHF3Li8fR3im8bIHbzxoyLGvw0yj-aHqR4/edit?usp=sharing)

[p1-Drone GitHub Repo](https://github.com/aryan114/Tri3Drone)

[p1-Drone Project Board](https://github.com/aryan114/Tri3Drone/projects/1)

## Umbrella Ticket 6/1

Umbrella Ticket (Overall Plan): [LINK](https://github.com/PranavKambhampati/Tri3Drone/issues/78)

This week, we worked on:
* Database Setup (Michael)
* Spring Security (Nakul)
* Form UI Refinement (Aryan)
* Chart.js for analytics (Pranav)

**1. [Database Setup](https://github.com/PranavKambhampati/Tri3Drone/issues/80):**
This week, AWS RDS was used as a live alternative to localhost used last week. The RDS VPC hosts a MySQL database that can be viewed inside of MySQLWorkbench or directly in IntelliJ's database viewer through its endpoint link. Database interaction is present through 3 HTML pages to perform Create, Read and Delete (not always working). Current errors include an SQL syntax error (I am not writing any SQL code because of javax.persistence use- hibernate) when trying to add a second POJO class. <br>
Next Week's Ticket [LINK](https://github.com/PranavKambhampati/Tri3Drone/issues/86)


**2. [Spring Security Create User Ticket](https://github.com/PranavKambhampati/Tri3Drone/issues/84):** This ticket was created by *Nakul Nandhakumar*. My goal this week was to implement the CreateUser HTML page for users to interact with and create their user account which must be used to login and access select portions of the website like the Forms section. I used CSS styling from our previous project last year to create a form that accepts usernames and passwords and validates them against a Java class which details parameters to check against and return an error if there is one. If the username and password are valid, the information is sent to a data transfer object created from the class NewUser which I created in order to store the information of the user. Currently, the create user page works as intended however the data transfer object created when submitting information does not link to the database so users are unable to log in with their newly created account. This will be fixed in the next ticket where database integration is the main priority and this is my goal for next week. I also have to set up the admin role and account with special permission. <br>
[Runtime Link]() <br>
[CreateUser HTML Code](https://github.com/PranavKambhampati/Tri3Drone/blob/master/src/main/resources/templates/security/createUser.html) <br>
[NewUser DTO Class](https://github.com/PranavKambhampati/Tri3Drone/blob/master/src/main/java/com/example/demo/Security/NewUser.java) <br>
[Spring Security CreateUser Controller](https://github.com/PranavKambhampati/Tri3Drone/blob/master/src/main/java/com/example/demo/Security/TemplateController.java#L30-L47) <br>
**[TICKET FOR NEXT WEEK](https://github.com/PranavKambhampati/Tri3Drone/issues/1)** <br>

**3. Form UI Refinement:** My *(Aryan)* goal this week was to display the created form on a new page and to also find a way to make the form more dynamic. I was able to accomplish the goal of showing the created form on a new page, however, I wasn't satisfied with how I made the form more dynamic. Currently, if you just type in the questions you desire (ex: you want 2 questions), then the form will only show 2 questions with populated results, with 3 other empty results. While this may be a solution, I am not pleased with it, and will look to either incorporate a list into the controller and research more this week or I will try to incorporate JavaScript files and HTML hidden variables in order to move through the number of questions the user requests for. <br>
[Runtime Link](http://ec2-34-217-90-30.us-west-2.compute.amazonaws.com/labs/CreateMC) <br>
[Link to Week of 5/31 Ticket](https://github.com/PranavKambhampati/Tri3Drone/issues/8) <br>
[Link to Week of 6/7 Ticket](https://github.com/PranavKambhampati/Tri3Drone/issues/67) <br>

**4. Chart.js:** This is a js library that can be used to produce graphs. Our idea was to use data from the polling service to generate graphs which would help the admin visualize the data. This week, I *(Pranav)* mostly spent my time setting up chart.js and experimenting with random data to generate graphs. I've basically created a template that help me in the next step. My next goal is to substitute the random data with actual data from the database to create more realistic charts. This is a link to my ticket for this, which outlines what I've worked on and provides code and runtime links: [LINK](https://github.com/PranavKambhampati/Tri3Drone/issues/79). <br>
Ticket for next week: [LINK](https://github.com/PranavKambhampati/Tri3Drone/issues/72). <br>



## Mini Review #1 Submission:
* [Binary Self Grade Link](https://docs.google.com/document/d/1JxNWZn2bUWhOfovqLVBmIACtPDtluWY6KuZ3SPmGEuw/edit)

## End Sprint #1 Submission (10/10):
* On Project Board, we have smart goals listed for each ticket as check-offs. Descriptions for each ticket is provided below binary grading.
* Commits for each person on their mini-lab can be seen in the branches section. Each scrum-member has their own branch, but these labs have now been deployed into **master**.
* All supplemental links are at the top of the README, including deployed project, and Project Idea with work-assignments for team members.
* Thymeleaf fragments for project can be see in Tri3Drone/src/main/resources/templates/fragments.
* **Mini-Labs** for each scrum member are located on **home-page** of website.

**_Group Requirements: 6pts/ 6pts_**
<table>
  <tr>
   <td><strong>Requirement</strong>
   </td>
   <td><strong>Scoring</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Project Plan</strong>
   </td>
   <td><a href="https://docs.google.com/document/d/1XclmN6p6ZTHF3Li8fR3im8bIHbzxoyLGvw0yj-aHqR4/edit?usp=sharing">LINK to Project Idea</a>
<p>
We have outlined what our project idea is and brainstormed possible ways we will manage project data in this document.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Project Idea to Support Individual Members Work within the plan</strong>
   </td>
   <td><a href="https://docs.google.com/document/d/1XclmN6p6ZTHF3Li8fR3im8bIHbzxoyLGvw0yj-aHqR4/edit#bookmark=id.envjpxv38sil">LINK to Project Idea</a>
<p>
There are tentative work-assignments on page 3 of the document. This is a basic guide on how we will split the work amongst ourselves.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Deployed Website</strong>
   </td>
   <td><a href="https://p1droneapp.herokuapp.com/">LINK to Deployed Website</a>
<p>
This is a link to the website we have deployed on Heroku. We will be switching to a unix-based deployment process next week possibly AWS or Microsoft Azure.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Thymeleaf Fragments in Version Control</strong>
   </td>
   <td><a href="https://github.com/PranavKambhampati/Tri3Drone/tree/master/src/main/resources/templates/fragments">LINK to Thymeleaf Fragments</a>
<p>
Our Thymeleaf Fragments can be accessed in the “fragments” folder from the link above. We have currently implemented a navbar(bootstrap) and a footer.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Scrum Board “In Progress" tickets active and assigned</strong>
   </td>
   <td><a href="https://github.com/PranavKambhampati/Tri3Drone/projects/1">LINK to Project Board with Tickets</a>
<p>
Our project board has tickets that have been assigned to each member in p1Drone. Each ticket also has SMART goals in the form of check-offs.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Scrum Board "Backlog" tickets defined for each member</strong>
   </td>
   <td><a href="https://github.com/PranavKambhampati/Tri3Drone/projects/1">LINK to Project Board with Tickets</a>
<p>
Project board has tickets in the “Backlog/To-Do” representing scrum-member assignments. Each person has at least one ticket that they need to work on.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
</table>


**_<span style="text-decoration:underline;">Individual Requirements:</span>_**

**_Pranav: 4/4_**
<table>
  <tr>
   <td><strong>Requirement</strong>
   </td>
   <td><strong>Scoring</strong>
   </td>
  </tr>
  <tr>
   <td><strong>“In Progress” Tickets for individual and initial commits in GitHub</strong>
   </td>
   <td><a href="https://github.com/PranavKambhampati/Tri3Drone/projects/1">LINK to Project Board with Tickets</a>
<p>
<a href="https://github.com/PranavKambhampati/Tri3Drone/graphs/contributors">LINK to Commits Chart</a>
<p>
In the first link, tickets that I’m currently working on can be seen in the “In Progress” column. Each ticket has SMART goals associated with it. My commits towards the master branch can be seen in the second link.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>“Backlog” Tickets for individual</strong>
   </td>
   <td><a href="https://github.com/PranavKambhampati/Tri3Drone/projects/1">LINK to Project Board with Tickets</a>
<p>
Tickets that I will be working on can be seen in the “Backlog/To-Do” Column. Each ticket has SMART goals associated with it.  
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Recursion Mini-Lab Deployed</strong>
   </td>
   <td><a href="https://p1droneapp.herokuapp.com/labs/PranavRecursion">LINK to Recursion Mini-Lab Deployed</a>
<p>
The link above takes you to my deployed factorial recursion minilab. There are also code-inserts here to show the different ways used to calculate each factorial.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Recursion MiniLab in GitHub</strong>
   </td>
   <td><a href="https://github.com/PranavKambhampati/Tri3Drone/tree/master/src/main/java/com/example/demo/Labs/PranavRecursion">LINK to Recursion Mini-Lab GitHub</a>
<p>
The link above takes you to my factorial recursion minilab in GitHub. Here, you can see the .java files associated with making my minilab work. To see the .html page, click this <a href="https://github.com/PranavKambhampati/Tri3Drone/blob/master/src/main/resources/templates/labs/PranavRecursionLab.html">LINK</a>.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
</table>

**_Michael: 4/4_**
<table>
  <tr>
   <td><strong>Requirement</strong>
   </td>
   <td><strong>Scoring</strong>
   </td>
  </tr>
  <tr>
   <td><strong>“In Progress” Tickets for individual and initial commits in GitHub</strong>
   </td>
   <td><a href="https://github.com/PranavKambhampati/Tri3Drone/issues/15">Current Ticket: SQLite Hibernate</a>
<p>
Initial commit completed with the <a href="https://github.com/PranavKambhampati/Tri3Drone/tree/database-setup/src/main/java/models">User, Form and Question</a> entities. This branch has @OneToOne and @OneToMany annotations, but this may not be the best way to approach relationships in the Hibernate/Lombok framework.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>“Backlog” Tickets for individual</strong>
   </td>
   <td>
<ol>

<li><a href="https://github.com/PranavKambhampati/Tri3Drone/issues/6">Default Hub View (Displays all Forms the User Can Access)</a>

<li><a href="https://github.com/PranavKambhampati/Tri3Drone/issues/26">Algos Sort Mini Lab</a>
<strong>(1pt)</strong>
</li>
</ol>
   </td>
  </tr>
  <tr>
   <td><strong>Recursion Mini-Lab Deployed</strong>
   </td>
   <td><a href="https://p1droneapp.herokuapp.com/labs/MichaelRecursion">Link to Insert Sort Mini-Lab Deployed</a>
<p>
Insertion Sort Lab has 3 approaches: for, while and recursion. Time is tracked using the example method and displayed in the table. Time analysis is displayed with the previous time for the sort, the rolling average of all sorts, and a comparison of the current sort to the rolling average (+/- nano seconds)
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Recursion MiniLab in GitHub</strong>
   </td>
   <td>
<ul>

<li>Logic takes input as comma separated number entry and <a href="https://github.com/PranavKambhampati/Tri3Drone/blob/30a74216eebd3417148f4e2d27a5beca88286255/src/main/java/com/example/demo/Labs/michael/insertSortModel/_InsertionSort.java#L50-L60">converts it to an int[] array</a>

<li><a href="https://github.com/PranavKambhampati/Tri3Drone/blob/30a74216eebd3417148f4e2d27a5beca88286255/src/main/java/com/example/demo/Labs/michael/insertSortModel/InsertSortFor.java#L11-L13">Statics</a> in each child class act as simple persistence to <a href="https://github.com/PranavKambhampati/Tri3Drone/blob/30a74216eebd3417148f4e2d27a5beca88286255/src/main/java/com/example/demo/Labs/michael/insertSortModel/InsertSortFor.java#L59-L66">track previous sort time, rolling average, and comparison to rolling average</a>

<li>Pass to model via <a href="https://github.com/PranavKambhampati/Tri3Drone/blob/30a74216eebd3417148f4e2d27a5beca88286255/src/main/java/com/example/demo/LabsController.java#L89-L95">sort interface list</a> in one object
<strong>(1pt)</strong>
</li>
</ul>
   </td>
  </tr>
</table>

**_Aryan: 4/4_**
<table>
  <tr>
   <td><strong>Requirement</strong>
   </td>
   <td><strong>Evidence</strong>
   </td>
  </tr>
  <tr>
   <td><strong>“In Progress” Tickets for individual and initial commits in GitHub</strong>
   </td>
   <td>My individual tickets can be seen in this link: <a href="https://github.com/PranavKambhampati/Tri3Drone/projects/1?card_filter_query=label%3Aaryan">LINK</a>
<p>
My commits towards the project can be seen here: <a href="https://github.com/PranavKambhampati/Tri3Drone/commits/master">LINK</a>
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>“Backlog” Tickets for individual</strong>
   </td>
   <td>My “backlog” tickets can be seen here: <a href="https://github.com/PranavKambhampati/Tri3Drone/projects/1?card_filter_query=label%3Aaryan">LINK</a>
<p>
Most of the goals are SMART goals and can be tracked through the checkboxes
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Recursion Mini-Lab Deployed</strong>
   </td>
   <td>Website with my deployed mini-lab (note due to technical difficulties during deployment, the time feature does not work for any mini-lab, however it works on the local host)
<p>
<a href="https://p1droneapp.herokuapp.com/labs/AryanRecursion">LINK</a>
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Recursion MiniLab in GitHub</strong>
   </td>
   <td>My recursion lab can be seen here: 
<p>
<a href="https://github.com/PranavKambhampati/Tri3Drone/blob/master/src/main/java/com/example/demo/Labs/AryanRecursion.java">LINK</a> (controller)
<p>
<a href="https://github.com/PranavKambhampati/Tri3Drone/blob/master/src/main/java/com/example/demo/LabsController.java#L47">LINK</a> (model)
<p>
<a href="https://github.com/PranavKambhampati/Tri3Drone/blob/master/src/main/resources/templates/labs/AryanRecursionLab.html">LINK</a> (view)
<p>
<a href="https://github.com/PranavKambhampati/Tri3Drone/blob/master/src/main/resources/templates/labs/AryanRecursionLab404.html">LINK</a> (view for 404 error)
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
</table>

**_Nakul: 4/4_**
<table>
  <tr>
   <td><strong>Requirement</strong>
   </td>
   <td><strong>Scoring</strong>
   </td>
  </tr>
  <tr>
   <td><strong>“In Progress” Tickets for individual and initial commits in GitHub</strong>
   </td>
   <td><a href="https://github.com/PranavKambhampati/Tri3Drone/projects/1?card_filter_query=label%3Anakul">LINK to Tickets</a>
<p>
<a href="https://github.com/PranavKambhampati/Tri3Drone/graphs/contributors">LINK to Commits Chart</a>
<p>
Currently, I am working on setting up a rudimentary login system with a default username and password and then link it to a database in a future ticket. I don’t have as many commits as the others but I have lots of code in every commit. However, I will try to commit more frequently as it is better practice.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>“Backlog” Tickets for individual</strong>
   </td>
   <td><a href="https://github.com/PranavKambhampati/Tri3Drone/projects/1?card_filter_query=label%3Anakul">LINK to Tickets</a>
<p>
Has been filtered with label “Nakul” so all tickets on screen will be the ones that I have participated in.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Recursion Mini-Lab Deployed</strong>
   </td>
   <td><a href="https://p1droneapp.herokuapp.com/labs/NakulRecursion">LINK to Lab</a>
<p>
Same as other team members, due to difficulties when deploying on Heroku the time analysis does not display however it does display when run on local host. Unknown reason for why as of now. Issue should be resolved when project is moved and deployed on AWS/RPI.
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Recursion MiniLab in GitHub</strong>
   </td>
   <td><a href="https://github.com/PranavKambhampati/Tri3Drone/blob/master/src/main/java/com/example/demo/LabsController.java#L29">LINK</a> (controller)
<p>
<a href="https://github.com/PranavKambhampati/Tri3Drone/blob/master/src/main/java/com/example/demo/Labs/NakulRecursion.java#L6">LINK</a> (model)
<p>
<a href="https://github.com/PranavKambhampati/Tri3Drone/blob/master/src/main/resources/templates/labs/NakulRecursion.html#L1">LINK</a> (view)
<p>
<strong>(1pt)</strong>
   </td>
  </tr>
</table>

### Tickets

##### Backlog Tickets
1. Admin Form Creator UI: Create a UI that admins can use to create forms for their groups.
2. Login/Logout/CreateUser Page: Create UI for users to login and logout and make new users. Need to connect this to database to store the credentials.
3. Spring Security Configuration: Add Spring Security to protect user credentials.
4. Default Hub View (Displays all forms that user can access): Create a Dashboard for the user which will serve as the main landing page. Users will be able to access forms here and admins will be able to make forms here.


##### In Progress Tickets
1. Michael Recursion Lab: Michael's Recursion Lab with base algo insertion sort (see master).
2. Setup Thymeleaf Fragments: Navbar and footer have been added to index.html. Other fragments have been set up, but not added yet.
3. Bootstrap CSS Styling: Used bootstrap code for navbar. Working on implementing bootstrap styling to other areas of the project.
4. User Form Response UI: Create a UI for normal users that would enable them to fill out forms that admins created.


##### Done Tickets
1. Aryan Recursion Lab: Aryan's Factorial Recursion Lab (see master).
2. Pranav Recursion Lab: Pranav's Factorial Recursion Lab (see master).
3. Nakul Recursion Lab: Nakul's Factorial Recursion Lab (see master).
4. Deploy Project Using Heroku: For this week, we are using Heroku for deployment, but we will be switching to AWS next week.
