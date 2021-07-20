package spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AClass {

    @Autowired
    private BClass bClass;

//    public AClass(BClass bClass) {
//        this.bClass = bClass;
//    }

    public void test() {
        System.out.println("this is AClass test");
        bClass.test();
    }
}
