package Oops.thisKeyword.AbstractClasses;

// Template Method pattern with 'this'
abstract class DataProcessor {
    // Template method
    final void process() {
        fetch();
        transform();
        save();
    }

    abstract void fetch();
    abstract void transform();

    void save() {
        System.out.println("Saving data for: " + this.getClass().getSimpleName());
    }
}

class CSVProcessor extends DataProcessor {
    @Override
    void fetch() {
        System.out.println("Fetching CSV data");
    }
    @Override
    void transform() {
        System.out.println("Transforming CSV data");
    }
}

public class ThisInTemplateMethod {
    public static void main(String[] args) {
        DataProcessor dp = new CSVProcessor();
        dp.process();
    }
}