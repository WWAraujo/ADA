package br.com.f1rst3.cadprodutos;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CadProdutoServiceTest.class, CadProdutoControllerTest.class})
public class SuiteTest {
}
