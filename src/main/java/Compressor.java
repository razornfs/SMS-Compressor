public interface Compressor<T> {
    T compress(String text);

    String decompress(T text);
}
