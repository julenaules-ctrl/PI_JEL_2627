import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordCheckerTest {


    /*
     * int     check(String password, String repeatPassword)
     *         Comprueba la validez de una contraseña.
     */

    @Test void passwordCorrecto()
    {
        PasswordChecker checker = new PasswordChecker();
        int resultado = checker.check("abcde123", "abcde123");
        assertEquals(PasswordChecker.PASSWORD_OK, resultado);
    }
/*
 * boolean getCheckDigits()
 *         Indica si se debe comprobar que la contraseña contiene dígitos.
 */

    @Test void comprobarDigits()
    {
        PasswordChecker checker = new PasswordChecker();
        boolean resultado = checker.getCheckDigits();
        assertEquals(PasswordChecker, resultado);
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