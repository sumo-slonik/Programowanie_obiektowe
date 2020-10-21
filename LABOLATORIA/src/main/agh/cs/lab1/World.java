package agh.cs.lab1;
import static java.lang.System.out;
public class World {
    public static void run(Direction [] args)
    {
        for (int i = 0;i < args.length;i++)
        {
            switch (args[i])
            {
                case FORWARD:
                    out.println("zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    out.println("zwierzak idzie do tyłu");
                    break;
                case LEFT:
                    out.println("zwierzak idzie w lewo");
                    break;
                case RIGHT:
                    out.println("zwierzak idzie w prawo");
                    break;
                default:
                    //ignorowanie
            }
        }
    }
    public  static Direction [] convert(String [] args)
    {
        Direction [] result = new Direction [args.length];
        for (int i =0; i < args.length;i++) {
            switch (args[i])
            {
                case "f":
                    result[i]=Direction.FORWARD;
                    break;
                case "b":
                    result[i]=Direction.BACKWARD;
                    break;
                case "r":
                    result[i]=Direction.RIGHT;
                    break;
                case "l":
                    result[i]=Direction.LEFT;
                    break;
                default:
                    //ignorowanie
        }
        }
        return result;
    }
    public static void main(String [] args){
        out.println("Start systemu");
        Direction [] converted = convert(args);
        run(converted);
        out.println("Stop systemu");
    }
}
