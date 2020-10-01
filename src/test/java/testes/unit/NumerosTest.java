package testes.unit;

import numeros.Numeros;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumerosTest {
    private Numeros numeros;

    @Before
    public void setUp () {
        // Vou utilizar o metodo e uma unidade passando o valor 9 que trata-se de uma unidade
        numeros = new Numeros();
    }

    @Test
    public void testValidarSeUmNumeroEUmaUnidade () {
        boolean eUnidade = numeros.eUmaUnidade(9);

        // Vou validar que a  resposta e verdadeira
        Assert.assertTrue(eUnidade);
    }

    @Test
    public void testValidarSeUmNumeroNaoEUmaUnidade () {
        boolean eUnidade = numeros.eUmaUnidade(10);

        // Vou validar que a resposta e falsa
        Assert.assertFalse(eUnidade);
    }
}
