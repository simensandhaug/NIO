import java.util.Scanner;

public class kryptering {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String key = s.nextLine();
        int msgLen = Integer.parseInt(s.nextLine());
        String code = s.nextLine();
        System.out.println(decodeMsg(code, key, msgLen));
    }

    private static String decodeMsg(String msg, String key, int msgLen) {
        String decodedMsg = "";

        for(int i = 0; i < msgLen; i++) {
            char currentChar = msg.charAt(i);
            int j = key.indexOf(currentChar);
            if(j == 0) decodedMsg += key.charAt(25);
            else decodedMsg += key.charAt(j - 1);
        }

        return decodedMsg;
    }
}
