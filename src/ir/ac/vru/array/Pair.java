package ir.ac.vru.array;

import java.util.Objects;

public class Pair <firstType, secondType> {
    public firstType first;
    public secondType second;

    public Pair(firstType first, secondType second) {
        this.first = first;
        this.second = second;
    }

    public Pair(Pair<firstType, secondType> pair) {
        this.first = pair.first;
        this.second = pair.second;
    }

    public static <firstType, secondType> Pair<firstType, secondType> of(firstType f, secondType s) {
        return new Pair<firstType, secondType>(f, s);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }

    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }


}
