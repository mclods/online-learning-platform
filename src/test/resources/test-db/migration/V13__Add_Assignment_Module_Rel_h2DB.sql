ALTER TABLE assignment
ADD COLUMN module_id INTEGER;


ALTER TABLE assignment
ADD CONSTRAINT fk_assignment_module
FOREIGN KEY (module_id)
REFERENCES module(id)
ON DELETE CASCADE;
