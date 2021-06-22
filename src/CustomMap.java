/**
 * @author ninolacap
 * @implNote custom implementation of Map
 */
public class CustomMap implements Map {

    // Initialize storage
    // Array of Custom Class<String, Object>
    public CustomKeyValue<String, Object>[] bucket = new CustomKeyValue[5];

    /**
     * @implNote custom implementation of inserting elements in a Key-Value pair array
     * @param key String
     * @param value Object
     */
    @Override
    public void put(String key, Object value) {

        // Create a custom object based on the parameters
        CustomKeyValue<String, Object> customKeyValue = new CustomKeyValue(key, value, null);

        // Whenever there is a null key, we'll insert it to index 0
        // if null 0; else hashcode modulus size of storage
        int index = (key == null ? 0 : key.hashCode()) % bucket.length;

        // Get the first element for validation
        CustomKeyValue<String, Object> e = bucket[index];

        // If an index is empty, insert the created object based on the calculated index
        // Else if key is existing, replace the old value with the new value
        // Else, iterate the index until it reaches the end node
        if(bucket[index] == null) {
            bucket[index] = customKeyValue;
        }
        else if(this.get(customKeyValue.key) != null) {
            while (e != null && (key != null)) {
                if (e.key.equals(key)) {
                    e.value = value;
                    break;
                }
                e = e.next;
            }
        }
        else {
            while (e != null) {
                if (e.next == null) {
                    e.next = customKeyValue;
                    break;
                }
                e = e.next;
            }
        }

    }

    /**
     * @implNote custom implementation of getting a value using a key
     * @param key
     * @return
     */
    @Override
    public Object get(String key) {

        // Whenever there is a null key, we'll insert it to index 0
        // if null 0; else hashcode modulus size of storage
        int index = (key == null ? 0 : key.hashCode()) % bucket.length;

        // Create a placeholder for the return value
        Object value = null;

        // Get the first element for validation
        CustomKeyValue<String, Object> e = bucket[index];

        // Iterate through all of the elements in the specified index and find the matching key
        // if the key matches the current element, pass the value to the placeholder
        while (e != null && (key != null)) {
            if (e.key.equals(key)) {
                value = e.value;
                break;
            }
            e = e.next;
        }

        return value;
    }

    /**
     * @implNote custom implementation of Key-Value pair with adjacent node
     * @param <String>
     * @param <Object>
     */
    class CustomKeyValue<String, Object> {
        private final String key;
        private Object value;
        private CustomKeyValue<String, Object> next;

        public CustomKeyValue(String key, Object value, CustomKeyValue<String, Object> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public CustomKeyValue<String, Object> getNext() {
            return next;
        }

        public void setNext(CustomKeyValue<String, Object> next) {
            this.next = next;
        }
    }
}
