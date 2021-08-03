create table movie (
    id bigint not null auto_increment,
    country varchar(255),
    description varchar(255),
    length integer not null,
    rate double precision not null,
    reldate date,
    title varchar(255),
    primary key (id)) engine=InnoDB;

create table movie_genres (
    movie_id bigint not null,
    genres varchar(255)) engine=InnoDB;

create table movie_rates (
    movie_id bigint not null,
    rates integer) engine=InnoDB;
