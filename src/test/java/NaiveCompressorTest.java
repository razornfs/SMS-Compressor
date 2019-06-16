import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NaiveCompressorTest {
    @Test
    public void simple_string_compression() {
        NaiveCompressor nc = new NaiveCompressor();
        String compressed = nc.compress("Ala ma kota");
        assertEquals("AlaMaKota", compressed);
        String decompressed = nc.decompress(compressed);
        assertEquals("Ala Ma Kota", decompressed);
    }

    @Test
    public void complicated_string_compression() {
        NaiveCompressor nc = new NaiveCompressor();
        String complicatedExpression = "LoRem ipsuM dolor sit ameT";
        String compressed = nc.compress(complicatedExpression);
        assertEquals("LoRemIpsuMDolorSitAmeT", compressed);
        String decompressed = nc.decompress(compressed);
        assertEquals("Lo Rem Ipsu M Dolor Sit Ame T", decompressed);
    }
}
