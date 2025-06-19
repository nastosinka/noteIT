package org.example;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class SoundTimer {
    public static void main(String[] args) {
        long interval = 10 * 60 * 1000; // 10 минут

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("10 минут прошло!");
                System.out.println(LocalTime.now());
                playSound("/Users/nastosinka/Desktop/summer-schools/demo/untitled/ding.wav");
            }
        }, 0, interval);
    }

    private static void playSound(String fileName) {
        try {
            File soundFile = new File(fileName);
            if (!soundFile.exists()) {
                System.err.println("Файл не найден: " + fileName);
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();

            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
