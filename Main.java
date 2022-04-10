import java.util.Scanner;

class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int newRecords =  sc.nextInt();
        Roster mainRoster = new Roster("Main");

        for (int i = 0; i < newRecords; i++) {
            String stud = sc.next(); 
            String mod = sc.next();
            String ass = sc.next();
            String grade = sc.next();

            mainRoster = mainRoster.add(stud, mod, ass, grade);
        }
        
        while (sc.hasNext()) {            
            System.out.println(
                    mainRoster.getGrade(
                        sc.next(), sc.next(), sc.next()));
        }        
    }
}
