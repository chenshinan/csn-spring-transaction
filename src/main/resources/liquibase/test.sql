--liquibase formatted sql

--changeset shinan.chen:2018-08-26-create-test
create table test (
    id int primary key,
    name varchar(255)
);

--changeset shinan.chen:2018-08-26-init-test
insert into test (id, name) values (1, 'name1');
insert into test (id, name) values (2, 'name2');

--changeset shinan.chen:2018-08-26-init-issue-type
-- insert into issue_type (name,icon,description,organization_id) values ('test','test','test',1);