insert into user values( 1, "Sudarshan");
insert into user values( 2, "Suneel");
insert into user values( 3, "Peruru");

insert into topic values(1,"Language");
insert into topic values(2,"Data Structures");
insert into topic values(3,"Algorithms");

insert into subtopic values(1, "Graphs", 2);
insert into subtopic values(2, "Java", 1);
insert into subtopic values(3, "Greedy", 3);

insert into company values( 1, "Amazon");
insert into company values( 2, "TCS");
insert into company values( 3, "Google");

insert into tags values( 1, "Spring");
insert into tags values( 2, "Loops");
insert into tags values( 3, "conditional statments");
insert into tags values( 4, "MVC");

insert into questions (ID, Text, User_ID, Subtopic_ID) values( 1, "This is 1st question on java by user 1.", 1, 2);
insert into questions (ID, Text, User_ID, Subtopic_ID) values( 2, "This is 1st question on graphs by user 2.", 2, 1);
insert into questions (ID, Text, User_ID, Subtopic_ID) values( 3, "This is question on graphs by user 3.", 3, 1);
insert into questions (ID, Text, User_ID, Subtopic_ID) values( 4, "This is question on greedy by user 2.", 2, 3);

insert into answers (ID, Text, User_ID, Questions_ID)  values( 1, "This is answer for graphs by user 1.", 1, 2);
insert into answers (ID, Text, User_ID, Questions_ID)  values( 2, "This is answer for java by user 2.", 2, 1);
insert into answers (ID, Text, User_ID, Questions_ID)  values( 3, "This is answer for greedy by user 3.", 3, 3);
insert into answers (ID, Text, User_ID, Questions_ID)  values( 4, "This is answer for greedy by user 2.", 2, 3);
insert into answers (ID, Text, User_ID, Questions_ID) values ( 5, "This is answer for greedy by user 1.", 1, 3);

insert into comments (ID, Text, User_ID, Answers_ID) values( 1, "This is a comment on graphs by user 1.", 1, 1);
insert into comments  (ID, Text, User_ID, Answers_ID) values( 2, "This is a comment on java by user 2.", 2, 2);
insert into comments  (ID, Text, User_ID, Answers_ID) values( 3, "This is a comment on graphs by user 3.", 3, 1);
insert into comments  (ID, Text, User_ID, Answers_ID) values( 4, "This is a comment on greedy by user 2.", 2, 3);

insert into questions_tags_map values(1, 1, 1);
insert into questions_tags_map values(2, 2, 4);
insert into questions_tags_map values(3, 3, 3);
insert into questions_tags_map values(4, 4, 2);

insert into questions_company_map values(1, 1, 1);
insert into questions_company_map values(2, 2, 3);
insert into questions_company_map values(3, 2, 2);

