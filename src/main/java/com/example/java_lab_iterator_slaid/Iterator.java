package com.example.java_lab_iterator_slaid;

import javafx.scene.image.Image;

public interface Iterator {
    public boolean hasNext();
    public boolean hasPrev();
    public Image next();
    public Image prev();
}
