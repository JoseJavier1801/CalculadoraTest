import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass(){
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Raiz Cuadrada Numero Conocido")
    void testRaizCuadradaconicido() throws Exception {
        assertEquals(2, miCalculadora.raizCuadrada(4));
    }

    @Test
    @DisplayName("Raiz Cuadrada de otro Numero Conocido")
    void testRaizCuadradaotro() throws Exception {
        assertEquals(3, miCalculadora.raizCuadrada(9));
    }

    @Test
    @DisplayName("Raiz Cuadrada uno")
    void testRaizCuadradauno() throws Exception {
        assertEquals(1, miCalculadora.raizCuadrada(1));
    }


    @Test
    @DisplayName("Raiz Cuadrada cero")
    void testRaizCero() throws Exception {
        assertEquals(0, miCalculadora.raizCuadrada(0));
    }

    @Test
    @DisplayName("Raiz Cuadrada Error")
    void testRaizCuadradaException() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.raizCuadrada(-2);
        });

        assertEquals("El radicando es negativo", thrown.getMessage());
    }

    @Test
    @DisplayName("Suma de dos números positivos")
    void testSumaPositivos() {
        assertEquals(5, miCalculadora.suma(2,3));
    }

    @Test
    @DisplayName("Suma de un número positivo y otro negativo")
    void testSumaPositivoYNegativo() {
        assertEquals(2, miCalculadora.suma(-2,4));
    }

    @Test
    @DisplayName("Suma de cero y un número positivo")
    void testSumaCeroYPositivo() {
        assertEquals(10, miCalculadora.suma(0,10));
    }

    @Test
    @DisplayName("Suma de dos números negativos")
    void testSumaNegativos() {
        assertEquals(-10, miCalculadora.suma(-5,-5));
    }

    @Test
    @DisplayName("Resta de dos números positivos")
    void testRestaPositivos() {
        assertEquals(1, miCalculadora.resta(3,2));
    }

    @Test
    @DisplayName("Resta de un número positivo y otro negativo")
    void testRestaPositivoYNegativo() {
        assertEquals(-1, miCalculadora.resta(2,3));
    }

    @Test
    @DisplayName("Resta de cero y un número positivo")
    void testRestaCeroYPositivo() {
        assertEquals(-10, miCalculadora.resta(0,10));
    }

    @Test
    @DisplayName("Resta de un número negativo y otro positivo")
    void testRestaNegativoYPositivo() {
        assertEquals(-4, miCalculadora.resta(-2,2));
    }

    @Test
    @DisplayName("Potencia de un número positivo y cero")
    void testPotenciaPositivoYCero() {
        assertEquals(1, miCalculadora.potencia(2,0));
    }

    @Test
    @DisplayName("Potencia de cero y un número positivo")
    void testPotenciaCeroYPositivo() {
        assertEquals(0, miCalculadora.potencia(0,2));
    }

    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2,3));
        assertEquals(0, miCalculadora.multiplica(5,0));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(4,2));
        assertEquals(2.5, miCalculadora.divide(10,4));
        assertEquals(4, miCalculadora.divide(10,2.5));
        assertEquals(3.2, miCalculadora.divide(8,2.5));
        assertEquals(0.5, miCalculadora.divide(2,4));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4,2) > 0);
        assertTrue(miCalculadora.divide(4,-2)< 0);
        assertTrue(miCalculadora.divide(-4,2) < 0);
        assertTrue(miCalculadora.divide(-4,-2) > 0);
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(5,0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }
}