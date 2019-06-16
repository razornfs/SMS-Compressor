import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsmazCompressorTest {
    @Test
    public void simple_string_compression() {
        JsmazCompressor nc = new JsmazCompressor();
        String ala_ma_kota = "Ala ma kota";
        byte[] compressed = nc.compress(ala_ma_kota);
        String decompressed = nc.decompress(compressed);
        assertEquals(ala_ma_kota, decompressed);
    }

    @Test
    public void complicated_string_compression() {
        JsmazCompressor nc = new JsmazCompressor();
        String complicatedExpression = "LoRem ipsuM dolor sit ameT";
        byte[] compressed = nc.compress(complicatedExpression);
        String decompressed = nc.decompress(compressed);
        assertEquals(complicatedExpression, decompressed);
    }
}
