package base.instance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo<T extends A> {
    public static void main(String[] args) throws Exception {
        Demo<B> a = new Demo<>();
        A b1 = a.getAorB(B.class);
        log.debug(String.valueOf(b1.hashCode()));

    }

    public T getAorB(Class<? extends T> clazz) throws Exception {
        return clazz.getDeclaredConstructor().newInstance();
    }
}
