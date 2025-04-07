# Система управления для промышленного предприятия

Данное приложение представляет собой сервер для управления задачами и данными сотрудников на промышленном предприятии. Система позволяет управлять задачами, сотрудниками, отделами и филиалами предприятия с различными уровнями доступа для пользователей.

## Описание

### Центральные сущности:

- **Сотрудник** — представляет собой работников предприятия.
- **Отдел** — содержит информацию о подразделениях предприятия.
- **Филиал** — включает данные о филиалах предприятия.
- **Задача** — задачи, которые выполняются сотрудниками на предприятии.

### Функционал для пользователей:

#### Администратор:
- Создавать, удалять и редактировать объекты (сотрудники, отделы, филиалы, задачи).
- Осуществлять поиск по имени (названию) объектов.
- Отслеживать список всех пользователей.

#### Зарегистрированный пользователь:
- Создавать задачи для исполнения.

#### Гость:
- Просматривать информацию о предприятиях и департаментах.
- Регистрация для дальнейшей работы.

### Структура базы данных:

#### Таблица **Сотрудник**:
- **id** — Уникальный идентификатор.
- **ФИО** — Полное имя сотрудника.
- **Адрес** — Адрес сотрудника.
- **Должность** — Должность сотрудника.
- **Дата рождения** — Дата рождения сотрудника.
- **Отдел** — Отдел, в котором работает сотрудник.

#### Таблица **Отдел**:
- **id** — Уникальный идентификатор.
- **Название** — Название отдела.
- **Количество сотрудников** — Количество сотрудников в отделе.
- **Номера комнат** — Номера рабочих комнат.
- **Начальник отдела** — Сотрудник, являющийся начальником отдела.

#### Таблица **Организация**:
- **id** — Уникальный идентификатор.
- **Название** — Название организации.
- **Описание** — Описание организации.
- **Адрес** — Адрес организации.
- **Начальник организации** — Руководитель организации.

#### Таблица **Задача**:
- **id** — Уникальный идентификатор.
- **Название** — Название задачи.
- **Описание** — Описание задачи.
- **Стоимость** — Стоимость задачи.
- **Статус выполнения** — Текущий статус выполнения задачи.

### Таблицы пользователей:
Для хранения пользователей используются две таблицы:
1. Первая таблица хранит **id**, **имя**, **пароль**, **статус активности**.
2. Вторая таблица (вспомогательная) хранит **роли пользователя** для доступа к данным.

### Шаблонизатор:
В качестве шаблонизатора используется **Mustache**.

## Структура каталогов:

- **config** — конфигурационные файлы, необходимые для настройки системы безопасности и других параметров приложения.
- **controller** — набор контроллеров, которые взаимодействуют с пользователем для получения данных из базы данных.
- **domain** — сущности, обеспечивающие взаимодействие с таблицами базы данных и описывающие отношения между ними.
- **repository** — интерфейсы для работы с сущностями в базе данных с использованием JPA.
- **application** — сервисы, предоставляющие функционал для выполнения запросов пользователя через контроллеры.

## Установка и запуск

1. Клонируйте репозиторий:
   ```bash
   git clone <URL>

## Скриншоты работы программы
### Страница доступная любому пользователю (GUEST):

 ![image](https://github.com/user-attachments/assets/aee6dd8a-0dee-4495-b73f-37a4b0879bc6)

### После попытки попасть на страницу пользователя или администратора предлагается осуществить вход или зарегистрироваться: 

 ![image](https://github.com/user-attachments/assets/2c7734ef-a660-4ea6-801d-4477875f4701)

### Если зайти под именем администратора, то вам будут доступны все функции приложения.
 
![image](https://github.com/user-attachments/assets/09e85f36-62e2-4204-a7b1-9c4d66a77ad8)
![image](https://github.com/user-attachments/assets/1dcd4173-c9ed-4407-ac1f-b8064c3131b6)
![image](https://github.com/user-attachments/assets/e17aeabb-bc2f-4df4-b492-1a52eea2e876)

### При входе в качестве пользователя предоставляется только возможность добавления задачи

![image](https://github.com/user-attachments/assets/e5b3426a-5389-42d0-9b96-a7b4a1a67c52)

