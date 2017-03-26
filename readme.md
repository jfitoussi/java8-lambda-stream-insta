# Java8 Lambda - Stream INSTA

Get Started with lambda and stream. New astonishing features of Java 8. It's inspired by java 8 kata.

## Usage
* Run the tests

You can run tests from your IDE or command line if you like. If you are using an IDE, right click on the test method and click `Run foobar()`. If you prefer command line, follow below.

```
$ pwd
/path/to/java8-code-kata

$ ./mvnw install -Dmaven.test.skip=true

$ ./mvnw test -Dtest=Exercise1Test#findRichCustomers -pl stream-api
```

* Edit unit tests.

To successfully pass the tests, you'll need to edit the test itself. You can see where you need to edit.

```java
@Easy @Test
public void simpleAddition() {
    /**
     * Get an addition result of 1 and 2 by using an operator "+".
     */
    Integer added = null;

    assertThat(added, is(3));
}
```

Here is a sample answer.

```java
@Easy @Test
public void simpleAddition() {
    /**
     * Get an addition result of 1 and 2 by using an operator "+".
     */
    Integer added = 1 + 2;

    assertThat(added, is(3));
}
```

Most tests are annotated with `@Easy` which means those tests only requires basic knowledge.

Tests annotated with `@Difficult` are more difficult. :grin:

## Modules

### Playground

Use in conference session only

### stream-api

+ Exercise1Test.java

`Stream#filter` and `Stream#map`

+ Exercise2Test.java

`Stream#sorted`, `Stream#distinct`, `Stream#limit` and `Stream#flatMap`

+ Exercise3Test.java

`Stream#count`, `Stream#max` and `Stream#min`

+ Exercise4Test.java

`Stream#findFirst`, `Stream#allMatch`, `Stream#anyMatch` and `Stream#noneMatch`

+ Exercise5Test.java

`Stream#collect` and `Collectors`

+ Exercise6Test.java

`Stream#of` and `Stream#iterate`

+ Exercise7Test.java

`IntStream`, `LongStream` and `DoubleStream`

+ Exercise8Test.java

Advanced problems

+ Exercise9Test.java

`Collector`

### collection-interfaces

+ Exercise1Test.java

`Iterable#forEach`, `Collection#removeIf`, `List#replaceAll`, `List#sort`, `Collection#stream` and `Collection#parallelStream`

+ Exercise2Test.java

`Map#getOrDefault`, `Map#putIfAbsent`, `Map#merge` and `Map#computeIfPresent`