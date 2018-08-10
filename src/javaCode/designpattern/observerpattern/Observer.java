package javaCode.designpattern.observerpattern;

class Observer {
    private String name;
    Observer(String name) {
        this.name = name;
    }

    void update(Subject subject) {
        System.out.println(name + ", new videos!");
        System.out.println(subject);
    }
}
