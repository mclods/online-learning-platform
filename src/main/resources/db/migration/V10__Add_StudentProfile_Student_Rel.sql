ALTER TABLE student_profile
ADD CONSTRAINT fk_student_profile_student
FOREIGN KEY (id)
REFERENCES student(id)
ON DELETE CASCADE;