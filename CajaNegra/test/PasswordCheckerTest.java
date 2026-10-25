import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordCheckerTest {

    PasswordChecker checker;

    @BeforeEach
    void setUp() {
        checker = new PasswordChecker();
        checker.setCheckDigits(true);
        checker.setCheckUppers(true);
        checker.setCheckLowers(true);
    }
    /*
     * int     check(String password, String repeatPassword)
     *         Comprueba la validez de una contraseña.
     */

    @Test void passwordCorrecto()
    {
        int resultado = checker.check("Abcde123", "Abcde123");
        assertEquals(PasswordChecker.PASSWORD_OK, resultado);
    }

    @Test void comprobarDigits()
    {
        int resultado = checker.check("Abcdefgh", "Abcdefgh");
        assertEquals(PasswordChecker.ERR_DIGITS, resultado);
    }

    @Test void comprobarUppers()
    {
        int resultado = checker.check("abcde123", "abcdefgh");
        assertEquals(PasswordChecker.ERR_UPPERS, resultado);
    }

    @Test void comprobarLowers()
    {
        int resultado = checker.check("ABCDE123", "ABCDE123");
        assertEquals(PasswordChecker.ERR_LOWERS, resultado);
    }

    @Test void comprobarNoMatch()
    {
        int resultado = checker.check("Abcde123", "Abcde678");
        assertEquals(PasswordChecker.ERR_NO_MATCH, resultado);
    }

    @Test void comprobarInvalidMaxLength()
    {
        checker.setMinLength(6);
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> checker.setMaxLength(5));
        assertEquals(PasswordChecker.ERR_INVALID_MAX_LENGTH, e.getMessage());
    }

    @Test void comprobarInvalidMinLength()
    {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> checker.setMinLength(-1));
        assertEquals(PasswordChecker.ERR_INVALID_MIN_LENGTH, e.getMessage());
    }

    @Test void comprobarLength()
    {
        checker.setMinLength(5);
        checker.setMaxLength(12);
        int resultado = checker.check("Ab12", "Ab12");
        assertEquals(PasswordChecker.ERR_LENGTH, resultado);

        resultado = checker.check("Abcde12345678910", "Abcde12345678910");
        assertEquals(PasswordChecker.ERR_LENGTH, resultado);
    }
}






/*

 *
 * boolean getCheckLowers()
 *         Indica si se debe comprobar que la contraseña contiene minúsculas.
 *
 * boolean getCheckUppers()
 *         Indica si se debe comprobar que la contraseña contiene mayúsculas.
 *
 * int     getMaxLength()
 *         Obtiene el valor de longitud máxima de la contraseña.
 *
 * int     getMinLength()
 *         Obtiene el valor de longitud mínima de la contraseña.
 *
 * void    setCheckDigits(boolean checkDigits)
 *         Establece si se debe o no comprobar la presencia de dígitos.
 *
 * void    setCheckLowers(boolean checkLowers)
 *         Establece si se debe o no comprobar la presencia de minúsculas.
 *
 * void    setCheckUppers(boolean checkUppers)
 *         Establece si se debe o no comprobar la presencia de mayúsculas.
 *
 * void    setMaxLength(int maxLength)
 *         Establece la longitud máxima de la contraseña.
 *
 * void    setMinLength(int minLength)
 *         Establece la longitud mínima de la contraseña.
 */