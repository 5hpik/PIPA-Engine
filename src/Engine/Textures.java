package Engine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class Textures
{
    enum Type
    {
        WALL,
        CEILING,
        FLOOR
    }

    private static Hashtable<Textures.Type, BufferedImage[]> textures = new Hashtable<>();
    private static Hashtable<Integer, Textures.Type> walls = new Hashtable<>();
    private static Hashtable<Integer, Textures.Type> floors = new Hashtable<>();
    private static Hashtable<Integer, Textures.Type> ceilings = new Hashtable<>();

    static void initAll()
    {
        try
        {
            initTextures();

            initFloors();
            initWalls();
            initCeilings();
        }
        catch (IOException e)
        {

        }
    }
    private static void initCeilings()
    {
        for (int i = 0; i < 7; i++)
            ceilings.put(i, Textures.Type.CEILING);
    }

    private static void initFloors()
    {
        for (int i = 0; i < 7; i++)
            floors.put(i, Textures.Type.FLOOR);
    }

    private static void initWalls()
    {
        walls.put(0, Textures.Type.WALL);
    }

    private static void initTextures() throws IOException
    {
        textures.put(Textures.Type.WALL, new BufferedImage[]{ImageIO.read(new File("Resources/Wall0.png"))});
        textures.put(Textures.Type.CEILING, new BufferedImage[]{ImageIO.read(new File("Resources/Ceiling0.png"))});
        textures.put(Textures.Type.FLOOR, new BufferedImage[]{ImageIO.read(new File("Resources/Floor0.png"))});
    }

    public static Hashtable<Textures.Type, BufferedImage[]> getTextures()
    {
        return textures;
    }

    public static Hashtable<Integer, Textures.Type> getWalls()
    {
        return walls;
    }

    public static Hashtable<Integer, Textures.Type> getFloors()
    {
        return floors;
    }
    public static Hashtable<Integer, Textures.Type> getCeilings()
    {
        return ceilings;
    }

    BufferedImage getImage()
    {
        return images[];     // 10 is arbitrary
    }
}
