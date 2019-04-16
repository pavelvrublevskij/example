INSERT INTO person(first_name, last_name, updated_at, created_at)
  VALUES
      ('Admin',  'Admin', now(), now()),
      ('Vardas', 'Pavardenis', now(), now()),
      ('Giedrius', 'Pavardenis', now(), now());
      ;

INSERT INTO task(title, description, priority, updated_at, created_at)
  VALUES ('Backlog', 'All new tasks came here.', 'Low', now(), now());

INSERT INTO person_has_task
   VALUES (1, 1),
          (2, 1);