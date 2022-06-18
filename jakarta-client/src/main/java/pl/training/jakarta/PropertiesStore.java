package pl.training.jakarta;

public interface PropertiesStore {

    void put(String key, String value);

    String get(String key);

    void close();

}
