package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {
    private final List<Item> items = new ArrayList<>();

    public static class Item {
        String text;
        boolean done;

        public Item(String text) {
            this.text = text;
            this.done = false;
        }
    }

    public void add(String item) {
        if (item != null) {
            item = item.trim();
            if (!item.isEmpty()) {
                items.add(new Item(item));
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public boolean markDone(int index) {
        if (index >= 0 && index < items.size()) {
            items.get(index).done = true;
            return true;
        }
        return false;
    }

    public void clear() {
        items.clear();
    }

    public List<String> getAll() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            Item it = items.get(i);
            result.add(String.format("%d: [%s] %s", i, it.done ? "x" : " ", it.text));
        }
        return result;
    }

    public List<String> search(String query) {
        return items.stream()
                .filter(it -> it.text.contains(query))
                .map(it -> String.format("[%s] %s", it.done ? "x" : " ", it.text))
                .collect(Collectors.toList());
    }

    public int size() {
        return items.size();
    }
}