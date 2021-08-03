create table actor (
    id            bigint  not null auto_increment,
    biography     varchar(255),
    country       varchar(255),
    name          varchar(255),
    year_of_birth integer not null,
    primary key (id)
) engine = InnoDB;

create table director (
    id            bigint  not null auto_increment,
    biography     varchar(255),
    country       varchar(255),
    name          varchar(255),
    year_of_birth integer not null,
    movie_id      bigint,
    primary key (id)
) engine = InnoDB;

create table movie_actors (
    movies_id bigint not null,
    actors_id bigint not null
) engine = InnoDB;
