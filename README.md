# Слайд-шоу для просмотра изображений 
----------------
**Описание**: В ходе данной работы была разработана программа для просмотра изображений, в ней предусморен режим слайд-шоу.
- Технологический стек: Java
- Статус: 1.7.2.
- По сравнению с другими подобными продуктами, данная разработка отличается понятным кодом и удобным интерфейсом.
**Скриншот рабочего окна приложения:**
----------------------------------------
 ![image](https://github.com/StephanKomov/Lab2Iter/blob/master/3.jpg)
 
![image](https://github.com/StephanKomov/Lab2Iter/blob/master/4.jpg)


 **Разбор части кода на примере класса HelloController**
```
package com.example.lab2iter;

import Iter.ConcreteAggregate;
import Iter.Iterator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Label labelError;
    @FXML
    private ImageView imgView;

    private Button btnClickStop;

    @FXML
    private TextField speedTextField;

    public ConcreteAggregate imgBuild = new ConcreteAggregate("");
    public Iterator imgIter = imgBuild.getIterator();
    Timeline timeline = new Timeline();



    public void btnClickBack() {
        imgView.setImage(imgIter.preview());
    }

    public void btnClickNext() {
        imgView.setImage(imgIter.next());
    }

    @FXML
    private void btnClickSlideShow() {
        String speedText = speedTextField.getText();

        if (speedText.isEmpty()) {
            labelError.setText("Введите скорость для слайд-шоу");
        } else {
            try {
                int time = Integer.parseInt(speedText);

                labelError.setText("");
                timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(time), event -> {
                    imgView.setImage(imgIter.next());
                }));
                timeline.play();
            } catch (NumberFormatException e) {
                labelError.setText("Введите числовое значение для скорости слайд-шоу");
            }
        }
    }

    @FXML
    private void btnClickStop() {
        timeline.stop();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imgView.setImage(new Image("/1.jpg"));
    }

}
```
------------------------

## Архитектура
Диаграмма классов:

 ![image](https://github.com/StephanKomov/Lab2Iter/blob/master/5.jpg)


## Завсимости
Для работы данного приложежния необходимы JavaFX и JDK 20.

## Установка
Не требуется. Достаточно запустить проект через любую доступную среду разработки JAVA.

##  Конфигурация
Не требуется


## Применение
В приложении можно просматривать картинки, путём переключения их между собой на кнопки "<" и ">".
Так же в программе предусмотрено переключение слайдов автоматически.
Для работы слайд-шоу требуется указать скорость переключения файлов в сек.
Так же можно остановить слайд-шоу кнопкой "стоп"



## Проверка ПО
Не предусмотрена

## Проблемы
Проблемы не обноружены 

## Получение справочной информации
По всем вопрсам можно обратиться в [ВК](https://vk.com/id484742584) разработчика  

## Приглашение к сотрудничеству 
В дальнейшем предполагается доработка кода, чтобы можно было добавлять картинки

## Источники и справочники
- [Что слайд-шоу?](https://www.justmedia.ru/news/russiaandworld/chto-takoye-slaydshou-zachem-ikh-sozdavat-i-kak-na-nikh-zarabatyvat)
- [Что такое Итератор?](https://sites.google.com/view/study-pattern/%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F/%D0%B7%D0%B0%D0%B4%D0%B0%D1%87%D0%B8/task-4-%D0%B8%D1%82%D0%B5%D1%80%D0%B0%D1%82%D0%BE%D1%80)
