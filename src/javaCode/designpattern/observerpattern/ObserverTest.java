package javaCode.designpattern.observerpattern;

public class ObserverTest {
    public static void main(String[] args) {
        VideoSite videoSite = new VideoSite();
        videoSite.registerObserver(new Observer("liping"));
        videoSite.registerObserver(new Observer("liupeng"));
        videoSite.registerObserver(new Observer("wangqing"));
        videoSite.addVideo("Game of Power.");

    }
}
