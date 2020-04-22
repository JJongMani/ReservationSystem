package inProject_jjm;

import org.springframework.beans.BeanUtils;

import javax.persistence.*;

public class PaymentSystem {

    private Long id;
    private Long studentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }




}
