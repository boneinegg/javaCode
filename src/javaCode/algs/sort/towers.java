package javaCode.algs.sort;

import javax.swing.plaf.synth.SynthOptionPaneUI;

///汉诺塔
public class towers {
    static int n = 3;

    public static void main(String[] args) {
        doTowers(n, 'A', 'B', 'C');
    }

    public static void doTowers(int n, char from, char inter, char to) {
        if (n == 1) {
            System.out.println("    Enter 1 disk: " + "s=" + from + " i=" + inter + " d=" + to);
            System.out.println("        Base: move disk 1 from " + from + " to " + to);
            System.out.println("    Return (1 disk)");
        }
        else {
            System.out.println("Enter " + n + " disks: " + "s=" + from + " i=" + inter + " d=" + to);
            doTowers(n - 1, from, to, inter);

            System.out.println("Move disk " + n + " from " + from + " to " + to);
            doTowers(n - 1, inter, from, to);
            System.out.println("Return (" + n + " disks)");

        }
    }

}
