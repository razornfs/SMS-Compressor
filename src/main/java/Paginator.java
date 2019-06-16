import java.util.ArrayList;
import java.util.List;

public class Paginator {
    private int pageSize;

    public Paginator(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<String> paginate(String text) {
        char[] chars = text.toCharArray();
        List<String> ret = new ArrayList<>();
        int charCount = 0;
        StringBuilder currentSMS = new StringBuilder();
        for (char c : chars) {
            if (charCount >= pageSize) {
                charCount = 1;
                ret.add(currentSMS.toString());
                currentSMS = new StringBuilder();
            } else {
                charCount++;
            }
            currentSMS.append(c);
        }
        if (currentSMS.length() > 0) {
            ret.add(currentSMS.toString());
        }
        return ret;
    }
}
