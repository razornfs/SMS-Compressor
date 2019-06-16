public class JsmazCompressor implements Compressor<byte[]> {

    private Smaz compressor;

    public JsmazCompressor() {
        compressor = new Smaz();
    }

    @Override
    public byte[] compress(String text) {
        return compressor.compress(text);
    }

    @Override
    public String decompress(byte[] bytes) {
        return compressor.decompress(bytes);
    }
}
