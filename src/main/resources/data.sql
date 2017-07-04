insert into users(id, email, first_name, last_name, password, username) values(1, 'example@email.com', 'John', 'Doe', 'password', 'johnDoe1');

insert into ingredients(id, name) values(3, 'flour');

insert into recipes(id, name, photo_url, weblink, user_id) values(2, 'Banana Cake', 'photoUrl', 'www.otherRecipe.com', 1);

insert into ingredient_recipe(ingredient_id, recipe_id) values(3, 2);

insert into recipe_methods(recipe_id, methods) values(2, 'mix the flour');
insert into recipe_methods(recipe_id, methods) values(2, 'do something');

