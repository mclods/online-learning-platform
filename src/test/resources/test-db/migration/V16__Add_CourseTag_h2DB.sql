CREATE TABLE course_tag(
    course_id INTEGER REFERENCES course(id),
    tag_id INTEGER REFERENCES tag(id),
    PRIMARY KEY(course_id, tag_id)
);