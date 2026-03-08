java.util.HashSet;
import java.util.Set;

public class _1980 {
    Set<String> sets;
    int N;
    String answer;
    String[] range = {"0", "1"};

    public void dfs(int cnt, StringBuilder temp) {
        if (answer != null) return; // 이미 정답을 찾았으면 더이상 dfs 를 진행하지 않는다. 
        if (cnt == N) {
            String tempResult = temp.toString();
            if (sets.contains(tempResult)) {
                return;
            } else {
                answer = tempResult;
                return;
            }
        }

        for (int i = 0; i < range.length; i++) {
            temp.append(range[i]);
            dfs(cnt + 1, temp);
            temp.setLength(temp.length() - 1);
        }
    }

    // 2026.03.08
    // nums 에 있는 이진수와 같은 길이의 이진수이 되, nums 에 없는 수를 반환하라.
    // 풀이: 백트랙킹을 이용해서 가능한 2진수를 만든후 nums 에 없는거면 정답으로 반환.
    // O(n * 2^n)
    public String findDifferentBinaryString(String[] nums) {
        sets = new HashSet<>();
        for (String s : nums) {
            sets.add(s);
        }

        N = nums[0].length();
        dfs(0, new StringBuilder());
        return answer;
    }

    public static void main(String[] args) {
        _1980 a = new _1980();
        String answer = a.findDifferentBinaryString(new String[]{"111", "011", "001"});
        System.out.println(answer); // "110"
    }
}
