class Solution {
    public String simplifyPath(String path) {
        Deque<String> queue = new ArrayDeque<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) continue;
            if (part.equals("..")) {
                if (!queue.isEmpty()) queue.pollLast();
            } else {
                queue.offerLast(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : queue) {
            sb.append("/").append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}