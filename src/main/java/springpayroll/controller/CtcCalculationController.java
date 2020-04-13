package springpayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springpayroll.exception.InvalidStateCodeException;
import springpayroll.impl.CtcControllerMethode;
import springpayroll.model.CtcData;

import java.io.IOException;


@RestController
public class CtcCalculationController
{

    @Autowired
    CtcControllerMethode ctcControllerImpl;



    @RequestMapping("ctc")
    public ResponseEntity<Object> all_the_calcution_find_New(@RequestBody CtcData  ctcData) throws InvalidStateCodeException, IllegalAccessException, IOException, InstantiationException {
        return new ResponseEntity<>( ctcControllerImpl.all_the_calcution_find_New(ctcData),HttpStatus.OK);
    }




    @PostMapping("ctc-eCode-eName")
    public ResponseEntity<CtcData> login_methode_Post(@RequestBody CtcData ctcData )
    {

        return new ResponseEntity<>(ctcControllerImpl.login_methode_Post(ctcData),HttpStatus.CREATED);
    }




    @RequestMapping(value = "ctc",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllCtcData()
    {

        return new ResponseEntity<>(ctcControllerImpl.getAllCtData(),HttpStatus.OK);
    }





    @RequestMapping(value = "ctc/{e_code}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<CtcData> getCtcData(@RequestParam String e_code)
    {
        System.out.println(e_code);
        return new ResponseEntity<>(ctcControllerImpl.getCtcData(e_code),HttpStatus.OK) ;

    }



    @RequestMapping(value = "ctc/{e_code}",method = RequestMethod.DELETE)

    public ResponseEntity<String> userDelete(@RequestParam String e_code)
    {

        return new  ResponseEntity<>(ctcControllerImpl.deleteOne(e_code),HttpStatus.OK);
    }



    @PutMapping("ctc")

    public ResponseEntity<CtcData> put_CtcData( CtcData ctc_data,@RequestParam String e_code)
    {
        return new  ResponseEntity<>(ctcControllerImpl.put_CtcData(e_code,ctc_data),HttpStatus.OK);
    }


    @DeleteMapping("ctc")

    public ResponseEntity<String> deleteAll()
    {
        return new ResponseEntity<>(ctcControllerImpl.deleteAllData(),HttpStatus.OK);
    }
}




