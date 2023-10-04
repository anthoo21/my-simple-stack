package but.aenj;

import java.util.EmptyStackException;

/**
 * Interface SimpleStack représentant une Pile.
 */
public interface SimpleStack {


    /**
     * Tests if this stack is empty.
     * @return true si pile vide
     *         false sinon
     */
    boolean isEmpty();


    /**
     * Returns the number of items in this stack.
     * @return la taille de la pile
     */
    int getSize();


    /**
     * Pushes an item onto the top of this stack.
     * null item is allowed.
     * @param item Item à pousser sur la pile
     */
    void push(Item item);


    /**
     * Looks at the object at the top of this stack without removing it from the
     stack.
     * @throws EmptyStackException if this stack is empty.
     * @return l'item en haut de la pile
     */
    Item peek() throws EmptyStackException;


    /**
     * Removes the object at the top of this stack and returns that object
     * as the value of this function.
     * @throws EmptyStackException if this stack is empty.
     * @return l'item en haut de la pile
     */
    Item pop() throws EmptyStackException;
}


