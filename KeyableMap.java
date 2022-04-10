import java.util.Optional;
import java.util.Map;

class KeyableMap<V extends Keyable> implements Keyable {
    private final String key;
    private final ImmutableMap<String, V> map;
    
    KeyableMap(String key, ImmutableMap<String, V> map) {
        this.key = key; 
        this.map = map; 
    }

    KeyableMap(String key) {
        this(key, new ImmutableMap<String, V>());
    }

    public String getKey() {
        return this.key;
    }

    public ImmutableMap<String, V> getMap() {
        return this.map;
    }

    KeyableMap<V> put(V value) {
        return new KeyableMap<V>(this.key, 
                this.map.put(value.getKey(),value));
    }

    Optional<V> get(String key) {
        return this.map.get(key);
    }

    public String toString() {
        if (this.map.isEmpty()) {
            return String.format("%s: {}", this.key);
        } else {
            String output = "";
            for (Map.Entry<String, V> e: map) {
                output += e.getValue() + ", ";
            }
            return String.format("%s: {%s}", 
                    this.key, 
                    output.substring(0, output.length() - 2));
        }
    }
}






