package tkpm.doan.student.data.models;

import java.util.Date;

import javax.inject.Inject;

public class Comment {
    private String id;
    private Student student;
    private Teacher teacher;
    private String content;



    private Date timeComment;
    @Inject
    public Comment(String id, Student student, Teacher teacher, String content) {
        this.id = id;
        this.student = student;
        this.teacher = teacher;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getContent() {
        return content;
    }
    public Date getTimeComment() {
        return timeComment;
    }

    public void setTimeComment(Date timeComment) {
        this.timeComment = timeComment;
    }
}
