class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, List<String>> buckets = new HashMap<>();
        buckets.put("electronics", new ArrayList<>());
        buckets.put("grocery", new ArrayList<>());
        buckets.put("pharmacy", new ArrayList<>());
        buckets.put("restaurant", new ArrayList<>());

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;
            if (!isValidCode(code[i])) continue;
            if (!buckets.containsKey(businessLine[i])) continue;

            buckets.get(businessLine[i]).add(code[i]);
        }

        List<String> result = new ArrayList<>();
        String[] order = {"electronics", "grocery", "pharmacy", "restaurant"};

        for (String category : order) {
            List<String> list = buckets.get(category);
            Collections.sort(list);
            result.addAll(list);
        }

        return result;
    }
    private boolean isValidCode(String s) {
        if (s == null || s.length() == 0) return false;

        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }
}