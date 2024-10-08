INSERT INTO tasks(author_id, performer_id, name_task, description, status, priority, created_date, updated_date, start_time, end_time, process)
VALUES
    (1, 2, 'Задача по дизайну', 'Создать макет для нового проекта', 'NEW', 'ВЫСОКИЙ', '2024-08-15 09:00:00', '2024-08-15 09:00:00', '09:00:00', '17:00:00', 50),
    (1, 1, 'Тестирование функционала', 'Провести тестирование нового функционала', 'IN PROGRESS', 'НИЗКИЙ', '2024-08-15 10:00:00', '2024-08-15 10:00:00', '10:00:00', '18:00:00', 100),
    (1, 1, 'Обновление документации', 'Обновить документацию по API', 'NEW', 'НИЗКИЙ', '2024-08-15 11:00:00', '2024-08-15 11:00:00', '11:00:00', '17:00:00', 40),
    (1, 2, 'Разработка нового модуля', 'Создание нового модуля для системы', 'NEW', 'СРЕДНИЙ', '2024-08-15 12:00:00', '2024-08-15 12:00:00', '12:00:00', '20:00:00', 60),
    (1, 2, 'Оптимизация базы данных', 'Оптимизировать запросы к базе данных', 'IN PROGRESS', 'СРЕДНИЙ', '2024-08-15 13:00:00', '2024-08-15 13:00:00', '13:00:00', '19:00:00', 70),
    (1, 1, 'Исследование технологий', 'Изучить новые технологии для проекта', 'DONE', 'ВЫСОКИЙ', '2024-08-15 14:00:00', '2024-08-15 14:00:00', '14:00:00', '18:00:00', 30),
    (1, 1, 'Внедрение CI/CD', 'Настроить CI/CD для проекта', 'DONE', 'ВЫСОКИЙ', '2024-08-15 15:00:00', '2024-08-15 15:00:00', '15:00:00', '22:00:00', 80),
    (1, 3, 'Подготовка презентации', 'Создать презентацию для клиента', 'NEW', 'СРЕДНИЙ', '2024-08-15 16:00:00', '2024-08-15 16:00:00', '16:00:00', '18:00:00', 90),
    (1, 2, 'Ревизия кода', 'Провести ревизию кода на проекте', 'IN PROGRESS', 'СРЕДНИЙ', '2024-08-15 17:00:00', '2024-08-15 17:00:00', '17:00:00', '20:00:00', 10),
    (1, 1, 'Обсуждение требований', 'Обсудить требования к новому функционалу', 'DONE', 'НИЗКИЙ', '2024-08-15 18:00:00', '2024-08-15 18:00:00', '18:00:00', '21:00:00',20);



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
