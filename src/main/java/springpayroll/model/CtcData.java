package springpayroll.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Component
@NoArgsConstructor
@Data
@ToString
@AllArgsConstructor
@Document("ctc")
@Table(name = "ctc")
public class CtcData {
    @Id
    private String eCode;

    @Indexed(name = "ctcComponet")
    private String eName;
    private Long ctc;

    private String lOC;

    Map<String, Demo> map=new HashMap<>();


    public CtcData(String eCode, String eName) throws IOException {
        System.out.println(map);
        this.eCode = eCode;
        this.eName = eName;
    }





    Map<Object,Object> as;

    {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            FileInputStream file = new FileInputStream("/home/ankit/Downloads/1dawfes-master/src/main/resources/new.yml");
                 String ass=convertYamlToJson(file);
            ObjectMapper objectMapper=new ObjectMapper();

            as = objectMapper.readValue(ass,Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  static     String convertYamlToJson(FileInputStream yaml) throws IOException {
        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Object obj = yamlReader.readValue(yaml, Object.class);

        ObjectMapper jsonWriter = new ObjectMapper();
        return jsonWriter.writeValueAsString(obj);
    }
}

