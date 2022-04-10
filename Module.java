class Module extends KeyableMap<Assessment> {   
    
    Module(String key) {
        super(key); 
    }

    private Module(String key, ImmutableMap<String, Assessment> map) {
        super(key, map);
    }
    
    Module put(Assessment value) {
        return new Module(super.getKey(),
                super.getMap().put(value.getKey(), value));
    }
}
