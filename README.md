# Digital office
So here you are my first web-based annotation driver Java application.
At the first for running this application you have to create database with a name 'hrdatabase' (or DB with a different name - you have to
change a name in DataConfig class then).
I used a Lombok plugin in some Entity classes istead using traditional Getters and Setters - so install please it in your IDE.
<hr>
There are three access levels - ADMIN, MANAGER and USER.
to access with ADMIN role you have to login as ADMIN with the proper password - you can find it in SecurityConfig class.
<p>As admin, you can create new departments, users, reset their passwords and change access level (USER by default).
<p>As Manager you can give some tasks to users, delete tasks, and confirm completing task (but only after user has clicked 'complete task'
button).
<p>Also there is a chat. :)
<hr>
In close future I'll implement additional features to a MANAGER role, s.a. registering outcoming documents of the department and give a role
to certain user to register incoming mail with attaching graphic or text files to a document regastration form.
<p>And of course - a list of all avialable users in chat and private messaging.
