class Solution {
    public String clearStars(String s) {
        List<Deque<Integer>> freq = new ArrayList<>();
        for (int i = 0; i < 26; i++) freq.add(new ArrayDeque<>());

        int a = 'a';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                for (int j = 0; j < 26; j++) {
                    if (!freq.get(j).isEmpty()) {
                        freq.get(j).removeLast();
                        break;
                    }
                }
            } else {
                freq.get(s.charAt(i) - a).add(i);
            }
        }

        boolean[] keep = new boolean[s.length()];
        for (Deque<Integer> stack : freq) {
            for (int idx : stack) {
                keep[idx] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (keep[i]) result.append(s.charAt(i));
        }
        return result.toString();
    }
}