package stream.api;

import common.test.tool.annotation.Easy;
import common.test.tool.dataset.ClassicOnlineStore;
import common.test.tool.entity.Customer;
import common.test.tool.entity.Item;
import common.test.tool.entity.Shop;

import org.junit.Test;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise7Test extends ClassicOnlineStore {

    @Easy @Test
    public void averageAge() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create {@link IntStream} with customer ages by using {@link Stream#mapToInt}
         * Then calculate the average of ages by using {@link IntStream#average}
         */
        ToIntFunction<Customer> ageFunction = c->c.getAge();
        IntStream ageStream = customerList.stream().mapToInt(ageFunction);
        OptionalDouble average = ageStream.average();

        assertThat(average.getAsDouble(), is(28.7));
    }

    @Easy @Test
    public void howMuchToBuyAllItems() {
        List<Shop> shopList = this.mall.getShopList();

        /**
         * Create {@link LongStream} with all items' prices using {@link Stream#mapToLong}
         * Then calculate the sum of prices using {@link LongStream#sum}
         */
        ToIntFunction<Item> itemPriceFunction = item -> item.getPrice();
        ToLongFunction<Shop> itemsPriceFunction = shop -> shop.getItemList().stream().mapToInt(itemPriceFunction).sum();
        LongStream priceStream = shopList.stream().mapToLong(itemsPriceFunction);
        long priceSum = priceStream.sum();

        assertThat(priceSum, is(60930L));
    }
}
