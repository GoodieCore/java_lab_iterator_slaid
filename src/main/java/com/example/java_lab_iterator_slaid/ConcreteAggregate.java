package com.example.java_lab_iterator_slaid;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class ConcreteAggregate implements Aggregate{
    private String filetopic;
    public ConcreteAggregate(String filetopic) {
        this.filetopic = filetopic;
    }
    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }
    public class ImageIterator implements Iterator {
        private int count = 0;

        private Image getImage(int iterator) {
            String filename = Paths.get("src/main/resources/" + filetopic + iterator + ".jpg").toUri().toString();
            return new Image(filename);
        }
        @Override
        public boolean hasNext() {
            return !getImage(count + 1).isError();
        }

        @Override
        public boolean hasPrev() {
            return !getImage(count - 1).isError();
        }

        @Override
        public Image next() {
            if(hasNext()) return getImage(++count);
            else{
                count = 1;
                return getImage(count);
            }
        }

        @Override
        public Image prev() {
            if(hasPrev()) return getImage(--count);
            else{
                count = 4;
                return getImage(count);
            }
        }
    }
}
