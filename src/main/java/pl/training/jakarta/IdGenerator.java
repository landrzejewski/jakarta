package pl.training.jakarta;

import javax.ejb.Remote;

@Remote
public interface IdGenerator {

    String getNext();

}
