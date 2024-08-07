insert into tasks(author_id, performer_id, name_task, description, status, priority, created_date, updated_date)
values
    (1, 2, 'Задача по дизайну', 'Создать макет для нового проекта', 'НОВЫЙ', 'ВЫСОКИЙ', current_timestamp, current_timestamp),
    (1, 1, 'Тестирование функционала', 'Провести тестирование нового функционала', 'В ПРОГРЕССЕ', 'НИЗКИЙ', current_timestamp, current_timestamp),
    (2, 1, 'Обновление документации', 'Обновить документацию по API', 'НОВЫЙ', 'НИЗКИЙ', current_timestamp, current_timestamp),
    (3, 2, 'Разработка нового модуля', 'Создание нового модуля для системы', 'НОВЫЙ', 'СРЕДНИЙ', current_timestamp, current_timestamp),
    (1, 2, 'Оптимизация базы данных', 'Оптимизировать запросы к базе данных', 'В ПРОГРЕССЕ', 'СРЕДНИЙ', current_timestamp, current_timestamp),
    (2, 1, 'Исследование технологий', 'Изучить новые технологии для проекта', 'СДЕЛАНА', 'ВЫСОКИЙ', current_timestamp, current_timestamp),
    (3, 1, 'Внедрение CI/CD', 'Настроить CI/CD для проекта', 'СДЕЛАНА', 'ВЫСОКИЙ', current_timestamp, current_timestamp),
    (2, 3, 'Подготовка презентации', 'Создать презентацию для клиента', 'НОВЫЙ', 'СРЕДНИЙ', current_timestamp, current_timestamp),
    (1, 2, 'Ревизия кода', 'Провести ревизию кода на проекте', 'В ПРОГРЕССЕ', 'СРЕДНИЙ', current_timestamp, current_timestamp),
    (2, 1, 'Обсуждение требований', 'Обсудить требования к новому функционалу', 'СДЕЛАНА', 'НИЗКИЙ', current_timestamp, current_timestamp);


insert into comments(author_id, description, created_date, task_id)
values
(1, 'Нужно уточнить детали с клиентом.', current_timestamp, 1),
(2, 'Я начну работать над макетом.', current_timestamp, 1),

(1, 'Тесты пройдены, есть небольшие замечания.', current_timestamp, 2),
(2, 'Давай обсудим замечания на встрече.', current_timestamp, 2),

(1, 'Документация устарела, нужны новые данные.', current_timestamp, 3),
(2, 'Я займусь обновлением в ближайшее время.', current_timestamp, 3),

(3, 'Начинаю работать над архитектурой модуля.', current_timestamp, 4),
(1, 'Необходимы требования от клиента.', current_timestamp, 4),

(1, 'Нужно проверить все индексы.', current_timestamp, 5),
(2, 'Оптимизация завершена, производительность улучшена.', current_timestamp, 5),

(1, 'Нашел интересную статью о новых фреймворках.', current_timestamp, 6),
(2, 'Необходимо сделать отчет по изученным технологиям.', current_timestamp, 6),

(1, 'Настройка CI/CD начата.', current_timestamp, 7),
(2, 'Проблемы с интеграцией, нужно разобраться.', current_timestamp, 7),

(2, 'Нужно включить результаты исследований в презентацию.', current_timestamp, 8),
(1, 'Убедитесь, что все данные актуальны.', current_timestamp, 8),

(1, 'Код требует улучшений.', current_timestamp, 9),
(2, 'Работаю над исправлениями.', current_timestamp, 9),

(1, 'Обсудили основные моменты.', current_timestamp, 10),
(2, 'Нужно подготовить список вопросов.', current_timestamp, 10);
