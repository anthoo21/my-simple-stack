package but.aenj;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Classe qui implément l'interface SimpleStack.
 */
public class DefaultStack implements SimpleStack {

    /**
     * Liste d'item représentant la pile.
     */
    private List<Item> stack;

    /**
     * Constructeur de la classe DefaultStack.
     */
    public DefaultStack() {
        this.stack = new ArrayList<>();
    }

    /**
     * Tests if this stack is empty.
     * @return true si pile vide
     *         false sinon
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Returns the number of items in this stack.
     * @return la taille de la pile
     */
    @Override
    public int getSize() {
        return stack.size();
    }

    /**
     * Pushes an item onto the top of this stack.
     * null item is allowed.
     * @param item Item à pousser sur la pile
     */
    @Override
    public void push(final Item item) {
        stack.add(item);
    }

    /**
     * Looks at the object at the top of this stack without removing it from the
     stack.
     * @throws EmptyStackException if this stack is empty.
     * @return l'item en haut de la pile
     */
    @Override
    public Item peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    /**
     * Removes the object at the top of this stack and returns that object
     * as the value of this function.
     * @throws EmptyStackException if this stack is empty.
     * @return l'item en haut de la pile
     */
    @Override
    public Item pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }
}
