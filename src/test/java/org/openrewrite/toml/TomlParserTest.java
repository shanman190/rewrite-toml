package org.openrewrite.toml;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.toml.Assertions.toml;

class TomlParserTest implements RewriteTest {
    @Test
    void keyValueString() {
        rewriteRun(
          toml(
            """
            str = "I'm a string. \\"You can quote me\\". Name\\tJos\\u00E9\\nLocation\\tSF."
            """
          )
        );
    }

    @Test
    void keyValueInteger() {
        rewriteRun(
          toml(
            """
            int1 = +99
            int2 = 42
            int3 = 0
            int4 = -17
            int5 = 1_000
            
            # hexadecimal with prefix `0x`
            hex1 = 0xDEADBEEF
            hex2 = 0xdeadbeef
            hex3 = 0xdead_beef
            # octal with prefix `0o`
            oct1 = 0o01234567
            oct2 = 0o755 # useful for Unix file permissions
            
            # binary with prefix `0b`
            bin1 = 0b11010110
            """
          )
        );
    }

    @Test
    void keyValueFloat() {
        rewriteRun(
          toml(
            """
            
              # fractional
            flt1 = +1.0
            flt2 = 3.1415
            flt3 = -0.01
            
            # exponent
            flt4 = 5e+22
            flt5 = 1e06
            flt6 = -2E-2
            
            # both
            flt7 = 6.626e-34
            """
          )
        );
    }

    @Test
    void keyValueBool() {
        rewriteRun(
          toml(
            """
            bool1 = true
            bool2 = false
            """
          )
        );
    }

    @Test
    void keyValueOffsetDateTime() {
        rewriteRun(
          toml(
            """
            odt1 = 1979-05-27T07:32:00Z
            odt2 = 1979-05-27T00:32:00-07:00
            odt3 = 1979-05-27T00:32:00.999999-07:00
            odt4 = 1979-05-27 07:32:00Z
            """
          )
        );
    }

    @Test
    void keyValueLocalDateTime() {
        rewriteRun(
          toml(
            """
            ldt1 = 1979-05-27T07:32:00
            ldt2 = 1979-05-27T00:32:00.999999
            """
          )
        );
    }

    @Test
    void keyValueLocalDate() {
        rewriteRun(
          toml(
            """
            ld1 = 1979-05-27
            """
          )
        );
    }

    @Test
    void keyValueLocalTime() {
        rewriteRun(
          toml(
            """
            lt1 = 07:32:00
            lt2 = 00:32:00.999999
            """
          )
        );
    }

    @Test
    void keyValueArray() {
        rewriteRun(
          toml(
            """
            integers = [ 1, 2, 3 ]
            colors = [ "red", "yellow", "green" ]
            nested_arrays_of_ints = [ [ 1, 2 ], [3, 4, 5] ]
            nested_mixed_array = [ [ 1, 2 ], ["a", "b", "c"] ]
            string_array = [ "all", 'strings', ""\"are the same""\", '''type''' ]
            
            # Mixed-type arrays are allowed
            numbers = [ 0.1, 0.2, 0.5, 1, 2, 5 ]
            contributors = [
              "Foo Bar <foo@example.com>",
              { name = "Baz Qux", email = "bazqux@example.com", url = "https://example.com/bazqux" }
            ]
            integers2 = [
              1, 2, 3
            ]
            
            integers3 = [
              1,
              2, # this is ok
            ]
            """
          )
        );
    }

    @Test
    void table() {
        rewriteRun(
          toml(
            """
             [table-1]
             key1 = "some string"
             key2 = 123
             
             [table-2]
             key1 = "another string"
             key2 = 456
             
             [dog."tater.man"]
             type.name = "pug"
             """
          )
        );
    }
}