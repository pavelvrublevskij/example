INSERT INTO person
  VALUES
      (-3, 'Admin',  'Admin'),
      (-2, 'Vardas', 'Pavardenis'),
      (-1, 'Giedrius', 'Pavardenis');

INSERT INTO task(id, title, description, priority)
  VALUES (0, 'Backlog', 'All new tasks came here.', 'Low');

-- INSERT INTO person_has_task
--   VALUES (-2, 0),
--          (-1, 0);