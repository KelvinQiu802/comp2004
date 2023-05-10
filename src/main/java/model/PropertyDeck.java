package model;

import java.util.ArrayList;
import java.util.List;

public class PropertyDeck {
    private List<PropertySet> propertySets;

    public PropertyDeck() {
        propertySets = new ArrayList<>();
    }

    public List<PropertySet> getPropertySets() {
        return propertySets;
    }

// TODO: 修改PropertySet里面的内容应该通过PropertyDeck里面的方法，这里需要抽象出方法
}
