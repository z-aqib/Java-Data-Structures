package Recursion;

// COMPLETED
public class TowerOfHanoi {

    /*
    1.  Base case: If (n==1) then move needle 1 to 3
    2.  Recursive case: If(n>1) then
        a.  Move (n-1) disks from needle 1 to needle 2 using needle 3 as an auxiliary, 
            so that largest disc could be accessed.
        b.  Move this largest disc from needle 1 to 3.
        c.  Now, Move (n-1) discs from needle 2 to 3 using needle 1 as an auxiliary.
     */
    public void hanoiTowerSteps(int diskNum, char fromRod, char toRod, char middleRod) {
        if (diskNum == 1) { // base case
            System.out.println("Move disk " + diskNum + " from rod " + fromRod + " to rod " + toRod);
        } else { // recursive calls
            /*
            first it moves all the disks from needle 1 to needle 2 using needle 3 as the extra rod
            then it displays the movement
            then it moves all the disks from needle 2 to needle 3 using needle 1 as an extra rod    
             */
            hanoiTowerSteps(diskNum - 1, fromRod, middleRod, toRod);
            System.out.println("Move disk " + diskNum + " from rod " + fromRod + " to rod " + toRod);
            hanoiTowerSteps(diskNum - 1, middleRod, toRod, fromRod);
        }
    }

    public int hanoiTowerCalls(int diskNum, char fromRod, char toRod, char middleRod) {
        /*
        this is the same thing as hanoiTowerSteps, but instead of displaying what is the next step, 
        it counts how many steps it will take to move diskNum many disks. 
         */
        if (diskNum == 1) {
            return 1;
        } else {
            return hanoiTowerCalls(diskNum - 1, fromRod, middleRod, toRod)
                    + hanoiTowerCalls(diskNum - 1, middleRod, toRod, fromRod) + 1;
        }
    }

}
