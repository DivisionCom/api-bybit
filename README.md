# API Bybit

Клиент-серверное Android-приложение, созданное с помощью современного стека технологий

## Описание

* При открытии приложения, пользователь видит список из десяти последних объявлений с Bybit
* В каждом объявлении отображается следующая информация: Заголовок, описание, тэги
* Пользователь может кликнуть на карточку объявления и приложение перенаправит его на сайт Bybit с информацией по соответствующему объявлению
* Если у пользователя отключен интернет, то, запустив приложение, пользователь увидит соответствующую ошибку и у него будет возможность, в случае возобновления интернет-потока, повторить попытку отображения данных, нажав на кнопку "Retry"

#### Отображение объявлений и открытие по нажатию в браузере
![bybit_main](https://github.com/DivisionCom/api-bybit/assets/107028454/9f470f4d-c0d6-42d1-9867-dfd47f67ce66)

#### Запуск приложения без подключения к интернету и последующая попытка отображения объявлений, возобновив интернет-поток
![bybit_error](https://github.com/DivisionCom/api-bybit/assets/107028454/9bb96b3c-1d1c-448e-bcb1-760f8237c5e5)

## Начинка

Мобильное приложение использующее <b>Android</b> платформу. Сделано с помощью:

* Kotlin
* Jetpack Compose
* Retrofit2 + OkHttp3
* Dagger-Hilt
* Coroutines
* MVVM
* KtLint

Bybit API: [ссылка](https://bybit-exchange.github.io/docs/v5/intro)

## Установка

* Скопируйте следующий код в Git Bash:
```
$ git clone https://github.com/DivisionCom/api-bybit.git
```
* Вы можете скачать <b>APK</b> файл [отсюда](https://www.dropbox.com/scl/fi/hjdkj2mh48vavytucim50/APIBybit.apk?rlkey=nwjknyrl2hypw6y1rh4kd5wdr&dl=0)

## Authors

Evgenii Fedin </br>
[@GitHub](https://github.com/DivisionCom) </br>
[@HeadHunter](https://spb.hh.ru/resume/80d9b2d3ff09d8ea370039ed1f6e463471544a) </br>
[@Telegram](https://t.me/DivisionCommander) </br>
[@LinkedIn](https://www.linkedin.com/in/evgenii-fedin/) </br>