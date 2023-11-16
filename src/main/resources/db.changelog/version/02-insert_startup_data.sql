--liquibase formatted sql
--changeset wierzbicki:2
--comment: comment_2

begin;

-- students
insert into students(id,dob,email,namee)
values (1,'2000-01-05','admin@gmail.com','admin')
ON CONFLICT DO NOTHING;

insert into students(id,dob,email,namee)
values (2,'2010-02-10','user@gmail.com','user')
ON CONFLICT DO NOTHING;

insert into students(id,dob,email,namee)
values (3,'2020-03-20','moderator@gmail.com','moderator')
ON CONFLICT DO NOTHING;

commit;
