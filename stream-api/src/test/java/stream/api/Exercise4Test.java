package stream.api;

import common.test.tool.annotation.Easy;
import common.test.tool.dataset.ClassicOnlineStore;
import common.test.tool.entity.Customer;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise4Test extends ClassicOnlineStore {

    @Easy @Test
    public void firstRegistrant() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Find the first customer who registered this online store by using {@link Stream#findFirst}
         * The customerList are ascending ordered by registered timing.
         */
       
        
        Optional<Customer> firstCustomer = customerList.stream().findFirst();

        assertThat(firstCustomer.get(), is(customerList.get(0)));
    }

    @Easy @Test
    public void isThereAnyoneOlderThan40() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Check whether any customer older than 40 exists or not, by using {@link Stream#anyMatch}
         */
        
        
        boolean olderThan40Exists = false;
        
        Predicate<Customer> olderThan40ExistsCondition = customer -> customer.getAge() > 40;

        boolean olderThan40ExistsStream = customerList.stream().anyMatch(olderThan40ExistsCondition);
        		
        assertThat(olderThan40Exists, is(false));
    }

    @Easy @Test
    public void isEverybodyOlderThan20() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Check whether all customer are older than 20 or not, by using {@link Stream#allMatch}
         */
        boolean allOlderThan20 = true;
        
        Predicate<Customer> allOlderThan20Condition = customer -> customer.getAge() > 20;

        boolean allOlderThan20ExistsStream = customerList.stream().allMatch(allOlderThan20Condition);
        
        assertThat(allOlderThan20, is(true));
    }

    @Easy @Test
    public void everyoneWantsSomething() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Confirm that none of the customer has empty list for their {@link Customer.wantToBuy}
         * by using {@link Stream#noneMatch}
         */
        boolean everyoneWantsSomething = true;
        
        Predicate<Customer> everyoneWantsSomethingCondition = customer -> customer.getWantToBuy() != null;
        
        boolean everyoneWantsSomethingStream = customerList.stream().noneMatch(everyoneWantsSomethingCondition);

        assertThat(everyoneWantsSomething, is(true));
    }
}
