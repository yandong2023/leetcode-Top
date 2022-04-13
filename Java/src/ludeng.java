import java.util.HashSet;

/**
XX....XXX.XXX
 如上路灯 只有.可以放路灯，问最少需要放几个路灯，路灯只能照到i-1和i+1
 */
class miniLight {
    public static void main(String[] args) {
        int light = miniLight("xx...xx....xx");
        System.out.println("Hello World!"+light);
    }
    private static int miniLight(String road){
        if(road ==null || road.length()==0){
            return 0;
        }
        return process(road.toCharArray(),0,new HashSet<>());
    }
    public static int process(char[] str,int index,HashSet<Integer> lights) {
        if (index == str.length) {
            for (int i = 0; i < str.length; i++) {
                if (str[i] != 'x') {
                    if (!lights.contains(i - 1) && !lights.contains(i) && !lights.contains(i + 1)) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            return lights.size();
        } else {
            int no = process(str, index + 1, lights);
            int yes = Integer.MAX_VALUE;
            if (str[index] == '.') {
                lights.add(index);
                yes = process(str, index + 1, lights);
                lights.remove(index);
            }
            return Math.min(no, yes);
        }
    }
}