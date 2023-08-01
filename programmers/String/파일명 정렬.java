import java.util.*;

/** Comparable은 자기 자신과 매개변수 객체를 비교, Comparator는 두 매개변수 객체를 비교
 Comparable은 lang패키지에 있기 때문에 import를 해줄 필요가 없지만, Comparator는 util패키지에 있다.
 Comparable 인터페이스를 쓰려면 compareTo() 메소드를 구현해야하고, Comparator 인터페이스를 쓰려면 compare() 메소드를 구현해야 한다
**/
class Solution {
    public String[] solution(String[] files) {
        
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) { //숫자로 구분하기 위한 정규식[0-9]
                String head1 = o1.split("[0-9]")[0].toLowerCase(); //대소문자를 구분 안하므로 소문자로 바꿔준다.
                String head2 = o2.split("[0-9]")[0].toLowerCase();
                //compareTo는 두 문자열이 단순히 같은지 아닌지를 알려줄 뿐만 아니라 어떤것이 사전적인 순서로 더 앞,뒤에 존재하는지를 알려준다.
                if(head1.compareTo(head2) == 0) {
                    return compareNum(o1, head1) - compareNum(o2, head2);
                } else {
                    return head1.compareTo(head2);
                }
            }
        });
        return files;
    }
    
     public static int compareNum(String o1, String head1) { //문자가 같으면 숫자를 비교
        int length = head1.length();
        
        String num = "";
        for(int i = length; i < o1.length(); i++) {
            if(Character.isDigit(o1.charAt(i))) { //숫자인지 검사
                num += o1.charAt(i);
            } else 
                break;
        }
        return Integer.parseInt(num);
    }
}
