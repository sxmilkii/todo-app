import org.example.TodoList;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TodoListTest {

    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("[ ] task1", t.getAll().get(0).substring(3));
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add(" ");
        assertEquals(0, t.size());
    }

    @Test
    void markDone() {
        TodoList t = new TodoList();
        t.add("task");
        assertTrue(t.markDone(0));
        assertEquals("[x] task", t.getAll().get(0).substring(3));
        assertFalse(t.markDone(5));
    }

    @Test
    void clear() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        t.clear();
        assertEquals(0, t.size());
    }

    @Test
    void search() {
        TodoList t = new TodoList();
        t.add("apple");
        t.add("banana");
        t.add("apricot");
        List<String> result = t.search("ap");
        assertEquals(2, result.size());
        assertTrue(result.get(0).contains("apple"));
        assertTrue(result.get(1).contains("apricot"));
    }
}