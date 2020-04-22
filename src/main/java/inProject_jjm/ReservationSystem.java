package inProject_jjm;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="ReservationSystem_table")
public class ReservationSystem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long studentId;

    @PostPersist
    public void onPostPersist(){
        Reserved reserved = new Reserved();
        BeanUtils.copyProperties(this, reserved);
//        reserved.publish();

        this.setStudentId(reserved.getStudentId());

        PaymentSystem paymentSystem = new PaymentSystem();
        paymentSystem.setStudentId(this.studentId);

        PaymentService paymentService = Application.applicationContext.getBean(PaymentService.class);
        paymentService.makePayment(paymentSystem);
    }

    @PreRemove
    public void onPreRemove(){
        ReservationCanceled reservationCanceled = new ReservationCanceled();

        ReservationSystemRepository reservationSystemRepository = Application.applicationContext.getBean(ReservationSystemRepository.class);
        System.out.println("%%%%%" + reservationSystemRepository.count());
        System.out.println("&&&&&" + reservationCanceled.getStudentId());

        BeanUtils.copyProperties(this, reservationCanceled);
        reservationCanceled.publish();




    }


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
