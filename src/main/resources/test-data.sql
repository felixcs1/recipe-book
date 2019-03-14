INSERT INTO foods VALUES
(DEFAULT,'Potato', 'g', FALSE),
(DEFAULT, 'Olive oil', 'ml', TRUE),
(DEFAULT , 'Salt', 'pinch', FALSE);

INSERT INTO tools VALUES
(DEFAULT, 'Knife'),
(DEFAULT, 'Peeler'),
(DEFAULT, 'Salt grinder');

INSERT INTO recipes VALUES
(DEFAULT, 'Salted Chips', 'This is how to make salted chips', 4),
(DEFAULT, 'Unsalted Chips', 'This is how to make unsalted chips', 5);

INSERT INTO instructions VALUES
(DEFAULT, 'Salted chips step 1', (SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Salted Chips'), 1),
(DEFAULT, 'Salted chips step 2', (SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Salted Chips'), 2),
(DEFAULT, 'Salted chips step 3', (SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Salted Chips'), 3),
(DEFAULT, 'Chips step 1', (SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Unsalted Chips'), 1),
(DEFAULT, 'Chips step 2', (SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Unsalted Chips'), 2);

INSERT INTO recipe_foods VALUES
((SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Salted Chips'),  (SELECT food_id FROM foods WHERE foods.food_name = 'Potato'), 500),
((SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Salted Chips'),  (SELECT food_id FROM foods WHERE foods.food_name = 'Salt'), 5),
((SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Unsalted Chips'),  (SELECT food_id FROM foods WHERE foods.food_name = 'Potato'), 500),
((SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Unsalted Chips'),  (SELECT food_id FROM foods WHERE foods.food_name = 'Olive oil'), 100);

INSERT INTO recipe_tools VALUES
((SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Salted Chips'),  (SELECT tool_id FROM tools WHERE tools.tool_name = 'Knife')),
((SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Salted Chips'),  (SELECT tool_id FROM tools WHERE tools.tool_name = 'Peeler')),
((SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Salted Chips'),  (SELECT tool_id FROM tools WHERE tools.tool_name = 'Salt grinder')),
((SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Unsalted Chips'),  (SELECT tool_id FROM tools WHERE tools.tool_name = 'Knife')),
((SELECT recipe_id FROM recipes WHERE recipes.recipe_name = 'Unsalted Chips'),  (SELECT tool_id FROM tools WHERE tools.tool_name = 'Peeler'));


--  SELECT recipes.recipe_name, recipes.description, recipes.serves
--  FROM recipes
--  WHERE recipes.recipe_id = 1;
--
--  SELECT instructions.instruction
--  FROM recipes
--         INNER JOIN instructions ON recipes.recipe_id=instructions.recipe_id
--  WHERE recipes.recipe_id = 1;
--
--  SELECT foods.food_name, recipe_foods.quantity, foods.units, foods.isLiquid
--  FROM recipes
--         INNER JOIN recipe_foods ON recipes.recipe_id=recipe_foods.recipe_id
--         INNER JOIN foods ON recipe_foods.food_id=foods.food_id
--  WHERE recipes.recipe_id = 1;
--
--  SELECT tools.tool_name
--  FROM recipes
--         INNER JOIN recipe_tools ON recipes.recipe_id=recipe_tools.recipe_id
--         INNER JOIN tools ON recipe_tools.tool_id=tools.tool_id
--  WHERE recipes.recipe_id = 1;
--
--
--  SELECT *
--  FROM recipes
--         INNER JOIN recipe_tools ON recipes.recipe_id=recipe_tools.recipe_id
--  WHERE recipes.recipe_id = 1;