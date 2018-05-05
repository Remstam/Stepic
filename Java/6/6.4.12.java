public static <T> void findMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer) {

    Collection<? extends T> coll = stream.collect(Collectors.toList());
    Optional<? extends T> minOpt = coll.stream().min(order);
    Optional<? extends T> maxOpt = coll.stream().max(order);
    
    T min = null;
    T max = null;
    if (minOpt.isPresent() && maxOpt.isPresent()) {
        min = minOpt.get();
        max = maxOpt.get();
    }
    
    minMaxConsumer.accept(min, max);
}
