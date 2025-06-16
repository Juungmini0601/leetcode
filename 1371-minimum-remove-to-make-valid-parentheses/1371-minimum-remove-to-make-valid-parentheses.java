import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	public String minRemoveToMakeValid(String s) {
		StringBuilder sb = new StringBuilder();
		Deque<Integer> stack = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.addLast(i);
				list.add(i);
			} else if (c == ')') {
				if (!stack.isEmpty()) {
					// Valid이므로 가지고 감
					stack.removeLast();
					list.add(i);
				}
			} else {
				list.add(i);
			}
		}
		
		// sb에서 지우기 시작하는 순간 인덱스가 밀려서 안됨
		while (!stack.isEmpty()) {
			set.add(stack.removeLast());
		}

		for (int i : list) {
			if (!set.contains(i)) {
				sb.append(s.charAt(i));
			}
		}
		
		return sb.toString();
	}
}