--liquibase formatted sql

--changeset pavel.vrublevskij:grant_rights_for_schemas dbms:postgresql
GRANT ALL ON SCHEMA example TO gr_example;

--rollback REVOKE ALL ON SCHEMA example FROM gr_example;

GRANT CONNECT ON DATABASE <your_database> TO GROUP gr_example;
--rollback REVOKE ALL ON DATABASE vddb FROM GROUP gr_example;