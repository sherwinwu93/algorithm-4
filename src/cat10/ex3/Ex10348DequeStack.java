package cat10.ex3;

public class Ex10348DequeStack<Item> {
    private Ex10333Deque<Item> deque = new Ex10333Deque<Item>();
    public Ex10348DequeStack() {
    }
    public void push(Item item) {
        deque.pushLeft(item);
    }
    public Item pop() {
        return deque.popLeft();
    }
    public Item peek() {
        Item item = deque.popLeft();
        deque.pushLeft(item);
        return item;
    }
    public int size() {
        return deque.size();
    }
    public boolean isEmpty() {
        return deque.isEmpty();
    }
}
