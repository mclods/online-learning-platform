ALTER TABLE course
ADD COLUMN instructor_id INTEGER;


ALTER TABLE course
ADD CONSTRAINT fk_course_instructor
FOREIGN KEY (instructor_id)
REFERENCES instructor(id)
ON DELETE CASCADE;
