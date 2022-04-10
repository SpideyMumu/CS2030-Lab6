import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Collection;
import java.util.Set;
import java.util.Iterator;

class ImmutableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    private final Map<K, V> map;

    ImmutableMap() {
        this.map = new LinkedHashMap<K, V>();
    }

    ImmutableMap(Map<K, V> map) {
        this.map = new LinkedHashMap<>(map);
    }

    boolean isEmpty() {
        return this.map.isEmpty();
    }

    ImmutableMap<K, V> put(K key, V value) {
        ImmutableMap<K, V> newMap = new ImmutableMap<K, V>(this.map);
        newMap.map.put(key, value);
        return newMap;
    }

    Optional<V> get(K key) {
        if (!this.map.containsKey(key)) {
            return Optional.<V>empty();
        } else {
            return Optional.<V>of(this.map.get(key));
        }
    }

    Set<K> keySet() {
        return this.map.keySet();
    }

    Collection<V> values() {
        return this.map.values();
    }

    Set<Map.Entry<K,V>> entrySet() {
        return this.map.entrySet();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return this.map.entrySet().iterator();
    }

    @Override
    public String toString() {
        return this.map.toString();
    }
}
