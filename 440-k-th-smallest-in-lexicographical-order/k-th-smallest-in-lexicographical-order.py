class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        curr = 1
        k -= 1  # convert to 0-based index
        while k > 0:
            steps = 0
            first = curr
            last = curr + 1
            # Count numbers in current level of the trie
            while first <= n:
                steps += min(n + 1, last) - first
                first *= 10
                last *= 10
            
            if steps <= k:
                # Move to next sibling
                curr += 1
                k -= steps
            else:
                # Move to first child
                curr *= 10
                k -= 1
        return curr