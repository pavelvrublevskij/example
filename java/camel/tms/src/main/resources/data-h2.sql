INSERT INTO person(first_name, last_name)
  VALUES
      ('Admin',  'Admin'),
      ('Vardas', 'Pavardenis'),
      ('Giedrius', 'Pavardenis')
;

INSERT INTO task_group (name)
  VALUES ('Backlog'),
         ('New'),
         ('In Progress'),
         ('Complete'),
         ('Declined')
;

INSERT INTO task(title, description, task_group_id, parent_task_id)
  VALUES ('First Test Task without subtasks', 'Lorem ipsum.', 1, NULL),
         ('(1)Parent task', 'Lorem ipsum.', 2, NULL),
         ('(1)Child task of (1)Parent task', 'Lorem ipsum.', 3, 2),
         ('(2)Child task of (1)Parent task', 'Lorem ipsum.', 2, 2)
;

INSERT INTO person_has_task (person_id, task_id)
   VALUES (1, 1),
          (2, 1),
          (3, 2)
;