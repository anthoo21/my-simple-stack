package but.aenj;

import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe DefaultStack.
 */
class DefaultStackTest {

    // Pile par défaut
    private DefaultStack stack;

    /**
     * Test de la classe IsEmpty avec une pile vide.
     */
    @Test
    void isEmptyPileVide() {
        stack = new DefaultStack();
        // La pile doit être vide car on a rien ajouté dedans
        assertTrue(stack.isEmpty(), "Pile non vide");

    }

    /**
     * Test de la classe getSize avec une pile vide.
     */
    @Test
    void getSizePileVide() {
        stack = new DefaultStack();
        // La pile ne doit contenir aucun élément
        assertEquals(0, stack.getSize());
    }

    /**
     * Test de la méthode push.
     */
    @Test
    void pushItem() {
        stack = new DefaultStack();

        // On crée un item
        DefaultItem item1 = new DefaultItem();
        // On pousse l'item crée dans la pile
        stack.push(item1);

        // Alors la pile doit être maintenant de taille 1
        assertEquals(1, stack.getSize());
    }

    /**
     * Test de la classe IsEmpty avec une pile non vide.
     */
    @Test
    void isEmptyPileNonVide() {
        stack = new DefaultStack();

        // On crée un item
        DefaultItem item1 = new DefaultItem();
        // On pousse l'item crée dans la pile
        stack.push(item1);

        // La pile ne doit pas être vide car on a rien ajouté dedans
        assertFalse(stack.isEmpty(), "Pile vide");

    }

    /**
     * Test de la classe getSize avec une pile non vide.
     */
    @Test
    void getSizePileNonVide() {
        stack = new DefaultStack();

        // On crée un item
        DefaultItem item1 = new DefaultItem();
        // On pousse l'item crée dans la pile
        stack.push(item1);

        // La pile doit contenir un élément
        assertEquals(1, stack.getSize());
    }

    /**
     * Test de la méthode peek avec une pile vide.
     */
    @Test
    void peekPileVide() {
        stack = new DefaultStack();

        assertThrows(EmptyStackException.class, () -> {
                    stack.peek();
                }, "EmptyStackException est attendu");

    }

    /**
     * Test de la méthode peek avec une pile non vide.
     */
    @Test
    void peekPileNonVide() {
        stack = new DefaultStack();

        // On crée un item
        DefaultItem item1 = new DefaultItem();
        // On pousse l'item crée dans la pile
        stack.push(item1);

        // Cela doit renvoyer l'élément en haut de la pile
        assertEquals(item1, stack.peek(), "L'item n'est pas renvoyé");

        // On crée un autre item
        DefaultItem item2 = new DefaultItem();
        // On pousse l'item crée dans la pile
        stack.push(item2);

        // Cela doit renvoyer l'élément en haut de la pile (donc item2, le dernier item push)
        assertNotEquals(item1, stack.peek(), "L'item renvoyé n'est pas le bon");

    }

    /**
     * Test de la méthode pop sur une pile vide.
     */
    @Test
    void popPileVide() {
        stack = new DefaultStack();

        assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        }, "EmptyStackException est attendu");
    }

    /**
     * Test de la méthode pop avec une pile non vide.
     */
    @Test
    void popPileNonVide() {
        stack = new DefaultStack();

        // On crée un item
        DefaultItem item1 = new DefaultItem();
        // On pousse l'item crée dans la pile
        stack.push(item1);

        // Cela doit renvoyer l'élément en haut de la pile
        assertEquals(item1, stack.pop(), "L'item n'est pas renvoyé");

        // Étant donné que l'on fait un pop, l'élément doit être retiré, et la pile doit être vide
        assertTrue(stack.isEmpty(), "La pile n'est pas vide");

        // On crée un autre item
        DefaultItem item2 = new DefaultItem();
        // On pousse le premier item dans la pile
        stack.push(item1);
        // On pousse le deuxième item dans la pile
        stack.push(item2);

        // Cela doit renvoyer l'élément en haut de la pile
        assertEquals(item2, stack.pop(), "L'item n'est pas renvoyé");

        // La pile doit être de taille 1
        assertEquals(1, stack.getSize(), "La pile n'est pas de taille 1");
    }
}