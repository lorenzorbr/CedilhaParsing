package Test;


import Shared.Model.Client;
import Shared.Transformer.ClientTransformer;
import Shared.Util.MockUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
//Validei somente o caso de sucesso, pois caso desse alguma falha, a classe validateLine impediria a criacao do transformer
public class ValidateClientTransformer {

    @Test
    public void validateClient() {
        Client client = ClientTransformer.transform((MockUtil.getClientSuccesLine()));
        assertEquals(client != null, true);
    }
}
