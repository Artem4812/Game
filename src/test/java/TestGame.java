import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGame {

    Game game = new Game();
    Player p1 = new Player(1,"Саша", 150);
    Player p2 = new Player(2,"Женя", 240);
    Player p3 = new Player(3,"Коля", 50);
    Player p4 = new Player(4,"Никита", 50);


    @BeforeEach
    public void setup() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);

    }


    @Test

    public void ShouldGetNotRegisteredExceptionP1P2() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Таня", "Гена");
        });
    }

    @Test

    public void ShouldGetNotRegisteredExceptionP1() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Таня", "Саша");
        });
    }

    @Test

    public void ShouldGetNotRegisteredExceptionP2() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Таня");
        });
    }

    @Test

    public void ShouldGetWinner2() {
        int expected = 2;
        int actual = game.round(p3.getName(), p2.getName());
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void ShouldGetWinner1() {
        int expected = 1;
        int actual = game.round(p1.getName(), p3.getName());
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void ShouldGetDraw() {
        int expected = 0;
        int actual = game.round(p3.getName(), p4.getName());
        Assertions.assertEquals(expected, actual);
    }
    @Test

    public void ShouldSetName() {
        p1.setName("Эдик");
        String expected = "Эдик";
        String actual = p1.getName();
        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void ShouldSetID() {
        p1.setId(44);
        int expected = 44;
        int actual = p1.getId();
        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void ShouldSetStrength() {
        p1.setStrength(100500);
        int expected = 100500;
        int actual = p1.getStrength();
        Assertions.assertEquals(expected, actual);

    }



}
