package stream.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;
import java.util.function.*;

import org.junit.Test;

import common.test.tool.dataset.ClassicOnlineStore;

public class PlaygroundLambdaTest extends ClassicOnlineStore {

    @Test
    public void intervention_should_be_demonstrative() {
        List<Integer> numbers = Arrays.asList(1, 100, 10, 1000);

        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        assertThat(numbers, is(Arrays.asList(1, 10, 100, 1000)));

        numbers = Arrays.asList(1, 2, 5, 4);
        Collections.sort(numbers, (o1, o2) -> o1.compareTo(o2));
        assertThat(numbers, is(Arrays.asList(1, 2, 4, 5)));
    }

    @Test
    public void operators() {
        UnaryOperator<Object> moins = null;

        assert moins.apply("un").equals("moins un");
    }

    @Test
    public void predicate() {
        Predicate<String> isEmpty = null;
        Predicate<String> isTrimmed = null;

        assert isEmpty.test(null);
        assert isEmpty.test("");
        assert !isEmpty.test("not empty");

        assert isEmpty.negate().and(isTrimmed).test("not empty");
        assert !isEmpty.negate().and(isTrimmed).test(" not empty ");

        assert isEmpty.or(isTrimmed).test("");
        assert isEmpty.or(isTrimmed).test("not empty");

        assert Predicate.isEqual("hello").test("hello");
    }

    @Test
    public void supplier() {
        Supplier<String> emptyString = null;

        assert "".equals(emptyString.get());
    }

    @Test
    public void consumer() {
        Consumer<String> print = null;
        Consumer<String> hello = null;

        print.accept("something"); // something
        print.andThen(hello).accept("JF"); // JF Hello JF !
    }

    @Test
    public void comparator() {
        Comparator<Integer> ascending = null;

        assert ascending.compare(10, 1) > 0;
        assert ascending.reversed().compare(10, 1) < 0;
    }

    @Test
    public void method_reference() {
        Function<Integer, String> toString = n -> String.valueOf(n);

        assert "4".equals(toString.apply(4));
    }


}
