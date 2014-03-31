class BreakWithLabelDemo {
    public static void main(String[] args) {

        int[][] arrayOfInts = { 
            { 32, 87, 3, 589 },
            { 12, 1076, 2000, 8 },
            { 622, 127, 77, 955, 12 }
        };
        int searchfor = 12;

        int i;
        int j = 0;
        boolean foundIt = false;

    search:
        for (i = 0; i < arrayOfInts.length; i++) {
            for (j = 0; j < arrayOfInts[i].length;
                 j++) {
                if (arrayOfInts[i][j] == searchfor) {
                    foundIt = true;
                    break search;
                }
            }
        }

        if (foundIt) {
            System.out.println("Found " + searchfor + " at " + i + ", " + j);
        } else {
            System.out.println(searchfor + " not in the array");
        }

        searchContinue(searchfor, arrayOfInts);

        searchLoop(searchfor, arrayOfInts);
    }

    private static void searchContinue(int searchfor, int[][] arrayOfInts)
    {
        int i;
        int j = 0;
        int count = 0;
        search:
        for (i = 0; i < arrayOfInts.length; i++) {
            for (j = 0; j < arrayOfInts[i].length;
                 j++) {
                if (arrayOfInts[i][j] == searchfor) {
                    count++;
                    continue;
                }
            }
        }
        System.out.println("Found " +count+" occuances of "+searchfor);
    }

    private static void searchLoops(int searchfor, int[][] arrayOfInts)
    {
        boolean foundIt = false;
        i_loop:
        for (i = 0; i < arrayOfInts.length; i++) 
        {
            
            j_loop:
            for (j = 0; j < arrayOfInts[i].length;j++) 
            {
                if (arrayOfInts[i][j] == searchfor) 
                {
                    foundIt = true;
                    break search;
                }
            }
            if (i == 3)
            {
                break j_loop;
            }
        }
        System.out.println("loop found? "+foundIt);
    }
}