package springpayroll.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("demo")
public class Demo  {

    private Long hra;

    private Long netTakeHome;



    private Long basic;

    private Long bonus;

    private Long employerEsi;

    private Long gratuity;

    private Long gross;

    private Long employeePf;

    private Long employeeEsi;

    private Long employerPf;

    private Long grossDed;

    private Long diff;
    private Long ptGross;


    private Long netPay;


    private Long minimumWage;


 }
