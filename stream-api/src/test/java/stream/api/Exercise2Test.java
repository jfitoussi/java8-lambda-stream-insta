package stream.api;

import common.test.tool.annotation.Easy;
import common.test.tool.dataset.ClassicOnlineStore;
import common.test.tool.entity.Customer;
import common.test.tool.entity.Item;
import common.test.tool.util.AssertUtil;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

public class Exercise2Test extends ClassicOnlineStore {

	@Easy @Test
	public void sortByAge() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Create a stream with ascending ordered age values.
		 * Use {@link Stream#sorted} to sort them.
		 */
		Stream<Integer> sortedAgeStream = customerList.stream().map(c -> c.getAge()).sorted();

		List<Integer> sortedAgeList = sortedAgeStream.collect(Collectors.toList());
		assertThat(sortedAgeList, contains(21, 22, 22, 26, 27, 28, 32, 35, 36, 38));
	}

	@Easy @Test
	public void descSortByAge() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Create a stream with descending ordered age values.
		 */
		Comparator<Integer> descOrder = (Integer i1, Integer i2) -> i1.compareTo(i2);
		Stream<Integer> sortedAgeStream = customerList.stream().map(c -> c.getAge()).sorted(descOrder.reversed());

		assertTrue(AssertUtil.isLambda(descOrder));
		List<Integer> sortedAgeList = sortedAgeStream.collect(Collectors.toList());
		assertThat(sortedAgeList, contains(38, 36, 35, 32, 28, 27, 26, 22, 22, 21));
	}

	@Easy @Test
	public void top3RichCustomer() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Create a stream with top 3 rich customers using {@link Stream#limit} to limit the size of the stream
		 */
		Comparator<Customer> topOrder = (Customer c1, Customer c2) -> c1.getBudget().compareTo(c2.getBudget());
		Stream<String> top3RichCustomerStream = customerList.stream().map(c -> c).sorted(topOrder.reversed()).map(c -> c.getName()).limit(3);

		List<String> top3RichCustomerList = top3RichCustomerStream.collect(Collectors.toList());
		assertThat(top3RichCustomerList, contains("Diana", "Andrew", "Chris"));
	}

	@Easy @Test
	public void distinctAge() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Create a stream with distinct age values using {@link Stream#distinct}
		 */
		Stream<Integer> distinctAgeStream = customerList.stream().map(c -> c.getAge()).distinct();

		List<Integer> distinctAgeList = distinctAgeStream.collect(Collectors.toList());
		assertThat(distinctAgeList, contains(22, 27, 28, 38, 26, 32, 35, 21, 36));
	}

	@Easy @Test
	public void itemsCustomersWantToBuy() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Create a stream with items' names stored in {@link Customer.wantToBuy}
		 * Use {@link Stream#flatMap} to create a stream from each element of a stream.
		 */
		Function<Customer, Stream<Item>> getItemStream = customer -> customer.getWantToBuy().stream();
		Stream<String> itemStream = customerList.stream().flatMap(getItemStream).map(item -> item.getName());

		assertTrue(AssertUtil.isLambda(getItemStream));
		List<String> itemList = itemStream.collect(Collectors.toList());
		assertThat(itemList,
				contains("small table", "plate", "fork", "ice cream", "screwdriver", "cable", "earphone", "onion",
						"ice cream", "crisps", "chopsticks", "cable", "speaker", "headphone", "saw", "bond",
						"plane", "bag", "cold medicine", "chair", "desk", "pants", "coat", "cup", "plate", "fork",
						"spoon", "ointment", "poultice", "spinach", "ginseng", "onion"));
	}
}
