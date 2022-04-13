import java.util.Stack;

public class Delete_middle_element_stack {

    public static void main(string... args) {
        Stack<E> st = new Stack();
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);
        st.add(5);
        st.add(6);
        solve(st, (arr.length + 1) / 2);
    }

    public static void solve(Stack s, int k) {
        if (k == 1) {
            s.pop();
        }
        int temp = s.top();
        s.pop();
        solve(s, k - 1);
        s.push(temp);
    }
}
