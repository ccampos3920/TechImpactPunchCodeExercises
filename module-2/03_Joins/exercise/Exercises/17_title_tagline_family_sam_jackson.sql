-- 17. The titles and taglines of movies that are in the "Family" genre and Samuel L. Jackson has acted in (4 rows)
SELECT movie.title, movie.tagline FROM movie
JOIN movie_genre ON movie_genre.movie_id = movie.movie_id
JOIN genre on movie_genre.genre_id = genre.genre_id
JOIN movie_actor on movie_actor.movie_id = movie.movie_id
JOIN person ON person.person_id = movie_actor.actor_id

WHERE person_name = 'Samuel L. Jackson' AND genre_name = 'Family'