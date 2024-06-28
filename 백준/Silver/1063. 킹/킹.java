import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int checkLocation(int n, int m) {
        if (0 < n && n < 9 && 0 < m && m < 9) {
            return 1;
        }
        return 0;
    }

    public static String changeLocation(int n, int m) {
        String n1 = Character.toString((char) (n + '0'));
        String m1 = Character.toString((char) (m + 64));
        return m1.concat(n1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        int n1 = king.charAt(1) - '0'; // 행
        int m1 = king.charAt(0) - 64; // 열

        String stone = st.nextToken();
        int n2 = stone.charAt(1) - '0';
        int m2 = stone.charAt(0) - 64;
        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            String command = br.readLine();
            switch (command) {
                case "R":
                    m1++;
                    if ((n1 == n2 && m1 == m2) && checkLocation(n1, m1) == 1) {
                        m2++;
                        if (checkLocation(n2, m2) == 0) {
                            m1--;
                            m2--;
                            break;
                        }
                        king = changeLocation(n1, m1);
                        stone = changeLocation(n2, m2);
                        break;
                    }

                    if (checkLocation(n1, m1) == 1) {
                        king = changeLocation(n1, m1);
                        break;
                    }
                    m1--;
                    break;

                case "L":
                    m1--;
                    if ((n1 == n2 && m1 == m2) && checkLocation(n1, m1) == 1) {
                        m2--;
                        if (checkLocation(n2, m2) == 0) {
                            m1++;
                            m2++;
                            break;
                        }
                        king = changeLocation(n1, m1);
                        stone = changeLocation(n2, m2);
                        break;
                    }

                    if (checkLocation(n1, m1) == 1) {
                        king = changeLocation(n1, m1);
                        break;
                    }
                    m1++;
                    break;

                case "B":
                    n1--;
                    if ((n1 == n2 && m1 == m2) && checkLocation(n1, m1) == 1) {
                        n2--;
                        if (checkLocation(n2, m2) == 0) {
                            n1++;
                            n2++;
                            break;
                        }
                        king = changeLocation(n1, m1);
                        stone = changeLocation(n2, m2);
                        break;
                    }

                    if (checkLocation(n1, m1) == 1) {
                        king = changeLocation(n1, m1);
                        break;
                    }
                    n1++;
                    break;

                case "T":
                    n1++;
                    if ((n1 == n2 && m1 == m2) && checkLocation(n1, m1) == 1) {
                        n2++;
                        if (checkLocation(n2, m2) == 0) {
                            n1--;
                            n2--;
                            break;
                        }
                        king = changeLocation(n1, m1);
                        stone = changeLocation(n2, m2);
                        break;
                    }
                    if (checkLocation(n1, m1) == 1) {
                        king = changeLocation(n1, m1);
                        break;
                    }
                    n1--;
                    break;

                case "RT":
                    n1++;
                    m1++;
                    if ((n1 == n2 && m1 == m2) && checkLocation(n1, m1) == 1) {
                        n2++;
                        m2++;
                        if (checkLocation(n2, m2) == 0) {
                            n1--;
                            m1--;
                            n2--;
                            m2--;
                            break;
                        }
                        king = changeLocation(n1, m1);
                        stone = changeLocation(n2, m2);
                        break;
                    }
                    if (checkLocation(n1, m1) == 1) {
                        king = changeLocation(n1, m1);
                        break;
                    }
                    n1--;
                    m1--;
                    break;

                case "LT":
                    n1++;
                    m1--;
                    if ((n1 == n2 && m1 == m2) && checkLocation(n1, m1) == 1) {
                        n2++;
                        m2--;
                        if (checkLocation(n2, m2) == 0) {
                            n1--;
                            m1++;
                            n2--;
                            m2++;
                            break;
                        }
                        king = changeLocation(n1, m1);
                        stone = changeLocation(n2, m2);
                        break;
                    }
                    if (checkLocation(n1, m1) == 1) {
                        king = changeLocation(n1, m1);
                        break;
                    }
                    n1--;
                    m1++;
                    break;

                case "RB":
                    n1--;
                    m1++;
                    if ((n1 == n2 && m1 == m2) && checkLocation(n1, m1) == 1) {
                        n2--;
                        m2++;
                        if (checkLocation(n2, m2) == 0) {
                            n1++;
                            m1--;
                            n2++;
                            m2--;
                            break;
                        }
                        king = changeLocation(n1, m1);
                        stone = changeLocation(n2, m2);
                        break;
                    }
                    if (checkLocation(n1, m1) == 1) {
                        king = changeLocation(n1, m1);
                        break;
                    }
                    n1++;
                    m1--;
                    break;

                case "LB":
                    n1--;
                    m1--;
                    if ((n1 == n2 && m1 == m2) && checkLocation(n1, m1) == 1) {
                        n2--;
                        m2--;
                        if (checkLocation(n2, m2) == 0) {
                            n1++;
                            m1++;
                            n2++;
                            m2++;
                            break;
                        }
                        king = changeLocation(n1, m1);
                        stone = changeLocation(n2, m2);
                        break;
                    }
                    if (checkLocation(n1, m1) == 1) {
                        king = changeLocation(n1, m1);
                        break;
                    }
                    n1++;
                    m1++;
                    break;
            }
        }

        System.out.println(king);
        System.out.println(stone);
    }
}