package javaCode.designpattern.observerpattern;

public interface Subject {
    void registerObserver(Observer observer);
    void removerObserver(Observer observer);
    void notifyAllObservers();
}
