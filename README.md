# TaskWizard - todo web app
<img src="https://github.com/mustGamedev/taskwizard/blob/master/screenshots/MainPageImage.png" width="480" height="270" />

<details open>
<summary>Описание 📔</summary>

# Описание проекта

Этот проект представляет собой простое приложение для управления задачами, созданное с использованием языка
программирования Java и фреймворка Spring.

## Особенности

- Возможность добавлять новые задачи
- Возможность удалять задачи
- Возможность обновлять статус задачи

## Описание методов

| Метод  | Путь         | Описание                                      | Параметры                                                                                           |
|--------|--------------|-----------------------------------------------|-----------------------------------------------------------------------------------------------------|
| `GET`  | /            | Возвращает страницу со списком всех задач.    | Нет                                                                                                 |
| `POST` | /add         | Добавляет новую задачу.                       | task_description - описание задачи                                                                  |
| `POST` | /delete/{id} | Удаляет задачу по её идентификатору.          | id - идентификатор задачи                                                                           |
| `POST` | /update/{id} | Обновляет статус задачи по её идентификатору. | id - идентификатор задачи, completed - новый статус задачи (true - выполнено, false - не выполнено) |

**Примечание:** все методы возвращают страницу с информацией о статусе выполнения операции.

## Схема взаимодействия классов проекта:

| Слои приложения     | Компонент        | Описание                                                                                                                                     |
|---------------------|------------------|----------------------------------------------------------------------------------------------------------------------------------------------|
| **Внешний**         | `TaskController` | Принимает HTTP-запросы от пользователя и возвращает HTTP-ответы. Реализует бизнес-логику на уровне приложения и взаимодействует с сервисами. |
| **Внешний**         | `index.html`     | Отображает данные пользователю и получает ввод данных. Предоставляет интерфейс пользователя для взаимодействия с приложением.                |
| **Бизнес логика**   | `TaskService`    | Содержит бизнес-логику приложения. Обрабатывает запросы от контроллера, взаимодействует с репозиторием и возвращает результат обработки.     |
| **Хранение данных** | `TaskRepository` | Взаимодействует с базой данных и предоставляет методы для работы с данными.                                                                  |
| **Хранение данных** | `TaskEntity`     | Представляет собой отдельную сущность, которая будет храниться в базе данных в виде таблицы. Содержит атрибуты и методы работы с данными.    |

**Для работы с базой данных:** Dto не планируется использовать, так как в проекте не требуется конвертация данных между
слоями.

## Используемые технологии

- Java 11
- Spring
- Hibernate
- Thymeleaf
- HTML
- Bootstrap
- CSS
- JavaScript
- MySQL

## Как запустить? 🛠

Чтобы запустить проект, выполните следующие действия:<br>

1. [Скачайте](https://github.com/mustGamedev/taskwizard.git) проект из репозитория на GitHub.
2. Загрузите и установите [Java 11](https://www.java.com/en/download/).
3. Установите [Maven](https://maven.apache.org/download.cgi).
4. Установите [MySQL](https://dev.mysql.com/downloads/installer/).
5. Создайте базу данных с именем "taskmanager" и таблицу "task".
6. Откройте файл "application.properties" в папке "src/main/resources" и укажите настройки базы данных.
   <br> `spring.datasource.url` - путь к БД
   <br> `spring.datasource.username` - Имя пользователя
   <br> `spring.datasource.password` - Пароль
7. Откройте командную строку в папке с проектом.
8. Введите команду "mvn clean install".
9. Запустите проект командой "mvn spring-boot:run".

## Лицензия 📜
Этот проект доступен под лицензией MIT, дополнительную информацию вы можете найти в файле [LICENSE](https://github.com/mustGamedev/taskwizard/blob/master/LICENSE). 😊

</details>
<br>
<details open>
<summary>Description 📚</summary>

## Description

TaskWizard is a simple web app for managing your tasks created with Java programming language and Spring framework.

## Features

- Ability to add new tasks
- Ability to delete tasks
- Ability to update the status of a task

## API Methods

| Method | Path         | Description                                  | Parameters                                                                                 |
|--------|--------------|----------------------------------------------|--------------------------------------------------------------------------------------------|
| `GET`  | /            | Returns the page with the list of all tasks. | None                                                                                       |
| `POST` | /add         | Adds a new task.                             | task_description - description of the task                                                 |
| `POST` | /delete/{id} | Deletes the task by its ID.                  | id - task ID                                                                               |
| `POST` | /update/{id} | Updates the status of the task by its ID.    | id - task ID, completed - new status of the task (true - completed, false - not completed) |

**Note:** all methods return a page with information about the status of the operation.

## Scheme of interaction of project classes:

| Application Layers | Component        | Description                                                                                                                                          |
|--------------------|------------------|------------------------------------------------------------------------------------------------------------------------------------------------------|
| **External**       | `TaskController` | Receives HTTP requests from the user and returns HTTP responses. Implements application-level business logic and interacts with services.            |
| **External**       | `index.html`     | Displays data to the user and receives user input. Provides a user interface for interacting with the application.                                   |
| **Business Logic** | `TaskService`    | Contains the application's business logic. Processes requests from the controller, interacts with the repository, and returns the processing result. |
| **Data Storage**   | `TaskRepository` | Interacts with the database and provides methods for working with data.                                                                              |
| **Data Storage**   | `TaskEntity`     | Represents a separate entity that will be stored in the database as a table. Contains attributes and methods for working with data.                  |

**To work with the database:** Dto is not planned to be used, since the project does not require data conversion between
layers.

## Technologies Used

- Java 11
- Spring
- Hibernate
- Thymeleaf
- HTML
- Bootstrap
- CSS
- JavaScript
- MySQL

## How to run? 🛠

To run the project, follow these steps:

1. [Download](https://github.com/mustGamedev/taskwizard.git) the project from GitHub repository.
2. Download and install [Java 11](https://www.java.com/en/download/).
3. Install [Maven](https://maven.apache.org/download.cgi).
4. Install [MySQL](https://dev.mysql.com/downloads/installer/).
5. Create a database with the name "taskmanager" and table "task".
6. Open the "application.properties" file in the "src/main/resources" folder and specify the database settings.
   <br> `spring.datasource.url` - path to the database
   <br> `spring.datasource.username` - username
   <br> `spring.datasource.password` - password
7. Open the command prompt in the project folder.
8. Enter the command "mvn clean install".
9. Run the project with the command "mvn spring-boot:run".

## License 📜
This project is available under the MIT license. For more information, refer to the [LICENSE](https://github.com/mustGamedev/taskwizard/blob/master/LICENSE) file. 😊
</details>
