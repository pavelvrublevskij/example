--liquibase formatted sql

--changeset pavel.vrublevskij:create_role dbms:postgresql
CREATE ROLE gr_example;
--rollback DROP ROLE gr_example;


--changeset pavel.vrublevskij:create_role_example_to_group dbms:postgresql
CREATE ROLE example LOGIN
  ENCRYPTED PASSWORD 'md5cf8491476c86811bb684554dd19b374a'  -- here are password: example
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;
GRANT gr_example TO example;
--rollback DROP ROLE example;