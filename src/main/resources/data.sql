insert into users(id, email, first_name, last_name, password, username) values(1, 'example1@email.com', 'Nancy', 'Doloksaribu', 'password', 'nancyD1000');
insert into users(id, email, first_name, last_name, password, username) values(2, 'example2@email.com', 'Jane', 'Doe', 'password', 'janeDoe1');
insert into users(id, email, first_name, last_name, password, username) values(3, 'example3@email.com', 'Mickey', 'Mouse', 'password', 'mickeyMouse');
insert into users(id, email, first_name, last_name, password, username) values(4, 'example4@email.com', 'Minnie', 'Mouse', 'password', 'minnieMouse');

insert into recipes(id, name, photo_url, weblink, user_id) values(1, 'Banana Bread', 'http://cdn-image.myrecipes.com/sites/default/files/image/recipes/oh/08/banana-bread-oh-1732689-x.jpg', 'http://allrecipes.com/recipe/241707/joys-easy-banana-bread/', 1);
insert into recipes(id, name, photo_url, weblink, user_id) values(2, 'Chocolate Cake', 'http://rentnema.com/blog/wp-content/uploads/2016/10/cake.png', 'www.otherRecipe2.com', 1);
insert into recipes(id, name, photo_url, weblink, user_id) values(3, 'Roasted Chicken', 'http://food.fnr.sndimg.com/content/dam/images/food/fullset/2011/11/23/0/FN_perfect-chicken-014_s4x3.jpg.rend.hgtvcom.616.462.suffix/1496060268796.jpeg', 'www.otherRecipe3.com', 2);
insert into recipes(id, name, photo_url, weblink, user_id) values(4, 'Avocado Smoothie', 'http://s.doctoroz.com/recipe/avocado.gif', 'www.otherRecipe4.com', 3);
insert into recipes(id, name, photo_url, weblink, user_id) values(5, 'Cheese Fondue', 'https://foodal.com/wp-content/uploads/2015/04/Cheese-Fondue-Recipe.jpg', 'www.otherRecipe5.com', 2);
insert into recipes(id, name, photo_url, weblink, user_id) values(6, 'Perfect Sunny Side Up', 'https://addapinch.com/wp-content/blogs.dir/3/files/2013/09/sunny-side-up-eggs-DSC_5863-640x425.jpg', 'www.otherRecipe6.com', 2);
insert into recipes(id, name, photo_url, weblink, user_id) values(7, 'Drunken Spicy Shrimps', 'https://img-global.cpcdn.com/001_recipes/4873504708100096/751x532cq70/photo.jpg', 'www.otherRecipe7.com', 1);
insert into recipes(id, name, photo_url, weblink, user_id) values(8, 'Steamed Fish Asian Style', 'https://i1.wp.com/www.angsarap.net/wp-content/uploads/2011/03/asian-style-steamed-fish.jpg?fit=800%2C600', 'www.otherRecipe8.com', 1);
insert into recipes(id, name, photo_url, weblink, user_id) values(9, 'Juice Burger', 'http://lorempixel.com/200/180/food/9', 'www.otherRecipe9.com', 1);
insert into recipes(id, name, photo_url, weblink, user_id) values(10, 'Homemade Bread', 'http://lorempixel.com/200/180/food/10', 'www.otherRecipe10.com', 4);
insert into recipes(id, name, photo_url, weblink, user_id) values(11, 'Spicy Beef Stew', 'http://lorempixel.com/200/180/food/1', 'www.otherRecipe11.com', 1);
insert into recipes(id, name, photo_url, weblink, user_id) values(12, 'Beef Salad', 'http://lorempixel.com/200/180/food/2', 'www.otherRecipe12.com', 1);
insert into recipes(id, name, photo_url, weblink, user_id) values(13, 'Fresh Garden Salad', 'http://lorempixel.com/200/180/food/5', 'www.otherRecipe13.com', 4);
insert into recipes(id, name, photo_url, weblink, user_id) values(14, 'Zuchini Salad', 'http://lorempixel.com/200/180/food/6', 'www.otherRecipe14.com', 1);
insert into recipes(id, name, photo_url, weblink, user_id) values(15, 'Honey Roasted Nuts', 'http://lorempixel.com/200/180/food/7', 'www.otherRecipe15.com', 1);
insert into recipes(id, name, photo_url, weblink, user_id) values(16, 'Easy Sushi', 'http://lorempixel.com/200/180/food/8', 'www.otherRecipe16.com', 1);

