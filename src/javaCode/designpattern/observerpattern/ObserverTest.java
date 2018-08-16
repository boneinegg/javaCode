package javaCode.designpattern.observerpattern;

import java.util.ArrayList;

class VideoSite implements Subject {
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


public class ObserverTest {
    public static void main(String[] args) {
        VideoSite videoSite = new VideoSite();
        videoSite.registerObserver(new Observer("liping"));
        videoSite.registerObserver(new Observer("liupeng"));
        videoSite.registerObserver(new Observer("wangqing"));
        videoSite.addVideo("Game of Power.");

    }
}
