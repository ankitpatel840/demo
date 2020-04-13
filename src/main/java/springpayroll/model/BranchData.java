package springpayroll.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@org.springframework.stereotype.Repository
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Document("branchData")
public class BranchData {


    @Id
    private String STATE;
    @Indexed(name = "indexd")

    private String STATE_CODE;

    private Long MINIMUM_WAGES;

    private Long HRA_PER;


}
