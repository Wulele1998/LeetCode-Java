package LC271;

import java.util.List;
import java.util.ArrayList;

public class CodeC {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            // find the length
            int start = i;
            while (i < n && s.charAt(i) != '#') {
                i++;
            }
            int strLen = Integer.parseInt(s.substring(start, i));
            i++; // skip the '#'
            res.add(s.substring(i, i + strLen));
            i += strLen;
        }

        return res;
    }
}
