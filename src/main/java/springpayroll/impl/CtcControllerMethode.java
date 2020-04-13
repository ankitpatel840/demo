package springpayroll.impl;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springpayroll.exception.ECodeNotFoundException;
import springpayroll.exception.InvalidStateCodeException;
import springpayroll.model.BranchData;
import springpayroll.model.CtcData;
import springpayroll.model.Demo;
import springpayroll.repo.BranchRepo;
import springpayroll.repo.CTCRepo;
import springpayroll.service.CtcCalculation;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Service
public class CtcControllerMethode implements CtcControllerImpl {
    @Autowired
    CTCRepo ctc_repo;
    @Autowired
    private BranchRepo branch_repo;

    @Autowired
    CtcCalculation ctcCalculation;
    @Autowired
    BranchData branchData;
    @Autowired
    CtcData ctcData;
    @Autowired
    Demo demo;

    Logger logger=  LoggerFactory.getLogger(CtcControllerMethode.class);

    public CtcControllerMethode(CTCRepo ctc_repo, BranchRepo branch_repo, CtcCalculation ctcCalculation, BranchData branchData, CtcData ctcData) {
        this.ctc_repo = ctc_repo;
        this.branch_repo = branch_repo;
        this.ctcCalculation = ctcCalculation;
        this.branchData = branchData;
        this.ctcData = ctcData;
    }




