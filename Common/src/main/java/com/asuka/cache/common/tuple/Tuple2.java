package com.asuka.cache.common.tuple;

import java.util.Objects;

public class Tuple2<A, B> {
    public A f1;
    public B f2;

    Tuple2(A f1, B f2){
        this.f1 = f1;
        this.f2 = f2;
    }

    public static <C,D>  Tuple2<C,D> of(C f1, D f2){
        return new Tuple2<C, D>(f1, f2);
    }

    @Override
    public String toString() {
        return "Tuple2{" +
                "f1=" + f1 +
                ", f2=" + f2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.equals(f1, tuple2.f1) && Objects.equals(f2, tuple2.f2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f1, f2);
    }
}
