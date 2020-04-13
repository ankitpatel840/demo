package springpayroll.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springpayroll.model.CtcData;

@Repository
public interface CTCRepo extends MongoRepository<CtcData, String>
{
      // CtcData findByCtcData(String id);


    boolean existsByECode(String eCode);

}
