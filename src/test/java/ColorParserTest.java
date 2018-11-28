import entity.Enum.Colors;
import entity.Enum.Material;
import entity.parser.ColorParser;
import org.junit.Assert;
import org.junit.Test;

public class ColorParserTest {
    @Test
    public void redParser(){
        String red = "red";

        Colors color = ColorParser.strToColor(red);

        Assert.assertEquals(Colors.RED, color);
    }

    @Test
    public void greenParser(){
        String green = "green";

        Colors color = ColorParser.strToColor(green);

        Assert.assertEquals(Colors.GREEN, color);
    }

    @Test
    public void blueParser(){
        String blue = "blue";

        Colors color = ColorParser.strToColor(blue);

        Assert.assertEquals(Colors.BLUE, color);
    }

    @Test
    public void whiteParser(){
        String white = "white";

        Colors color = ColorParser.strToColor(white);

        Assert.assertEquals(Colors.WHITE, color);
    }

    @Test
    public void blackParser(){
        String black = "black";

        Colors color = ColorParser.strToColor(black);

        Assert.assertEquals(Colors.BLACK, color);
    }

    @Test
    public void yellowParser(){
        String yellow = "yellow";

        Colors color = ColorParser.strToColor(yellow);

        Assert.assertEquals(Colors.YELLOW, color);
    }

    @Test
    public void defaultParser(){
        String def = "yBahf";

        Colors color = ColorParser.strToColor(def);

        Assert.assertEquals(Colors.DEFAULT, color);
    }
}
