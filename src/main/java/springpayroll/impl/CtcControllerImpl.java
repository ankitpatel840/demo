package springpayroll.impl;

import org.springframework.stereotype.Service;
import springpayroll.exception.InvalidStateCodeException;
import springpayroll.model.CtcData;

import java.io.IOException;
import java.util.List;



@Service
public interface CtcControllerImpl
{

    public CtcData all_the_calcution_find_New(CtcData ctcData) throws InvalidStateCodeException, IOException, IllegalAccessException, InstantiationException;


    public CtcData login_methode_Post(CtcData ctcData );

    public List<CtcData> getAllCtData();

    public CtcData getCtcData(String e_code);

    public String deleteOne(String e_code);

    public CtcData put_CtcData(String e_code, CtcData ctc_data);

    public  String  deleteAllData();

}
