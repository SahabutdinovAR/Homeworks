package maxima.reflection.solution;

import maxima.reflection.framework.CheckRange;
import maxima.reflection.framework.Document;

public class Certificate implements Document {
    @CheckRange(min = 0,max = 10)
    private static int activeYears;


    public Certificate(int getActiveYears) {
       this.activeYears = activeYears;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "activeYears=" + activeYears +
                '}';
    }

    public static int getActiveYears() {
        return activeYears;
    }

    public void setActiveYears(int activeYears) {
        this.activeYears = activeYears;
    }
}
