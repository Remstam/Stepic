public static <T, U> Function<T, U> ternaryOperator(
        Predicate<? super T> condition,
        Function<? super T, ? extends U> ifTrue,
        Function<? super T, ? extends U> ifFalse) {

    return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);

}
