-- 3. Did you know Eric Stoltz was originally cast as Marty McFly in "Back to the Future"?
--Add Eric Stoltz to the list of actors for "Back to the Future" (1 row) 105 movie 3984917
INSERT INTO person(person_name, person_id)
VALUES('Eric Stoltz', 3984917);

INSERT INTO movie_actor(movie_id, actor_id)
VALUES (105, 3984917);

SELECT * FROM movie_actor
WHERE movie_id = 105