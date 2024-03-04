import org.junit.jupiter.api.Test;
import org.example.Node;
import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {
    @Test
    void creationTest() {
            Node node = new Node("node1");
            assertNotNull(node, "Узел не создан");
            assertEquals("node1", node.getName(),
                    "Узел создан не корректно");
    }
    @Test
    void addingTest() {
        Node node = new Node("node1");
        Node newNode = new Node("node2");
        node.add(newNode);
        assertEquals(node.getChildrenList().size(), 1);
    }

    @Test
    void findTest(){
        Node node = new Node("node1");
        Node newNode = new Node("node2");
        node.add(newNode);
        assertEquals(node.findChildrenByName("node2", node.getChildrenList()), newNode);
    }

    @Test
    void deleteByNameTest() {
        Node node = new Node("node1");
        Node newNode = new Node("node2");
        node.add(newNode);
        node.removeByName("node2", node.getChildrenList());
        assertEquals(node.getChildrenList().size(), 0);
    }

    @Test
    void clearTest() {
        Node node = new Node("node1");
        Node first = new Node("node2");
        Node second = new Node("Node3");
        node.add(first);
        node.add(second);
        assertEquals(node.getChildrenList().size(), 2);
        node.clear();
        assertTrue(node.getChildrenList().isEmpty());
    }
    @Test
    void setNameTest() {
        Node node = new Node("node1");
        node.setName("newName");
        assertEquals(node.getName(), "newName");
    }
}
