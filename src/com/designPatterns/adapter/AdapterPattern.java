package com.designPatterns.adapter;

/**
 * 适配器模式
 *
 * @author dingfubing
 * @since 2020/9/15 16:18
 */
public class AdapterPattern {

}
// 老式媒体播放器
interface MediaPlayer {
    void play(String auditType, String fileName);
}
// 新式媒体播放器，支持MP4
interface AdvanceMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
class MediaAdapter implements MediaPlayer {

    @Override
    public void play(String auditType, String fileName) {
        System.out.println("");
    }
}

class VlcPlayer implements AdvanceMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("play Vle , file name :" + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // 啥也不做
    }
}
class Mp4Player implements AdvanceMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        // 啥也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("play Mp4 , file name :" + fileName);
    }
}