    public CtcData all_the_calcution_find_New(CtcData ctcData) throws InvalidStateCodeException, IOException, IllegalAccessException, InstantiationException {

        System.out.println(ctcData);

       // System.out.println(ctcData.getLOC());

      //  System.out.println(    ctc_repo.existsByECode(ctcData.getECode()));

       // logger.info("ctcRepo>>>>"+ctc_repo.existsByECode(ctcData.getECode()));
               if (branch_repo.existsBySTATE(ctcData.getLOC()) ) {

         logger.info("branch>>>>>>>>>>"+branch_repo.existsBySTATE(ctcData.getLOC()));

            BranchData get_data_to_breanch_repo =  branch_repo.findBySTATE(ctcData.getLOC());

            assert get_data_to_breanch_repo != null;
            Long get_minimum_Wage_to_database = get_data_to_breanch_repo.getMINIMUM_WAGES();
            System.out.println(get_minimum_Wage_to_database);

            Long get_Hra_Percentage_To_DataBase = get_data_to_breanch_repo.getHRA_PER();
                   System.out.println(get_Hra_Percentage_To_DataBase);
            Class scriptClass =  new GroovyClassLoader().parseClass(new File("/home/ankit/Downloads/1dawfes-master/src/main/java/springpayroll/groovyctc/CtcCalcualtion.groovy"));

            GroovyObject calc = (GroovyObject) scriptClass.newInstance();





           //   logger.info("Basic >"+got_basic_calculation_by_basic);
            // Basic_Calculation_Methode_is_started_here_________________________________________________________________________________
                   Long got_basic_calculation_by_basic = (Long) calc.invokeMethod("basie_calculation_methode", new Object[] {ctcData.getCtc(),get_minimum_Wage_to_database});

            //Bonus_Calculation_Methode_IS_Started_here_____________________________________________________________________________
         //   Long got_bonis_calculation_bonus = ctcCalculation.bonusCalulation(got_basic_calculation_by_basic);
                   Long got_bonis_calculation_bonus = (Long) calc.invokeMethod("bonusCalulation", new Object[]{got_basic_calculation_by_basic});

                   //Employer_PF_Calculation_Methode_IS_Given_Output_________________________________________________________________________
          //  Long got_Employer_PF_claculation_by_employer_pf = ctcCalculation.employePfCalculation(got_basic_calculation_by_basic);
                   Long got_Employer_PF_claculation_by_employer_pf = (Long) calc.invokeMethod("employePfCalculation", new Object[]{got_basic_calculation_by_basic});

                   //Gratutity_Methode_IS_Given_Output________________________________________________________________________________________
         //   Long got_gratutity_calculation_by_gratutity = ctcCalculation.gratutityCalculation(got_basic_calculation_by_basic);
                   Long got_gratutity_calculation_by_gratutity = (Long) calc.invokeMethod("gratutityCalculation", new Object[]{got_basic_calculation_by_basic});

                   //Gross_Calculation_Methode_IS_Given_Output_______________________________________________________________________________
         //   Long got_Gross_Calculation_by_gross = ctcCalculation.grossCalculation(ctcData.getCtc(), got_Employer_PF_claculation_by_employer_pf, got_gratutity_calculation_by_gratutity);
                   Long got_Gross_Calculation_by_gross = (Long) calc.invokeMethod("grossCalculation", new Object[]{ctcData.getCtc(),got_Employer_PF_claculation_by_employer_pf,got_gratutity_calculation_by_gratutity});

                   //Employer_ESI_Calculation_IS_Given_Output________________________________________________________________________________________
        //    Long got_Employer_Esi_Calculation_by_employer_esi_ = ctcCalculation.employerEsiCalculation(got_Gross_Calculation_by_gross);
                   Long got_Employer_Esi_Calculation_by_employer_esi_ = (Long) calc.invokeMethod("employerEsiCalculation", new Object[]{got_Gross_Calculation_by_gross});


                   //Employee_PF__Calculation__IS_Given_Output
         //   Long got_Employee_PF_Calculation_by_employee_pf = ctcCalculation.employeePf(got_basic_calculation_by_basic);
                   Long got_Employee_PF_Calculation_by_employee_pf = (Long) calc.invokeMethod("employeePf", new Object[]{got_basic_calculation_by_basic});


                   //Employee_ESI_Calculation_IS_Output__________________________________________________________________________________
         //   Long got_Employee_ESI_Calculation_by_employee_esi = ctcCalculation.employeeEsiCalculation(got_Gross_Calculation_by_gross);
                   Long got_Employee_ESI_Calculation_by_employee_esi = (Long) calc.invokeMethod("employeeEsiCalculation", new Object[]{got_Gross_Calculation_by_gross});


                   //Employee_Goss_Ana_Calculation_IS Given_Output_______________________________________________________________________________________
       //     Long got_Gross_And_Deduction_Calculation_by_gross_and_deduction = ctcCalculation.grossAndDeductionCalculation(got_Employee_ESI_Calculation_by_employee_esi, got_Employee_PF_Calculation_by_employee_pf);

                   Long got_Gross_And_Deduction_Calculation_by_gross_and_deduction = (Long) calc.invokeMethod("grossAndDeductionCalculation", new Object[]{got_Employee_ESI_Calculation_by_employee_esi,got_Employee_PF_Calculation_by_employee_pf});

                   //Net_Pay_Calculation_IS_Given_Output_______________________________________________________________________________________
      //      Long got_Net_Pay_Calculation_net_pay = ctcCalculation.netPayCalucaltion(got_Gross_Calculation_by_gross, got_Employee_PF_Calculation_by_employee_pf, got_Employee_ESI_Calculation_by_employee_esi);
                   Long got_Net_Pay_Calculation_net_pay = (Long) calc.invokeMethod("netPayCalucaltion", new Object[]{got_Gross_Calculation_by_gross,got_Employee_PF_Calculation_by_employee_pf,got_Employee_ESI_Calculation_by_employee_esi});

                   //Net_Take_Home_IS_Given_Output__________________________________________________________________________________________________

          ///  Long got_Net_Take_Home_Calculation_by_net_take_home = ctcCalculation.netTakeHomeCalculation(got_Gross_Calculation_by_gross, got_Gross_Calculation_by_gross);
                   Long got_Net_Take_Home_Calculation_by_net_take_home = (Long) calc.invokeMethod("netTakeHomeCalculation", new Object[]{got_Gross_Calculation_by_gross,got_Gross_And_Deduction_Calculation_by_gross_and_deduction});


                   //PT_Gross_CAlculation_IS_Created________________________________________________________________________________________________
         //   Long got_PT_Gross_Calculation_by_pt_gross = ctcCalculation.ptGrossCalculation(got_Net_Pay_Calculation_net_pay, got_Net_Pay_Calculation_net_pay);

                   Long got_PT_Gross_Calculation_by_pt_gross = (Long) calc.invokeMethod("ptGrossCalculation", new Object[]{got_Net_Pay_Calculation_net_pay,got_Net_Pay_Calculation_net_pay});

                   //DIFFERENCE_Calculation_IS_Given_Output_________________________________________________________________________________________

        //    Long got_DIFFERNECE_Calculation_by_differnence = ctcCalculation.differneceCalculation(got_Net_Take_Home_Calculation_by_net_take_home, got_Net_Pay_Calculation_net_pay);

                   Long got_DIFFERNECE_Calculation_by_differnence = (Long) calc.invokeMethod("differneceCalculation", new Object[]{got_Net_Take_Home_Calculation_by_net_take_home,got_Net_Pay_Calculation_net_pay});

                   //Home_Ret_Allowance__IS__Given_Output______________________________________________________________________________________________

         //   Long got_HOME_RENT_Allowance_Calculation_by_hra = ctcCalculation.home_Rent_Allowance(got_basic_calculation_by_basic, got_bonis_calculation_bonus, got_Gross_And_Deduction_Calculation_by_gross_and_deduction, got_Net_Pay_Calculation_net_pay, get_Hra_Percentage_To_DataBase);

                   Long got_HOME_RENT_Allowance_Calculation_by_hra = (Long) calc.invokeMethod("home_Rent_Allowance", new Object[]{got_basic_calculation_by_basic,got_bonis_calculation_bonus,got_Gross_And_Deduction_Calculation_by_gross_and_deduction,got_Net_Pay_Calculation_net_pay,get_Hra_Percentage_To_DataBase});

                   //    public Demo(Long hra, Long netTakeHome, Long basic, Long bonus, Long employerEsi, Long gratuity, Long gross, Long employeePf, Long employeeEsi, Long employerPf, Long grossDed, Long diff, Long ptGross,  Long netPay, Long minimumWage) {

                   System.out.println("fefe");
            demo=  new Demo(got_HOME_RENT_Allowance_Calculation_by_hra,got_Net_Take_Home_Calculation_by_net_take_home,got_basic_calculation_by_basic,got_bonis_calculation_bonus,got_Employer_Esi_Calculation_by_employer_esi_,got_gratutity_calculation_by_gratutity,got_Gross_Calculation_by_gross,got_Employee_PF_Calculation_by_employee_pf,got_Employee_ESI_Calculation_by_employee_esi,got_Employer_PF_claculation_by_employer_pf,got_Gross_And_Deduction_Calculation_by_gross_and_deduction,got_DIFFERNECE_Calculation_by_differnence,got_PT_Gross_Calculation_by_pt_gross,got_Net_Pay_Calculation_net_pay,get_minimum_Wage_to_database);
                   System.out.println(ctcData.getECode());
               ctcData.getMap().put(ctcData.getEName(),demo);

            System.out.println(ctcData);
            ctc_repo.save(ctcData);
            return ctcData;

        } else {
            throw new InvalidStateCodeException("You are enter  wrong statecode ");
        }


    }

