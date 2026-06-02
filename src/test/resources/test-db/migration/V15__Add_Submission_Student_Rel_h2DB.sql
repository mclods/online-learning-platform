ALTER TABLE submission
ADD COLUMN student_id INTEGER;


ALTER TABLE submission
ADD CONSTRAINT fk_submission_student
FOREIGN KEY (student_id)
REFERENCES student(id)
ON DELETE CASCADE;