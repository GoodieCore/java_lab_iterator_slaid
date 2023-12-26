# Слайд-шоу для просмотра изображений 
----------------
**Описание**: В ходе данной работы была разработана программа для просмотра изображений, в ней предусморен режим слайд-шоу.
- Технологический стек: Java
- Статус: 1.7.2.
- По сравнению с другими подобными продуктами, данная разработка отличается понятным кодом и удобным интерфейсом.
**Скриншот рабочего окна приложения:**
----------------------------------------
 ![image](https://github.com/GoodieCore/java_lab_iterator_slaid/blob/master/Iterator_img_1.JPG)
 
![image](https://github.com/GoodieCore/java_lab_iterator_slaid/blob/master/Iterator_img_2.JPG)


 **Разбор части кода на примере класса HelloController**
```
package com.example.java_lab_iterator_slaid;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class IteratorController {
    public ImageView imgView;
    public TextField inputTime;
    Timeline time = new Timeline();
    public ConcreteAggregate concreteAggregate = new ConcreteAggregate("");
    public Iterator iterator = concreteAggregate.getIterator();
    @FXML
    public void onNextButtonClick(){
        imgView.setImage(iterator.next());
    }
    @FXML
    public void onPrevButtonClick(){
        imgView.setImage(iterator.prev());
    }
    @FXML
    public void onChouseButtonClick(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(imgView.getScene().getWindow());
        if (file != null) {
            String filename = file.getAbsolutePath();
            Image image = new Image("file:" + filename);
            imgView.setImage(image);
        }
    }

    @FXML
    public void onStartButtonClick(){
        int playtime= Integer.parseInt(inputTime.getText());

        time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(new KeyFrame(Duration.seconds(playtime), event -> {
            imgView.setImage(iterator.next());
        }));
        time.play();
    }
    public void onStopButtonClick(ActionEvent actionEvent) {
        time.stop();
        time.getKeyFrames().clear();
    }
}
```
------------------------

## Архитектура
Диаграмма классов:

 ![image](https://github.com/GoodieCore/java_lab_iterator_slaid/blob/master/Iterator_img_3.JPG)


## Зависимости
Для работы данного приложежния необходимы JavaFX и JDK 21.

## Установка
Не требуется. Достаточно запустить проект через любую доступную среду разработки JAVA.

##  Конфигурация
Не требуется


## Применение
В приложении можно просматривать картинки, путём переключения их между собой на кнопки "prev" и "next".
Также в программе предусмотрено переключение слайдов автоматически.
Для работы слайд-шоу требуется указать скорость переключения файлов в сек и нажатие кнопки "start".
Также можно остановить слайд-шоу кнопкой "stop"
Имеется возмозможность выбрать и добавить изображения из диска


## Проверка ПО
Не предусмотрена

## Проблемы
Проблемы не обноружены 

## Получение справочной информации
По всем вопрсам можно обратиться в [ВК](https://vk.com/iayiwer) разработчика  

## Приглашение к сотрудничеству 
В дальнейшем предполагается доработка кода, чтобы можно было добавлять картинки

## Источники и справочники
- [Что слайд-шоу?](https://www.business-gazeta.ru/article/361076)
- [Что такое Итератор?](https://sites.google.com/view/study-pattern/%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F/%D0%B7%D0%B0%D0%B4%D0%B0%D1%87%D0%B8/task-4-%D0%B8%D1%82%D0%B5%D1%80%D0%B0%D1%82%D0%BE%D1%80)
