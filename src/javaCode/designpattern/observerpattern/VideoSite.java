package javaCode.designpattern.observerpattern;

import java.util.ArrayList;

public class VideoSite implements Subject {
    private ArrayList<Observer> userList;
    private ArrayList<String> videos;

    public VideoSite() {
        userList = new ArrayList<>();
        videos = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        userList.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        userList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : userList) {
            observer.update(this);
        }
    }

    public void addVideo(String video) {
        videos.add(video);
        notifyAllObservers();
    }

    public ArrayList<String> getVideos() {
        return videos;
    }

    @Override
    public String toString() {
        return videos.toString();
    }
}
