insert into users(id, email, first_name, last_name, password, username) values(1, 'example1@email.com', 'John', 'Doe', 'password', 'johnDoe1');

insert into ingredients(id, name) values(3, 'flour');

insert into recipes(id, name, photo_url, weblink, user_id) values(2, 'Banana Cake', 'photoUrl', 'www.otherRecipe.com', null);

insert into recipes_ingredients(recipe_id, ingredients_id) values(2, 3);

insert into recipe_methods(recipe_id, methods) values(2, 'mix the flour');
insert into recipe_methods(recipe_id, methods) values(2, 'do something');
