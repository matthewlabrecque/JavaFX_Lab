package com.example.lab14_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class HelloController {
    @FXML
    private Label song;
    @FXML
    private CheckBox cbMakeDifficult;

    private String[] EasySongsArray = new String[]{};
    private String[] HardSongsArray = new String[]{};

    // global variable to hold previously set value
    // this is to prevent the code from outputting the same index value twice so it's always a different number
    private int oldVal = 0;

    @FXML
    public void initialize() {
        // Read from the source files into ArrayLists and convert to conventional arrays
        try {
            List<String> EasySongs;
            List<String> HardSongs;
            EasySongs = Files.readAllLines(Paths.get("EasySongs.txt"));
            HardSongs = Files.readAllLines(Paths.get("HardSongs.txt"));
            EasySongsArray = EasySongs.toArray(new String[0]);
            HardSongsArray = HardSongs.toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // When user clicks the button, generate a random response
    @FXML
    protected void onSongGenerate() {
        Random rand = new Random();
        int value;
        if (cbMakeDifficult.isSelected()) {
            // check if the values are the same and if they are it generates a new value
            do {
                value = rand.nextInt(HardSongsArray.length);
            } while (value == oldVal);
            song.setText("You should learn \"" + HardSongsArray[value] + "\"!");
        } else {
            // check if the values are the same and if they are it generates a new value
            do {
                value = rand.nextInt(EasySongsArray.length);
            } while (value == oldVal);
            song.setText("You should learn \"" + EasySongsArray[value] + "\"!");
        }
        // set oldValue equal to value
        oldVal = value;
    }
}