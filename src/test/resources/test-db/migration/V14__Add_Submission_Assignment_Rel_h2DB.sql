ALTER TABLE submission
ADD COLUMN assignment_id INTEGER;


ALTER TABLE submission
ADD CONSTRAINT fk_submission_assignment
FOREIGN KEY (assignment_id)
REFERENCES assignment(id)
ON DELETE CASCADE;