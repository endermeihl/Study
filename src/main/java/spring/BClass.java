package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BClass {

    @Autowired
    private  AClass aClass;

//    public BClass(AClass aClass) {
//        this.aClass = aClass;
//    }

    public void test() {
        System.out.println("this is BClass test");
        aClass.test();
    }
}
