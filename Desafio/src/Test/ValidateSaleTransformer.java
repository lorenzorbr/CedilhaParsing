package Test;

import Shared.Model.Sale;
import Shared.Transformer.SaleTransformer;
import Shared.Util.MockUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Validei somente o caso de sucesso, pois caso desse alguma falha, a classe validateLine impediria a criacao do transformer
public class ValidateSaleTransformer {
    @Test
    public void validateSale() {
        Sale sale = SaleTransformer.transform((MockUtil.getSalesSuccesLine()));
        assertEquals(sale != null, true);
    }
}
