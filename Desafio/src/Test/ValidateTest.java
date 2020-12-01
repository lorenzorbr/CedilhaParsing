package Test;

import Shared.Constants.Constants;
import Shared.Util.MockUtil;
import Shared.Validate.ValidateCNPJ;
import Shared.Validate.ValidateCPF;
import Shared.Validate.ValidateFileChanges;
import Shared.Validate.ValidateValue;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ValidateTest {
    @Test
    public void validateCPF(){
        List<String> listCPF = MockUtil.getCPFList();

        assertEquals(ValidateCPF.isCPF(listCPF.get(0)),true);
        assertEquals(ValidateCPF.isCPF(listCPF.get(1)),true);
        assertEquals(ValidateCPF.isCPF(listCPF.get(2)),true);
        assertEquals(ValidateCPF.isCPF(listCPF.get(3)),false);
        assertEquals(ValidateCPF.isCPF(listCPF.get(4)),false);
    }
    @Test
    public void validateCNPJ(){
        List<String> listCNPJ = MockUtil.getCNPJList();

        assertEquals(ValidateCNPJ.isCNPJ(listCNPJ.get(0)),true);
        assertEquals(ValidateCNPJ.isCNPJ(listCNPJ.get(1)),true);
        assertEquals(ValidateCNPJ.isCNPJ(listCNPJ.get(2)),true);
        assertEquals(ValidateCNPJ.isCNPJ(listCNPJ.get(3)),false);
        assertEquals(ValidateCNPJ.isCNPJ(listCNPJ.get(4)),false);
    }
    @Test
    public void validateValue(){
        assertEquals(ValidateValue.validateSaleID("1000"),true);
        assertEquals(ValidateValue.validateSaleID("50.50"),false);
        assertEquals(ValidateValue.validateSaleID("xx1"),false);
        assertEquals(ValidateValue.validateSaleID(""),false);

        assertEquals(ValidateValue.validateValue("500", Constants.REGEX.INTEGER),true);
        assertEquals(ValidateValue.validateValue("50.50", Constants.REGEX.DOUBLE),true);
        assertEquals(ValidateValue.validateValue("20",Constants.REGEX.DOUBLE),true);
        assertEquals(ValidateValue.validateValue("20.5",Constants.REGEX.INTEGER),false);
        assertEquals(ValidateValue.validateValue("",Constants.REGEX.DOUBLE),false);
    }
    @Test
    public void validateFileChanges(){
        List<List<String>> data = MockUtil.getListFiles();

        assertEquals(ValidateFileChanges.hasChanged("fileA", data.get(0)),true);
        assertEquals(ValidateFileChanges.hasChanged("fileA", data.get(0)),false);
        assertEquals(ValidateFileChanges.hasChanged("fileA", data.get(1)),true);
        assertEquals(ValidateFileChanges.hasChanged("fileB", data.get(1)),true);

    }
}
