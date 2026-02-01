package OA;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


class Entry<V> {
    private V value;
    private long expireAt;

    public Entry(V value, long expireAt) {
        this.value = value;
        this.expireAt = expireAt;
    }

    public V getValue() {
        return value;
    }

    public long getExpireAt() {
        return expireAt;
    }
}

public class CacheTTL<K, V> {
    private ConcurrentMap<K, Entry<V>> cache;

    public CacheTTL() {
        cache = new ConcurrentHashMap<>();
    }

    /**
     * put the entry in to cache
     * @param key key
     * @param value value
     * @param ttlMillis the time-to-live in millisecond
     */
    public void put(K key, V value, long ttlMillis) {
        cache.put(key, new Entry<>(value, System.currentTimeMillis() + ttlMillis));
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        if (System.currentTimeMillis() >= cache.get(key).getExpireAt()) {
            cache.remove(key);
            return null;
        }

        return cache.get(key).getValue();
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void cleanUp() {
        // ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        long currentTimeStamp = System.currentTimeMillis();
        for (ConcurrentMap.Entry<K, Entry<V>> entry : cache.entrySet()) {
            if (entry.getValue().getExpireAt() <= currentTimeStamp) {
                cache.remove(entry.getKey());
            }
        }
    }
}
