insert into users(id, email, first_name, last_name, password, username) values(1, 'example1@email.com', 'John', 'Doe', 'password', 'johnDoe1');

insert into recipes(id, name, photo_url, weblink, user_id) values(2, 'Banana Cake', 'photoUrl', 'www.otherRecipe.com', 1);

insert into recipe_ingredients(recipe_id, ingredients) values(2, '4 bananas');
insert into recipe_ingredients(recipe_id, ingredients) values(2, '100 gr flour');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(2, 'mix the flour');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(2, 'do something');