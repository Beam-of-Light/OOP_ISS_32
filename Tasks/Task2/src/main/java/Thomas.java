import java.lang.reflect.Array;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Thomas {
    private List<Double> a;
    private List<Double> c;
    private List<Double> b;
    private List<Double> f;
    private List<Double> result;


    public Thomas(ArrayList<Double> a, ArrayList<Double> c, ArrayList<Double> b, ArrayList<Double> f) {
        this.a = a;
        this.c = c;
        this.b = b;
        this.f = f;
    }

    private void leftThomas() {
        int size = a.size();

        List<Double> alpha = new ArrayList<Double>(size);
        List<Double> beta = new ArrayList<Double>(size);

        alpha.add(-b.get(0) / c.get(0));
        beta.add(f.get(0) / c.get(0));

        for (int i = 1; i < size; ++i) {
            double temp = c.get(i) + alpha.get(i - 1) * a.get(i);
            alpha.add(-b.get(i) / temp);
            beta.add((f.get(i) - a.get(i) * beta.get(i - 1)) / temp);
        }

        result = new ArrayList<>(Arrays.asList(new Double[size]));
        result.set(size - 1, beta.get(size - 1));

        for (int i = size - 2; i >= 0; --i) {
            result.set(i, alpha.get(i) * result.get(i + 1) + beta.get(i));
        }
    }

    public List<Double> algoThomas() {
        leftThomas();
        return result;
    }
}
