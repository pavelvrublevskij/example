--liquibase formatted sql

--changeset pavel.vrublevskij:init_schemas dbms:postgresql
CREATE SCHEMA example;
--rollback DROP SCHEMA IF EXISTS example;