package but.aenj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe DefaultStack.
 */
class DefaultStackTest {

    // Pile par défaut
    private DefaultStack stack;

    // Items utilisés pour les tests
    private DefaultItem item1;
    private DefaultItem item2;

    /**
     * Méthode initialisant les variables utiles pour les tests
     */
    @BeforeEach
    void setUp() {
        item1 = new DefaultItem();
        item2 = new DefaultItem();
    }

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

        // On pousse un item dans la pile
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

        // On pousse un item dans la pile
        stack.push(item1);

        // La pile ne doit pas être vide car on a ajouté un item dedans
        assertFalse(stack.isEmpty(), "Pile vide");

    }

    /**
     * Test de la classe getSize avec une pile non vide.
     */
    @Test
    void getSizePileNonVide() {
        stack = new DefaultStack();

        // On pousse un item dans la pile
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

        // On pousse un item dans la pile
        stack.push(item1);

        // Cela doit renvoyer l'élément en haut de la pile
        assertEquals(item1, stack.peek(), "L'item renvoyé n'est pas le bon");

        // On pousse un deuxième item dans la pile
        stack.push(item2);

        // Cela doit renvoyer l'item 2 car c'est le dernier a avoir été ajouté (il est donc en haut de la pile)
        assertEquals(item2, stack.peek(), "L'item renvoyé n'est pas le bon");

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

        // On pousse un item crée dans la pile
        stack.push(item1);

        // Cela doit renvoyer l'élément en haut de la pile
        assertEquals(item1, stack.pop(), "L'item n'est pas renvoyé");

        // Étant donné que l'on fait un pop, l'élément doit être retiré, et la pile doit être vide
        assertTrue(stack.isEmpty(), "La pile n'est pas vide");
        // La pile doit être de taille 0
        assertEquals(0, stack.getSize(), "La pile n'est pas de taille 0");

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