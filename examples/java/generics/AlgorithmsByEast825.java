import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

public class AlgorithmsByEast825
{
    public static class ColoredPoint extends Point 
    {
        public final Color color;

        public ColoredPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }
        @Override
        public String toString() {
            return String.format("ColoredPoint(x=%d, y=%d, color=%s)", x, y, color);
        }
    }

    public static class Point implements Comparable<Point> 
    {
        public final int x, y;

        public Point(int x, int y) 
        {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() 
        {
            return String.format("Point(x=%d, y=%d)", x, y);
        }
        
        @Override
        public int compareTo(Point p) 
        {
            return x != p.x ? x - p.x : y - p.y;
        }
    }

    public static <T extends Comparable<? super T>> T min(Collection<? extends T> xs) {
        Iterator<? extends T> iter = xs.iterator();
        if (!iter.hasNext()) {
            throw new IllegalArgumentException("Collection is empty");
        }
        T minElem = iter.next();
        while (iter.hasNext()) {
            T elem = iter.next();
            if (elem.compareTo(minElem) < 0) {
                minElem = elem;
            }
        }
        return minElem;
    }

    public static <T extends Comparable<? super T>> T wrongMin(Collection<T> xs) {
        return min(xs);
    }

    public static <T extends Object & Comparable<? super T>>
        T max(List<? extends T> list, int begin, int end) 
    {
        T maxElem = list.get(begin);

        for (++begin; begin < end; ++begin)
            if (maxElem.compareTo(list.get(begin)) < 0)
                maxElem = list.get(begin);
        return maxElem;
    }

    public static void main(String[] args) {
        List<ColoredPoint> points = Arrays.asList(
                new ColoredPoint(1, 2, Color.BLACK),
                new ColoredPoint(0, 2, Color.BLUE),
                new ColoredPoint(0, -1, Color.RED)
        );
        Point p1 = wrongMin(points);
        Point p2 = min(points);
        Point p3 = max(points, 1, 2);
        System.out.println("WrongMin element is " + p1);
        System.out.println("minimum  element is " + p2);
        System.out.println("Max      element is " + p3);
    }
}