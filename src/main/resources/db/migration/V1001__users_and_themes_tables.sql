CREATE TABLE users (
                       id serial primary key  NOT NULL,
                       name varchar(128) NOT NULL,
                       password varchar(128) NOT NULL,
                       enabled boolean NOT NULL default true,
                       role varchar(128),
                       UNIQUE (name)
);

CREATE TABLE themes (
                        id serial primary key NOT NULL,
                        title    varchar(128) NOT NULL,
                        created date,
                        description varchar NOT NULL,
                        count int,
                        user_id int not null,
                        CONSTRAINT fk_theme_user FOREIGN KEY (user_id) REFERENCES users (id)
);