    public CtcData login_methode_Post(CtcData ctccData) {
        //VARIFY_IN_DATA_BASE_BY_PASSING_DATA_IS_TRUE/FALSE_________________________________________________________________________________


        System.out.println("ankiy");
        ctcData.setECode(ctccData.getECode());
        ctcData.setEName(ctccData.getEName());
        System.out.println(ctc_repo);
        return ctc_repo.save(ctcData);

    }



    public List<CtcData> getAllCtData() {

        return ctc_repo.findAll();
    }


    public CtcData getCtcData(String e_code) {
        System.out.println(e_code);

//        if (ctc_repo.existsById(e_code)) {
//
//            //return ctc_repo.findByCtcData(e_code);
//        } else {
//            throw new ECodeNotFoundException("Invalid e_code ....");
//        }

     return ctcData;
        //return ctc_repo.findById(e_code);

    }


    public String deleteOne(String e_code) {
        if (ctc_repo.existsById(e_code)) {
            System.out.println(e_code);
       //     CtcData ab = ctc_repo.findByCtcData(e_code);
            System.out.println("ADS");
        //    ctc_repo.delete(ab);
            System.out.println("df");
            return "This";
        } else {
            throw new ECodeNotFoundException("Invalid e_code ....");
        }
    }


    public CtcData put_CtcData(String e_code, CtcData ctc_data) {

        return (ctc_repo.findById(e_code)
                .map(ctc_data1 -> {
                    ctc_data1.setEName(ctc_data.getEName());

                    return ctc_repo.save(ctc_data1);
                })
                .orElseGet(() -> {
                    ctc_data.setECode(e_code);
                    return ctc_repo.save(ctc_data);
                })
        );


    }

    public String deleteAllData() {
        ctc_repo.deleteAll();
        return " All Data  Deleted";
    }

}
