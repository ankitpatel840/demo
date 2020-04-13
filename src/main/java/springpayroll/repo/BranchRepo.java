package springpayroll.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springpayroll.model.BranchData;

@Repository
public interface BranchRepo extends MongoRepository<BranchData,String>
{
    BranchData  findBySTATE(String STATE);

  boolean  existsBySTATE(String STATE);
}
