public class MaxComparable implements Comparable<Integer> 
{
        public final int x;

        public MaxComparable(int x) 
        {
            this.x = x;
        }

        public String toString() 
        {
            return "x="+x;
        }

        @Override
        public int compareTo(Integer y) 
        {
            return (y > x) ? y : x;
        }
}