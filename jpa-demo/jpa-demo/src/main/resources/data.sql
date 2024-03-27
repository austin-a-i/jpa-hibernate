insert into genre(id, genre)
values (4001, 'Pop');
insert into genre(id, genre)
values (4002, 'Indie');
insert into genre(id, genre)
values (4003, 'Rock');

insert into artist(id, name,genre_id,place_of_origin)
values (1001, 'Ed Sheeran', 4001, England);
insert into artist(id, name,genre_id,place_of_origin)
values (1002, 'Harry Styles', 4001, England);
insert into artist(id, name,genre_id,place_of_origin)
values (1003, 'Novo Amor', 4002, USA);
insert into artist(id, name,genre_id,place_of_origin)
values (1004, 'Lumineers', 4002, USA);

insert into audience(id, name, genre_id)
values (2001, 'Pop', 4001);
insert into audience(id, name, genre_id)
values (2002, 'Alternative/Indie', 4002);
insert into audience(id, name, genre_id)
values (2003, 'Folk Rock', 4003);


insert into song(id, rating, songname, artist_id)
values (5001, '4', 'Afterglow', 1001);
insert into song(id, rating, songname, artist_id)
values (5002, '5', 'Photograph', 1001);
insert into song(id, rating, songname, artist_id)
values (5003, '3', 'Golden', 1002);

insert into artist_audience(artist_id, audience_id)
values (1001,2001);
insert into artist_audience(artist_id, audience_id)
values (1001,2002);
insert into artist_audience(artist_id, audience_id)
values (1004,2002);
insert into artist_audience(artist_id, audience_id)
values (1004,2003);