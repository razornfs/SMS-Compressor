import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaginatorTest {
    @Test
    public void small_text_big_page_size() {
        Paginator paginator = new Paginator(100);
        String ala_ma_kota = "Ala ma kota";
        List<String> ala = paginator.paginate(ala_ma_kota);
        assertEquals(1, ala.size());
        assertEquals(ala_ma_kota, ala.get(0));
    }

    @Test
    public void big_text_small_page_size() {
        Paginator paginator = new Paginator(3);
        List<String> letters = paginator.paginate("aaabbbcccdddeeefff");
        assertEquals(6, letters.size());
        assertEquals("aaa", letters.get(0));
        assertEquals("bbb", letters.get(1));
        assertEquals("ccc", letters.get(2));
        assertEquals("ddd", letters.get(3));
        assertEquals("eee", letters.get(4));
        assertEquals("fff", letters.get(5));
    }
}
