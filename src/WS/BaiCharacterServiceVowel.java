/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;

/**
 *
 * @author ADMIN
 */
import vn.medianews.*;
import java.util.*;

public class BaiCharacterServiceVowel {

    public static void main(String[] args) {
        String sCode = "B22DCCN826", qCode = "tOpPk1L0";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();

        //a.
        List<String> a = (List<String>) port.requestStringArray(sCode, qCode);

        //b.
        Map<Integer, List<String>> mp = new HashMap<>();
        for (String x : a) {
            int nVowels = countVowels(x);
            if (mp.containsKey(nVowels)) {
                mp.get(nVowels).add(x);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(x);
                mp.put(nVowels, tmp);
            }
        }

        List<Integer> keys = new ArrayList<>(mp.keySet());
        Collections.sort(keys);
        
        List<String> res = new ArrayList<>();
        for (Integer k : keys) {
            List<String> g = mp.get(k);
            Collections.sort(g);
            String line = String.join(", ", g);
            
            res.add(line);
        }
        
        port.submitCharacterStringArray(sCode, qCode, res);
    }

    private static int countVowels(String s) {
        s = s.toLowerCase();
        String root = "ueoai";
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (root.indexOf(c) != -1) {
                ++cnt;
            }
        }

        return cnt;
    }

}
