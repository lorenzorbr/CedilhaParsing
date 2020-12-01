package Test;

import Shared.Model.Salesman;
import Shared.Transformer.SalesManTransformer;
import Shared.Util.MockUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Validei somente o caso de sucesso, pois caso desse alguma falha, a classe validateLine impediria a criacao do transformer
public class ValidateSalesmanTransformer {

    @Test
    public void validateSalesman() {
        Salesman salesman = SalesManTransformer.transform(MockUtil.getSalesmanSuccesLine());
        assertEquals(salesman != null, true);
    }
}
