class Student extends KeyableMap<Module> {
    //private final ImmutableMap<String, Module> studentMap;

    Student(String key) {
        super(key); 
    }

    private Student(String key, ImmutableMap<String, Module> map) {
        super(key, map);
    }

    /*private Student(KeyableMap<Assessment> a) {
        super(a.getKey(), a.getMap());
    
    }*/

    Student put(Module value) {
        //return new Student();
        return new Student(super.getKey(),
                super.getMap().put(value.getKey(), value));
    } 

}

