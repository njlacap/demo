
/**
 * @author ninolacap
 *
 */

public class Main {

    public static void main(String[] args) {

        CustomMap customMap = new CustomMap();

        customMap.put("a", "human1");
        customMap.put("b", "human2");
        customMap.put("c", "human3");
        customMap.put("d", "human4");
        customMap.put(null, null);

        System.out.println(customMap.get("a"));
        System.out.println(customMap.get("b"));
        System.out.println(customMap.get("c"));
        customMap.put("c", "human5");
        System.out.println(customMap.get("c"));
        System.out.println(customMap.get("d"));

    }

}
