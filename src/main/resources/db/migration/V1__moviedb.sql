create table actor (
    id bigint not null auto_increment,
    biography varchar(255),
    country varchar(255),
    name varchar(255),
    year_of_birth integer not null,
    primary key (id)) engine=InnoDB;

create table director (
    id bigint not null auto_increment,
    biography varchar(255),
    country varchar(255),
    name varchar(255),
    year_of_birth integer not null,
    movie_id bigint,
    primary key (id)) engine=InnoDB;

create table movie (
    id bigint not null auto_increment,
    country varchar(255),
    description varchar(255),
    length integer not null,
    rate double precision not null,
    reldate date,
    title varchar(255),
    primary key (id)) engine=InnoDB;

create table movie_actors (
    movies_id bigint not null,
    actors_id bigint not null) engine=InnoDB;

create table movie_genres (
    movie_id bigint not null,
    genres varchar(255)) engine=InnoDB;

create table movie_rates (
    movie_id bigint not null,
    rates integer) engine=InnoDB;

insert into actor (biography, country, name, year_of_birth)
values ('bio', 'USA', 'Leonardo DiCaprio', 1974);
insert into director (biography, country, movie_id, name, year_of_birth)
values ('bio', 'Canada', 1, 'James Cameron', 1954);
insert into movie (country, description, length, rate, reldate, title)
values ('USA', 'description', 180, 3, '1997-08-02', 'Titanic');
insert into movie_actors (movies_id, actors_id)
values (1, 1);
insert into movie_genres (movie_id, genres)
values (1, 'ACTION');
insert into movie_rates (movie_id, rates)
values (1, 3);