import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> c = new ArrayList<>(Arrays.asList(1.0, 3.0, 2.0));
        ArrayList<Double> b = new ArrayList<>(Arrays.asList(1.0, 2.0, 0.0));
        ArrayList<Double> f = new ArrayList<>(Arrays.asList(1.0, 1.0, 1.0));
        ArrayList<Double> a = new ArrayList<>(Arrays.asList(0.0, 1.0, 0.0));
        Thomas test = new Thomas(a, c, b, f);
        test.algoThomas();
    }
}
