package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class ModelImpl implements Model{
    Map<String, Object> map = new HashMap<>();
    @Override
    public void addAttribute(String key, Object value) {
        map.put(key, value);
    }

    @Override
    public void addAttribute(Object o) {

    }

    public Map<String, Object> getMap() {
        return map;
    }
}
