create table answers
(
    id  serial primary key NOT Null ,
    description varchar ,
    created date,
    theme_id int not null,
    CONSTRAINT fk_answers_theme FOREIGN KEY (theme_id) REFERENCES themes(id),
    user_id int not null,
    CONSTRAINT fk_answers_user FOREIGN KEY (user_id) REFERENCES users(id)
);

insert into answers(description, created, theme_id, user_id)
values ('Наверное он http://kinozal.tv/details.php?id=65368', '2022-01-16',
        (select id from themes where title='Помогите найти фильм'),
        (select id from users where name ='User4')),
       ('Возможно, это фильм "Крик дельфина", другой информации выдать не смогу, очень давно это было.;-)',' 2022-01-29',
        (select id from themes where title='Помогите найти фильм'),
        (select id from users where name ='User1')),
       ('был такой древний мистический фильм "треугольник сатаны"...но мне в нормальном виде его найти так и не удалось','2022-01-27',
        (select id from themes where title='поиск фильмов в жанре МИСТИКА'),
        (select id from users where name ='User1')),
       ('таких фильмов - вагон и маленькая тележка))) один из последних, понравившихся мне "Исходный код" (2011 г). до этого был прикольный "Дежа вю" (2006 г)','2022-01-28',
        (select id from themes where title='поиск фильмов в жанре МИСТИКА'),
        (select id from users where name ='User3'));