package springpayroll.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import springpayroll.model.BranchData;
import springpayroll.model.CtcData;
import springpayroll.repo.BranchRepo;
import springpayroll.repo.CTCRepo;
import springpayroll.service.CtcCalculation;

class CtcControllerMethodeTest {


    @InjectMocks
    CTCRepo ctc_repo;
  @MockBean
    private BranchRepo branch_repo;

    @InjectMocks
    CtcCalculation ctcCalculation;

     @MockBean
     BranchData branchData;
      @MockBean
      CtcData ctcData;
      @MockBean
      CtcControllerImpl ctcControllerImpl;




    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        ctcCalculation= org.mockito.Mockito.mock(CtcCalculation.class);
        ctc_repo= org.mockito.Mockito.mock(CTCRepo.class);
        branch_repo= org.mockito.Mockito.mock(BranchRepo.class);
        ctcControllerImpl=org.mockito.Mockito.mock(CtcControllerImpl.class);


    }








    @Test
    void login_methode_cheaking()
    {
//        Ctc_Data ctcData=new Ctc_Data("123","Ank");
//        when
    }

//    @Test
//    void all_the_calcution() {
//    }
//
//    @Test
//    void all_the_calcution_find_New() {
//    }
//
//    @Test
//    void login_methode_Post()
//    {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void getAllCtData()
//    {
//
//      //  MockitoAnnotations.initMocks(this);
//
//        CtcData ctc_Data=new CtcData("Ank1","Ank");
//        List<CtcData> list= Arrays.asList(ctcData,ctc_Data);
//        when(ctc_repo.findAll()).thenReturn(list);
//        when(ctcControllerImpl.getAllCtData()).thenReturn(list);
//        System.out.println(ctc_repo.findAll());
//        System.out.println(ctcControllerImpl.getAllCtData());
//        List<CtcData>getList=ctcControllerImpl.getAllCtData();
//        verify(ctc_repo).findAll();
//        assertThat(getList,is(list));
//    }
//
//   // @Test
////    void getCtcData()
////    {
////        MockitoAnnotations.initMocks(this);
////        String id="Ank12";
////       CtcData ctcData=new CtcData("Ank12","Ank");
////
////        when(ctc_repo.findByCtcData(id)).thenReturn(ctcData);
////        CtcData ctc_data= ctcControllerImpl.getCtcData("An12");
////        System.out.println(ctc_data);
////        System.out.println(ctc_repo.findByCtcData(id));
////        assertThat(ctc_data,is(ctc_repo.findByCtcData(id)));
////
////    }
//
//    @Test
//    void deleteOne()
//    {
////        when(queueReository.findByUserId("tarun")).thenReturn(defaultQueue);
////
////        DefaultQueue deletedQueue = queueServices.DeleteUserQueue("tarun");
////
////        verify(queueServices).DeleteUserQueue("tarun");
////        assertThat(deletedQueue,is(defaultQueue));
////
////        System.out.println(e_code);
////        Ctc_Data ab=ctc_repo.getOne(e_code);
////        System.out.println("ADS");
////        ctc_repo.delete(ab);
////        System.out.println("df");
//        CtcData ctcData=new CtcData("Ak11","Ank");
//
//    }
//
//    @Test
//    void put_CtcData()
//    {
//
//    }
//
//    @Test
//    void deleteAllData()
//    {
//
//    }
}