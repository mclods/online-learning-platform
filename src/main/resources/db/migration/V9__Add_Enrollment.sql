CREATE TABLE enrollment(
    student_id INTEGER REFERENCES student(id) ON DELETE CASCADE,
    course_id INTEGER REFERENCES course(id) ON DELETE CASCADE,
    enrolled_at TIMESTAMP NOT NULL,
    status VARCHAR(100) NOT NULL,
    PRIMARY KEY(student_id, course_id)
);