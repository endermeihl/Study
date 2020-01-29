package leetCode;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<Character> s=new Stack<>();
        for(char c:path.toCharArray()){
            if(s.isEmpty()){
                s.push(c);
                continue;
            }
            if(s.peek()=='/' && c=='/'){
                continue;
            }
            if(s.peek()=='.' && c=='.'){
                s.pop();
                s.pop();
                while(!s.isEmpty()&&s.peek()!='/'){
                    s.pop();
                }
                continue;
            }
            if(s.peek()=='.' && c!='.'){
                s.pop();
                s.pop();
            }
            s.push(c);
        }
        StringBuilder res=new StringBuilder();
        if(s.size()>1 && (s.peek()=='/'||s.peek()=='.')){
            s.pop();
        }
        if(s.isEmpty()){
            s.push('/');
        }
        while(!s.isEmpty()){
            res.append(s.pop());
        }
        return res.reverse().toString();
    }
    public static void main(String[] args){
        String s="/...";
        SimplifyPath simplifyPath=new SimplifyPath();
        simplifyPath.simplifyPath(s);
    }
}
