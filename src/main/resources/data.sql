insert into users(id, email, first_name, last_name, password, username) values(1, 'example1@email.com', 'John', 'Doe', 'password', 'johnDoe1');
insert into users(id, email, first_name, last_name, password, username) values(2, 'example2@email.com', 'Jane', 'Doe', 'password', 'janeDoe1');
insert into users(id, email, first_name, last_name, password, username) values(3, 'example3@email.com', 'Mickey', 'Mouse', 'password', 'mickeyMouse');
insert into users(id, email, first_name, last_name, password, username) values(4, 'example4@email.com', 'Minnie', 'Mouse', 'password', 'minnieMouse');

insert into recipes(id, name, photo_url, weblink, user_id) values(1, 'Banana Cake', 'photoUrl1', 'www.otherRecipe1.com', 1);
insert into recipes(id, name, photo_url, weblink, user_id) values(2, 'Chocolate Cake', 'photoUrl2', 'www.otherRecipe2.com', 1);
insert into recipes(id, name, photo_url, weblink, user_id) values(3, 'Roasted Chicken', 'photoUrl3', 'www.otherRecipe3.com', 2);
insert into recipes(id, name, photo_url, weblink, user_id) values(4, 'Avocado Smoothie', 'photoUrl4', 'www.otherRecipe4.com', 3);

insert into recipe_ingredients(recipe_id, ingredients) values(1, '4 bananas');
insert into recipe_ingredients(recipe_id, ingredients) values(1, '100 gr flour');
insert into recipe_ingredients(recipe_id, ingredients) values(1, '2 eggs');
insert into recipe_ingredients(recipe_id, ingredients) values(1, '60 gr butter');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(1, 'mix the flour');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(1, 'smash bananas');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(1, 'crack eggs');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(1, 'melt butter in a pan');

insert into recipe_ingredients(recipe_id, ingredients) values(2, '180 gr flour');
insert into recipe_ingredients(recipe_id, ingredients) values(2, '80 gr choco powder');
insert into recipe_ingredients(recipe_id, ingredients) values(2, '60 gr butter');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(2, 'mix the flour');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(2, 'mix the choco powder');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(2, 'find eggs');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(2, 'melt butter in a pan');

insert into recipe_ingredients(recipe_id, ingredients) values(3, '1 whole chicken');
insert into recipe_ingredients(recipe_id, ingredients) values(3, 'rosemary');
insert into recipe_ingredients(recipe_id, ingredients) values(3, '1 lemon');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(3, 'stuff rosemary into chicken');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(3, 'stuff lemon into chicken');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(3, 'put chicken in oven');

insert into recipe_ingredients(recipe_id, ingredients) values(4, '2 avocadoes');
insert into recipe_ingredients(recipe_id, ingredients) values(4, '200 ml milk');
insert into recipe_ingredients(recipe_id, ingredients) values(4, '2 tsp honey');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(4, 'put all ingredients in a mixer');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(4, 'serve cold');

