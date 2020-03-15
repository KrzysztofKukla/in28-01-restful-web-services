--user
insert into user values('a93d3c9c-83cd-4fa8-8a6e-3f17d9f4f10a', sysdate(), 'first', 'pass1');
insert into user values('cff737c8-c489-469c-a2a4-29fd503e1354', sysdate(), 'second', 'pass2');
insert into user values('09d2db40-fc12-4df6-960d-005d8c210178', sysdate(), 'third', 'pass3');

--post
insert into post values ('cd100a1f-b860-48fd-ab31-f1e3ccbf9070', 'First description', 'cff737c8-c489-469c-a2a4-29fd503e1354');
insert into post values ('49299eba-337e-4a52-9a7c-a93ef8bdb734', 'First description', '09d2db40-fc12-4df6-960d-005d8c210178');
insert into post values ('3255a2c8-6350-44b3-ab79-1304e1142c9e', 'First description', 'cff737c8-c489-469c-a2a4-29fd503e1354');
insert into post values ('02f0077a-d1e1-4c9a-8706-123a1882efa4', 'First description', 'a93d3c9c-83cd-4fa8-8a6e-3f17d9f4f10a');