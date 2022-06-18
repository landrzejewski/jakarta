package pl.training.jakarta;

import javax.ejb.Stateless;

@Stateless
public class FakeIdGenerator implements IdGenerator {

    @Override
    public String getNext() {
        return "00000000000001";
    }

}
