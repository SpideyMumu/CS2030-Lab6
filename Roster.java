import java.util.Optional;

class Roster extends KeyableMap<Student> {

    Roster(String key) {
        super(key);
    }
    
    private Roster(String key, ImmutableMap<String, Student> map) {
        super(key, map);
    }

    Roster put(Student value) {
        return new Roster(super.getKey(),
                super.getMap().put(value.getKey(), value));
    }

    String getGrade(String stud, String mod, String ass) {
        return this.get(stud).flatMap(x -> x.get(mod))
            .flatMap(x -> x.get(ass)).map(x -> x.getGrade())
            .orElse(String.format("No such record: %s %s %s",
                        stud, mod, ass));  
    }

    Roster add(String stud, String mod, String ass, String grade) {
        // check if student exists
        Student student = this.get(stud).orElse(new Student(stud));
        // check if Module exists
        Module module = student.get(mod).orElse(new Module(mod));
        // check if assessment exists            
        Assessment test = new Assessment(ass, grade);
        
        return new Roster(super.getKey(), super.getMap())
                .put(student.put(module.put(test))); 
    }
}
