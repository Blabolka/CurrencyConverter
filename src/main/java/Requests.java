import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Requests {

    public static List<CurrencyItem> getCurrencies(URL jsonUrl) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        TypeFactory typeFactory = objectMapper.getTypeFactory();
        CollectionType collectionType = typeFactory.constructCollectionType(
                List.class, CurrencyItem.class);
        return objectMapper.readValue(jsonUrl, collectionType);
    }
}