insert into recipe_ingredients(recipe_id, ingredients) values(1, '4 ripe bananas, mashed');
insert into recipe_ingredients(recipe_id, ingredients) values(1, '1 cup white/cane sugar');
insert into recipe_ingredients(recipe_id, ingredients) values(1, '1 egg');
insert into recipe_ingredients(recipe_id, ingredients) values(1, '1/4 cup melted butter');
insert into recipe_ingredients(recipe_id, ingredients) values(1, '1 1/2 cup all-purpose flour');
insert into recipe_ingredients(recipe_id, ingredients) values(1, '1 tsp baking powder');
insert into recipe_ingredients(recipe_id, ingredients) values(1, '1 tsp salt');
insert into recipe_ingredients(recipe_id, ingredients) values(1, '1 handful crushed walnuts');
insert into recipe_ingredients(recipe_id, ingredients) values(1, 'cinammon powder to sprinkle');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(1, 'Preheat oven to 325 degrees F (165 degrees C). Grease a 9x5-inch loaf pan.');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(1, 'Combine bananas, sugar, egg, and butter together in a bowl.');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(1, 'Mix flour and baking soda together in a separate bowl; stir into banana mixture until batter is just mixed.');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(1, 'Stir salt and crushed walnuts into batter. Pour batter into the prepared loaf pan.');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(1, 'Bake in the preheated oven until a toothpick inserted in the center of the bread comes out clean, about 1 hour.');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(1, 'Let it cool down and sprinkle with cinamon powder.');

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

insert into recipe_ingredients(recipe_id, ingredients) values(5, 'cheese fondue pack');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(5, 'follow instructions on package');

insert into recipe_ingredients(recipe_id, ingredients) values(6, 'eggs');
insert into recipe_ingredients(recipe_id, ingredients) values(6, 'herb butter');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(6, 'put butter in a pan on medium heat');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(6, 'crack egg on pan and season');

insert into recipe_ingredients(recipe_id, ingredients) values(7, 'shrimps');
insert into recipe_ingredients(recipe_id, ingredients) values(7, '1 can beer');
insert into recipe_ingredients(recipe_id, ingredients) values(7, 'lots of piri-piri');
insert into recipe_ingredients(recipe_id, ingredients) values(7, 'butter');
insert into recipe_ingredients(recipe_id, ingredients) values(7, 'garlic');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(7, 'clean shrimps, sprinkle with minced garlic and piri-piri');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(7, 'heat butter in a pan, add the shrimps');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(7, 'when half cooked, add the beer. Continue cooking until beer is mostly evaporated');

insert into recipe_ingredients(recipe_id, ingredients) values(8, '1 fish cleaned');
insert into recipe_ingredients(recipe_id, ingredients) values(8, 'low sodium soy sauce');
insert into recipe_ingredients(recipe_id, ingredients) values(8, 'sesame oil');
insert into recipe_ingredients(recipe_id, ingredients) values(8, 'ginger sliced into small sticks');
insert into recipe_ingredients(recipe_id, ingredients) values(8, 'spring onions chopped');
insert into recipe_ingredients(recipe_id, ingredients) values(8, 'white wine');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(8, 'stuff the cleaned fish with ginger and spring onions');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(8, 'steam fish over white wine for 10-15 mnts');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(8, 'prepare sauce: mix soy sauce with sesame oil and a little bit water');
insert into recipe_cooking_methods(recipe_id, cooking_methods) values(8, 'serve fish on a plate and pour sauce on top of it');

insert into recipe_ingredients(recipe_id, ingredients) values(9, 'some ingredients');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(9, 'follow instructions ...');

insert into recipe_ingredients(recipe_id, ingredients) values(10, 'some ingredients');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(10, 'follow instructions ...');

insert into recipe_ingredients(recipe_id, ingredients) values(11, 'some ingredients');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(11, 'follow instructions ...');

insert into recipe_ingredients(recipe_id, ingredients) values(12, 'some ingredients');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(12, 'follow instructions ...');

insert into recipe_ingredients(recipe_id, ingredients) values(13, 'some ingredients');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(13, 'follow instructions ...');

insert into recipe_ingredients(recipe_id, ingredients) values(14, 'some ingredients');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(14, 'follow instructions ...');

insert into recipe_ingredients(recipe_id, ingredients) values(15, 'some ingredients');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(15, 'follow instructions ...');

insert into recipe_ingredients(recipe_id, ingredients) values(16, 'some ingredients');

insert into recipe_cooking_methods(recipe_id, cooking_methods) values(16, 'follow instructions ...');

